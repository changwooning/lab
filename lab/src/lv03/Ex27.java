package lv03;

import java.util.Scanner;
import java.util.Arrays;

public class Ex27 {

	// #숫자이동[1단계]
	// 1.숫자2는 캐릭터이다.
	// 2. 숫자1을 입력하면, 캐릭터가 왼쪽으로
	// 숫자2를 입력하면, 캐릭터가 오른쪽으로 이동한다.
	// 3. 단, 좌우 끝에 도달했을 때, 예외처리를 해야한다.
	// 4. {0,0,2,0,0,0,0}; ==> 왼쪽 ==> {0,2,0,0,0,0,0,};
	//

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] game = { 0, 0, 2, 0, 0, 0, 0 };

		// 플레이어의 현재 위치 (좌표 : 인덱스)
		int x = -1; // 값이 없음

		// 플레이어 현재 위치 초기화
		// x : 2

		// x의 인덱스 값을 찾기위해
		for (int i = 0; i < 7; i++) {
			if (game[i] == 2) {
				x = i;
			}
		}

		System.out.println(Arrays.toString(game));

		System.out.println("1.왼쪽 2.오른쪽");
		int sel = scan.nextInt();
		int temp = 0;
		if (sel == 1) {
			if (x == 2) { //인덱스 2일때 -> 1로
				game[x-1] = game[x];
			}

				System.out.println(Arrays.toString(game));

		}

	}

}
