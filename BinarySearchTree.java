package study;

public class BinarySearchTree<V extends Comparable<V>> {
	public BinarySearchTree<V> left;
	public BinarySearchTree<V> right;
	public V data;

	public BinarySearchTree() {
		left = null;
		right = null;
	}

	public void add(V v) {
		System.out.println(v);
		this.add(this, v);
		// System.out.println();
	}

	private void add(BinarySearchTree<V> bst, V v) {
		// System.out.println(bst.data + " , " + v);
		if (bst.data == null) {
			bst.data = v;
		} else if (bst.data.compareTo(v) > 0) {
			// 새로 입력할 데이터가 왼쪽으로.
			if (bst.left == null)
				bst.left = new BinarySearchTree<>();
			add(bst.left, v);
		} else if (bst.data.compareTo(v) < 0) {
			// 새로 입력할 데이터가 오른쪽으로.
			if (bst.right == null)
				bst.right = new BinarySearchTree<>();
			add(bst.right, v);
		}
	}

	public boolean contains(V v) {
		return contains(this, v);
	}

	public boolean contains(BinarySearchTree<V> bst, V v) {
		if (bst == null) {
			return false;
		} else if (bst.data.compareTo(v) > 0) {
			// 왼쪽에서 검색.
			return contains(bst.left, v);
		} else if (bst.data.compareTo(v) < 0) {
			// 오른쪽에서 검색.
			return contains(bst.right, v);
		} else if (bst.data.equals(v)) {
			// 같으면.
			return true;
		} else {
			return false;
		}
	}

	public void remove(V v) {
		remove(this, v);
	}

	private void remove(BinarySearchTree<V> bst, V v) {
		if (contains(bst, v) == true) {
			bst = bst.left;
		}
	}

	public void preOrder() {
		// center > left > right
		System.out.println();
		preOrder(this);
	}

	private void preOrder(BinarySearchTree<V> bst) {
		if (bst != null) {
			System.out.print(bst.data);
			System.out.print(" ");
			preOrder(bst.left);
			preOrder(bst.right);
		}
	}

	public void inOrder() {
		// left > center > right
		System.out.println();
		inOrder(this);
	}

	private void inOrder(BinarySearchTree<V> bst) {
		if (bst != null) {
			inOrder(bst.left);
			System.out.print(bst.data);
			System.out.print(" ");
			inOrder(bst.right);
		}

	}

	public void postOrder() {
		// left > right > center
		System.out.println();
		postOrder(this);
	}

	private void postOrder(BinarySearchTree<V> bst) {
		if (bst != null) {
			postOrder(bst.left);
			postOrder(bst.right);
			System.out.print(bst.data);
			System.out.print(" ");
		}

	}

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

		// add items..
		int cnt = 10;
		for (int i = 0; i < cnt; i++) {
			int r = (int) (Math.random() * cnt) + 1;
			// bst.add(r);
		}

		bst.add(6);
		bst.add(8);
		bst.add(2);
		bst.add(9);
		bst.add(4);
		bst.add(1);
		bst.add(7);

		// check
		System.out.println(bst.contains(5));
		System.out.println(bst.contains(7));
		System.out.println(bst.contains(4));

		// print traversal..
		bst.preOrder();
		bst.inOrder();
		bst.postOrder();

		// remove
		bst.remove(2);

		// confirm
		System.out.println(bst.contains(2));
		bst.preOrder();
	}

}
