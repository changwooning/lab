package lv03practice;

import java.util.Scanner;

public class Practice33 {
	
	//즉석복권
	//2126

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] lotto = { 0,0,0,7,7,0,0,0};
		
		System.out.println("1)복권당첨확인");
		System.out.println("1.메뉴선택 : ");
		int sel = scan.nextInt();
		
		if(sel == 1) {
			
			boolean isFound = false;
			
			
			for(int i=0; i<6; i++) {
				if(lotto[i] == 7 && lotto[i+1] == 7 &&  lotto[i+2] == 7) {
					isFound = true;
				}
				
			}
			if(isFound)
				System.out.println("당첨");
			else
				System.out.println("꽝!");
			
			
			
			
		}

	}

}
