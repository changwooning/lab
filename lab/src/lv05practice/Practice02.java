package lv05practice;

import java.util.Scanner;
import java.util.Random;

public class Practice02 {
	
	// # 타자연습

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		String[] word = {"java","mysql","jsp","spring"};
		
		// 랜덤 
		for(int i=0; i<100; i++) {
			int rIdx = ran.nextInt(4);
			String temp = word[0];
			word[0] = word[rIdx];
			word[rIdx] = temp;
		}
		
		for(int i=0; i<word.length; i++) {
			System.out.println("문제 : " + word[i]);
			System.out.print("입력 : ");
			String input = scan.next();
			
			if(!word[i].equals(input))
				i--;
					
		}
		
	}

}
