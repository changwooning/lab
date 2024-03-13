package lv04practice;

import java.util.Scanner;
import java.util.Random;

public class Practice76 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		final int SIZE = 7;
		final int PLAYER = 2; // ▲
		final int BALL = 3; // ●
		final int GOAL = 7; // ☐
		final int WALL = 9; // ■
		final int LOAD = 0; // +︎

		int[][] map = new int[SIZE][SIZE];

		int wallCount = 0;

		// 플레이어 1명
		int pY = 0;
		int pX = 0;

		// 공 1개
		int ballY = 0;
		int ballX = 0;

		// 골대 1개
		int goalY = 0;
		int goalX = 0;

		// 벽 설치(개수만큼 랜덤 좌표에 배치, 벽 개수 10개)
		while (wallCount < 1 || wallCount > 10) {
			System.out.print(">>> 설치할 벽 개수를 입력하세요 : ");
			wallCount = scan.nextInt();
		}

		while (wallCount > 0) {
			// 랜점 좌표 뽑기
			int rY = ran.nextInt(SIZE);
			int rX = ran.nextInt(SIZE);

			if (map[rY][rX] == LOAD) {
				map[rY][rX] = WALL;
				wallCount--;
			}
		}
		// 공설치
		while (true) {
			// 벽에서 떨구기 위해서 한칸
			int rY = ran.nextInt(SIZE - 2) + 1;
			int rX = ran.nextInt(SIZE - 2) + 1;

			if (map[rY][rX] == LOAD) {
				// 랜덤 좌표에 대한 사방 검사
				int cnt = 0;
				for (int i = -1; i <= 1; i++) {
					// 세로방향
					if (map[rY + i][rX] == WALL)
						cnt++;
					// 가로방향
					if (map[rY][rX + i] == WALL)
						cnt++;
				}
				if (cnt < 2) {
					// 공설치
					map[rY][rX] = BALL;
					ballY = rY;
					ballX = rX;
					break;
				}

			}
		}
		// 골대 설치
		while (true) {
			int rY = ran.nextInt(SIZE);
			int rX = ran.nextInt(SIZE);

			if (map[rY][rX] == LOAD) {
				map[rY][rX] = GOAL;
				goalY = rY;
				goalX = rX;
				break;
			}
		}
		// 플레이어 배치
		while (true) {
			int rY = ran.nextInt(SIZE);
			int rX = ran.nextInt(SIZE);

			if (map[rY][rX] == LOAD) {
				// 랜덤좌표에 대한 사방검사
				int cnt = 0;
				for (int i = -1; i <= 1; i++) {
					// 세로방향
					if (rY + i >= 0 && rY + i < SIZE && map[rY + i][rX] == WALL)
						cnt++;
					// 가로방향
					if (rX + i >= 0 && rX + i < SIZE && map[rY][rX + i] == WALL)
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
		// run
		boolean isGoal = false;
		while (true) {
			// print
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					int block = map[i][j];
					if (block == PLAYER)
						System.out.print("▲");
					else if (block == BALL)
						System.out.print("●");
					else if (block == GOAL) {
						if (isGoal)
							System.out.print("☐ ");
						else if (pY == goalY && pX == goalX)
							System.out.print("♽");
						else
							System.out.print("◉");
					} else if (block == WALL)
						System.out.print("■");
					else if (block == LOAD)
						System.out.print("+");
				}
				System.out.println();
			}
			System.out.println();

			// end

			// move
			System.out.print("a서 d동 w북 s남");
			String dir = scan.next();

			// 플레이어에 대한 이동처리
			// ㄴ 맵 범위 바껭 대한 예외처리
			// ㄴ 구조물(벽,골대)에 대한 예외처리

			// 이동처리 전 임시좌표
			int y = pY;
			int x = pX;
			int a = ballY;
			int b = ballX;

			if (dir.equals("a")) {
				x--;
				b--;
			} else if (dir.equals("d")) {
				x++;
				b++;
			} else if (dir.equals("w")) {
				y--;
				a--;
			} else if (dir.equals("s")) {
				y++;
				b++;
			}

			// 임시좌표 변화를 가지고 예외처리
			if (x < 0 || x > SIZE - 1 || y < 0 || y > SIZE - 1 || map[y][x] == WALL || map[y][x] == GOAL)
				continue;

			// 공 움직이기
			if (map[y][x] == BALL) {
				// 공 좌표에 대한 예외처리
				if (a < 0 || a > SIZE - 1 || b < 0 || b > SIZE - 1 || map[a][b] == WALL)
					continue;

				if (map[a][b] == GOAL)
					isGoal = true;
				map[ballY][ballX] = LOAD;
				ballY = a;
				ballX = b;
				map[ballY][ballX] = BALL;
			}
			map[pY][pX] = LOAD;
			pY = y;
			pX = x;
			map[pY][pX] = PLAYER;

		}

	}

}
