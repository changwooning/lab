package lv03;

import java.util.Scanner;

public class Ex15 {

	// #즉석복권
	// 1. 숫자 7이 연속으로 3번 등장하면, "당첨" 출력
	
	// 배열은 무조건 규칙부터 찾으라!
	

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		// int[] lotto = {0,0,7,7,7,0,0,0};

		// Test case
		// int[] lotto = {7,0,7,7,0,7,0,7};
		// int[] lotto = {7,7,7,7,0,7,0,7};
		// int[] lotto = {7,7,7,7,7,7,7,7};
		// int[] lotto = {0,0,0,0,0,0,7,7};
		int[] lotto = { 0, 0, 0, 0, 0, 7, 7, 7 };

		System.out.println("1) 복권 결과확인");
		System.out.print("메뉴 선택 : ");
		int sel = scan.nextInt();

		
		//두번째 풀이
		if(sel == 1) {
			//count 변수를 두고
			// 7을 만나면 -> count ++;
			// count가 3에 도달하면 -> 당첨확인
			
			int count = 0;
			boolean isFound = false;
			
			for(int i=0; i<8; i++) {
				if(lotto[i] == 7)
					count++;
				else
					count = 0;
				
				if(count == 3)
					isFound = true;
				
				
			}
			
			if(isFound)
				System.out.println("당첨");
			else
				System.out.println("꽝");
				
				
		}
			
		
		
		
		
		
		
		//첫번째 풀이
//		if (sel == 1) {
//			// 규칙 찾기
//			boolean isFound = false;
//
//			for (int i = 0; i < 6; i++) { // 우선 순위는 왼쪽에서부터 오른쪽
//				if (lotto[i] == 7 && lotto[i + 1] == 7 && lotto[i + 2] == 7) {
//					isFound = true;
//				}
//			}
//			if (isFound) {
//				System.out.print("당첨입니다.");
//			} else
//				System.out.print("꽝입니다.");

//		}

	}

}
