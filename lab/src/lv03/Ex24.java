package lv03;

import java.util.Scanner;

public class Ex24 {
	
	// #즉석복권
	// 1. 숫자 7이 연속으로 3번 등장하면, "당첨" 출력
	
	// 배열은 무조건 규칙부터 찾으라!
	

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		//int[] lotto = {0,0,7,7,7,0,0,0};
		
		//Test case
		 //int[] lotto = {7,0,7,7,0,7,0,7};
		//nt[] lotto = {7,7,7,7,0,7,0,7};
		 //int[] lotto = {7,7,7,7,7,7,7,7};
		int[] lotto = {0,0,0,0,0,0,7,7};
		
		System.out.print("1) 복권 결과확인");
		int sel = scan.nextInt();
		
		boolean isFound = false;
		
		for(int i=0; i<6; i++) {
			if(lotto[i] == 7 && lotto[i+1] == 7 && lotto[i+2] == 7) {
				isFound = true;
			}
		}
		if(isFound)
			System.out.println("당첨");
		else
			System.out.println("꽝");
		
		

	}

}
