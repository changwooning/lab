package lv03practice;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Practice77 {

	/*
	 * # 1 to 4 1. arr배열에 1~4 사이의 숫자를 중복없이 랜덤으로 저장한다. 2. 사용자는 1부터 순서대로 해당 위치 값을
	 * 입력한다. 3. 정답을 맞추면 해당 값은 9로 변경되어 모든 값이 9가 되면 게임은 종료된다. 예) 4 2 3 1 입력 : 3 4 2 3
	 * 9 입력 : 1 4 9 3 9 ...
	 */

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		int[] arr = new int[4];
		int[] check = new int[4];

		int gameNum = 1;

		// 중복확인
		for (int i = 0; i < 4; i++) {
			int rNum = ran.nextInt(4) + 1;
			if (check[rNum - 1] == 0) {
				arr[i] = rNum;
				check[rNum - 1] = 1;
			} else
				i--;
		}

		boolean isRun = true;
		while (isRun) {

			System.out.println(Arrays.toString(arr));

			// 입력
			System.out.print("입력 : ");
			int input = scan.nextInt();

			// 예외처리 1. 인덱스범위
			if (input < 0 || input > 3) {
				System.out.println("입력하신 값은 존재하지 않습니다.");
				continue;
			}

			// 예외처리 2. 오답일때
			if (arr[input] != gameNum) {
				System.out.println("오답입니다..");
				continue;
			}

			arr[input] = 9;
			gameNum++;

			// 종료조건
			if (gameNum > 4) {
				System.out.println("game clear~");
				isRun = false;
			}

		}

	}

}
