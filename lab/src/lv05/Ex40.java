package lv05;

import java.util.Scanner;
import java.util.Random;

public class Ex40 {

	// # 크레이지 아케이드
	// 1. 맵의 크기는 7 * 7 이다.
	// 2. 상(w)하(s)좌(a)우(d)로 이동이 가능하며,
	// 폭탄설치(e), 폭파(q)로 설정한다.
	// 3. 벽(3), 플레이어(2), 폭탄(9), 아이템(4)로 설정한다.
	// 4. 단, 폭탄이 설치된 순서대로 터져야 하며,
	// 폭파 시 십자가 형태로 터진다.
	// 5. 벽 파괴시 아이템이 랜덤하게 생성되어,
	// 아이템을 먹으면 설치할 수 있는 폭탄의 개수가 증가된다.

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		final int SIZE = 7;
		final int PLAYER = 2;
		final int WALL = 3;
		final int ITEM = 4;
		final int BOMB = 9;
		final int ROAD = 0;

		// 맵크기 7 * 7
		int[][] map = new int[SIZE][SIZE];

		// 벽
		int wallY = 0;
		int wallX = 0;

		// 아이템
		int itemY = 0;
		int itemX = 0;

		// 플레이어
		int pY = 0;
		int pX = 0;

		// 폭탄
		int bombY = 0;
		int bombX = 0;

		int wallCount = 0;

		while (wallCount < 10 || wallCount > 20) {
			System.out.print("설치할 벽 개수 : ");
			wallCount = scan.nextInt();
		}

		while (wallCount > 0) {
			int rY = ran.nextInt(SIZE);
			int rX = ran.nextInt(SIZE);

			if (map[rY][rX] == ROAD) {
				map[rY][rX] = WALL;
				wallCount--;
			}
		}

		// 플레이어 설치
		while (true) {

			int rY = ran.nextInt(SIZE);
			int rX = ran.nextInt(SIZE);

			if (map[rY][rX] == ROAD) {
				// 사방검사
				int cnt = 0;
				for (int i = -1; i <= 1; i++) {
					if (rY + i >= 0 && rY + i <= SIZE - 1 && map[rY + i][rX] == WALL)
						cnt++;
					if (rX + i >= 0 && rX + i <= SIZE - 1 && map[rY][rX + i] == WALL)
						cnt++;
				}
				if (cnt < 2) {
					map[rY][rX] = PLAYER;
					pY = rY;
					pX = rX;
					break;
				}
			}
		}
		while (true) {
			// print
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if (map[i][j] == PLAYER)
						System.out.print("🐶  ");
					else if (map[i][j] == WALL)
						System.out.print("◼︎   ");
					else if (map[i][j] == ITEM)
						System.out.print("❄︎   ");
					else if (map[i][j] == BOMB)
						System.out.print("@   ");
					else if (map[i][j] == ROAD)
						System.out.print("•   ");
				}
				System.out.println();
			}
			System.out.println();

			// 이동처리
			System.out.println("상(w)하(s)좌(a)우(d)");
			System.out.println("폭탄설치(e)");
			System.out.println("폭탄폭파(q)");
			String input = scan.next();

			int y = pY;
			int x = pX;

			if (input.equals("w"))
				y--;
			else if (input.equals("s"))
				y++;
			else if (input.equals("a"))
				x--;
			else if (input.equals("d"))
				x++;
			else if (input.equals("e")) {
				while (true) {
					map[y][x] = BOMB;
					bombY = y;
					bombX = x;
					break;
				}

			} else if (input.equals("q")) {

			}

			// 예외처리 1. 이동
			if (y < 0 || y > SIZE - 1 || x < 0 || x > SIZE - 1 || map[y][x] == WALL) {
				System.out.println("이동불가~");
				continue;
			}
			// 예외처리 2. 폭탄 같은때랑
			// 폭탄 설치 (e)
			// 폭탄 폭파 (q)
			// ㄴ 플레이어 현재 위치에 깔아 놓는 것이고
			// ㄴ 폭탄은 사방으로 터진다

			map[pY][pX] = ROAD;
			pY = y;
			pX = x;
			map[pY][pX] = PLAYER;
			// 벽이 부셔졌을때 아이템 랜덤 생성

		}

	}

}
