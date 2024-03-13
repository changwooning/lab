package lv06practice;
import java.util.Scanner;
class Tictactoep2{
	
	Scanner scan = new Scanner(System.in);
	final int SIZE = 3;
	final int P1 = 1;
	final int P2 = 2;
	
	int win;
	int turn;
	int[][] map;
	
	void printWinner() {
		
		System.out.printf("P%d WIN !!!!\n", win);
	}
	
	void checkTurn() {
		
		turn = turn == P1 ? P2 : P1;
	}
	
	int checkReversedDiagonal() {
		
		int win = 0;
		int cnt = 0;
		for(int i=0; i<SIZE; i++) {
			if(map[i][i] == turn)
				cnt ++;
		}
		if(cnt == SIZE)
			win = turn;
		
		return win;
		
	}
	
	int checkDiagonal() {
		
		int win = 0;
		int cnt = 0;
		for(int i=0; i<SIZE; i++) {
			if(map[i][SIZE - i - 1] == turn)
				cnt++;
		}
		if(cnt == SIZE)
			win = turn;
		
		return win;
		
	}
	
	int checkSero() {
		
		int win = 0;
		
		for(int i=0; i<SIZE; i++) {
			int cnt = 0;
			for(int j=0; j<SIZE; j++) {
				if(map[j][i] == turn)
					cnt ++;
			}
			if(cnt == SIZE)
				win = turn;
		}
		
		return win;
		
	}
	
	int checkGaro() {
		
		int win = 0;
		
		for(int i=0; i<SIZE; i++) {
			int cnt = 0;
			for(int j=0; j<SIZE; j++) {
				if(map[i][j] == turn)
					cnt ++;
			}
			if(cnt == SIZE)
				win = turn;
		}
		
		return win;
	}
	
	void checkWin() {
		
		win = win == 0 ? checkGaro() : win;
		win = win == 0 ? checkSero() : win;
		win = win == 0 ? checkDiagonal() : win;
		win = win == 0 ? checkReversedDiagonal() : win;
		
	}
	
	boolean marking(int position) {
		
		int y = position / 10;
		int x = position % 10;
		
		if(y < 0 || y > SIZE -1 || x < 0 || x > SIZE -1 || map[y][x] != 0)
			return false;
		
		map[y][x] = turn;
		
		return true;
		
	}
	
	int inputNumber() {
		
		
		int number = -1;
		try {
			String input = scan.next();
			number = Integer.parseInt(input);
		}catch(Exception e) {
			System.out.println("숫자를 입력하세요.");
		}
		
		
		return number;
		
	}
	
	void printMap() {
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(map[i][j] == P1)
					System.out.print("[ O]");
				else if(map[i][j] == P2)
					System.out.print("[ X]");
				else
					System.out.printf("[%d%d",i,j);
			}
			System.out.println();
		}
		System.out.println();
		
	}
	
	boolean checkDraw() {
		
		boolean isDraw = true;
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(map[i][j] == 0)
					isDraw = false;
			}
		}
		
		return isDraw;
		
	}
	
	boolean isRun() {
		
		return win == 0 && !checkDraw() ? true : false;
		
	}
	
	void setGame() {
		
		win = 0;
		turn = P1;
		map = new int[SIZE][SIZE];
		
		
	}
	
	void run() {
		
		setGame();
		while(isRun()) {
			printMap();
			int position = inputNumber();
			if(marking(position)) {
				checkWin();
				checkTurn();
			}
		}
		printWinner();
	}
	
}
public class Practice19 {

	public static void main(String[] args) {

	}

}
