package lv06;

// # 틱택토

import java.util.Scanner;
class Tictactoe{
	
	Scanner scan = new Scanner(System.in);
	final int SIZE = 3;
	final int P1 = 1;
	final int P2 = 2;
	
	
	int[][] map;
	
	int turn;
	int win;
	
	void printMap() {
		
		
		System.out.println("== 틱택토 ==");
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(map[i][j] == 1)
					System.out.print("[O]");
				else if(map[i][j] == 2)
					System.out.print("[X]");
				else
					System.out.print("[ ]");
			}
			System.out.println();
		}
		System.out.println();
		
	}
	
	void run() {
		
		map = new int[SIZE][SIZE];
		win = 0;
		turn = P1;
		
		while(true) {
			
			printMap();
			if(win != 0)
				break;

			// 입력
			System.out.printf("[P%d] y : ",turn);
			int y = scan.nextInt();
			System.out.printf("[P%d] x : ",turn);
			int x = scan.nextInt();
			
			
			// 예외
			if(x < 0 || x > SIZE -1 || y < 0 || y > SIZE -1 || map[y][x] != 0)
				continue;
			
			// 마킹
			map[y][x] = turn;
			
			// -  0,0 0,1 0,2
			//	  1,0 1,1 1,2
			//	  2,0 2,1 2,2
			for(int i=0; i<SIZE; i++) {
				int cnt = 0;
				for(int j=0; j<SIZE; j++) {
					if(map[i][j] == turn)
						cnt ++;
				}
				if(cnt == 3)
					win = turn;
			}
			// |  0,0 1,0 2,0
			//	  0,1 1,1 2,1
			// 	  0,2 1,2 2,2
			for(int i=0; i<SIZE; i++) {
				int cnt = 0;
				for(int j=0; j<SIZE; j++) {
					if(map[j][i] == turn)
						cnt ++;
				}
				if(cnt == 3)
					win = turn;
			}
			// \	0,0 1,1 2,2
			int cnt = 0;
			for(int i=0; i<SIZE; i++) {
				if(map[i][i] == turn)
					cnt ++;
			}
			if(cnt == 3)
				win = turn;
			// /	0,2 1,1 2,0
			cnt = 0;
			for(int i=0; i<SIZE; i++) {
					
			}
			
			
			
			turn = turn == P1 ? P2 : P1;
			
		}
		System.out.printf("P%d WIN", win);
		
		
	}
}

public class Ex20 {

	public static void main(String[] args) {
		
		Tictactoe game = new Tictactoe();
		game.run();
		
	}

}
