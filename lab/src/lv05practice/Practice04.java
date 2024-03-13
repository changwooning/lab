package lv05practice;

import java.util.Scanner;

public class Practice04 {
	
	// 문자열 비교
	// .equals .compareTo 사용없이 비교하기		
	// 예)코끼리
	// 입력 티라노사우르스
	// 출력 false

	// 결과를 담을 boolean변수 생성
	// 길이 비교 -> 다르면 false
	// (같으면) 각각의 인덱스별로 비교 -> 다르면 false
			

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String name = "코끼리";
		System.out.println(name);
		System.out.print("동물 이름 입력 : ");
		String myName = scan.next();
		
		int size = name.length();
		boolean result = false;
		if(name.length() == myName.length()) {
			int cnt = 0;
			for(int i=0; i<name.length(); i++) {
				if(name.charAt(i) == myName.charAt(i))
					cnt ++;
				if(cnt == size)
					result = true;
			}
		}

	}

}
