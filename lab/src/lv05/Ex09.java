package lv05;

import java.util.Scanner;

public class Ex09 {

	// # 끝말잇기 게임
	// 제시어 : 자건거
	// 입력 : 거미
	// 제시어 : 거미
	// 입력 : 미술
	// ...

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// char 문자 한개 비교
		// ㄴ 비교 연산자 사용가능 (== !=)

		String start = "자전거";

		while (true) {
			System.out.println("제시어 : " + start);

			System.out.print("입력 : ");
			String input = scan.next();

			char end = start.charAt(start.length() - 1);
			char begin = input.charAt(0);

			if (end != begin)
				break;

			start = input;		// 인풋값을 스타트에 저장
		}

		System.out.println("GAME OVER~");

	}

}
