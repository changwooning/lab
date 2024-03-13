package lv03practice;

import java.util.Scanner;

public class Practice51 {

	// 숫자 이동
	// 1752
	//1758

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] game = { 0, 0, 2, 0, 0, 0, 0, };

		int x = -1;
		// 플레이어 초기화
		// x : 2
		for (int i = 0; i < 7; i++) {
			if (game[i] == 2)
				x = i;
		}

		boolean isRun = true;
		while (isRun) {
			// 맵출력
			for (int i = 0; i < 7; i++) {
				if (i == x) {
					System.out.print("훗_");
				} else
					System.out.print("__");
			}

			// 입력
			System.out.print("1.왼쪽 2.오른쪽");
			int sel = scan.nextInt();

			// 플레이어 지우기
			game[x] = 0;

			if (sel == 1) {
				if (x > 0)
					x--;
				else
					System.out.println("빠찍!!");
			} else if (sel == 2) {
				if (x < 6)
					x++;
				else
					System.out.println("꽈아앙!!");
			}
			// 플레이어 재지정
			game[x] = 2;

		}

	}

}
