package lv03practice;

import java.util.Scanner;

public class Practice39 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 문제1) 아래 배열 a에서 내가 입력한 값만 빼고 b에 저장
		int a[] = { 10, 20, 30, 40, 50 };
		int b[] = { 0, 0, 0, 0, 0 };
		// 예) 30 ==> b[] = { 10,20,40,50,0}

		boolean isRun = false;

		int idx = 0;

		System.out.print("값 : ");
		int input = scan.nextInt();

		for (int i = 0; i < 5; i++) {
			if (a[i] == input) {
				isRun = true;
			} else {
				b[idx] = a[i];
				idx++;
			}
		}
		for (int i = 0; i < 5; i++) {
			System.out.print(b[i] + " ");
		}

		// 문제2) 아래 배열에서 내가 입력한 번호의 "번호와 값" 만 빼고 d에 저장
		int c[] = { 1001, 40, 1002, 65, 1003, 70 };
		int d[] = { 0, 0, 0, 0, 0, 0 };
		// 예) 1002 ==> d[] = {1001, 40, 1003, 70, 0, 0};

		// 세트메뉴
		idx = 0;

		System.out.print("\n번호 입력 : ");
		int num = scan.nextInt();

		for (int i = 0; i < 6; i+=2) {   	// 0 2 4
			if(num != c[i] && num != c[i+1]) {
				d[idx] = c[i];
				idx ++;
				d[idx] = c[i+1];
				idx ++;
			}
		}
		for (int i = 0; i < 6; i++) {
			System.out.printf(d[i] + " ");
		}

	}

}
