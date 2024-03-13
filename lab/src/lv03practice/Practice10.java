package lv03practice;

import java.util.Scanner;

public class Practice10 {

	// # 틱택토
	// ===틱택토===
	// [X][X][O]
	// [ ][O][ ]
	// [ ][ ][ ]
	// [P1]인덱스 입력 : 6
	// ===틱택톡===
	// [X][X][O]
	// [ ][O][ ]
	// [O][ ][ ]
	// [P1]승리

	// 1223

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		final int SIZE = 9;
		final int P1 = 1;
		final int P2 = 2;

		int[] game = new int[SIZE];

		int turn = P1;
		int win = 0;

		boolean run = true;
		while (run) {
			// 1. 맵 입력
			/*
			 * 줄바꿈 원리
			 * 0 1 [2]
			 * 3 4 [5]
			 * 6 7 [8]
			 */
			for (int i = 0; i < 9; i++) {
				if (game[i] == P1)
					System.out.print("[O]");
				else if (game[i] == P2)
					System.out.print("[X]");
				else
					System.out.print("[ ]");
				// 2. 줄바꿈
				if (i % 3 == 2)
					System.out.println();
			}

			// 3. 종료 조건
			if(win != 0)
				break;

			// 4. 입력
			System.out.println("인덱스 : ");
			int index = scan.nextInt();

			// 5. 예외처리 1. 인덱스 범주 & 이미 마킹된 자리
			if (index < 0 || index >= SIZE || win != 0) {
				continue;
			}
			// 6. 마킹처리
			game[index] = turn;
			
			// 7. 승리확인
			// 7-1 - 기준 i : 0 3 6
			for(int i=0; i<SIZE; i+=3) {
				if(game[i] == turn && game[i+1] == turn && game[i+2] == turn)
					win = turn;
			}
			// 7-2 ㅣ 기준 i : 0 1 2
			for(int i=0; i<3; i++) {
				if(game[i] == turn && game[i+3] == turn && game[i+6] == turn)
					win = turn;
			}
			// 7-3 \ 기준x 
			for(int i=0; i<SIZE; i++) {
				if(game[0] == turn && game[4] == turn && game[8] == turn)
					win = turn;
			}
			// 7-4 /
			for(int i =0; i<SIZE; i++) {
				if(game[2] == turn && game[4] == turn && game[6] == turn)
					win = turn;
			}
			
			// 8. 턴변경 => 삼항연산자 사용 => 아직 잘 이해 못함
			turn = turn == P1 ? P2 : P1;
			
			// 삼항(세개의 항) 연산 
			// 조건식 ? 참일때결과값 : 거짓일때결과값  

		}
		// 9. 승자출력
		System.out.printf("[P%d] WIN!!!", win);
	}

}
