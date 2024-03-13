package lv04practice;

import java.util.Scanner;

public class Practice31 {

	// 숫자 이동
	// 1818
	// 1832

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		final int SIZE = 9;
		final int MARIO = 2;
		final int WALL = 1;

		final int LEFT = 1;
		final int RIGHT = 2;
		final int PUNCH = 3;

		int[] game = { 0, 0, 1, 0, 2, 0, 0, 1, 0 };

		int x = -1;

		for (int i = 0; i < SIZE; i++) {
			if (game[i] == MARIO)
				x = i;
		}

		boolean run = true;
		while (run) {

			// 맵출력
			for (int i = 0; i < SIZE; i++) {
				if (game[i] == MARIO)
					System.out.print("M_");
				else if (game[i] == WALL)
					System.out.print("ㅣㅣ");
				else
					System.out.print("__");
			}
			System.out.println();

			// 입력
			System.out.printf("1)왼쪽 2)오른쪽 3)뿌시기 \n선택 : ", LEFT, RIGHT, PUNCH);
			int dir = scan.nextInt();

			// 임시좌표
			int tmpX = x;

			if (dir == LEFT)
				tmpX--;
			else if (dir == RIGHT)
				tmpX++;
			else if (dir == PUNCH) {
				// 왼쪽일때
				if (x > 0 && game[x - 1] == WALL) {
					game[x - 1] = 0;
					System.out.println("빠직-");
				}
				if (x < SIZE - 1 && game[x + 1] == WALL) {
					game[x + 1] = 0;
					System.out.println("꽝-");
				}
			}

			// 예외처리 인덱스 범위 & 벽 일때
			if (tmpX < 0 || tmpX > SIZE - 1 || game[tmpX] == WALL)
				continue;

			// 이동처리
			game[x] = 0;
			x = tmpX;
			game[x] = MARIO;

		}

	}

}
