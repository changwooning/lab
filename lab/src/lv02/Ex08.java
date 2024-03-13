package lv02;

import java.util.Scanner;

public class Ex08 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int gameNum = (int) (Math.random() * 100) + 1;
		int answer = 0;

		// 종료 조건 :
		// 실행 조건

		while (answer != gameNum) {
			// 사용자로부터 입력 받기 반복
			System.out.print("정답 : ");
			answer = scan.nextInt();

			if (answer < 1 || answer > 100) {
				System.out.print("입력값의 범위는 1~100입니다.");
			} else if (answer < gameNum) {
				System.out.println("더 크다");
			} else if (answer > gameNum) {
				System.out.println("더 작다");
			}
		}
		System.out.println("정답!");
		System.out.println("게임종료");
		
	}

}
