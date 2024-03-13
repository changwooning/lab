package lv06;

import java.util.Scanner;
// # 나만의 마블
// 옷 □ □ □ □
// □ ■ ■ ■ □
// □ ■ ■ ■ □
// □ ■ ■ ■ □
// □ □ □ □ □
// 옷이 이동숫자를 입력받을때 마다 이동 하는데
// 외각으로 시계방향으로만 이동 아래 그림참조
// ㄴ 입력 : 이동 칸 수 (1이상)

// 종료 조건 : 음수 입력시

class Marble {

	Scanner scan = new Scanner(System.in);

	final int PLAYER = 1;
	final int SIZE = 5;

	final int EAST = 1;
	final int WEST = 2;
	final int NORTH = 3;
	final int SOUTH = 4;

	int[][] map;

	int y;
	int x;

	int dir; // 동 -> 남 -> 서 -> 북

	int inputNumber() {

		int number = -1;
		System.out.print("move : ");
		try {
			String input = scan.next();
			int move = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력하세요.");
		}

		return number;

	}

	void printMap() {

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (map[i][j] == PLAYER)
					System.out.print("M ");
				else if (map[i][j] == 2)
					System.out.print("◼︎ ");
				else
					System.out.print("◻︎ ");
			}
			System.out.println();
		}
		System.out.println();

	}

	void setMap() {

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (i > 0 && i < SIZE - 1 && j > 0 && j < SIZE - 1)
					map[i][j] = 2;
			}
		}

	}

	void setGame() {

		y = 0;
		x = 0;

		map = new int[SIZE][SIZE];
		map[y][x] = PLAYER;
		
		dir = EAST;

	}

	void run() {

		setGame();

		while (true) {

			setMap();
			printMap();
			int move = inputNumber();


			int pY = y;
			int pX = x;


			for (int i = 0; i < move; i++) {

				if (pX < SIZE - 1 && dir == EAST) {
					pX++;
					dir = SOUTH;
				} else if (y < SIZE - 1 && dir == SOUTH) {
					pY++;
					dir = WEST;
				} else if (x > 0 && dir == WEST) {
					pX--;
					dir = NORTH;
				} else if (y > 0 && dir == NORTH) {
					pY--;
					dir = EAST;
				}
			}

			y = pY;
			x = pX;
			map[y][x] = PLAYER;

		}

	}

}

public class Ex22 {

	public static void main(String[] args) {

		Marble game = new Marble();
		game.run();

	}

}
