package lv05;

import java.util.Scanner;
import java.util.Random;

public class Ex41 {

	// # 크레이지 아케이드
	// 1. 맵의 크기는 7 * 7 이다.
	// 2. 상(w)하(s)좌(a)우(d)로 이동이 가능하며,
	// 폭탄설치(e), 폭파(q)로 설정한다.
	// 3. 벽(3), 플레이어(2), 폭탄(9), 아이템(4)로 설정한다.
	// 4. 단, 폭탄이 설치된 순서대로 터져야 하며,
	// 폭파 시 십자가 형태로 터진다.
	// 5. 벽 파괴시 아이템이 랜덤하게 생성되어,
	// 아이템을 먹으면 설치할 수 있는 폭탄의 개수가 증가된다.
	
	// 선생님 코드

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		final int SIZE = 7;
		final int BAZZI = 2;
		final int WALL = 3;
		final int ITEM = 4;
		final int BOMB = 9;

		final int LEFT = 'a';
		final int RIGHT = 'd';
		final int UP = 'w';
		final int DOWN = 's';
		final int INSTALL_BOMB = 'e';
		final int EXPLODE_BOMB = 'q'; // => 가동성을 위해서 상수 사용

		int[][] map = new int[SIZE][SIZE];

		int pY = 0;
		int pX = 0;

		// 설치된 폭탄의 좌표를 기억해야함 -> 순서대로 폭파 (0인덱스 폭탄부터 차례대로 1개씩 폭파)

		int itemCnt = 10;
		int bombCnt = 0;
		int[][] bombYx = null; // {bombY,bombX},{bombY,bombX},{bombY,bombX},,,

		// 벽 설치
		int wallCnt = ran.nextInt(SIZE * SIZE / 4) + 5;

		while (wallCnt > 0) { // 벽이 다 설치가 될때까지
			// 랜덤 좌표 뽑기
			int rY = ran.nextInt(SIZE);
			int rX = ran.nextInt(SIZE);

			if (map[rY][rX] == 0) {
				map[rY][rX] = WALL;
				wallCnt--;
			}
		}

		// 플레이어 배치
		while (true) {

			int rY = ran.nextInt(SIZE);
			int rX = ran.nextInt(SIZE);

			if (map[rY][rX] == 0) {
				map[rY][rX] = BAZZI;
				pY = rY; // 좌표 기억
				pX = rX;
				break;
			}
		}

		// 게임 실행
		boolean isRun = true;
		while (isRun) {

			// print
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					int block = map[i][j];

					if (block == BAZZI)
						System.out.print("▲  ");
					else if (block == WALL)
						System.out.print("◼︎  ");
					else if (block == BOMB)
						System.out.print("@  ");
					else if (block == ITEM)
						System.out.print("❖  ");
					else
						System.out.print("•  ");
				}
				System.out.println();
			}
			System.out.println();

			System.out.println("----------------");
			System.out.printf("bomb : %d/%d\n", bombCnt, itemCnt);
			System.out.println("----------------");
			System.out.println("   [w]"          );
			System.out.println("[a][s][d]"       );
			System.out.println("[q]폭파 [e]폭탄설치");
			System.out.println("----------------");
			System.out.print("move : ");
			char move = scan.next().charAt(0);

			// 플레이어 좌표의 복사본
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

			// 이동에 대한 예외처리
			if (y < 0 || y >= SIZE || x < 0 || x >= SIZE || map[y][x] == WALL || map[y][x] == BOMB && map[pY][pX] != BOMB)
				continue;

			// 아이템 먹기
			if(map[y][x] == ITEM)
				itemCnt ++;
			
			
			// 설치 및 폭파
			if (move == INSTALL_BOMB) {

				// 예외처리 1. 폭탄 개수
				if (itemCnt == 0) {
					System.err.println("아이템이 부족합니다.");
					continue;
				}

				// 설치할 폭탄의 좌표 기억해둠 (차례대로)
				int bY = pY;
				int bX = pX;

				int[][] temp = bombYx;                             // 구 주소
				bombYx = new int[bombCnt + 1][];                   // 새 주소

				for (int i = 0; i < bombCnt; i++)                  // 1차원 주소 옮기기( {bY,bX} <- 기존에 설치된 폭탄 좌표들
					bombYx[i] = temp[i];

				bombYx[bombCnt] = new int[2]; // null -> {0,0}
				bombYx[bombCnt][0] = bY;                           // 새로 설치한 폭탄 좌표를 추가
				bombYx[bombCnt][1] = bX;

				map[bY][bX] = BOMB;				                   // 폭탄설치

				bombCnt++;
				itemCnt--;

			} else if (move == EXPLODE_BOMB) {

				if(bombCnt == 0) {
					System.out.println("설치된 폭탄이 없습니다.");
					continue;
				}
				
				// 먼저 설치된 순서대로 폭파
				int bY = bombYx[0][0];
				int bX = bombYx[0][1];
				
				// 폭탄을 중심으로 사방 지우기(WALL에 대한)
				for(int i=-1; i<=1; i++) {		
					// 중앙을 뺀 나머지 - > 중앙포함
					// |
					if(bY+ i >= 0 && bY + i < SIZE) {
						if(map[bY+i][bX] == WALL) {
							map[bY+i][bX] = ran.nextInt(2) * ITEM;
						}else if(bY + i == pY && bX == pX) {
							isRun = false;
						}
					}
					// -
					if(bX+i >= 0 && bX + i < SIZE) {
						if(map[bY][bX + i] == WALL) {
							map[bY][bX+ i] = ran.nextInt(2) * ITEM;
						}
						else if(bY == pY && bX + i == pX) {		// 자폭에 대한 예외처리
							isRun = false;
						}
					}
				}
				
				map[bY][bX] = 0;					  // 폭탄 삭제
				
				// 폭탄의 좌표 배열 -> 재정렬
				int[][] temp = bombYx;
				bombYx = new int[bombCnt -1][];
				
				for(int i=1; i<bombCnt; i++) 		  // 폭파가 된 0인덱스 좌표를 뺀 나머지 옮기기
					bombYx[i-1] = temp[i];
				
				bombCnt--;
				
			}

			// 플레이어 다시 그리기
			if (map[pY][pX] != BOMB)                 // 폭탄이 설치되지 않았을 때에만 0 초기화
				map[pY][pX] = 0;
			pY = y;
			pX = x;
			
			if (map[pY][pX] != BOMB)
				map[pY][pX] = BAZZI;
		}
		
		System.out.println("BAZZI is DEAD...");
		
		
		

	}

}
