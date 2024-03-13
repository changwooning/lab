package lv03practice;

import java.util.Scanner;

public class Practice68 {
	
	//즉선 복권
	//1720

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
		int[] lotto = { 0, 0, 0, 7, 7, 7, 0, 0 };
		
		
		boolean isFound = false;
		
		System.out.println("1.복권당첨확인!");
		System.out.println("1)확인하기");
		int sel = scan.nextInt();
		
		if(sel == 1) {
			
			for(int i=0; i<6; i++) {
				if(lotto[i] == 7 && lotto[i+1] == 7 && lotto[i+2] == 7)
					isFound = true;
				
			}
			if(isFound)
				System.out.println("당첨!");
			else
				System.out.println("꽝..");
		}
		

		
		
		
		
	}

}
