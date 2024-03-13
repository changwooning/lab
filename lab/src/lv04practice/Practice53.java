package lv04practice;

import java.util.Scanner;
import java.util.Random;

public class Practice53 {

	// 랜덤 사다리

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		final int SIZE = 9;
		final int LEFT = 1;
		final int RIGHT = 2;

		// 참여 인원수
		int n = 0;
		while (n < 2) {
			System.out.print("참여 인원 수 : ");
			n = scan.nextInt();
		}

		String[] menu = new String[n];
		boolean[] isOpen = new boolean[n];

		int ladder[][] = new int[SIZE][n];
		boolean[] isHook = new boolean[n];

		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < n - 1; x++) {
				// 0 또는 1 -> 고리를 걸때 ,1-2 쌍으로 만들기
				ladder[y][x] = (int) (Math.random() * 2);
				if (ladder[y][x] == LEFT) {
					isHook[x] = true;
					x++;
					ladder[y][x] = RIGHT;
				}
			}
			// 맵이 완성된 후 검증
			if (y == SIZE - 1) {
				for (int i = 0; i < n - 1; i++) {
					if (!isHook[i]) { // 훅이 하나도 안걸린 상태
						ladder = new int[SIZE][n]; // 래더도 초기화
						y = -1; // 초기화 다시 그려라
						break;
					}
				}
			}
		}

		// 참여 인원 수만큼 문자열 입력받기
		for (int i = 0; i < n; i++) {
			System.out.printf("메뉴 %d : ", i + 1);
			String str = scan.next();

			// 중복메뉴 검사
			boolean isDupl = false;
			for (int j = 0; j < i; j++) { // 마지막 메뉴는 알아서 정해진거니까
				if (str.equals(menu[j]))
					isDupl = true;
			}
			if (!isDupl)
				menu[i] = str;
			else
				i--;
		}

		// ├ ─ ┤ │
		while (true) {

			// set map
			for (int i = 0; i < n; i++)
				System.out.print(i + 1 + " ");
			System.out.println();

			// print
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < n; j++) {
					if (ladder[i][j] == LEFT)
						System.out.print("├─");
					else if (ladder[i][j] == RIGHT)
						System.out.print("┤ ");
					else
						System.out.print("│ ");
				}
				System.out.println();
			}
			for(int i=0; i<n; i++) {
				if(isOpen[i])
					System.out.print("◻︎ ");
				else
					System.out.print("◼︎ ");
			}
			// end
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				if (isOpen[i])
					cnt++;
			}
			if (cnt == n)
				break;

			// input
			System.out.print("\n번호 선택 : ");
			int x = scan.nextInt() - 1;

			// 예외처리
			if (x < 0 || x > n - 1)
				continue;

			// 핵심 이동처리
			for (int y = 0; y < SIZE; y++) {
				if (ladder[y][x] == LEFT)
					x++;
				else if (ladder[y][x] == RIGHT)
					x--;
			}
			if (isOpen[x]) {
				System.out.println("이미 고른 메뉴 입니다.");
				continue;
			} else {
				System.out.printf("%s 메뉴 당첨\n", menu[x]);
				isOpen[x] = true;
			}

		}

	}

}
