package lv04;

import java.util.Arrays;

import java.util.Scanner;

public class Ex16 {

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
			}

			else if (sel == 2) {
				System.out.print("삭제할 인덱스 : ");
				int delIdx = scan.nextInt();

				if (delIdx < 0 || delIdx >= count)
					continue;

				int[] temp = score;
				
				score = new int[count - 1];
				  
				int idx = 0;
				for (int i = 0; i < count; i++) {
					if (i != delIdx) {
						score[idx] = temp[i];
						idx++;
					}
				}
				count--;

			} else if (sel == 3) {

				System.out.print("삭제할 값 : ");
				int delData = scan.nextInt();

				// 삭제할 개수 확인
				int delCnt = 0;
				for (int i = 0; i < count; i++)
					if (score[i] == delData)
						delCnt++;

				// 새로 이사갈 집의 규모를 알수있다
				int[] temp = score;
				score = new int[count - delCnt];

				// 값 올리기 (삭제할 값만 뺴고)
				int idx = 0;
				for (int i = 0; i < count; i++) {
					if (temp[i] != delData) {
						score[idx] = temp[i];
							idx ++;
					}
				}
				count -= delCnt;

//				System.out.print("삭제할 값 : ");
//				int delData = scan.nextInt();
//				
//				int delIdx = -1;
//				for(int i=0; i<count; i++) {
//					if(score[i] == delData)
//						delIdx = i;
//				}
//					
//				if(delIdx == -1)
//					continue;
//				
//				int[] temp = score;
//				score = new int[count - 1];
//				
//				int idx = 0;
//				for (int i = 0; i < count; i++) {
//					if (i != delIdx) {
//						score[idx] = temp[i];
//						idx++;
//					}
//				}
//				count--;

			} else if (sel == 4) {
				System.out.print("삽입할 인덱스 : ");
				int index = scan.nextInt();
				System.out.print("삽입할 값 : ");
				int data = scan.nextInt();

				if (index < 0 || index >= count)
					continue;

				int[] temp = score;
				score = new int[count + 1];

				for (int i = 0; i < count; i++) { // i : temp 배열의 인덱스
					if (i < index)
						score[i] = temp[i];
					else
						score[i + 1] = temp[i];
				}
				score[index] = data;
				count++;

			} else if (sel == 0) {
				break;

			}
		}

	}

}
