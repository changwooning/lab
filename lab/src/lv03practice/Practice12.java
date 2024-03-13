package lv03practice;

import java.util.Scanner;


public class Practice12 {
	
	//*틱택토 게임
	
	//1500
	//1515

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		final int SIZE = 9;
		final int P1 = 1;
		final int P2 = 2;
		
		int game[] = new int[9];
		
		int turn = P1;
		int win = 0;
		
		boolean run = true;
		while(run) {
			
			//맵출력
			for(int i=0; i<SIZE; i++) {
				if(game[i] == P1)
					System.out.print("[O]");
				else if(game[i] == P2)
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
			
			//예외 조건 범주 밖 & 이미 마킹된 자리
			if(idx < 0 || idx >=SIZE || win != 0)
				continue;    // ->ㅇㅋ 이해감
			
			//마킹 처리
			game[idx] = turn;
			
			//승리조건
			// - 기준 i: 0 3 6
			for(int i=0; i<SIZE; i+=3) { //범위 잘생각하기
				if(game[i] == turn && game[i+1] == turn && game[i+2] == turn)
					win = turn;
			}
			
			// ㅣ 기준 i : 0 1 2
			for(int i=0; i<3; i++) {		//범위 잘생각하기
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
		System.out.printf("P%d WIN ", win);
		

	}

}