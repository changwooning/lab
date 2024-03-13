package lv04practice;

import java.util.Scanner;
import java.util.Random;

public class Practice74 {

	// 빙고 플레이어 1

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		final int MAX_NUM = 5;
		final int MARK = 0;

		int[][] bingo = new int[MAX_NUM][MAX_NUM];
		int[] temp = new int[MAX_NUM * MAX_NUM];

		int size = 50;

		int win = 0;

		int n = 0;
		while (n < 1 || n > MAX_NUM * 2 + 2) {
			System.out.print("몇 빙고 ? ");
			n = scan.nextInt();
		}

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
		// 별도의 인덱스 필요
		int idx = 0;
		for (int i = 0; i < MAX_NUM; i++) {
			for (int j = 0; j < MAX_NUM; j++) {
				bingo[i][j] = temp[idx];
				idx++;
			}
		}

		while (true) {
			// print
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
			for (int y = 0; y < MAX_NUM; y++) {
				int cnt = 0;
				for (int x = 0; x < MAX_NUM; x++) {
					if (bingo[x][y] == MARK)
						cnt++;
				}
				if (cnt == MAX_NUM)
					win++;
			}

			// \
			int cnt = 0;
			for (int i = 0; i < MAX_NUM; i++) {
				if (bingo[i][i] == MARK)
					cnt++;
			}
			if (cnt == MAX_NUM)
				win++;

			// /
			cnt = 0;
			for (int i = 0; i < MAX_NUM; i++)
				if (bingo[i][MAX_NUM - 1 - i] == MARK)
					cnt++;
			if (cnt == MAX_NUM)
				win++;

		}

	}

}
