package lv03test;

import java.util.Scanner;
import java.util.Arrays;

public class Test306 {

	// 2046
	// 2126

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// lv test 3

		// 6. last

		int arr[] = { 0, 2, 0, 4, 3, 0, 0, 5, 6 };

		// test case
		// int arr[] = {1,2,0,3,4,0,0,5,8};
		// int arr[] = {1,0,0,0,0,0,0,0,0};

		// 아래 번호를 입력받고 각방향으로 0이 아닌 숫자를 모으시요.
		// 1)left 2)right

		// 예) 1) left ==> arr = [2,4,3,5,6,0,0,0,0]
		// 예) 1) right ==> arr = [0,0,0,0,2,4,3,5,6]
		System.out.println(Arrays.toString(arr));

		System.out.println("1)left 2)right");
		int input = scan.nextInt();

		int cnt = 0;
		for (int i = 0; i < 9; i++) {
			// 값찾기
			if (arr[i] != 0)
				cnt++; // 0이 아닌숫자 세기
		}
		if (input == 1) {
			// 왼쪽/.
			int idx = 0;
			for (int i = 0; i < 9; i++) {
				if (arr[i] != 0) {
					arr[idx] = arr[i];
					idx++;
				}
			}

			for (int i = cnt; i < 9; i++) { // i: 값이 cnt 개수 만큼일때 나머지 0으로 넣어준다
				arr[i] = 0;
			}

		} else if (input == 2) {
			int idx = 9 - 1;
			for (int i = 9 - 1; i >= 0; i--) {
				if (arr[i] != 0) {
					arr[idx] = arr[i];
					idx--;
				}
			}
			// cnt 변수 들어가야함 개수만큼0으로 만들어줘야함
			for (int i = 0; i < 9 - cnt; i++) {
				arr[i] = 0;
			}

		}
		System.out.println(Arrays.toString(arr));

	}

}
