package study;

public class LinkedList<T> implements Queue<T>{

	LinkedData start;	//시작.
	LinkedData end;	//끝.
	int size=0;
	
	public LinkedList(){
		this.start = new LinkedData();
		this.end = new LinkedData();
		start.pre = null;
		start.next = end;
		end.pre = start;
		end.next = null;
	}

	/**
	*	맨 뒤에 하나씩 추가한다.
	*	맨 뒤는 결국 end의 앞부분이다.
	*	end.pre에 있는 객체의 next에 연결하고,
	*	end의 pre에 넣어주면 된다.
	*/
	public void add(T data){
		add(size,data);	//맨 마지막에 넣는다.
	}

	public void add(int index, T data){
		LinkedData idxData = getLinkedData(index);
		LinkedData<T> lData = new LinkedData<T>();
		lData.data = data;
		lData.pre = idxData.pre;
		lData.next = idxData;
		
		//end.pre
		idxData.pre.next = lData;
		idxData.pre = lData;

		//size
		size++;

		//print
		print();

	}

	public T get(int index){
		return (T) getLinkedData(index).data;
	}

	public int size(){
		return size;
	}

	private LinkedData getLinkedData(int idx){
		return getLinkedData(idx, start);
	}

	private LinkedData getLinkedData(int idx, LinkedData lData){
		if(idx > -1){
			return getLinkedData(idx-1, lData.next);
		}else {
			return lData;
		}
	}

	private void print(){
		System.out.print("\nList [ ");
		for(int i=0; i<size; i++){
			System.out.print(getLinkedData(i)+" ");
		}
		System.out.print("]");
	}

	//queue implement.
	
	//집어넣는다.
	public void offer(T data){
		add(0,data);
	}

	//꺼내고 지운다.
	public T poll(){
		T data = get(size-1);
		//test
		//System.out.println();
		end.pre = end.pre.pre;
		end.pre.next = end;
		size--;		
		print();
		return data;
	}

	//있는지 확인한다.
	public T peek(){
		return get(size-1);
	}

	public static void main(String[] args){
		LinkedList<Data> list = new LinkedList<Data>();
		list.add(new Data(2));	// 2
		list.add(new Data(3));	// 2 3
		list.add(new Data(5));	// 2 3 5

		list.add(1, new Data(9));	// 2 9 3 5 expected

		Data d2 = list.get(2);	// 3.
		System.out.println("\n" + d2);
		
		System.out.println("\nend!");
	}
}

class LinkedData<T> {
	LinkedData pre;
	T data;
	LinkedData next;

	public String toString(){
		if(data == null){
			return "null!!";
		}else{
			return data.toString();
		}
	}

}
