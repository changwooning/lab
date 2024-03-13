package lv03practice;

import java.util.Scanner;

public class Practice34 {
	
	//틱택토 게임
	//2150
	//2207
	
	//승리 확인 
	// for문 중첩사용
	

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
				if(game[i] == P1) {
					System.out.print("[O]");
				}
				else if(game[i] == P2) {
					System.out.print("[X]");
				}else
					System.out.print("[ ]");
				//줄 바꿈
				if(i % 3 == 2)
					System.out.println();
			}
			
			//종료조건
			if(win != 0)
				break;
			
			//입력
			System.out.printf("P%d 입력 :  ",turn);
			int idx = scan.nextInt();
			
			//인덱스 범위 및 이미 마킹된 자리
			if(idx < 0 || idx>=SIZE || game[idx] != 0) {
				continue;
			}
			
			//마킹 처리
			game[idx] = turn;
			// - 
			for(int i=0; i<SIZE; i+=3) {  //i : 0 3 6
				int cnt = 0;
				for(int j=0; j<3; j++) {  //j : 0 1 2
					if(game[i+j] == turn)
						cnt++;
				}
				if(cnt == 3)
					win = turn;
			}
			// ㅣ
			for(int i=0; i<3; i++) {	// i : 0 1 2
				int cnt = 0;
				for(int j=0; j<3; j++) {	// j : 0 1 2
					if(game[i+3*j] == turn)	// i+3*j : 0 ->  0 3 6 ,	1 -> 1 4 7 , 2-> 2 5 8 
						cnt++;
				}
				if(cnt == 3)
					win = turn;
			}
			// \ 
			int cnt = 0;
			for(int i=0; i<SIZE; i+=4)
				if(game[i] == turn)
					cnt ++;
			if(cnt == 3)
				win = turn;
			
			// /
			cnt = 0;
			for(int i=2; i<= 6; i+=2) {
				if(game[i] == turn)
					cnt ++;
			}
			if(cnt == 3)
				win = turn;
			
			
			
			
			
			
			
//			//승리조건 중첩 포문 사용해보기
//			// - 기준 i : 0 3 6
//			for(int i=0; i<SIZE; i+=3) {
//				if(game[i] == turn && game[i+1] == turn && game[i+2] == turn)
//					win = turn;
//			}
//			// ㅣ 기준 i : 0 1 2
//			for(int i=0; i<3; i++) {
//				if(game[i] == turn && game[i+3] == turn && game[i+6] == turn)
//					win = turn;
//			}
//			// / 
//			for(int i=0; i<SIZE; i++) {
//				if(game[2] == turn && game[4] == turn && game[6] == turn)
//					win = turn;
//			}
//			// \ 
//			for(int i=0; i<SIZE; i++) {
//				if(game[0] == turn && game[4] == turn && game[i+8] == turn)
//					win = turn;
//			}
			
			
			//턴 변경
			turn = turn == P1 ? P2 : P1;
			
		}
		//승자출력
		System.out.printf("P%d WIN!!!", win);
		

	}

}
