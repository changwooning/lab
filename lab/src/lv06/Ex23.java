package lv06;

import java.util.Scanner;

class Marble2 {

	Scanner scan = new Scanner(System.in);

	final int PLAYER = 1;
	final int SIZE = 5;

	final int EAST = 0;
	final int SOUTH = 1;
	final int WEST = 2;
	final int NORTH = 3;

	int[][] map;

	int y;
	int x;

	int dir; // 동 -> 남 -> 서 -> 북
	boolean isRun;


	boolean isEnd(int distance) {

		if (distance < 0) {
			isRun = false;
			return true;
		}
		return false;
	}
	void putPlayer(int x, int y) {
		
		// 플레이어 다시 그리기
		map[this.y][this.x] = 0;
		this.x = x;
		this.y = y;
		map[this.y][this.x] = PLAYER;
		
	}

	void move(int distance) {

		if (isEnd(distance)) {
			isRun = false;
			return;
		}
		// 지역변수를 클래스 멤버 변수의 값으로 초기화
		int x = this.x;
		int y = this.y;

		while (distance > 0) {
			int tempX = x;
			int tempY = y;

			// distance %= SIZE * 4 - 4; => 해도되고 안해도 되고

			if (dir == EAST)
				tempX++;
			else if (dir == SOUTH)
				tempY++;
			else if (dir == WEST)
				tempX--;
			else if (dir == NORTH)
				tempY--;

			if (!checkDirection(tempX, tempY))
				continue;

			x = tempX;
			y = tempY;

			distance--;
		}
		putPlayer(x, y);
	}

	boolean checkDirection(int x, int y) {
		boolean isChecked = true;

		// 네 코너를 벗어나는 순간 확인 -> 방향전환 ( 동남서북)
		if (x < 0 || x > SIZE - 1 || y < 0 || y > SIZE - 1) {
			dir = dir + 1 > NORTH ? EAST : ++dir;
			isChecked = false;
		}
		return isChecked;
	}

	int inputNumber() {

		int number = 0;
		try {
			String input = scan.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자를 입력하세요.");
		}
		return number;
	}

	void printMap() {

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (map[i][j] == PLAYER)
					System.out.print("M ");
				else if (i == 0 || i == SIZE - 1 || j == 0 || j == SIZE - 1)
					System.out.print(" ◻ ︎");
				else
					System.out.print(" ◼ ");
			}
			System.out.println();
		}
		System.out.println();
	}

	void setGame() {

		map = new int[SIZE][SIZE];
		x = 0;
		y = 0;
		dir = EAST;
		isRun = true;

	}

	void run() {

		setGame();
		while (isRun) {
			printMap();
			int number = inputNumber();
			move(number);

		}

	}

}

public class Ex23 {

	public static void main(String[] args) {

		Marble2 game = new Marble2();
		game.run();
	}

}
