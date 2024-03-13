package lv04;

import java.util.Random;
import java.util.Scanner;

public class Ex46 {

	// 플레이어 2 받ㄱ기

	public static void main(String[] args) {
		

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		final int MAX_NUM = 5;
		final int MARK = 0;

		int[][] bingo = new int[MAX_NUM][MAX_NUM];
		int[][] bingo2 = new int[MAX_NUM][MAX_NUM];

		int[] temp = new int[MAX_NUM * MAX_NUM];

		int size = 50; // 1~50까지의 수를 중복없이 빙고판에 배치

		int win = 0;
		int win2 = 0;

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
					board[i][j] = temp[idx++];
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
			
			
			// -
			for(int i=0; i<MAX_NUM; i++) {
				int cnt = 0;
				int cnt2 = 0;
				for(int j=0; j<MAX_NUM; j++) {
					if(bingo[i][j] == MARK)
						cnt++;
					if(bingo2[i][j] == MARK)
						cnt2 ++;
				}
				if(cnt == MAX_NUM)
					win ++;
				if(cnt2 == MAX_NUM)
					win2 ++;
			}
			// ㅣ 
			for(int i=0; i<MAX_NUM; i++) {
				int cnt = 0;
				int cnt2 = 0;
				for(int j=0; j<MAX_NUM; j++) {
					if(bingo[j]][i] == MARK)
						cnt++;
					if(bingo2[j][i] == MARK)
						cnt2 ++;
				}
				if(cnt == MAX_NUM)
					win ++;
				if(cnt2 == MAX_NUM)
					win2 ++;
			}
			// \
			int cnt = 0;
			int cnt2 = 0;
			for(int i=0; i<MAX_NUM; i++) {
				for(int j=0; j<MAX_NUM; j++) {
					if(bingo[i][i] == MARK)
						cnt ++;
					if(bingo[i][i] == MARK)
						cnt2 ++;
				}
				if(cnt == MAX_NUM)
					win++;
				if(cnt2 == MAX_NUM)
					win2 ++;
			}
			


		}
		

	}
}
