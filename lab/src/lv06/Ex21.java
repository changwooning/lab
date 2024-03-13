package lv06;

import java.util.Scanner;

class Tictactoe2 {

	Scanner scan = new Scanner(System.in);

	final int SIZE = 3;
	final int P1 = 1;
	final int P2 = 2;

	int[][] map;

	int turn;
	int win;

	void setGame() {

		turn = P1;
		win = 0;
		map = new int[SIZE][SIZE];

	}

	boolean isRun() {

		return win == 0 && !checkDraw() ? true : false;
	}

	void printMap() {

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (map[i][j] == P1)
					System.out.print("[ O]");
				else if (map[i][j] == P2)
					System.out.print("[ X]");
				else
					System.out.printf("[%d%d]", i, j);
			}
			System.out.println();
		}
		System.out.println();

	}

	int inputNumber() {

		int number = -1;
		try {
			System.out.print("input : ");
			String input = scan.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자를 입력하세요.");
		}

		return number;
	}

	boolean marking(int position) {
		int y = position / 10;
		int x = position % 10;

		if (y < 0 || y > SIZE - 1 || x < 0 || x > SIZE - 1 || map[y][x] != 0)
			return false;

		map[y][x] = turn;
		
		return true;
	}

	boolean checkDraw() {

		boolean isDraw = true;

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (map[i][j] == 0)
					isDraw = false;
			}
		}

		return isDraw;
	}

	void checkWin() {
		win = win == 0 ? checkHorisontal() : win;
		win = win == 0 ? checkVertical() : win;
		win = win == 0 ? checkDiagonal() : win;
		win = win == 0 ? checkReversedDiagonal() : win;

	}

	int checkHorisontal() {

		int win = 0;

		for (int i = 0; i < SIZE; i++) {
			int cnt = 0;
			for (int j = 0; j < SIZE; j++)
				if (map[j][i] == turn)
					cnt++;
			if (cnt == SIZE)
				win = turn;
		}

		return win;
	}

	int checkVertical() {

		int win = 0;
		for (int i = 0; i < SIZE; i++) {
			int cnt = 0;
			for (int j = 0; j < SIZE; j++)
				if (map[i][j] == turn)
					cnt++;
			if (cnt == SIZE)
				win = turn;
		}

		return win;

	}

	int checkDiagonal() {

		int win = 0;
		int cnt = 0;
		for (int i = 0; i < SIZE; i++)
			if (map[i][i] == turn)
				cnt++;
		if (cnt == SIZE)
			win = turn;

		return win;

	}

	int checkReversedDiagonal() {

		int win = 0;
		int cnt = 0;
		for (int i = 0; i < SIZE; i++)
			if (map[i][SIZE - i - 1] == turn)
				cnt++;
		if (cnt == SIZE)
			win = turn;

		return win;
	}

	void changeTurn() {

		turn = turn == P1 ? P2 : P1;
	}

	void printWinner() {

		if (win != 0)
			System.out.printf("P%d WIN!!!\n", win);
		else
			System.out.println("Draw");
	}

	void run() {

		setGame();							//	게임 초기화
		while (isRun()) {					//  종료조건 확인
			printMap();	// 맵출력
			int position = inputNumber();	//사용자한테 값 입력받기(유효한 값 들어올때까지)
			if (marking(position)) {		// 유효한 값은 boolean making() 으로 보내서 계산
				checkWin();					// 마킹하고 승리자 있는지 확인
				changeTurn();				// 턴 변경
			}
		}
		printWinner();						// 겜 끝나면 승자 출력

	}

}

public class Ex21 {

	public static void main(String[] args) {

		Tictactoe2 game = new Tictactoe2();
		game.run();

	}

}
