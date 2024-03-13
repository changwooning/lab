package lv04;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		final int SIZE = 9;
		final int MARIO = 2;
		final int WALL = 1;

		final int LEFT = 1;
		final int RIGHT = 2;
		final int PUNCH = 3;

		int[] game = { 0, 0, 1, 0, 2, 0, 0, 1, 0 };

		// 플레이어 현위치
		int x = -1;

		for (int i = 0; i < SIZE; i++) {
			if (game[i] == MARIO)
				x = i;
		}

		while (true) {
			// 출력
			for (int i = 0; i < SIZE; i++) {
				if (game[i] == MARIO)
					System.out.print("M_");
				else if (game[i] == WALL)
					System.out.print("ㅣㅣ");
				else
					System.out.print("__");

			}
			System.out.printf("\n1) 왼쪽\n2) 오른쪽 \n3) 격파\n 선택 :", LEFT, RIGHT, PUNCH);
			int dir = scan.nextInt();

			// 변수를 하나 더 사용함으로써 코드를 줄일 수있음
			// 임시좌표
			int tmpX = x;

			if (dir == LEFT)
				tmpX--;
			else if (dir == RIGHT)
				tmpX++;
			else if (dir == PUNCH) {
				// 왼쪽벽 격파
				if (x > 0 && game[x - 1] == WALL) {
					game[x - 1] = 0;
					System.out.println("빠직~!");
				}
				if (x < SIZE - 1 && game[x + 1] == WALL) {
					game[x + 1] = 0;
					System.out.println("뽀지직!");
				}
			}

			// 예외 처리 (인덱스 & 벽 확인)
			if (tmpX < 0 || tmpX >= SIZE || game[tmpX] == WALL)
				continue;

			// 이동처리
			game[x] = 0;
			x = tmpX;
			game[x] = MARIO;

		}

	}

}
