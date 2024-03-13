package lv03practice;

import java.util.Scanner;

public class Practice74 {

	// 숫자 이동[1단계]

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] game = { 0, 0, 2, 0, 0, 0, 0 };

		int x = -1;

		// 플레이어 초기화
		for (int i = 0; i < 7; i++) {
			if (game[i] == 2)
				x = i;
		}

		boolean run = true;
		while (run) {

			// 맵출력
			for (int i = 0; i < 7; i++) {
				if (game[i] == 2)
					System.out.print("훗_");
				else
					System.out.print("__");
			}

			// 입력
			System.out.print("1.왼쪽 2.오른쪽");
			int sel = scan.nextInt();

			if (sel == 1) {

				if (x > 0) {
					game[x - 1] = 2;
					game[x] = 0;
					x--;
				} else
					System.out.println("꽈앙!!!!");
			} else if (sel == 2) {
				if (x < 6) {
					game[x + 1] = 2;
					game[x] = 0;
					x++;
				} else
					System.out.println("꽈직");

			}

		}

	}

}
