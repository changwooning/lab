package lv07;

import java.util.Scanner;

class Tic2 {

	boolean isMarked; // false;
	int owner; // 0

	@Override
	public String toString() {
		return isMarked ? (owner == 1 ? "[O]" : "[X]") : "[ ]";
	}

}

class Tictactoe2 {
	// 게임 구현
	Scanner scan = new Scanner(System.in);
	final int P1 = 1;
	final int P2 = 2;
	final int SIZE = 3;
	
	Tic2[][] map;

	int turn;
	int win;
	
	
	

	void marking() {

		int y = inputNumber("P" + turn + " y");
		int x = inputNumber("P" + turn + " x");
		
		if(y < 0 || y > SIZE -1 || x < 0 || x > SIZE - 1 || map[y][x].isMarked)
			return;
		
		Tic2 tic = map[y][x];
		tic.isMarked = true;
		tic.owner = turn;
		
		checkWin();
		changeTurn();
		
		
	}
	
	void changeTurn() {
		
		turn = turn == P1 ? P2 : P1;
	}
	
	void checkWin() {
		
		if(checkHorisontal())
			return;
		if(checkVertical())
			return;
		if(checkDiagonal())
			return;
		if(checkReveredDiagonal())
			return;
		
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
	
	boolean checkVertical() {
		
		for(int i=0; i<SIZE; i++) {
			int cnt = 0;
			for(int j=0; j<SIZE; j++) {
				if(map[j][i].owner == turn)
					cnt ++;
			}
			if(cnt == SIZE) {
				win = turn;
				return true;
			}
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

	int inputNumber(String message) {

		int number = -1;
		System.out.print(message + " : ");
		try {
			String input = scan.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("숫자를 입력하세요.");
		}
		return number;

	}

	void printMap() {

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++)
				System.out.print(map[i][j]);
			System.out.println();
		}
		System.out.println();

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

	boolean isRun() {

		return win == 0 && !isDraw() ? true : false;

	}
	
	void printResult() {
		
		if(win == 0)
			System.out.println("draw");
		else
			System.out.printf("P%d WIN !!!", win);
	}

	void setGame() {

		turn = P1;
		win = 0;

		setMap();
	}

	void setMap() {

		map = new Tic2[SIZE][SIZE]; // 현 상태 null

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				map[i][j] = new Tic2(); // null -> 객체 인스턴스
			}
		}

	}

	void run() {

		setGame();
		while (isRun()) {
			printMap();
			marking();
		}
		//printMap();
		printResult();
	}

}

public class Ex04 {

	public static void main(String[] args) {
		
		Tictactoe2 tic = new Tictactoe2();
		tic.run();
		

	}

}
