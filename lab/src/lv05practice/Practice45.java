package lv05practice;

import java.util.Random;

public class Practice45 {

	// 경마 게임
	// 1254

	public static void main(String[] args) {

		Random ran = new Random();

		final int MAX = 20;
		final int HORSE = 1;

		int[][] horse = new int[5][MAX];
		int[] rank = new int[5];
		int[] total = new int[5];

		int record = 1;

		for (int i = 0; i < horse.length; i++) {
			int x = total[i];
			horse[i][x] = HORSE;
		}

		while (true) {

			System.out.println("RACE >>>>>>>");
			for (int i = 0; i < horse.length; i++) {
				for (int x = 0; x < MAX; x++) {
					if (horse[i][x] == HORSE)
						System.out.print("_말");
					else
						System.out.print("__");
				}
				System.out.println();
			}
			System.out.println();

			if (record > horse.length)
				break;

			boolean isGoal = false;
			for (int i = 0; i < horse.length; i++) {

				if (rank[i] != 0)
					continue;

				int x = total[i];
				int jump = ran.nextInt(4);

				horse[i][x] = 0;
				x += jump;

				if (x >= MAX - 1) {
					if (isGoal) {
						i--;
						continue;
					}
					x = MAX - 1;
					rank[i] = record++;
					isGoal = true;
				}

				horse[i][x] = HORSE;
				total[i] = x;
			}
			try {
				Thread.sleep(300);
			} catch (Exception e) {
			}
		}
		for (int i = 0; i < rank.length; i++)
			System.out.printf("%d) %d등\n", i + 1, rank[i]);

	}

}
