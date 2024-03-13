package lv05;

import java.util.Scanner;


public class Ex14 {
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String text = "Life is too short.";
		System.out.println(text);
		
		System.out.print("검색할 단어를 입력하세요 : ");
		String word = scan.nextLine();
		
		String a = text.toLowerCase();
		String b = word.toLowerCase();
		
		// word를 검색하기 위한 시작점을 도는 반복문
		// text : abcd
		//		  012
		// word : ab
		
		boolean result = false;
		
		for(int i=0; i<=a.length()- b.length(); i++) {
			int cnt = 0;
			for(int j=0; j<b.length(); j++) {
				if(a.charAt(i+j) == b.charAt(j))	// j : word 문자열의 각 인덱스
					cnt ++;
			}
			if(cnt == b.length())
				result = true;
		}
		System.out.println(result);
		
		
		
		
		
	}

}
