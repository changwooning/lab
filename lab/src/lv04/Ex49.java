package lv04;

import java.util.Scanner;

public class Ex49 {

	// # 오목
	// ㄴ 육목과 3/3 등 추가 룰 모두 제외
	// ㄴ 연속으로 5개 이상의 돌이 놓이면 승
	// ㄴ 인덱스 두 개를 입력 받아 마킹

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

			// 맵 출력
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if (omok[i][j] == P1)
						System.out.print("[●]");
					else if (omok[i][j] == P2)
						System.out.print("[○]");
					else
						System.out.print(" • ");
				}
				System.out.println();
			}
			System.out.println();

			// 승리조건 연속으로 5개 이상 될시 승리
			if (win != 0)
				break;

			// 입력
			System.out.printf("P%d 인덱스1 : ", turn);
			int idx1 = scan.nextInt();
			System.out.printf("P%d 인덱스2 : ", turn);
			int idx2 = scan.nextInt();

			// 예외처리 2. 범위 밖
			if (idx1 < 0 || idx1 > SIZE - 1 || idx2 < 0 || idx2 > SIZE - 1) {
				System.out.println("움직일 수 없습니다.");
				continue;
			}
			// 예외처리 1. 이미 놓여진 자리
			if (omok[idx1][idx2] != 0) {
				System.out.println("이미 놓여진 자리입니다.");
				continue;
			}

			// 마킹처리
			omok[idx1][idx2] = turn;

			// 승리확인
			// - 5까지
			// 0 0 0 0 0 0 0 0 0 0
			// 0 0 0 0 0 0 0 0 0 0
			// 0 0 0 0 0 0 0 0 0 0
			// 0 0 0 0 0 0 0 0 0 0
			// 0 0 0 0 0 0 0 0 0 0
			// 0 0 0 0 0 0 0 0 0 0
			// 0 0 0 0 0 0 0 0 0 0
			// 0 0 0 0 0 0 0 0 0 0
			// 0 0 0 0 0 0 0 0 0 0
			// 0 0 0 0 0 0 0 0 0 0
			for (int i = 0; i < SIZE; i++) {
				int cnt = 0;
				for (int j = 0; j < 6; j++)
					if (omok[i][j] == turn && omok[i][j + 1] == turn && omok[i][j + 2] == turn && omok[i][j + 3] == turn
							&& omok[i][j + 4] == turn)
						win = turn;
			}

			// ㅣ
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < SIZE; j++) {
					if (omok[i][j] == turn && omok[i + 1][j] == turn && omok[i + 2][j] == turn && omok[i + 3][j] == turn
							&& omok[i + 4][j] == turn)
						win = turn;
				}
			}
			// \ i : + j : +
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {
					if (omok[i][j] == turn && omok[i + 1][j + 1] == turn && omok[i + 2][j + 2] == turn
							&& omok[i + 3][j + 3] == turn && omok[i + 4][j + 4] == turn)
						win = turn;
				}
			}

			// / i : - j : +
			for (int i = 4; i < SIZE; i++) {
				for (int j = 0; j < 6; j++) {
					if (omok[i][j] == turn && omok[i - 1][j + 1] == turn && omok[i - 2][j + 2] == turn
							&& omok[i - 3][j + 3] == turn && omok[i - 4][j + 4] == turn)
						win = turn;
				}
			}

			// 턴변경
			turn = turn == P1 ? P2 : P1;

		}
		// 승자출력
		System.out.printf("P%d WIN!!!", win);
		scan.close();

	}

}
