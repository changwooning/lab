package lv06;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

// # 사다리 게임(N플레이어)

class Ladder {
	final int HOOK = 1;

	int player; // 플레이어 수
	int ladder[][];
	String[] menu;

	void run() {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		final int SIZE = 9;

		// 참여인원수
		int player = 0;
		while (player < 2) {
			System.out.print("참여 인원 수 : ");
			player = scan.nextInt();
		}

		// ├ ─ ┤ │

		String[] menu = new String[player];
		boolean[] isOpen = new boolean[player];
		int[][] ladder = new int[SIZE][player];
		boolean[] isHook = new boolean[player];

		for (int y = 1; y < SIZE - 1; y++) {
			for (int x = 0; x < player - 1; x++) {
				ladder[y][x] = ran.nextInt(2);
				if (ladder[y][x] == HOOK) {
					isHook[x] = true;
					ladder[y][x + 1] = HOOK;
					x += 1;
				}
			}

			if (y == SIZE - 1) {
				for (int i = 0; i < player - 1; i++) {
					if (!isHook[i]) {
						ladder = new int[SIZE][player];
						y = -1;
						break;
					}
				}
			}
		}

		for (int i = 0; i < player; i++) {
			System.out.printf("메뉴 %d : ", i + 1);
			String menuName = scan.next();

			boolean isDupl = false;
			for (int j = 0; j < i; j++) {
				if (menuName.equals(menu[j]))
					isDupl = true;
			}
			if (!isDupl)
				menu[i] = menuName;
			else
				i--;
		}

		while (true) {

			for (int i = 0; i < player; i++)
				System.out.print(i + 1);
			System.out.println();

			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < player; j++) {
					if (ladder[i][j] == HOOK) {
						System.out.print("├┤");
						j++;
					} else
						System.out.print("│");
				}
				System.out.println();
			}
			System.out.println();

			for (int i = 0; i < player; i++) {
				if (isOpen[i])
					System.out.print("◻");
				else
					System.out.print("◼︎");
			}

			System.out.println();

			System.out.printf("번호 선택 : ");
			int num = scan.nextInt()-1;

			for(int i=0; i<SIZE; i++) {
				int hookCnt = 0;
				for(int j=0; j<player; j++) {
					if(ladder[i][j] == HOOK)
						hookCnt++;
					
					if(ladder[i][j] == HOOK) {
						if(hookCnt % 2 == 0)
							num --;
						else
							num ++;
					}
				}
					
			}
			
			
			
			
			

		}

	}

}

public class Ex12 {

	public static void main(String[] args) {

		Ladder ladder = new Ladder();
		ladder.run();

	}

}
