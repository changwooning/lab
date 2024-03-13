package lv04;

import java.util.Arrays;
import java.util.Scanner;

public class Ex02 {

	// #숫자이동[2단계]
	// 1. 숫자2는 캐릭터이다.
	// 2. 숫자1을 입력하면, 캐릭터가 왼쪽으로
	// 숫자2를 입력하면, 캐릭터가 오른쪽으로 이동한다.
	// 3. 단, 좌우 끝에 도달했을 때, 예외처리를 해야한다.
	// 4. 숫자 1은 벽이다. 벽을 만나면 이동할 수 없다.
	// 5. 단, 숫자3을 입력하면, 벽을 격파 할 수 있다.
	//

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		final int SIZE = 9;
		final int MARIO = 2;
		final int WALL = 1;

		final int LEFT = 1;
		final int RIGHT = 2;
		final int PUNCH = 3;

		int[] game = { 0, 0, 1, 0, 2, 0, 0, 1, 0 };

		int x = -1;

		// 플레이어 위치 초기화
		for (int i = 0; i < SIZE; i++) {
			if (game[i] == MARIO)
				x = i;
		}

		boolean run = true;
		while (run) {
			// 맵출력 0일때 바닥 2일때 마리오 1일때 벽
			for (int i = 0; i < SIZE; i++) {
				if (game[i] == 0) {
					System.out.print("__");
				} else if (game[i] == 1) {
					System.out.print("ㅣㅣ");
				} else if (game[i] == 2)
					System.out.print("M_");
			}

			// 입력
			System.out.println("1.왼쪽 2.오른쪽 3.벽뿌시기");
			int sel = scan.nextInt();

			if (sel == 1) {
				if (x == 0) {
					System.out.println("꽝!");
					continue;
				}
				if (game[x - 1] == WALL) {
					System.out.print("벽을 만났다..!");
					continue;
				}

				game[x] = 0;
				x--;
				game[x] = 2;

			} else if (sel == 2) {
				if (x == SIZE - 1) {
					System.out.println("빠직!");
					continue;
				}
				if (game[x + 1] == WALL) {
					System.out.print("벽을 만났다...!");
					continue;
				}

				game[x] = 0;
				x++;
				game[x] = 2;

			} else if (sel == 3) {
				if (game[x - 1] == WALL) {
					System.out.print("격파!!!!");
					game[x - 1] = 0;

				}
				if (game[x + 1] == WALL) {
					System.out.print("격파!!!!");
					game[x + 1] = 0;
				}

			}

		}

	}

}
