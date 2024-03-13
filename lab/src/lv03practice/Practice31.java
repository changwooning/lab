package lv03practice;

import java.util.Scanner;

public class Practice31 {
	
	// #즉석복권
	// 1. 숫자 7이 연속으로 3번 등장하면, "당첨" 출력
		
	// 배열은 무조건 규칙부터 찾으라!
	//2103
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		//int[] lotto = {0,0,7,7,7,0,0,0};

		// Test case
		 //int[] lotto = {7,0,7,7,0,7,0,7};
		// int[] lotto = {7,7,7,7,0,7,0,7};
		 //int[] lotto = {7,7,7,7,7,7,7,7};
		int[] lotto = {0,0,0,0,0,0,7,7};
		
		System.out.println("1) 복권 결과 확인");
		System.out.println("메뉴 선택 : ");
		int sel = scan.nextInt();
		
		if(sel == 1) {
			
			boolean isFound = false;
			
			
			for(int i=0; i<6; i++) {
				if(lotto[i] == 7 && lotto[i+1] == 7 && lotto[i+2] == 7) {
					isFound = true;
				}
			}
			if(isFound) {
				System.out.println("당첨");
			}else
				System.err.println("꽝!");
			
			
			
			
			
			
		}
		
		
	}

}
