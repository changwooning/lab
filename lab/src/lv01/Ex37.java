package lv01;

import java.util.Random;


public class Ex37 {
	
	/*
	 * # 369게임 [1단계]
	 * 1. 1~50 사이의 랜덤 숫자를 저장한다.
	 * 2. 위 수에 369의 개수가
	 *  1)2개이면 짝짝을 출력
	 *  2)1개이면 짝을 출력
	 *  3)0개이면 해당 숫자를 출력
	 * 예)
	 *      33  : 짝짝
	 *      3   : 짝
	 *      7   : 7
	 */
	
	public static void main(String[] args) {
		
		//1. 랜덤 숫자 지정
		Random random = new Random();
		int num = random.nextInt(50) + 1;
		
		//2. 숫자 자리수 분리하기.
		
		int num1 = num / 10; //십의 자리
		int num2 = num % 10; //일의 자리
		
		//3. 두개일 경우
		
		if((num1 == 3 || num1 == 6 || num1 == 9) && (num2 == 3 || num2 == 6 || num2 ==9)) {
			System.out.print(num + " : 짝짝");
		}
		//4. 한개일경우
		else if((num1 ==3 || num1 == 6 || num1 == 9) || (num2 == 3 || num2 == 6 || num2 == 9)) {
			System.out.print(num + " : 짝");
		}
		else {
			System.out.print(num);
		}
		
		

	}

}
