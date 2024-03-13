package lv04practice;

import java.util.Scanner;

public class Practice03 {

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
		// 플레이어 현재 위치 초기화
		for (int i = 0; i < SIZE; i++) {
			if (game[i] == MARIO)
				x = i;
		}

		while (true) {

			// 맵 출력
			for (int i = 0; i < SIZE; i++) {
				if (game[i] == MARIO)
					System.out.print("M_");
				else if (game[i] == WALL)
					System.out.print("ㅣㅣ");
				else
					System.out.print("__");
			}

			// 입력받기
			System.out.println("1.왼쪽 2.오른쪽 3.벽뿌시기!");
			int dir = scan.nextInt();

			// 플레이어 임시값

			int tmpX = x;
			if (dir == LEFT) {
				tmpX--;
			}
			if (dir == RIGHT) {
				tmpX++;
			}
			if (dir == PUNCH) {
				// 왼쪽 벽을 만났을때
				if (x > 0 && game[x - 1] == WALL) {
					System.out.println("빠직~!");
					game[x - 1] = 0;
				}
				if (x < SIZE - 1 && game[x + 1] == WALL) {
					System.out.println("꽝!!");
					game[x + 1] = 0;
				}

			}

			// 예외처리
			if (tmpX < 0 || tmpX >= SIZE || game[tmpX] == WALL)
				continue;

			// 이동처리
			game[x] = 0;
			x = tmpX;
			game[x] = MARIO;
		}

	}

}
