package lv05practice;

import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Practice42 {

	// # 소코반
	// 2302
	// 0007

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		final int SIZE = 9;
		final int LEFT = 'a';
		final int RIGHT = 'd';
		final int UP = 'w';
		final int DOWN = 's';

		final int PLAYER = 2;
		final int WALL = 3;
		final int BALL = 4;
		final int GOAL = 5;
		final int GOAL_IN = 6;

		final int INSTALL_WALL = '1';
		final int INSTALL_BALL = '2';
		final int INSTALL_GOAL = '3';
		final int REMOVE = '4';
		final int EXIT = '0';

		int[][] map = new int[SIZE][SIZE];
		int[][] maker = new int[SIZE][SIZE];

		int pY = 0;
		int pX = 0;

		String lastPos = null;

		int goalCnt = 0;
		int ballCnt = 0;

		String fileName = "maker.txt";

		File file = new File(fileName);
		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br = null;

		maker[pY][pX] = PLAYER;

		try {

			fr = new FileReader(file);
			br = new BufferedReader(fr);

			int y = 0;
			while (y < SIZE) {

				String[] line = br.readLine().split("/");

				for (int x = 0; x < line.length; x++) {
					map[y][x] = Integer.parseInt(line[x]);
					
					if (map[y][x] == BALL)
						ballCnt++;
					else if (map[y][x] == GOAL)
						goalCnt++;
				}
				y++;

			}
			lastPos = br.readLine();

			br.close();
			fr.close();
			System.out.println("파일 로드 완료");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("파일 로드 실패");
		}

		while (true) {

			System.out.println("[1]소코반 메이커");
			System.out.println("[2]게임 시작하기");
			System.out.println("[0]종료하기");
			int sel = scan.nextInt();

			if (sel == 1) {

				while (true) {

					for (int i = 0; i < SIZE; i++) {
						for (int j = 0; j < SIZE; j++) {
							if (map[i][j] != 0 && maker[i][j] == PLAYER)
								System.out.print("* ");
							else if (maker[i][j] == PLAYER)
								System.out.print("옷 ");
							else if (map[i][j] == WALL)
								System.out.print("벽 ");
							else if (map[i][j] == BALL)
								System.out.print("공 ");
							else if (map[i][j] == GOAL)
								System.out.print("골 ");
							else if (map[i][j] == GOAL_IN)
								System.out.print("인 ");
							else
								System.out.print("+ ");
						}
						System.out.println();
					}
					System.out.println();

					System.out.println("상w하s좌a우d");
					System.out.println("벽1 공2 골3 삭제4 종료0");
					int move = scan.next().charAt(0);

					int y = pY;
					int x = pX;

					if (move == LEFT)
						x--;
					else if (move == RIGHT)
						x++;
					else if (move == UP)
						y--;
					else if (move == DOWN)
						y++;

					if (y < 0 || y > SIZE - 1 || x < 0 || x > SIZE - 1 || map[y][x] == WALL)
						continue;

					if (map[y][x] != 0
							&& (map[y][x] == INSTALL_WALL || map[y][x] == INSTALL_BALL || map[y][x] == INSTALL_GOAL))
						continue;

					if (move == INSTALL_WALL)
						map[y][x] = WALL;
					else if (move == INSTALL_BALL) {
						map[y][x] = BALL;
						ballCnt++;
					} else if (move == INSTALL_GOAL) {
						map[y][x] = GOAL;
						goalCnt++;
					} else if (move == REMOVE) {
						if (map[y][x] == BALL)
							ballCnt--;
						else if (map[y][x] == GOAL)
							goalCnt--;
					} else if (move == EXIT) {
						if (ballCnt != goalCnt) {
							System.out.println("골대와 공은 쌍을 이루어야 합니다.");
							continue;
						}
						break;
					}

					maker[pY][pX] = 0;
					pY = y;
					pX = x;
					maker[pY][pX] = PLAYER;

				}

			} else if (sel == 2) {

				int y = 0;
				int x = 0;

				while (true) {

					if (lastPos == null) {

						while (true) {

							int rY = ran.nextInt(SIZE);
							int rX = ran.nextInt(SIZE);

							if (map[rY][rX] == 0) {
								map[rY][rX] = PLAYER;
								y = rY;
								x = rX;
								break;
							}
						}
					} else {

						String[] pos = lastPos.split("/");
						y = Integer.parseInt(pos[0]);
						x = Integer.parseInt(pos[1]);
					}

					map[y][x] = PLAYER;

					while (true) {

						for (int i = 0; i < SIZE; i++) {
							for (int j = 0; j < SIZE; j++) {
								if (map[i][j] == PLAYER)
									System.out.print("옷 ");
								else if (map[i][j] == WALL)
									System.out.print("벽 ");
								else if (map[i][j] == BALL)
									System.out.print("공 ");
								else if (map[i][j] == GOAL)
									System.out.print("골 ");
								else if (map[i][j] == GOAL_IN)
									System.out.print("인 ");
								else
									System.out.print("+ ");
							}
							System.out.println();
						}
						System.out.println();

						// 종료조건
						if (ballCnt == 0) {
							System.out.println("game clear");
							map = new int[SIZE][SIZE];
							lastPos = null;
							break;
						}

						System.out.println("상w하s좌a우d");
						System.out.println("종료0");
						int move = scan.next().charAt(0);

						int yy = y;
						int xx = x;

						if (move == LEFT)
							xx--;
						else if (move == RIGHT)
							xx++;
						else if (move == UP)
							yy--;
						else if (move == DOWN)
							yy++;
						else if (move == EXIT) {
							lastPos = y + "/" + x;
							break;
						}

						if (yy < 0 || yy > SIZE - 1 || xx < 0 || xx > SIZE - 1 || map[yy][xx] == WALL)
							continue;

						if (map[yy][xx] == BALL) {

							int bY = yy;
							int bX = xx;

							if (move == LEFT)
								bX--;
							else if (move == RIGHT)
								bX++;
							else if (move == UP)
								bY--;
							else if (move == DOWN)
								bY++;

							if (bY < 0 || bY > SIZE - 1 || bX < 0 || bX > SIZE - 1 || map[bY][bX] == WALL
									|| map[bY][bX] == GOAL_IN)
								continue;

							if (map[bY][bX] == GOAL) {
								map[bY][bX] = GOAL_IN;
								ballCnt--;
								goalCnt--;
							} else {
								map[bY][bX] = BALL;
							}

						}

						if (map[y][x] != GOAL)
							map[y][x] = 0;
						y = yy;
						x = xx;
						if (map[y][x] != GOAL)
							map[y][x] = PLAYER;

					}
				}

			} else if (sel == 0) {

				System.out.println("프로그램을 종료합니다.");
				break;
			}

			String mapData = "";
			for (int i = 0; i < SIZE; i++) {
				String line = "";
				for (int j = 0; j < SIZE; j++)
					line += map[i][j] + "/";
				mapData += line.substring(0, line.length() - 1);
				if (i < SIZE - 1)
					mapData += "\n";
			}

			try {

				fw = new FileWriter(fileName);
				fw.write(mapData);
				if (lastPos != null)
					fw.write("\n" + lastPos);
				fw.close();
				System.out.println("파일 저장 완료");

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("파일 저장 실패");
			}

		}

	}

}
