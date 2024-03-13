package lv03;

import java.util.Arrays;
import java.util.Scanner;

public class Ex28 {

	// 변수
	// ㄴ 변수
	// ㄴ 상수 : 변수 앞에 final 키워드를 붙여, 수정 불가한 값으로 고정
	// 이름 규칙 -> 변수명 전체 캐릭터를 대문자로 작성 (두 개 이상의 키워드가 조합 경우,헝가리언)

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		final int PLAYER = 2;
		final int SIZE = 7;
		final int LOAD = 0;

		int[] game = { 0, 0, 2, 0, 0, 0, 0 };

		int x = -1;
		// 플레이어 현재위치 초기화
		// x : 2
		for (int i = 0; i < 7; i++) {
			if (game[i] == 2)
				x = i;

		}

		boolean isRun = true;
		while (isRun) {
			// 맵 출력
			for (int i = 0; i < 7; i++) {
				if (i == x)
					System.out.print("옷_");
				else
					System.out.print("__");
			}

			System.out.println("1.왼쪽 2.오른쪽");
			int sel = scan.nextInt();

			// 플레이어 지우기
			game[x] = 0;    // ?

			// 좌표이동
			if (sel == 1) {
				if (x > 0)
					x--;
				else
					System.out.println("꽝");
			} else if (sel == 2) {
				if (x < 6)
					x++;
				else
					System.out.println("빠직");
			}

			// 플레이어 새로 그리기
			game[x] = 2;

		}

	}

}
