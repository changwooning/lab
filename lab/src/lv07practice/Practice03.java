package lv07practice;
// 틱택토

class Ticp2 {

	// 속성 한칸에 들어갈
	boolean isMarked;
	int owner;

	@Override
	public String toString() {

		return isMarked ? (owner == 1 ? "[O]" : "[X]") : "[ ]";

	}

}

class Tictactoep2 {

	// 게임 실행
	final int SIZE = 3;
	final int P1 = 1;
	final int P2 = 2;

	Ticp2[][] map;

	int turn;
	int win;
	
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

		for (int i = 0; i < SIZE; i++) {
			int cnt = 0;
			for (int j = 0; j < SIZE; j++) {
				if (map[i][j].owner == turn)
					cnt++;
			}
			if (cnt == SIZE) {
				win = turn;
				return true;
			}
		}

		return false;
		
	}

	void marking() {

		if (checkHorisontal())
			return;
		else if (checkVertical())
			return;
		else if (checkDiagonal())
			return;
		else if (checkReveredDiagonal())
			return;

	}

	void printMap() {

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();

	}

	boolean isRun() {

		return win == 0 ? true : false;

	}

	void setMap() {

		map = new Ticp2[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				map[i][j] = new Ticp2();
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

public class Practice03 {

	public static void main(String[] args) {

		Tictactoep2 game = new Tictactoep2();
		game.run();

	}

}
