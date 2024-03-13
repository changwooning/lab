package lv03practice;

import java.util.Scanner;
import java.util.Arrays;

public class Practice21 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 문제1) 인덱스(방번호)를 입력하면 값출력
		int a[] = { 10, 20, 30, 40, 50 };
		// 예) 3 ==> 40

		System.out.print("방 번호 : ");
		int idx = scan.nextInt();

		if (idx >= 0 && idx < 5) {
			System.out.println(a[idx]);
		} else
			System.err.println("유효하지 않은 범위입니다.");

		// 문제2) 아래배열중 가장 큰값 출력
		int b[] = { 12, 54, 23, 87, 1 };
		// 예) 87
		int max = 0;
		for (int i = 0; i < 5; i++) {
			if (b[i] > max) {
				max = b[i];
			}
		}
		for (int i = 0; i < 5; i++) {
			if (b[i] == max) {
				System.out.print(max);
			}
		}

		System.out.println();

		// 문제3) 아래 배열중 홀수의 개수 출력
		int c[] = { 12, 54, 23, 87, 1 };
		// 예) 홀수의 개수 : 3
		int cnt = 0;

		for (int i = 0; i < 5; i++) {
			if (c[i] % 2 == 1) {
				cnt++;
			}
		}
		System.out.println(cnt);

		// 문제4) 아래배열을 거꾸로 저장
		int d[] = { 1, 2, 3, 4, 5 };
		int e[] = { 0, 0, 0, 0, 0 };
		// 예) = {5,4,3,2,1};

		int index = 4;
		for (int i = 0; i < 5; i++) {
				e[index] = d[i];
				index--;
		}
		for (int i = 0; i < 5; i++) {
			System.out.print(e[i]);
		}

	}

}
