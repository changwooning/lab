package lv04;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Ex43 {

	// # 빙고 Ver1. (플레이어 1명)

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		final int MAX_NUM = 5;

		int[][] bingo = new int[MAX_NUM][MAX_NUM];

		int[] temp = new int[MAX_NUM * MAX_NUM];

		int size = 50; // 1~50까지의 수를 중복없이 빙고판에 배치

		int win = 0;
		

		System.out.print("몇 빙고? "); // ~MAX_NUM*2 + 2
		int n = scan.nextInt();

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
			
			
			//종료조건
			
			//입력
			System.out.print("숫자 입력 : ");
			int input = scan.nextInt();
			
			//예외처리 1. 숫자 범위
			if(input < 1 || input > size) {
				System.out.println("입력한 값은 존재하지 않습니다.");
				continue;
			}
			
			//예외처리 2. 이미 선택된 카드
			for(int i=0; i<MAX_NUM; i++) {
				for(int j=0; j<MAX_NUM; j++) {
					
				}
			}
			
			//마킹처리
			for(int i=0; i<MAX_NUM; i++) {
				for(int j=0; j<MAX_NUM; j++) {
					if(bingo[i][j] == input)
						bingo[i][j] = 0;
				}
			}
			
			
			//빙고 확인
			// - i : 0,0 1,0 2,0 3,0 4,0
			for(int i=0; i<MAX_NUM; i++) {
				for(int j=0; j<MAX_NUM; j++) {
					
				}
			}
			
			// ㅣ
			// /
			// \ 
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}

	}

}
