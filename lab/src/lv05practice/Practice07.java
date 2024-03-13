package lv05practice;

import java.util.Scanner;
import java.util.Random;

public class Practice07 {
	
	// # 크레이지 아케이드
		// 1. 맵의 크기는 7 * 7 이다.
		// 2. 상(w)하(s)좌(a)우(d)로 이동이 가능하며,
		// 폭탄설치(e), 폭파(q)로 설정한다.
		// 3. 벽(3), 플레이어(2), 폭탄(9), 아이템(4)로 설정한다.
		// 4. 단, 폭탄이 설치된 순서대로 터져야 하며,
		// 폭파 시 십자가 형태로 터진다.
		// 5. 벽 파괴시 아이템이 랜덤하게 생성되어,
		// 아이템을 먹으면 설치할 수 있는 폭탄의 개수가 증가된다.
		

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		final int SIZE = 7;
		final int PLAYER = 2;
		final int WALL = 3;
		final int ITEM = 4;
		final int BOMB = 9;
		
		final int LEFT = 'a';
		final int RIGHT = 'd';
		final int UP = 'w';
		final int DOWN = 's';
		
		final int INSTALL_BOMB = 'e';
		final int EXPLODE_BOMB = 'q';
		
		
		int[][] map = new int[SIZE][SIZE];
		
		int pY = 0;
		int pX = 0;
		
		int bombCnt = 10;
		int itemCnt = 0;
		int[][] bombYx = null;		// => {bombY,bombX}
		
		// 벽 랜덤 설치
		int wallCnt = ran.nextInt(SIZE * SIZE/4) + 7;
		
		// 랜덤 좌표 생성
		while(wallCnt > 0) {
			
			int rY = ran.nextInt(SIZE);
			int rX = ran.nextInt(SIZE);
			
			if(map[rY][rX] == 0) {
				map[rY][rX] = WALL;
				wallCnt --;
			}
		}
		
		// 플레이어 랜덤 지정
		while(true) {
			
			int rY = ran.nextInt(SIZE);
			int rX = ran.nextInt(SIZE);
			
			if(map[rY][rX] == 0) {
				map[rY][rX] = PLAYER;
				pY = rY;
				pX = rX;
				break;
			}
		}
		
		// run
		boolean run = true;
		while(run) {
			
			// print
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<SIZE; j++) {
					int block = map[i][j];
					if(block == PLAYER)
						System.out.print("");
					else if(block == WALL)
						System.out.print("");
					else if(block == ITEM)
						System.out.print("");
					else if(block == BOMB)
						System.out.print("");
					else
						System.out.print("");
				}
				System.out.println();
			}
			System.out.println();
			
			System.out.println("---------------");
			System.out.printf("bomb : %d/%d\n",bombCnt,itemCnt);
			System.out.println("---------------");
			System.out.println("      [w]      ");
			System.out.println("   [a][s][d]   ");
			System.out.println(" [e]폭탄 [q]폭파 ");
			System.out.println("---------------");
			System.out.print("move : ");
			char move = scan.next().charAt(0);
			
			int y = pY;
			int x = pX;
			
			// 이동처리
			
			if(move == 'a')
				x--;
			else if(move == 'd')
				x++;
			else if(move == 'w')
				y--;
			else if(move == 's')
				y++;
			
			// 예외처리 1. 범위 
			if(y < 0 || y >= SIZE || x < 0 || x >= SIZE || map[y][x] == WALL || map[y][x] == BOMB && map[pY][pX] != BOMB)
				continue;
			
			// 아이템 먹기
			if(map[y][x] == ITEM)
				itemCnt++;
			
			// 폭탄 설치
			if(move == INSTALL_BOMB) {
				
				// 예외처리 1. 폭탄 개수
				if(itemCnt == 0) {
					System.out.println("아이템이 부족합니다.");
					continue;
				}
				
				int bY = pY;
				int bX = pX;
				
				int[][] temp = bombYx;
				bombYx = new int[bombCnt][];
				
				for(int i=0; i<bombCnt; i++)
					bombYx[i] = temp[i];
				
				bombYx[bombCnt] = new int[2];
				bombYx[bombCnt][0] = bY;
				bombYx[bombCnt][1] = bX;
				bombCnt ++;
				
				map[bY][bX] = BOMB;
				
				bombCnt ++;
				itemCnt --;
			}
			
			// 폭파
			else if(move == EXPLODE_BOMB) {
				
				if(bombCnt == 0) {
					System.out.println("설치된 폭탄이 없습니다.");
					continue;
				}
				
				// 설치된 순서대로 터트려야함
				int bY = bombYx[0][0];
				int bX = bombYx[0][1];
				
				// 폭탄을 중심으로 사방 지우기 (WALL에 대한)
				for(int i=-1; i<=1; i++) {
					if(bY + i >= 0 && bY + i < SIZE) {				// 좌표 값이 map 범위 내에 있어야함
						if(map[bY + i][bX] == WALL)					// bY 기준으로 -1, 0, 1 벽일 때
							map[bY+i][bX] = ran.nextInt(2)* ITEM;	// 50프로 확률로 아이템 생성
						else if(bY+i == pY && bX == pX)				// 
							run = false;
					}
					if(bX + i >= 0 && bX + i < SIZE)
						if(map[bY][bX+i] == WALL)
							map[bY][bX+i] = ran.nextInt(2) * ITEM;
						else if(bY == pY && bX+i == pX)
							run = false;
				}
				
				map[bY][bX] = 0; 	// 폭탄 삭제
				
				// 폭탄의 좌표 배열 => 재정렬
				int[][] temp = bombYx;
				bombYx = new int[bombCnt-1][];
				
				for(int i=1; i<bombCnt; i++) 
					bombYx[i-1] = temp[i];		// 폭파가 된 0인덱스 좌표를 뺀 나미저 옮기기
				
				bombCnt --;
			}
			
			// 플레이어 다시 그리기
			if(map[pY][pX] != BOMB)
				map[pY][pX] = 0;
			pY = y;
			pX = x;
			
			if(map[pY][pX] != BOMB)
				map[pY][pX] = PLAYER;
		}
		System.out.println("PLAYER is DAED...");
		
		
		
		
		
		
	}

}
