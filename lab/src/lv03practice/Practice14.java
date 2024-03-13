package lv03practice;

import java.util.Scanner;

public class Practice14 {
	
	//틱택토
	
	//1616
	//1620
	

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		final int SIZE = 0;
		final int P1 = 1;
		final int P2 = 2;
		
		int[] game = new int[9];
		
		int turn = P1;
		int win = 0;
		
		boolean run = true;
		while(run) {
			//맵출력
			for(int i=0; i<9; i++) {
				if(game[i] == 1)
					System.out.print("[O]");
				else if(game[i] == 2)
					System.out.print("[X]");
				else
					System.out.print("[ ]");
				//줄바꿈
				if(i % 3 == 2) {
					System.out.println();
				}
			}
			
			//입력
			System.out.printf("P%d 인덱스 : ");
			int idx = scan.nextInt();
			
			//예외처리
			
			if(idx < 0 || idx >= 9 || game[idx] != 0)  //이게 ㅁ ㅏㅈ음
				continue;
			
			//
			game[idx] = turn;
			
			//승자확인
			// -  0 3 6
			for(int i=0; i<9; i++) {
				if(game[i] == turn && game[i+3] == turn && game[i+6] == turn)
					win = turn;
			}
			
			
		}

	}

}
