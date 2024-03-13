package lv04practice;

import java.util.Scanner;
import java.util.Random;

public class Practice56 {

	// # 랜덤 사다리
	// 1506
	// 1532

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		final int SIZE = 9;
		final int LEFT = 1;
		final int RIGHT = 2;

		int n = 0;
		while (n < 2) {
			System.out.print("참여 인원 수 : ");
			n = scan.nextInt();
		}

		boolean[] isOpen = new boolean[n];
		boolean[] isHook = new boolean[n];

		String[] menu = new String[n];
		int[][] ladder = new int[SIZE][n];

		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < n - 1; x++) {
				ladder[y][x] = (int) (Math.random() * 2);	// 0 or 1 때
				if (ladder[y][x] == LEFT) {					
					isHook[x] = true;
					x += 1;
					ladder[y][x] = RIGHT;
				}
			}
			// 맵이 완성된 후 검증
			if (y == SIZE - 1) {
				for (int i = 0; i < n - 1; i++) {
					if (!isHook[i]) {
						ladder = new int[SIZE][n];
						y = -1;
						break;
					}
				}
			}
		}
		
		//참여 인원 수 만큼 메뉴 입력받기
		for(int i=0; i<n; i++) {
			System.out.print("메뉴 입력 : ");
			String str = scan.next();
			
			//중복검사
			boolean isDupl = false;
			for(int j=0; j<i; j++) {
				if(str.equals(menu[j]))
					isDupl = true;
			}
			if(!isDupl)
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
					System.out.print("◼");
				else
					System.out.print("◻︎");
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

			// 중요
			for (int y = 0; y < SIZE; y++) {
				if (ladder[y][x] == LEFT)
					x++;
				else if (ladder[y][x] == RIGHT)
					x--;
			}

			// 메뉴
			if (isOpen[x]) {
				System.out.println("이미 선택된 메뉴입니다.");
				continue;
			} else {
				System.out.printf("%s 메뉴 당첨!", menu[x]);
				isOpen[x] = true;
			}

		}

	}

}
