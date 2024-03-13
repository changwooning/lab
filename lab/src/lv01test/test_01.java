package lv01test;

import java.util.Random;

import java.util.Scanner;

public class test_01 {

	// 모든 문제 최상단에 다음 주석 추가 (분:초)

	// 시작 14: 37
	// 종료 15:03
	// 소요 00:00

	public static void main(String[] args) {

		// 문제 1)
		// 가위바위보 게임 만들기
		// ㄴ 가위(0)바위(1)보(2)
		// com : 랜덤 0~2 추출
		// me : 입력 0~2
		// 승자 출력

		Random random = new Random();
		Scanner scan = new Scanner(System.in);

		int com = random.nextInt(3);

		System.out.println("가위(0) 바위(1) 보(2)");
		System.out.println("com : " + com);

		System.out.println("가위(0) 바위(1) 보(2)");
		System.out.print("me : ");

		int me = scan.nextInt();
		System.out.print("me : ");

		if ((me == 0 && com == 2) || (me == 1 && com == 0) || (me == 2 && com == 1)) {
			System.out.print("이겼다");
		} else if (me == com) {
			System.out.print("비겼다");
		} else {
			System.out.print("졌다");
		}

	}

}
