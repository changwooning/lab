package lv03test;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Test302 {

	// lv TEST 3
	// 1 to 4
	// 1024
	// 1048

	// 1057
	// 1102

	public static void main(String[] args) {
		
		//

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		int SIZE = 4;
		int gameNum = 1;

		int[] arr = new int[SIZE];
		int[] chk = new int[SIZE];

		for (int i = 0; i < SIZE; i++) {
			int rNum = ran.nextInt(4) + 1;
			if (chk[rNum - 1] == 0) {	//아무것도 없다.
				arr[i] = rNum;
				chk[rNum - 1] = 1;
			} else
				i--;	//i ++;만회하기위해서
		}

		boolean isRun = true;
		while (isRun) {

			System.out.println(Arrays.toString(arr));
			// 입력
			System.out.print("인덱스 : ");
			int idx = scan.nextInt();

			// 예외처리 1. 인덱스범위
			if (idx < 0 || idx > SIZE - 1) {
				System.out.println("입력한 값은 범위에 벗어났습니다.");
				continue;
			}
			// 예외처리 2. 오답일때
			if (arr[idx] != gameNum) {
				System.out.println("땡~!");
				continue;
			}

			arr[idx] = 9;
			gameNum++;
			// 종료
			if (gameNum > SIZE) {
				isRun = false;
				System.out.println("GAME CLEAR");
			}

		}

	}

}
