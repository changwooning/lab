package lv04;

import java.util.Scanner;
import java.util.Arrays;

public class Ex15 {

	// # 배열 컨트롤러[2단계] : 벡터(Vector)
	// 1. 추가
	// 값을 입력받아 순차적으로 추가
	// 2. 삭제(인덱스)
	// 인덱스를 입력받아 해당 위치의 값 삭제
	// 3. 삭제(값)
	// 값을 입력받아 삭제
	// 없는 값 입력 시 예외처리
	// 4. 삽입
	// 인덱스와 값을 입력받아 삽입

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] score = null;
		int count = 0;

		while (true) {
			System.out.println(Arrays.toString(score));

			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가");
			System.out.println("[2]삭제(인덱스)");
			System.out.println("[3]삭제(값)");
			System.out.println("[4]삽입");
			System.out.println("[0]종료");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			if (sel == 1) {

				System.out.print("값 : ");
				int input = scan.nextInt();

				// 구 주소를 temp에게 전달
				int[] temp = score;
				// 새 주소를 score에 초기화
				score = new int[count + 1];

				// 구 주소에 있는 값들을 새 주소에 복사
				for (int i = 0; i < count; i++)
					score[i] = temp[i];

				// 마지막 인덱스에 입력받은 값 넣은것
				score[count] = input;
				count++;

			} else if (sel == 2) {
				// 삭제 (인덱스)
				System.out.print("인덱스 : ");
				int idx = scan.nextInt();

				// 구 주소를 temp 전달
				int[] temp = score;

				// 새 주소를 score에 초기화
				score = new int[count - 1];

				// 구 주소를 새 주소에 저장
				int j = 0;
				for (int i = 0; i < count; i++) {
					if (i != idx) {		
						score[j] = temp[i];
						j++;
					}
				}
				
				count--;

			} else if (sel == 3) {
				System.out.print("값 입력 : ");
				int num = scan.nextInt();

				// 구 주소를 temp전달
				int[] temp = score;
				// 새 주소를 score에 초기화
				score = new int[count - 1];

				// 구 주소를 새 주소에 저장하기
				int idx = -1;
				for (int i = 0; i < count; i++) {
					if (score[i] == num) {
						idx = i;
					}
				}

			}
		}

	}

}
