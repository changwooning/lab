package lv03;

import java.util.Scanner;

public class Ex16 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		//int[] lotto = {0,0,7,7,7,0,0,0};
		
		//Test case
		//int[] lotto = {7,0,7,7,0,7,0,7}; 
		//int[] lotto = {7,7,7,7,0,7,0,7}; 
		//int[] lotto = {7,7,7,7,7,7,7,7}; 
		//int[] lotto = {0,0,0,0,0,0,7,7};
		int[] lotto = {0,0,0,0,0,0,0,0};
		
		System.out.println("1) 복권 결과확인");
		System.out.print("메뉴 선택 : ");
		int sel = scan.nextInt();
		
		boolean isFound = false;
		
		if(sel == 1) {
			//규칙 찾기 6번
			for(int i=0; i<6; i++) {
				//정답일때
				if(lotto[i] == 7 && lotto[i+1] == 7 && lotto[i+2] == 7) {
					isFound = true;
				}
			}
			if(isFound) {
				System.out.println("정답");
			}else
				System.out.println("꽝");
			
			
		}
		
		
		
		
	}

}
