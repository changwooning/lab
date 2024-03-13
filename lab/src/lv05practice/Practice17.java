package lv05practice;

import java.util.Scanner;

public class Practice17 {
	
	// # 단어 교체하기(replace)
		// 1. text변수 문장 속에서 변경하고 싶은 단어를 입력받아,
		// 2. 교체해주는 기능을 구현한다.
		// ㅇㅖ)
		// Life is too short.
		// 변경하고 싶은 단어입력 : Life
		// 바꿀 단어입력 : Time
		//

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String text = "life is too too short.";
		System.out.println(text);
		
		System.out.print("변경하고 싶은 단어를 고르세요 : ");
		String word = scan.next();
		
		System.out.print("변경할 단어를 입력하세요 : ");
		String newWord = scan.next();
		
		int size = text.length();
		String result = "";
		
		for(int i=0; i<size; i++) {
			int cnt = 0;
			for(int j=0; j<word.length(); j++) {
				if(i+j < size && text.charAt(i+j) == word.charAt(j))
					cnt ++;
			}
			if(cnt == word.length()) {
				result += newWord;
				i += word.length()-1;		//
			}else
				result += text.charAt(i);
		}
		System.out.println(result);
	}
}
