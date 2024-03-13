package lv06test;

import java.util.Scanner;
//틱택토 : 클래스 메소드
// TEST6 3번
// 1130
// 1229

class Tictactoe {

	Scanner scan = new Scanner(System.in);
	int[][] map;
	final int SIZE = 3;
	final int P1 = 1;
	final int P2 = 2;
	int turn;
	int win;

	void result() {

		System.out.printf("P%d WIN!!!", win);

	}

	void turn() {

		turn = turn == P1 ? P2 : P1;

	}

	void rediagonally() {

		// \
		int cnt = 0;
		for (int i = 0; i < SIZE; i++) {
			if (map[i][i] == turn)
				cnt++;
		}
		if (cnt == SIZE)
			win = turn;

	}

	void diagonally() {

		// / 0,2 1,1 2,0
		int cnt = 0;
		for (int i = 0; i < SIZE; i++) {
			if (map[i][SIZE - i - 1] == turn)
				cnt++;
		}
		if (cnt == SIZE)
			win = turn;

	}

	void length() {

		// |
		for (int i = 0; i < SIZE; i++) {
			int cnt = 0;
			for (int j = 0; j < SIZE; j++)
				if (map[j][i] == turn)
					cnt++;
			if (cnt == SIZE)
				win = turn;
		}

	}

	void transverse() {

		// -
		for (int i = 0; i < SIZE; i++) {
			int cnt = 0;
			for (int j = 0; j < SIZE; j++)
				if (map[i][j] == turn)
					cnt++;
			if (cnt == SIZE)
				win = turn;
		}

	}

	boolean exception(int y, int x) {

		if (y < 0 || y > SIZE - 1 || x < 0 || x > SIZE - 1) {
			System.out.println("입력 범위 오류");
			return false;
		}

		if (map[y][x] != 0) {
			System.out.println("이미 마킹된 자리 입니다.");
			return false;
		}

		map[y][x] = turn;

		return true;

	}

	int inputX() {

		System.out.printf("[P%d] : ", turn);
		int x = scan.nextInt();

		return x;
	}

	int inputY() {

		System.out.printf("[P%d] : ", turn);
		int y = scan.nextInt();

		return y;

	}

	void setPrint() {

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (map[i][j] == 1)
					System.out.print("[O]");
				else if (map[i][j] == 2)
					System.out.print("[X]");
				else
					System.out.print("[ ]");
			}
			System.out.println();
		}
		System.out.println();

	}

	void setGame() {

		turn = P1;
		map = new int[SIZE][SIZE];

	}

	void run() {

		setGame();
		while (true) {
			setPrint();
			if (win != 0)
				break;
			int input1 = inputY();
			int input2 = inputX();
			if (exception(input1, input2)) {
				turn();
				transverse();
				length();
				diagonally();
				rediagonally();
			}
		}
		result();
	}

}

public class Test603 {

	public static void main(String[] args) {

		Tictactoe game = new Tictactoe();
		game.run();

	}

}
