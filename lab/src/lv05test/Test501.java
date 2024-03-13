package lv05test;

import java.util.Scanner;

public class Test501 {

	// lv5 test
	// # 단어 교체하기
	// 1. text 변수 문장 속에서 변경하고 싶은 단어를 입력받아,
	// 2. 교해해주는 기능을 구현한다.
	// 예) Life is too short.
	// 변경하고 싶은 단어입력 : Life
	// 바꿀 단어 입력 : Time

	// Time is too short.

	// 1005
	// 1355

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String text = "Life is too too short.";
		System.out.println(text);

		System.out.print("변경하고 싶은 단어를 입력하세요 : ");
		String word = scan.next();

		System.out.print("변경할 단어를 입력하세요 : ");
		String newWord = scan.next();

		int size = word.length();
		String data = "";
		for (int i = 0; i < text.length(); i++) {
			int cnt = 0;
			for (int j = 0; j < word.length(); j++) {
				if (i+j < text.length() && text.charAt(i+j) == word.charAt(j))
					cnt++;
			}
			if (cnt == size) {
				data += newWord;
				i += word.length()-1;
			}
			else
				data += text.charAt(i);
		}
		System.out.println(data);
		
		
	}
}
