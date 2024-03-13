package lv05practice;

import java.util.Scanner;
import java.util.Random;

public class Practice03 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		String[] word = {"java","mysql","jsp","spring"};
		
		for(int i=0; i<100; i++) {
			int rIdx = (int)(Math.random()*3 + 1);
			String temp = word[0];
			word[0] = word[rIdx];
			word[rIdx] = temp;
		}
		for(int i=0; i<word.length; i++) {
			String temp = "";
			int rIdx = (int)(Math.random()*word[i].length());
			while(true) {
				for(int j=0; j<word[i].length(); j++) {
					if(j == rIdx)
						System.out.print("*");
					else
						System.out.print(word[i].charAt(j));
				}
				System.out.println("문제 : " + temp);
				System.out.print("정답 : ");
				String answer = scan.next();
				System.out.println("입력한 값 : " + answer);
				
				if(!answer.equals(word[i])) {
					System.out.println("틀렸습니다.");
				}else {
					System.out.println(i == word.length -1 ? "끝!!!" : "정답입니다! 다음문제");
					break;
				}
				
				
			}
		}
		

	}

}
