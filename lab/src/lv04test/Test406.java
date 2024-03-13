package lv04test;

import java.util.Scanner;

public class Test406 {

	// # 나만의 마블
	// 캐릭터가 방향을 입력받을때마다 이동 하는데
	// 외각으로만 이동아래 그림참조
	// ㄴ 동d/서a/남s/북w
	// ㄴ 입력 : 이동 칸 수(1 이상)

	// 테두리로만 이동!
	// 옷◻◻◻◻︎︎︎︎
	// ◻︎︎◼︎︎◼︎︎◼︎◻
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		final int PLAYER = 1;

		final int EAST = 0;
		final int SOUTH = 1;
		final int WEST = 2;
		final int NORTH = 3;

		final int SIZE = 5;

		int[][] map = new int[SIZE][SIZE];

		int pY = 0;
		int pX = 0;

		map[pY][pX] = PLAYER;

		int dir = EAST; // 동 -> 남 -> 서 -> 북

		int move = 0; // 이동 칸 수 입력

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (i == 0 || i == SIZE - 1 || j == 0 || j == SIZE - 1) {
					map[i][j] = 0;
				} else {
					map[i][j] = 2;
				}
			}
		}

		while (true) {
			// 맵출력

			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if (map[i][j] == PLAYER)
						System.out.print("훗");
					else if (map[i][j] == 2)
						System.out.print("◼");
					else
						System.out.print("◻");
				}
				System.out.println();
			}
			System.out.println();

			// 방향 입력
			System.out.print("이동하기 : ");
			int input = scan.nextInt();

			if (input <= 0) {
				System.out.print("움직일수없음");
				continue;
			}
			map[pY][pX] = 0;

			for (int i = 0; i < input; i++) {

				// 0,4 동 -> 남
				if (pX == SIZE - 1 && dir == EAST) {
					dir = SOUTH;
					// 4,4 남 -> 서
				} else if (pY == SIZE - 1 && dir == SOUTH) {
					dir = WEST;
				} else if (pX == 0 && dir == WEST) {
					dir = NORTH;
				} else if (pY == 0 && dir == NORTH) {
					dir = EAST;
				}
				// 4,0 서 -> 북

				if (dir == EAST && pX < SIZE - 1) {
					pX++;
				} else if (dir == SOUTH && pY < SIZE - 1) {
					pY++;
				} else if (dir == WEST && pX > 0) {
					pX--;
				} else if (dir == NORTH && pY > 0) {
					pY--;
				}
				map[pY][pX] = PLAYER;
			}

		}

	}

}
