package lv03test;

import java.util.Scanner;

public class Test303 {

	// 틱택토
	// 1102
	// 1135

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		final int SIZE = 9;
		final int P1 = 1;
		final int P2 = 2;

		int turn = P1;
		int win = 0;
		int[] map = new int[SIZE];

		boolean run = true;
		while (run) {

			System.out.println("===틱택토===");
			for (int i = 0; i < SIZE; i++) {
				if (map[i] == P1)
					System.out.print("[O]");
				else if (map[i] == P2)
					System.out.print("[X]");
				else
					System.out.print("[ ]");
				if (i % 3 == 2)
					System.out.println();
			}

			// 종료조건
			if (win != 0)
				break;

			// 입력
			System.out.printf("P%d 입력 : ", turn);
			int input = scan.nextInt();

			// 예외처리 1. 인덱스 범위 & 이미 마킹된 자리
			if (input < 0 || input > SIZE - 1 || map[input] != 0) {
				continue;
			}

			// 마킹처리
			map[input] = turn;

			// 승리조건
			// - i : 0 3 6
			for (int i = 0; i < SIZE; i += 3) {
				if (map[i] == turn && map[i + 1] == turn && map[i + 2] == turn)
					win = turn;
			}
			// ㅣ i : 0 1 2
			for (int i = 0; i < 3; i++) {
				if (map[i] == turn && map[i + 3] == turn && map[i + 6] == turn)
					win = turn;
			}
			// /
			for (int i = 0; i < SIZE; i++) {
				if (map[2] == turn && map[4] == turn && map[6] == turn)
					win = turn;
			}
			// \
			for (int i = 0; i < SIZE; i++) {
				if (map[0] == turn && map[4] == turn && map[8] == turn)
					win = turn;
			}

			// 턴 변경
			turn = turn == P1 ? P2 : P1;

		}
		// 승자출력
		System.out.printf("P%d WIN!!!", win);

	}

}
