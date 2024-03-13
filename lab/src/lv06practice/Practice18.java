package lv06practice;
import java.util.Scanner;
// 틱택토
class Tictactoep1{
	
	Scanner scan = new Scanner(System.in);
	
	final int SIZE = 3;
	final int P1 = 1;
	final int P2 = 2;
	
	int[][] map;
	
	int turn;
	int win;
	
	void printWinner() {
		
		if(win != 0)
			System.out.printf("P%d win!!!\n", win);
		else
			System.out.println("draw");
	}
	
	void changeTurn() {
		
		turn = turn == P1 ? P2 : P1;
		
	}
	
	int checkHorisontal() {
		
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
	
	int checkVertical() {
		
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
	
	int checkDiagonal() { // /
		
		int win = 0;
		
		int cnt = 0;
		for(int i=0; i<SIZE; i++) {
			if(map[i][SIZE - i - 1] == turn)
				cnt ++;
		}
		if(cnt == SIZE)
			win = turn;
		
		return win;
		
	}
	
	int checkReversedDiagonal() { 	// \
		
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
	
	void checkWin() {	// 승리조건
		
		win = win == 0 ? checkHorisontal() : win;
		win = win == 0 ? checkVertical() : win;
		win = win == 0 ? checkDiagonal() : win;
		win = win == 0 ? checkReversedDiagonal() : win;
		
	}
	
	boolean marking(int position) {
		
		int y = position / 10;
		int x = position % 10;
		
		if(y < 0 || y > SIZE -1 || x < 0 || x > SIZE - 1 || map[y][x] != 0)
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
					System.out.printf("[%d%d]",i,j);
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
	
	void setGame(){
		
		map = new int[SIZE][SIZE];
		turn = P1;
		win = 0;
		
	}
	
	void run() {
		
		setGame();
		while(isRun()) {
			printMap();
			int position = inputNumber();
			if(marking(position)) {
				checkWin();
				changeTurn();
			}
		}
		printWinner();
		
	}
	
}
public class Practice18 {

	public static void main(String[] args) {

	}

}
