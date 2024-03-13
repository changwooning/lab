package lv04;

import java.util.Random;
import java.util.Scanner;

public class Ex47 {

	public static void main(String[] args) {

		Random ran = new Random();
		Scanner scan = new Scanner(System.in);

		final int SIZE = 7;
		final int PLAYER = 2; // ▲
		final int BALL = 3; // ●
		final int GOAL = 7; // ☐
		final int WALL = 9; // ■
		final int LOAD = 0; // +︎

		int[][] map = new int[SIZE][SIZE];

		int wallCount = 0;
		
		int wallX = 0;
		int wallY = 0;
		

		// 플레이어 1명 (좌표)
		int pY = 0;
		int pX = 0;

		// 공 1개 (좌표)
		int ballY = 0;
		int ballX = 0;

		// 골대 1개 (좌표)
		int goalY = 0;
		int goalX = 0;

		// 벽 설치 (개수만큼 랜덤 좌표에 배치, 벽 개수 10개)
		System.out.print(">>> 설치할 벽의 개수를 입력하세요 : ");
		wallCount = scan.nextInt();

		if (wallCount < 1 || wallCount > 10)
			System.out.println("벽 개수는 1~10개입니다.");

		for (int i = 0; i < wallCount; i++) {

			// 벽 랜덤 좌표 ?
			wallX = ran.nextInt(SIZE);
			wallY = ran.nextInt(SIZE);

			// 예외처리 이미 있을때?
			if (map[wallY][wallX] == LOAD)
				map[wallY][wallX] = WALL;
			else
				wallCount--;
		}

		// 플레이어 설치 랜덤 초기화
//		pY = ran.nextInt(SIZE);
//		pX = ran.nextInt(SIZE);
		map[pY][pX] = PLAYER;

		// 공 설치
		ballY = ran.nextInt(SIZE);
		ballX = ran.nextInt(SIZE);
		map[ballY][ballX] = BALL;

		// 골대 설치
		goalY = ran.nextInt(SIZE);
		goalX = ran.nextInt(SIZE);
		map[goalY][goalX] = GOAL;

		// 게임 시작
		// 플레이어에 대한 이동처리
		// ㄴ 맵 범위 밖에 대한 예외처리
		// ㄴ 구조물(골대,벽)에 대한 예외처리
		// a : 서
		// d : 동
		// s : 남
		// w : 북
		boolean run = true;
		while (run) {
			// 맵출력
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if (map[i][j] == PLAYER) {
						System.out.print("▲ ");
					} else if (map[i][j] == BALL)
						System.out.print("● ");
					else if (map[i][j] == GOAL)
						System.out.print("☐ ");
					else if (map[i][j] == WALL)
						System.out.print("■ ");
					else if (map[i][j] == LOAD)
						System.out.print("+︎ ");
				}
				System.out.println();
			}
			System.out.println();

			System.out.print("1.서(a) 2.동(d) 3.남(s) 4.북(w)");
			String input = scan.next();

			int temp1 = pY;
			int temp2 = pX;

			if (input.equals("a")) {
				temp1--;
			} else if (input.equals("d")) {
				temp2++;
			} else if (input.equals("s")) {
				temp1--;
			} else if (input.equals("w")) {
				temp2++;
			} else {
				System.out.println("다시 입력 해주세요.");
				continue;
			}

			if (map[temp1][temp2] < 0 || map[pY][pX] > SIZE) {
				System.out.println("삐삐--");
				continue;
			}
			if (map[temp1][temp2] == map[goalY][goalX]) {
				System.out.println("삐-");
				continue;
			}
			if(map[temp1][temp2] == map[wallY][wallX]) {
				System.out.println("삐삐삐---");
				continue;
			}
			
			map[pY][pX] = LOAD;
			temp1 = pY;
			temp2 = pX;
			map[pY][pX] = PLAYER;
			
			

		}

	}

}
