package lv05practice;

import java.util.Scanner;

public class Practice01 {
	
	// # 끝말잇기 게임

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String start = "자전거";
		
		while(true) {
			System.out.println("제시어 : " + start);
			
			System.out.print("입력 : ");
			String input = scan.next();
			
			char end = start.charAt(start.length()-1);
			char begin = input.charAt(0);
			
			if(end != begin)
				break;
			
			start = input;
		}
		System.out.println("game over~");
		

	}

}
