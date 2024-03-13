package lv03;

import java.util.Scanner;

public class Ex21 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 문제2) 만약에 가로가 3이 연속으로 3개 있으면 "빙고" 출력

		int arr[] = { 0, 0, 0, 0, 0, 0, 0, 3, 3 };

		System.out.println("1) 빙고 결과확인");
		System.out.println("메뉴 선택 : ");
		int sel = scan.nextInt();

		if (sel == 1) {

			for (int i = 0; i < 9; i++) {
				System.out.print(arr[i]);
				if (i % 3 == 2) {
					System.out.println();
				}
			}
			for (int i = 0; i < 9; i++) {
				if ((i >= 0 && i < 3) || (i >= 3 && i < 6) || (i >= 6 && i < 9)) {
					System.out.print("빙고");
				}else {
					System.out.print("꽝");
				}
			}
		}

	}

}
