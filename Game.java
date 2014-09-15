package study;

import java.util.Scanner;
import java.util.Date;

public class Game{

	static Scanner keyboard;

	public static void main(String[] args){
		//repeat
		//열개의 무언가를 출력하는 방법.
		//현재날짜를 열번.
		for(int i=0; i<10; i++){
			System.out.println(new Date());
		}

		//조건문.
		keyboard = new Scanner(System.in);
		String aa = keyboard.nextLine();
		int a = Integer.parseInt(aa);
		int bb = doubleInt(a);
		System.out.println(bb);
		if(a % 2 == 0){
			System.out.println("짝수");
		}else{
			System.out.println("홀수");
		}

		//함수.
		//함수의 정의.
		// f(x) x를 넣었을 때 결과값 f(x)가 나온다.
	}

	//값을 두배로 하는 함수.
	// y = 2x
	// x를 입력 했을 때, 결과값으로 x의 두배 되는 값을 돌려준다.
	public static int doubleInt(int x){
		return x*2;
	}

	public static void main2(String[] args){
		//키보드 입력 받아서 뭘 테스트할지 선택한다.
		keyboard = new Scanner(System.in);

		System.out.println("첫번째숫자.");
		String int1s = keyboard.nextLine();
		int int1 = Integer.parseInt(int1s);

		System.out.println("두번째숫자.");
		String int2s = keyboard.nextLine();
		int int2 = Integer.parseInt(int2s);
		
		//더한다.
		int result = int1 * int2;

		//repeat
		//열개의 무언가를 출력하는 방법.
		//현재날짜를 열번.
		System.out.println(new Date());

		//for(int i=0; 
		System.out.println("첫번째 숫자 더하기 두번째 숫자 = " + result);
	}
}
