package lv04practice;

import java.util.Scanner;

public class Practice04 {

	// 숫자이동 2단계

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		final int MARIO = 2;
		final int WALL = 1;
		final int SIZE = 9;

		final int LEFT = 1;
		final int RIGHT = 2;
		final int PUNCH = 3;

		int[] game = { 0, 1, 0, 2, 0, 0, 1, 0, 0 };

		int x = -1;

		for (int i = 0; i < SIZE; i++) {
			if (game[i] == MARIO)
				x = i;
		}

		while (true) {

			for (int i = 0; i < SIZE; i++) {
				if (game[i] == MARIO)
					System.out.print("M_");
				else if (game[i] == WALL)
					System.out.print("ㅣㅣ");
				else
					System.out.print("__");
			}

			// 입력
			System.out.print("1.왼쪽 2.오른쪽 3.뿌시기");
			int input = scan.nextInt();

			// 플레이어 임시변수 => 임시변수를 두는지
			int tmpX = x;

			if (input == LEFT)
				tmpX--;
			else if (input == RIGHT)
				tmpX++;
			else if (input == PUNCH) {
				// 왼쪽일때
				if (x > 0 && game[x - 1] == WALL) {
					System.out.println("꽈직!");
					game[x - 1] = 0;
				}
				if (x < SIZE - 1 && game[x + 1] == WALL) {
					System.out.println("빠직!");
					game[x + 1] = 0;
				}
			}

			// 예외처리
			if (tmpX < 0 || tmpX > SIZE - 1 || game[tmpX] == WALL)
				continue;

			// 이동처리
			game[x] = 0;
			x = tmpX;
			game[x] = MARIO;

		}

	}

}
