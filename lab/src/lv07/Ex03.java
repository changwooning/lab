package lv07;
import java.util.Scanner;

class Tic{
	// 네모 한칸
	// ㄴ 속성이 뭐가 있을까 ?
	// ㄴ toString() override
	int turn;
	int P1,P2;
	
	
	
}

class Tictactoe{
	// 게임 구현
	// ㄴ tic[][] map = new tic[3][3];
	Scanner scan = new Scanner(System.in);
	final int SIZE = 3;
	final int P1 = 1;
	final int P2 = 2;
	int[][] map;
	int turn;
	int win;
	int cnt;
	
	void printWin() {
		
		System.out.printf("P%d WIN!!!\n",win);
	}
	
	void changeTurn() {
		
		turn = turn == P1 ? P2 : P1;
		
	}
	
	int checkreDiagonal() {
		
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
				cnt ++;
		}
		if(cnt == SIZE)
			win = turn;
		
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
	
	void checkWin() {
		
		win = win == 0 ? checkHorisontal(): win;
		win = win == 0 ? checkVertical() : win;
		win = win == 0 ? checkDiagonal() : win;
		win = win == 0 ? checkreDiagonal() : win;
		
	}
	
	boolean marking(int position) {
		
		int y = position / 10;
		int x = position % 10;
		
		if(y < 0 || y > SIZE -1 || x < 0 || x > SIZE -1)
			return false;
		
		map[y][x] = turn;
		
		return true;
	}
	
	int inputNumber() {
		
		int number = -1;
		try {
			System.out.print("input : ");
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
					System.out.printf("[%d%d]", i,j);
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
		
		map = new int[SIZE][SIZE];
		win = 0;
		turn = P1;
		cnt = 0;
		
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
		printWin();
		
	}
	
}
public class Ex03 {

	public static void main(String[] args) {
		
		Tictactoe game = new Tictactoe();
		game.run();

	}

}
