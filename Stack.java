package study;

import java.lang.reflect.Array;
import study.StackOverflowException;
import study.StackUnderflowException;

/**
* 스택을 구현한 프로그램.
*/
public class Stack<T> {

	private final int size;
	private T[] datum;
	private int p = -1;

	public Stack(int initSize){
		size = initSize;
		datum = (T[]) new Object[initSize];
	}

	public void push(T data) throws StackOverflowException {
		if(p == size - 1 ) throw new StackOverflowException();
		datum[++p] = data;
		print("push");
	}

	public T pop() throws StackUnderflowException {
		if(p < 0) throw new StackUnderflowException();
		T data = datum[p];
		datum[p--] = null;
		print("pop");
		return data;
	}

	public int size(){
		return p;
	}

	private void print(String cmd){
		//verify data.
		System.out.print("\n "+cmd + " [");
		for(int i=0; i<=p; i++){
			System.out.print(datum[i] + " ");
		}
		System.out.print("]");
	}

	public static void main(String[] args){
		if(args.length < 3){
			System.err.println("enter init size and iteration count!! \n [1]size [2]push count [3]pop count");
			return;
		}

		//size, iter cnt.
		int size = 0;
		int pushCnt = 0;
		int popCnt = 0;
		try{
			size = Integer.parseInt(args[0]);
			pushCnt = Integer.parseInt(args[1]);
			popCnt = Integer.parseInt(args[2]);
		}catch(java.lang.NumberFormatException nfe){
			System.err.println("please input integer!!!");
		}

		
		
		try{
			Stack<Data> s = new Stack<Data>(size);

			//push
			System.out.print("\n push start.. ");
			for(int i=0; i<pushCnt; i++){
				int r = (int) (Math.random()*100);
				s.push(new Data(r));
			}

			//pop
			System.out.print("\n pop start.. ");
			for(int i=0; i<popCnt; i++){
				System.out.print(" >> "+s.pop());
			}

			System.out.println("\n end!");

		}catch(StackUnderflowException soe){
			System.out.println("stack underflow!!");
		}catch(StackOverflowException soe){
			System.out.println("stack overflow!!");
		}
	}
}


