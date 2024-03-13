package lv04practice;

import java.util.Scanner;
import java.util.Random;

public class Practice39 {

	// 1 to 18
	// 2010

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		final int SIZE = 9;

		int[] front = new int[SIZE];
		int[] back = new int[SIZE];

		// set map
		for (int i = 0; i < SIZE; i++) {
			front[i] = i + 1;
			back[i] = i + 1 + SIZE;
		}

		// 셔플
		for (int i = 0; i < SIZE; i++) {
			int rIdx = (int) (Math.random() * SIZE);
			int temp = front[0];
			front[0] = front[rIdx];
			front[rIdx] = temp;

			rIdx = (int) (Math.random() * SIZE);
			temp = back[0];
			back[0] = back[rIdx];
			back[rIdx] = temp;
		}

		// run
		int gameNum = 1;
		while (true) {
			// print
			for (int i = 0; i < SIZE; i++) {
				System.out.printf("[%2d]", front[i]);
				if (i % 3 == 2)
					System.out.println();
			}

			// end
			if (gameNum > SIZE * 2)
				break;

			// input
			System.out.print("idx : ");
			int idx = scan.nextInt();

			// 예외처리
			if (idx < 0 || idx > SIZE - 1) {
				System.out.println("입력한 값은 범위에 해당하지 않습니다.");
				continue;
			}

			// 카드 뒤집기
			if (front[idx] == gameNum) {
				front[idx] = back[idx];
				back[idx] = 0;
				gameNum++;
			}else {
				System.out.println("순서가 틀렸습니다.");
				continue;
			}

		}
		System.out.println("GAME CLEAR~!");

	}

}
