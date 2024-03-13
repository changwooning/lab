package lv05practice;

import java.util.Scanner;
import java.util.Random;

public class Practice34 {
	
	// # 영어단어 맞추기

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		int score = 100;
		
		String word = "performance";
		String meaning = "공연";
		
		int size = word.length();
		int check[] = new int[size];
		
		int open = 0;
		
		while(true) {
			
			System.out.println("뜻 : " + meaning);
			System.out.print("문제 : ");
			for(int i=0; i<size; i++) {
				if(check[i] == 0)
					System.out.print("*");
				else
					System.out.print(word.charAt(i));
			}
			System.out.println("\n영어단어를 입력하세요 >>>>>");
			String input = scan.next();
			
			if(input.equals(word))
				break;
			
			if(open == size)
				break;
			
			while(true) {
				
				int rIdx = ran.nextInt(size);
				
				if(check[rIdx] == 0) {
					char target = word.charAt(rIdx);
					
					for(int i=0; i<size; i++) {
						if(target == word.charAt(i)) {
							check[i] = 1;
							open ++;
						}
					}
					break;
				}
				
			}
			
		}
		score = open == size ? 0 : score - open * 5;
		System.out.printf("%d점", score);
		
		
	}

}
