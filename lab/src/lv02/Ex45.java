package lv02;

import java.util.Scanner;

public class Ex45 {
	// #베스킨라빈스31
		// 1. p1과 p2가 번갈아가면서 1~3을 입력한다. (범위 밖이면 turn 유지)
		// 2. br은 p1과 p2의 입력값을 누적해서 저장한다.
		// 3. br이 31을 넘으면 게임은 종료된다.
		// 4. 승리자를 출력한다.

		// 예)
		// 1턴 : p1(2) br(2)
		// 2턴 : p2(1) br(3)
		// 3턴 : p1(3) br(6)
		// ****
		//
	
	//1841
	//1848

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		
		int input = 0;
		int br = 0;
		int turn = 0;
		
		// br 31 이상이면 종료
		while(br < 31) {
			//br 값 보여주기
			System.out.printf("br [%d]\n", br);
			
			//플레이어 입력 반복
			System.out.printf("P%d (1~3) : ",turn % 2 + 1);
			input = scan.nextInt();
			
			//turn 값 범주 안 일때
			if(input > 0 && input <= 3) {
				//br 증가
				br += input;
				//turn 스위치
				turn += 1;
			}
		}
		//승리자 출력
		System.out.printf("P%d WIN!!!", turn % 2 + 1);
	}

}
