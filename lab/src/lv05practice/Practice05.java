package lv05practice;

import java.util.Scanner;

public class Practice05 {
	
	// # 단어 검색
		// 1. 단어를 입력받아 text 변수 문장 속에 해당 단어가 있는지 검색한다.
		// 2. 단어가 존재하면 true
		//	  단어가 없으면 false를 출력한다.
		// 3. contains() 사용안함


	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String text = "Life is too short.";
		System.out.println(text);
		
		System.out.print("검색할 단어를 입력하세요 : ");
		String word = scan.next();
		
		String a = text.toLowerCase();
		String b = text.toUpperCase();
		
		boolean result = false;
		
		for(int i=0; i<=a.length()-b.length(); i++) {
			int cnt = 0;
			for(int j=0; j<b.length(); j++) {
				if(a.charAt(i+j) == b.charAt(j))
					cnt ++ ;
			}
			if(cnt == b.length())
				result = true;
		}
		System.out.println(result);

	}

}
