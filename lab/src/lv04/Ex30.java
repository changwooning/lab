package lv04;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Ex30 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		final int SIZE = 9;
		final int LEFT = 1;
		final int RIGHT = 2;

		int n = 0;
		while (n < 2) {
			System.out.print("참여 인원 수 : ");
			n = scan.nextInt();
		}

		String menu[] = new String[n];
		boolean[] isOpen = new boolean[n]; // {false, false,false,false,false}
		int ladder[][] = new int[SIZE][n];

		for (int i = 0; i < n; i++) {
			System.out.print("먹고 싶은거? ");
			menu[i] = scan.next();
		}

		// 사다리 규칙
		while (true) {
			ladder = new int[SIZE][n];
			for (int i = 1; i < SIZE - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					if (j == 0) {
						ladder[i][j] = ran.nextInt(2);
						if (ladder[i][j] == LEFT)
							ladder[i][j + 1] = RIGHT;
					} else if (ladder[i][j] == 0 && ladder[i][j - 1] != 2) {
						ladder[i][j] = ran.nextInt(2);
						if (ladder[i][j] == LEFT)
							ladder[i][j + 1] = RIGHT;
					}
				}
			}
			// 예외처리 전체구간을 다 봐야하니까
			int cnt1 = 0;
			for (int i = 0; i < n - 1; i++) {
				int cnt = 0;
				for (int j = 0; j < SIZE - 1; j++) {
					if (ladder[j][i] == LEFT)
						cnt++;
				}
				if (cnt != 0)
					cnt1++;
			}
			if (cnt1 == n - 1)
				break;
		}
		// ├ ─ ┤ │

		// 랜덤 사다리 생성

		while (true) {
			// print
			for (int i = 0; i < n; i++) {
				System.out.print(i + 1 + " ");
			}
			System.out.println();
			// 맵출력
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < n; j++) {
					if (ladder[i][j] == LEFT)
						System.out.print("├─");
					else if (ladder[i][j] == RIGHT)
						System.out.print("┤ ");
					else
						System.out.print("│ ");
				}
				System.out.println();
			}
			System.out.println();

			for (int i = 0; i < n; i++) {
				System.out.print("◼︎ ");
			}

			// end
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				if (isOpen[i])
					cnt++;
			}
			if (cnt == n)
				break;

			// input
			System.out.print("\n번호 선택 : ");
			int x = scan.nextInt() - 1;

			if (x < 0 || x > n - 1) {
				System.out.println("입력범위는 1~5입니다.");
				continue;
			}

			// 여기가 핵심 주요깊게 보기
			for (int y = 0; y < SIZE; y++) {
				if (ladder[y][x] == LEFT)
					x++;
				else if (ladder[y][x] == RIGHT)
					x--;
			}
			if (isOpen[x])
				System.out.println("이미 고른 메뉴입니다.");
			else {
				System.out.printf("%s 메뉴 당첨!\n", menu[x]);
				isOpen[x] = true;
			}

		}

	}

}
