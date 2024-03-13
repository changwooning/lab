package lv03practice;

import java.util.Scanner;

public class Practice50 {

	// 숫자이동
	// 1738

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] game = { 0, 0, 2, 0, 0, 0, 0 };

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

			// 플레이어 지우기
			game[x] = 0;

			// 입력
			System.out.print("1.왼쪽 2.오른쪽");
			int sel = scan.nextInt();

			if (sel == 1) {
				if (x > 0) {
					x--;
				}else
					System.out.print("빠아아직!!");
			} else if (sel == 2) {
				if (x < 6) {
					x++;
				}else
					System.out.print("꽝꽝!!");
			}
			
			//플레이어 초기화
			game[x] = 2;

		}

	}

}
