package lv02;

import java.util.Scanner;


public class Ex12 {
	
	//31 게임!
	

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int input = 0;
		int br = 0;
		int turn = 0;
		//방법 1) 짝홀
		//방법 2) 1 or 2 로 스위치
		
		
		//종료 조건 br 값이 31이상이면,
		while(br < 31) {
			//br 보여주기
			System.out.printf("br [%d]\n", br);
			
			//플레이어 입력값 받기(반복)
			System.out.printf("P%d (1~3) : ", turn % 2 + 1);
			input = scan.nextInt();
			
			//정상 범주일 때에만 
			if(input > 0 && input <= 3) {
				// br 증가
				br += input;
				// turn 스위치
				turn ++; 		// turn --> 변수 생각 못함;; 
			}
			
		}
		System.out.printf("P%d WIN!!!", turn % 2 + 1);

	}

}
