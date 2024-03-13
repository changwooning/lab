package lv04;

import java.util.Scanner;

public class Ex50 {

	// # 오목
	// 선생님 풀이

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		final int SIZE = 10;
		final int P1 = 1;
		final int P2 = 2;

		int[][] omok = new int[SIZE][SIZE];

		int turn = P1;

		int win = 0;

		boolean run = true;
		while (run) {

			// 오목출력
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if (omok[i][j] == P1)
						System.out.print("▲ ");
					else if (omok[i][j] == P2)
						System.out.print("◼ ︎");
					else
						System.out.print("[" + i + "" + j + "]");
				}
				System.out.println();
			}
			System.out.println();
			
			//종료조건
			if(win != 0)
				break;
			
			//입력
			System.out.printf("P%d y : ",turn);
			int y = scan.nextInt();
			System.out.printf("P%d x : ",turn);
			int x = scan.nextInt();
			
			//예외처리
			if(y < 0 || y > SIZE -1 || x < 0 || x > SIZE -1) {
				System.out.println("인덱스 범위는 0~9까지 입니다.");
				continue;
			}
			
			//예외처리
			if(omok[y][x] != 0) {
				System.out.println("이미 돌이 놓여져 있습니다.");
				continue;
			}
			
			//마킹
			omok[y][x] = turn;
			
			//승자확인
			// -
			//풀이 1
//			for(int i=0; i<SIZE; i++) {
//				int cnt = 0;
//				for(int j=0; i<SIZE; j++) {
//					if(omok[i][j] == turn)
//						cnt ++;
//					else
//						cnt = 0;
//					if(cnt == 5)
//						win = turn;
//				}
//			}
			//풀이 2
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<SIZE-4; j++) {
					if(omok[i][j] == turn) {
						int cnt = 0;
						for(int k=0; k<5; k++)
							if(omok[i][j+k] == turn)
								cnt++;
						if(cnt == 5)
							win = turn;
					}
				}
			}
			// ㅣ
			for(int i=0; i<SIZE; i++) {
				int cnt= 0;
				for(int j=0; j<SIZE; j++) {
					if(omok[j][i] == turn)
						cnt ++;
					else
						cnt =0;
					if(cnt == 5)
						win = turn;
				}
			}
			// \
			for(int i=0; i<SIZE-4; i++) {
				for(int j=0; i<SIZE-4; j++) {
					if(omok[i][j] == turn) {
						//연속 5회 turn 검사
						int cnt = 0;
						for(int k=0; k<5; k++) {	//조건부
							if(omok[i+k][j+k] == turn)
								cnt ++;
						}
						if(cnt == 5)
							win = turn;
					}
				}
			}
			// /
			for(int i=4; i<SIZE; i++) {
				for(int j=0; j<SIZE-4; j++) {
					if(omok[i][j] == turn) {
						int cnt = 0;
						for(int k=0; k<5; k++) {
							if(omok[i-k][j+k] == turn)
								cnt ++;
						}
						if(cnt == 5)
							win = turn;
					}
				}
			}
			//턴변경
			turn = turn == P1 ? P2 : P1;
		}
		//승자출력
		System.out.printf("P%d WIN!!!", win);

	}

}
