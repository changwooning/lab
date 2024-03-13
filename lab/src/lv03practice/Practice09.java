package lv03practice;

import java.util.Scanner;

public class Practice09 {

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
	
	//10%센트

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

			// 1.틱택토 맵배열 설정
			for (int i = 0; i < SIZE; i++) {
				if (game[i] == P1)
					System.out.print("[O]");
				else if (game[i] == P2)
					System.out.print("[X]");
				else
					System.out.print("[ ]");
				// 2.줄바꿈 => 왜 이렇게 하는지 모름
				if (i % 3 == 2)
					System.out.println();

			}
			// 3.종료조건 => 이해안됨
//			if(win != 0)
//				break;
			
			// 4.입력
			//System.out.print("[P1] 인덱스 입력 : "); => 틀림 P1만 입력받음 printf로 둘다 입력받기
			int index = scan.nextInt();
			
			// 5.예외처리 1. 인덱스 범주 밖 & 이미 마킹된 자리
			if (index < 0 || index >= SIZE || win != 0) {
				continue; // => 여기서 continue 쓰는 이유 모름
				// System.err.print("해당 범위에 벗어난 값입니다."); => 
			}

			// 6.마킹처리 => ? 이해안됨
			game[index] = turn;

			// 7.승리확인
			for (int i = 0; i < SIZE; i++) {
				// 일단개별로 for문 작성하는 이유와 for문 조건식 이해하기
				// 6-1 - 가로기준 i : 0 3 6
				if (game[i] == turn && game[i + 1] == turn && game[i + 2] == turn)
					win = turn;
				// 6-2 ㅣ 세로기준 i : 0 1 2
				else if (game[i] == turn && game[i + 3] == turn && game[i + 6] == turn)
					win = turn;
				// 6-3 \ 기준이 없음
				else if (game[0] == turn && game[4] == turn && game[8] == turn)
					win = turn;
				// 6-4 /
				else if (game[2] == turn && game[4] == turn && game[6] == turn)
					win = turn;
			}
			// 8.턴 변경 => 삼항연산 사용 모름 다시 공부하기
			turn = turn == P1 ? P2 : P1;

		}
		// 9.승자출력
		// 틀림 승자는 = win => 이유는 승리확인에서 win= turn 했고 turn은 =P1 같다 
		System.out.print("WIN!!! : " + win);

	}

}
