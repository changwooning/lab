package lv05practice;

import java.util.Scanner;

public class Practice11 {
	
	// # 끝말잇기

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String start = "자전거";
		
		while(true) {
			
			System.out.print("제시어 ; " + start);
			System.out.print("입력 : ");
			String input = scan.next();
			
			char end = start.charAt(start.length()-1);
			char begin = input.charAt(0);
			
			if(end != begin)
				break;
			
			start = input;
			
		}
		

	}

}
