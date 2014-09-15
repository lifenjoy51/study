package study;

public interface Queue<T> {

	//집어넣는다.
	public void offer(T data);

	//꺼내고 지운다.
	public T poll();

	//있는지 확인한다.
	public T peek();

}
