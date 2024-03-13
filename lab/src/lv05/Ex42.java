package lv05;

import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;

public class Ex42 {

	// 플레이어가 돌아다니면서 폭탄 내려놓듯이 구조물을 설치 -> 파일로 저장 후,
	// 콘솔종료 후 재실행 시에도 -> 게임을 이어갈 수 있게 만들어보세요.

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		final int SIZE = 9;

		final int LEFT = 'a';
		final int RIGHT = 'd';
		final int UP = 'w';
		final int DOWN = 's';

		final int INSTALL_WALL = '1'; // => 일반 상수가 아님 아스키 코드
		final int INSTALL_BALL = '2';
		final int INSTALL_GOAL = '3';
		final int REMOVE = '4';
		final int EXIT = '0';

		final int PLAYER = 2;
		final int WALL = 3;
		final int BALL = 4;
		final int GOAL = 5;
		final int GOAL_IN = 6;

		int pY = 0;
		int pX = 0;

		int[][] map = new int[SIZE][SIZE];
		int[][] maker = new int[SIZE][SIZE];

		String fileName = "maker.txt";

		File file = new File(fileName);
		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br = null;

		String lastPos = null;  // y/x

		int ballCnt = 0;
		int goalCnt = 0;

		maker[pY][pX] = PLAYER;

		// 파일 로드
		try {

			fr = new FileReader(file);
			br = new BufferedReader(br);

			int y = 0;
			while (y < SIZE) {
				String[] line = br.readLine().split("/");

				for (int x = 0; x < line.length; x++) { // i : 맵 배열의 내부 인덱스
					map[y][x] = Integer.parseInt(line[x]);

					if (map[y][x] == BALL)
						ballCnt++;
					else if (map[y][x] == GOAL)
						goalCnt++;
				}
				y++; 	// 
			}
			lastPos = br.readLine();
			
			br.close();
			fr.close();
			System.out.println("파일 로드 완료");
		} catch (Exception e) {

			System.out.println("파일 로드 실패");
		}

		while (true) {
			System.out.println("[1]소코반 메이커");
			System.out.println("[2]게임 시작하기");
			// 저장된 맵이 있으면 -> 불러와서 게임시작
			System.out.println("[0]종료하기");

			int choice = scan.nextInt();

			if (choice == 1) {
				while (true) {
					for (int i = 0; i < SIZE; i++) {
						for (int j = 0; j < SIZE; j++) {
							if (map[i][j] != 0 && maker[i][j] == PLAYER)
								System.out.print("* ");
//							else if(i == pY && j == pX) 
//								System.out.print("옷\t");
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

					System.out.println("[이동] ▶ 상(w)하(s)좌(a)우(d)︎");
					System.out.println("[설치] ▶ 벽(1)공(2)골(3)제거(4) ︎");
					System.out.println("[종료] ▶ 0");

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

					// 구조물 설치 예외처리
					if (map[y][x] != 0 && (move == INSTALL_WALL || move == INSTALL_BALL || move == INSTALL_GOAL))
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
						map[y][x] = 0;
					} else if (move == EXIT) {
						if (ballCnt != goalCnt) {
							System.out.println("공과 골대는 쌍을 이루어야 합니다.");
							continue;
						}
						break;
					}

					// 플레이어 이동처리 (좌표만 변경)
					maker[pY][pX] = 0;
					pY = y;
					pX = x;
					maker[pY][pX] = PLAYER;

				}

			} else if (choice == 2) {
				// 게임 실행
				// ㄴ 게임용 플레이어의 좌표 -> 랜덤으로 배치
				int y = 0;
				int x = 0;

				if (lastPos == null) {	// 시작전

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
				}else { 	// 게임 시작 이후 플레이어 좌표 있음
					String[] pos = lastPos.split("/");
					y = Integer.parseInt(pos[0]);
					x = Integer.parseInt(pos[1]);
				}
				map[y][x] = PLAYER;

				boolean isRun = true;
				while (isRun) {
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

					// 종료 조건
					if (ballCnt == 0) {
						System.out.println("game CLEAR");
						map = new int[SIZE][SIZE];
						lastPos = null;
						break;
					}

					System.out.println("[이동] ▶ 상(w)하(s)좌(a)우(d)︎");
					System.out.println("[종료] ▶ 0");
					char move = scan.next().charAt(0);

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
						// 플레이어 좌표 기억이 필요 
						lastPos = y + "/" + x;
						break;
					}
					if (yy < 0 || yy > SIZE - 1 || xx < 0 || xx > SIZE - 1 || map[yy][xx] == WALL)
						continue;

					// 볼 움직이기
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
						} else
							map[bY][bX] = BALL;

					}
					if (map[y][x] != GOAL)
						map[y][x] = 0;
					y = yy;
					x = xx;
					if (map[y][x] != GOAL)
						map[y][x] = PLAYER;

				}

			}

			// 파일저장 (map)

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
				fw = new FileWriter(file);
				fw.write(mapData);
				
				if(lastPos != null)	// 게임 시작 후 좌표가 있을때
					fw.write("\n" + lastPos);	// 
				fw.close();
				System.out.println("파일 저장 완료");

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("파일 저장 실패");
			}

		}

	}

}
