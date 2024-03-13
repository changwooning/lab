package lv07practice;

import java.util.Scanner;

class Ticp1 {

	boolean isMarked; // false;
	int owner; // 0

	@Override
	public String toString() {
		return isMarked ? (owner == 1 ? "O" : "X") : "[ ]";
	}

}

class Tictactoep1 {

	// 게임 구현
	Scanner scan = new Scanner(System.in);
	final int P1 = 1;
	final int P2 = 2;
	final int SIZE = 3;

	Ticp1[][] map;

	int turn;
	int win;
	
	void printResult() {
		
		System.out.printf("P%d WIN!!!\n", win);
		
		
	}
	
	void changeTurn() {
		
		turn = turn == P1 ? P2 : P1;
		
	}
	
	boolean checkReveredDiagonal() {
		
		int cnt = 0;
		for(int i=0; i<SIZE; i++) {
			if(map[i][SIZE - i - 1].owner == turn)
				cnt ++;
		}
		if(cnt == SIZE) {
			win = turn;
			return true;
		}
		
		return false;
		
	}
	
	boolean checkDiagonal() {
		
		int cnt = 0;
		for(int i=0; i<SIZE; i++) {
			if(map[i][i].owner == turn)
				cnt ++;
		}
		if(cnt == SIZE) {
			win = turn;
			return true;
		}
		
		return false;
		
	}
	
	boolean checkVertical() {
		
		for(int i=0; i<SIZE; i++) {
			int cnt = 0;
			for(int j=0; j<SIZE; j++) {
				if(map[i][j].owner == turn)
					cnt ++;
			}
			if(cnt == SIZE) {
				win = turn;
				return true;
			}
		}
		
		return false;
		
	}
	
	boolean checkHorisontal() {
		
		for(int i=0; i<SIZE; i++) {
			int cnt = 0;
			for(int j=0; j<SIZE; j++) {
				if(map[i][j].owner == turn)
					cnt ++;
			}
			if(cnt == SIZE) {
				win = turn;
				return true;
			}
		}
		
		return false;
		
	}

	void checkWin() {

		if (checkHorisontal())
			return;
		else if (checkVertical())
			return;
		else if (checkDiagonal())
			return;
		else if (checkReveredDiagonal())
			return;

	}
	
	boolean isDraw() {
		
		int cnt = 0;
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(map[i][j].isMarked)
					cnt++;
			}
		}
		if(cnt == SIZE * SIZE)
			return true;
		return false;
		
		
	}

	void marking() {

		int y = inputNumber("P " + turn + " y");
		int x = inputNumber("P " + turn + " x");

		if (y < 0 || y > SIZE - 1 || x < 0 || x > SIZE - 1 || map[y][x].isMarked)
			return;

		Ticp1 tic = map[y][x];
		tic.isMarked = true;
		tic.owner = turn;
		
		checkWin();
		changeTurn();

	}

	int inputNumber(String message) {

		int number = -1;
		System.out.println(message + " : ");
		try {
			String input = scan.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("숫자를 입력하세요.");
		}
		return number;
	}

	void printMap() { // Ticp1에 만들어 놓은걸 불러오면 됨 (setMap)

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.println(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();

	}

	boolean isRun() {

		return win == 0 && !isDraw() ? true : false;

	}

	void setMap() {

		map = new Ticp1[SIZE][SIZE]; // -> null 인 상태
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				map[i][j] = new Ticp1(); // null -> 객체 인스턴스 (값을 담을 수 있음)
			}
		}

	}

	void setGame() {

		turn = P1;
		win = 0;
		setMap();

	}

	void run() {

		setGame();
		while (isRun()) {
			printMap();
			marking();
		}
		printResult();

	}

}

public class Practice02 {

	public static void main(String[] args) {

		Tictactoep1 game = new Tictactoep1();
		game.run();

	}

}
