package lv03practice;

import java.util.Scanner;

public class Practice16 {
	
	//틱택토
	//1431
	//1444
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		final int SIZE = 9;
		final int P1 = 1;
		final int P2 = 2;
		
		int turn = P1;
		int win = 0;
		
		
		
		int game[] = new int[9];
		
		
		
		boolean run = true;
		while(run) {
			
			//맵출력
			for(int i =0; i<SIZE; i++) {
				if(game[i] == 1) 
					System.out.print("[O]");
				else if(game[i] == 2) 
					System.out.print("[X]");
				else
					System.out.print("[ ]");
				//줄바꿈
				if(i % 3 == 2)
					System.out.println();
			}
			
			//종료조건
			if(win != 0)
				break;
			
			
			//입력
			System.out.printf("P%d 인덱스 : ",turn);
			int idx = scan.nextInt();
			
			//인덱스 범주 및 이미 마킹된 자리
			if(idx < 0 || idx >= SIZE || game[idx] != 0)
				continue;
			
			//마킹 처리
			game[idx] = turn;
			
			//승리 조건
			//- i 0 3 6 => 조건식!
			for(int i=0; i<SIZE; i+=3) {
				if(game[i] == turn && game[i+1] == turn && game[i+2] == turn)
					win = turn;
			}
			//ㅣ i : 0 1 2 => 조건식!
			for(int i=0; i<3; i++) {
				if(game[i] == turn && game[i+3] == turn && game[i+6] == turn)
					win = turn;
			}
			// /
			for(int i=0; i<SIZE; i++) {
				if(game[2] == turn && game[4] == turn && game[6] == turn)
					win = turn;
			}
			// \
			for(int i=0; i<SIZE; i++) {
				if(game[0] == turn && game[4] == turn && game[8] == turn)
					win = turn;
			}
			
			//턴변경
			turn = turn == P1 ? P2 : P1;
			
		}
		//승자 출력
		System.out.printf("P%d WIN!!!", win);

	}

}
