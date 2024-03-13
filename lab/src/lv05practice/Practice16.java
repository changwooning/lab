package lv05practice;

import java.util.Scanner;

public class Practice16 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		String text = "Life is too short.";
		System.out.println(text);
		
		System.out.println("검색할 단어를 입력하세요");
		String word = scan.next();
		
		boolean result = false;
		for(int i=0; i<=text.length()-word.length(); i++) {
			int cnt = 0;
			for(int j=0; j<word.length(); j++) {
				if(text.charAt(i+j) == word.charAt(j))
					cnt ++;
			}
			if(cnt == word.length())
				result = true;
		}
		System.out.println(result);
		
		
	}

}
