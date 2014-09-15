package study;

public class QueueTest{
	public static void main(String[] args){
		Queue<Data> q = new LinkedList<Data>();
		q.offer(new Data(3));
		q.offer(new Data(6));
		q.offer(new Data(9));

		Data d1 = q.poll();
		System.out.println();
		System.out.println(d1);
		Data d2 = q.peek();
		System.out.println(d2);
	}
}
