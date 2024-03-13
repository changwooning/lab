package lv04test;

import java.util.Arrays;
import java.util.Scanner;

public class Test402 {

	// test 4

	// 배열 컨트롤러[2단계]
	// 1. 추가
	// 값을 입력받아 순차적으로 추가
	// 2. 삭제(인덱스)
	// 인덱스를 입력받아 해당 위치의 값 삭제
	// 3, 삭제(값)
	// 값 입력받아 삭제 ( 중복값 X, 인덱스가 가장 작은 값 한개 0)
	// 없는 값 입력 시 예외처리
	// 4, 삽입
	// 인덱스와 값을 입력받아 삽입

	// 
	// 
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] arr = null;
		int cnt = 0;

		while (true) {

			System.out.println("[배열컨트롤러]");
			System.out.println("[1]추가");
			System.out.println("[2]삭제(인덱스)");
			System.out.println("[3]삭제(값)");
			System.out.println("[4]삽입");

			System.out.print("선택 : ");
			int sel = scan.nextInt();

			if (sel == 1) {
				System.out.println(Arrays.toString(arr));
				// 입력
				System.out.print("추가할 값 : ");
				int input = scan.nextInt();

				int[] temp = arr;

				arr = new int[cnt + 1];

				for (int i = 0; i < cnt; i++)
					arr[i] = temp[i];

				arr[cnt] = input;
				cnt++;
			} else if (sel == 2) {
				// 입력
				System.out.print("삭제할 인덱스 : ");
				int delIdx = scan.nextInt();

				int[] temp = arr;
				arr = new int[cnt - 1];

				int idx = 0;
				for (int i = 0; i < cnt; i++) {
					if (i != delIdx) {
						arr[idx] = temp[i];
						idx++;
					}
				}
				cnt--;
			} else if (sel == 3) {
				// 삭제 값
				// 입력
				System.out.print("삭제할 값 : ");
				int delData = scan.nextInt();

				int idx = -1;
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] == delData) {
						idx = i;
						break;
					}
				}

				int[] temp = arr;
				arr = new int[cnt - 1];
			

				int index = 0;
				for (int i = 0; i < cnt; i++) {
					if (i != idx) {
						arr[index] = temp[i];
						index++;
					}
				}

			} else if (sel == 4) {
				// 삽입

				System.out.print("삽입할 인덱스 : ");
				int index = scan.nextInt();
				System.out.print("삽입할 값 : ");
				int data = scan.nextInt();

				if (index < 0 || index > cnt - 1) {
					System.out.println("범위에 해당하지 않습니다.");
				}

				int[] temp = arr;
				arr = new int[cnt + 1];

				for (int i = 0; i < cnt; i++) {
					if (i < index)
						arr[i] = temp[i];
					else
						arr[i + 1] = temp[i];
				}
				arr[index] = data;
				cnt++;

			}

		}

	}

}
