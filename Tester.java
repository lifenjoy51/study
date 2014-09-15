package study;

import java.util.Scanner;


public class Tester{

	static Scanner keyboard;
	public static void main(String[] args){
		//키보드 입력 받아서 뭘 테스트할지 선택한다.
		keyboard = new Scanner(System.in);
		System.out.println("테스트할 작업을 입력하세요. S = stack, Q = queue, L = linked list.");
		String cmd = keyboard.nextLine();
		if("S".equalsIgnoreCase(cmd)){
			//StackTest
			testStack();
		}else if("Q".equalsIgnoreCase(cmd)){
			//QueueTest
			testQueue();
		}else if("L".equalsIgnoreCase(cmd)){
			//LinkedListTest
			testLinkedList();
		}else{
			System.out.println("잘못 입력하셨습니다..");
		}

		//종료명령어를 입력할 때 까지 작업을 계속한다.
	}

	public static void testStack(){
		System.out.println("push, pop.");
		Stack<Data> s = new Stack<Data>(10);
		String cmdline = keyboard.nextLine();

		while(!"q".equalsIgnoreCase(cmdline)){
			String cmd =  cmdline.split(" ")[0];
			System.out.println("cmd > "+ cmd);

			//명령어 push, pop 뒤에는 숫자.
			if("push".equalsIgnoreCase(cmd)){
				int value =  Integer.parseInt(cmdline.split(" ")[1]);
				try{
					s.push(new Data(value));
				}catch(StackOverflowException soe){
					System.out.println("StackOverflowException");
				}
			}else if("pop".equalsIgnoreCase(cmd)){
				try{
					Data d = s.pop();
					System.out.println(d);
				}catch(StackUnderflowException soe){
					System.out.println("StackUnderflowException");
				}
			}

			System.out.println("push, pop.");
			cmdline = keyboard.nextLine();

		}
	}

	public static void testQueue(){
		System.out.println("offer, poll, peek. ");
		Queue<Data> q = new LinkedList<Data>();
		String cmdline = keyboard.nextLine();

		while(!"q".equalsIgnoreCase(cmdline)){
			String cmd =  cmdline.split(" ")[0];

			System.out.println("cmd > "+ cmd);

			//명령어 offer, poll, peek. 뒤에는 숫자.
			if("offer".equalsIgnoreCase(cmd)){
				int value =  Integer.parseInt(cmdline.split(" ")[1]);
				System.out.println("offer");
				q.offer(new Data(value));
			}else if("poll".equalsIgnoreCase(cmd)){
				Data d = q.poll();
				System.out.println("poll");
				System.out.println(d);
			}else if("peek".equalsIgnoreCase(cmd)){
				Data d = q.peek();
				System.out.println("peek");
				System.out.println(d);
			}

			System.out.println("offer, poll, peek. ");
			cmdline = keyboard.nextLine();
		}
	}

	public static void testLinkedList(){
		System.out.println("testLinkedList");
		String cmdline = keyboard.nextLine();
		while(!"q".equalsIgnoreCase(cmdline)){
			cmdline = keyboard.nextLine();
		}
	}
}
