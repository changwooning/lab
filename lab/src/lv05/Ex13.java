package lv05;

import java.util.Scanner;

public class Ex13 {
	
	// matches 
	// ㄴ 문자열 패턴 여부
	// ㄴ return boolean

	// 알파벳으로 이루어진문자열에 대하여
	// String.toUpperCase() -> 대문자로 변경
	// String.toLowerCase() -> 소문자로 변경
	
	public static void main(String[] args) {
		
		// 숫자만, 문자만, 둘다있다 출력
				Scanner scan = new Scanner(System.in);

				System.out.println("입력: ");
				String text = scan.next();

				String str = "abc";
				str = str.toLowerCase();
				
//				int cnt = 0;
//				for(int i = 0 ;i<text.length();i++) {
//					char target = text.charAt(i);
//					if(target>='0'&&target<='9')
//						cnt++;
//				}
//				
//				if(cnt==0)
//					System.out.println("문자만 있음");
//				else if(cnt==text.length())
//					System.out.println("숫자만 있음");
//				else
//					System.out.println("문자와 숫자가 섞여있다.");
				
//				String nums = "0123456789";
//				int cnt = 0;
//				for (int i = 0; i < text.length(); i++) {
//					char target = text.charAt(i);
//					if (nums.contains(String.valueOf(target)))
//						cnt++;
//				}
//				if (cnt == 0)
//					System.out.println("문자만 있음");
//				else if (cnt == text.length())
//					System.out.println("숫자만 있음");
//				else
//					System.out.println("문자와 숫자가 섞여있다.");

//				boolean isAllNumber = text.split("\\d").length==0;
//				boolean isAllChar = text.split("\\D").length==0;
				boolean isAllNumber = text.matches("\\d+");
				boolean isAllChar = text.matches("\\D+");
				
				if(isAllChar)
					System.out.println("문자만 있다.");
				else if(isAllNumber)
					System.out.println("숫자만 있다.");
				else
					System.out.println("문자와 숫자가 섞여있다.");

	}

}
