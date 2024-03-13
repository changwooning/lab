package lv01;

import java.util.Random;


public class Ex36 {
	
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
		
		
		// 랜덤 숫자 지정!
		Random random = new Random();
		int rNum = random.nextInt(50) +1;
		
		// 숫자 분리
		int rNum1 = rNum / 10; // 십의자리
		int rNum2 = rNum % 10; // 일의자리
		
		//두개일 경우
		if((rNum1 == 3 || rNum1 == 6 || rNum1 == 9) && (rNum2 == 3 || rNum2 == 6 || rNum2 == 9)){
			System.out.print(rNum + " : 짝짝");
		}
		//한개일 경우
		else if((rNum1 == 3 || rNum1 == 6 || rNum1 == 9) || (rNum2 == 3 || rNum2 == 6 || rNum2 == 9)){
			System.out.print(rNum + " : 짝");
		}
		// 없는경우
		else {
			System.out.print(rNum);
		}
		
		
		
	
		
		
		
		// 십의 자리
		
		
		
		
		
		
		
		
		
		
		
		
		// 특정 자릿수에 대한 값 찾기 
		// 1. 십의 자리 수 
		int ten = number / 10;
		
		// 2. 일의 자리 수 
		int one = number % 10;
		
		// 3. 박수횟수
		int count = 0;
		
		// 3. 십의 자리 수가 3/6/9 이냐? -> count += 1
		// 4. 일의 자리 수가 3/6/9 이냐? -> count += 1
		
		if(ten % 3 == 0 && ten != 0) {
			count += 1;
			
		}
		if(one % 3 == 0 && one != 0) {
			count += 1;
		}
		// 5. 십의 자리 수와 일의 자리 수 모두 3/6/9가 아니면 -> 숫자 출력 
		
		if(count == 2) {
			System.out.print("짝짝");
		}
		else if(count == 1) {
			System.out.print("짝");
		}
		else {
			System.out.print(number);
		}
		
		
				
		
		
		
		
		
	
	}

}
