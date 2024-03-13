package lv03practice;

import java.util.Scanner;

public class Practice79 {
	
	/* 
	 * # 틱택토
	 * === 틱택토 ===
	 * [X][X][O]
	 * [ ][O][ ]
	 * [ ][ ][ ]
	 * [p1]인덱스 입력 : 6
	 * === 틱택토 ===
	 * [X][X][O]
	 * [ ][O][ ]
	 * [O][ ][ ]
	 * [p1]승리
	 * 
	 */

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		final int SIZE = 9;
		final int P1 = 1;
		final int P2 = 2;
		
		int turn = P1;
		int win = 0;
		
		
		
		int[] game = new int[9];
		
		
		boolean isRun = true;
		while(isRun) {
			
			//맵출력
			for(int i=0; i<SIZE; i++) {
				if(game[i] == P1) 
					System.out.print("[O]");
				else if(game[i] == P2)
					System.out.print("[X]");
				else
					System.out.print("[ ]");
				if(i % 3 == 2)
					System.out.println();
			}
			
			//종료조건
			if(win != 0)
				break;
			
			//입력
			System.out.printf("P%d 입력 : ",turn);
			int idx = scan.nextInt();
			
			//예외처리 1. 인덱스 범위
			if(idx < 0 || idx > SIZE-1) {
				System.out.println("입력하신 값은 존재하지 않습니다.");
				continue;
			}
			//예외처리 2. 이미 마킹된 자리
			if(game[idx] != 0) {
				System.out.println("이미 마킹된 자리입니다.");
				continue;
			}
			
			//마킹처리
			game[idx] = turn;
			
			//승리확인
			//-  i : 0 3 6
			for(int i =0; i<SIZE; i+=3) {
				if(game[i] == turn && game[i+1] == turn && game[i+2] == turn)
					win = turn;
			}
			// ㅣ i : 0 1 2
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
			
			//턴 변경
			turn = turn == P1 ? P2 : P1;
		}
		//승자 출력
		System.out.printf("승자 P%d WIN!!!", win);

	}

}
