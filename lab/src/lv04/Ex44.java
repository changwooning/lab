package lv04;

import java.util.Scanner;
import java.util.Random;

public class Ex44 {

	//// # 빙고 Ver1. (플레이어 1명)

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		final int MAX_NUM = 5;
		final int MARK = 0;

		int[][] bingo = new int[MAX_NUM][MAX_NUM];

		int[] temp = new int[MAX_NUM * MAX_NUM];

		int size = 50; // 1~50까지의 수를 중복없이 빙고판에 배치

		int win = 0;

		int n = 0;
		while (n < 1 || n > MAX_NUM * 2 + 2) {
			System.out.print("몇 빙고? "); // ~MAX_NUM*2 + 2
			n = scan.nextInt();
		}
		// set map (bingo 완성 후, 정방형 출력)
		// 1.temp 배열 완성 (중복 없이 1~50 랜덤값으로 초기화
		// 2. bingo 배열 전체값에 temp 배열의 값을 차례대로 넣기
		// 3. bingo 배열 출력문 분리

		// 5 * 5 판에 랜덤 숫자 1~50 넣기
		// 중복체크
		for (int i = 0; i < temp.length; i++) {
			int rNum = ran.nextInt(50) + 1;
			boolean check = true;
			for (int j = 0; j < i; j++) {
				if (temp[j] == rNum)
					check = false;
			}
			if (check)
				temp[i] = rNum;
			else
				i--;
		}

		// bingo 배열에 차례대로 넣기

		// 별도의 변수 인덱스
		int idx = 0;
		for (int i = 0; i < MAX_NUM; i++) {
			for (int j = 0; j < MAX_NUM; j++) {
				bingo[i][j] = temp[idx];
				idx++;
			}
		}

		while (true) {

			for (int i = 0; i < MAX_NUM; i++) {
				for (int j = 0; j < MAX_NUM; j++) {
					System.out.printf("[%2d]", bingo[i][j]);
				}
				System.out.println();
			}
			System.out.println();

			// 종료조건
			if (win >= n)
				break;

			// 입력
			System.out.print("숫자 입력 : ");
			int number = scan.nextInt();

			for (int i = 0; i < MAX_NUM; i++) {
				for (int j = 0; j < MAX_NUM; j++) {
					if (bingo[i][j] == number)
						bingo[i][j] = MARK;
				}
			}

			win = 0;
			// -

			// 00 01 02 03 04
			// 10 11 12 13 14
			// 20 21 22 23 24
			// 30 31 32 33 34
			// 40 41 42 43 44

			for (int y = 0; y < MAX_NUM; y++) {
				int cnt = 0;
				for (int x = 0; x < MAX_NUM; x++) {
					if (bingo[y][x] == MARK)
						cnt++;
				}
				if (cnt == MAX_NUM)
					win++;
			}
			// ㅣ

			// 00 01 02 03 04
			// 10 11 12 13 14
			// 20 21 22 23 24
			// 30 31 32 33 34
			// 40 41 42 43 44

			for (int x = 0; x < MAX_NUM; x++) {
				int cnt = 0;
				for (int y = 0; y < MAX_NUM; y++) {
					if (bingo[y][x] == MARK)
						cnt++;
				}
				if (cnt == MAX_NUM)
					win++;
			}
			// \

			// 00 01 02 03 04
			// 10 11 12 13 14
			// 20 21 22 23 24
			// 30 31 32 33 34
			// 40 41 42 43 44

			int cnt = 0;
			for (int i = 0; i < MAX_NUM; i++) {
				if (bingo[i][i] == MARK)
					cnt++;
			}
			if (cnt == MAX_NUM)
				win++;
			// /

			// 00 01 02 03 04
			// 10 11 12 13 14
			// 20 21 22 23 24
			// 30 31 32 33 34
			// 40 41 42 43 44
			cnt = 0;
			for (int i = 0; i < MAX_NUM; i++)
				if (bingo[i][MAX_NUM - 1 - i] == MARK)
					cnt++;
			if (cnt == MAX_NUM)
				win++;

		}
	}

}
