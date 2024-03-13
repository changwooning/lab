package lv04practice;

import java.util.Arrays;
import java.util.Scanner;

public class Practice36 {

	// 숫자 야구 게임
	// 1913
	// 1921

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] com = { 1, 7, 3 };
		int[] me = new int[3];

		while (true) {

			// 입력
			for (int i = 0; i < 3; i++) {
				System.out.printf("숫자 %d 번째 입력 : ", i + 1);
				int input = scan.nextInt();

				int idx = -1;
				for (int j = 0; j < i; j++) {
					if (me[j] == input)
						idx = j;
				}

				if (idx == -1 && input > 0 && input <= 9)
					me[i] = input;
				else {
					System.out.println("유효하지 않은 값 입니다.");
					i--;
				}

			}

			// 검토
			int strike = 0;
			int ball = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (com[i] == me[j]) {
						if (j == i)
							strike++;
						else
							ball++;
					}
				}
			}

			System.out.println("com : " + Arrays.toString(com));
			System.out.println("me : " + Arrays.toString(me));
			System.out.printf("strike %d,ball %d\n", strike, ball);

			// 종료조건
			if (strike == 3)
				break;
		}
		System.out.println("GAME CLEAR~");

	}

}
