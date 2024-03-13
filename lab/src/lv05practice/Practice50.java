package lv05practice;

import java.util.Scanner;
import java.util.Random;

public class Practice50 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		final int SIZE = 10;
		final int ITEM = -1;

		int[][] map = new int[SIZE][SIZE];

		int snake = 4;

		int[] y = new int[snake];
		int[] x = new int[snake];

		for (int i = 0; i < snake; i++) {
			x[i] = i;
			map[y[i]][x[i]] = i + 1;
		}

		while (true) {
			
			// 랜덤 아이템 생성
			int pick = ran.nextInt(3);
			if(pick == 1) {
				
				int rY = ran.nextInt(SIZE);
				int rX = ran.nextInt(SIZE);
				
				if(map[rY][rX] == 0) {
					map[rY][rX] = ITEM;
					
				}
			}
			

			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if (map[i][j] == 0)
						System.out.print(" + ");
					else if (map[i][j] == ITEM)
						System.out.print(" ● ");
					else
						System.out.printf("%2d ", map[i][j]);
				}
				System.out.println();
			}
			System.out.println();

			System.out.println("상w하s좌a우d");
			int move = scan.next().charAt(0);

			int yy = y[0];
			int xx = x[0];

			if (move == 'a')
				xx--;
			else if (move == 'd')
				xx++;
			else if (move == 'w')
				yy--;
			else if (move == 's')
				yy++;

			if (yy < 0 || yy > SIZE - 1 || xx < 0 || xx > SIZE - 1)
				continue;

			if (map[yy][xx] != 0 || map[yy][xx] != ITEM)
				break;

			if (map[yy][xx] == ITEM) {

				int[] tempY = y;
				int[] tempX = x;

				y = new int[snake + 1];
				x = new int[snake + 1];

				for (int i = 0; i < snake; i++) {
					y[i] = tempY[i];
					x[i] = tempX[i];
				}
				snake++;
			}

			map[y[snake - 1]][x[snake - 1]] = 0;

			for (int i = snake - 1; i > 0; i--) {
				y[i] = y[i - 1];
				x[i] = x[i - 1];
			}
			y[0] = yy;
			x[0] = xx;
			for (int i = 0; i < snake; i++) {
				map[y[i]][x[i]] = i + 1;
			}
		}
		System.out.println("snake is dead");

	}

}
