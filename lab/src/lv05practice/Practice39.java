package lv05practice;

import java.util.Scanner;
import java.util.Random;

public class Practice39 {
	
	// # 크레이지 아케이드
	// 0152
	// 0212

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
		
		int[][] bomb = null;
		int bombCnt = 0;
		int itemCnt = 0;
		
		int wallCnt = ran.nextInt(SIZE*SIZE/4)+5;
		
		while(wallCnt > 0) {
			
			int rY = ran.nextInt(SIZE);
			int rX = ran.nextInt(SIZE);
			
			if(map[rY][rX] == 0) {
				map[rY][rX] = WALL;
				wallCnt--;
			}
		}
		
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
		
		boolean isRun = true;
		while(isRun) {
			
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

			System.out.println("상w하s좌a우d")	;
			System.out.println("폭탄e 폭발q");
			System.out.print("move : ");
			char move = scan.next().charAt(0);
			
			int y = pY;
			int x = pX;
			
			if(move == LEFT)
				x--;
			else if(move == RIGHT)
				x++;
			else if(move == UP)
				y--;
			else if(move == DOWN)
				y++;
			
			if(y < 0 || y > SIZE-1 || x < 0 || x > SIZE-1 || map[y][x] == WALL || map[y][x] == BOMB && map[pY][pX] != BOMB)
				continue;
			
			// 아이템 추가
			if(map[y][x] == ITEM)
				itemCnt++;
			
			
			if(move == INSTALL_BOMB) {
				
				if(itemCnt == 0) {
					System.out.println("아이템이 부족합니다.");
					continue;
				}
				
				int bY = pY;
				int bX = pX;
				
				int[][] temp = bomb;
				bomb = new int[bombCnt+1][];
				
				for(int i=0; i<bombCnt; i++)
					bomb[i] = temp[i];
				
				bomb[bombCnt] = new int[2];
				bomb[bombCnt][0] = bY;
				bomb[bombCnt][1] = bX;
				bombCnt++;
				itemCnt--;
				
				map[bY][bX] = BOMB;
				
			}
			
			if(move == EXPLODE_BOMB) {
				
				if(bombCnt == 0) {
					System.out.print("설치된 폭탄이 없습니다.");
					continue;
				}
				
				int bY = bomb[0][0];
				int bX = bomb[0][1];
				
				for(int i=-1; i<=1; i++) {
					if(bY+i >= 0 || bY + i < SIZE)
						if(map[bY+i][bX] == WALL)
							map[bY+i][bX] = ran.nextInt(2) * ITEM;
						else if(bY+i == pY && bX == pX)
							isRun = false;
					if(bX+i >= 0 || bX + i < SIZE)
					if(map[bY][bX+i] == WALL)
						map[bY][bX+i] = ran.nextInt(2) * ITEM;
					else if(bY == pY && bX+i == pX)
						isRun = false;
				}
				
				map[bY][bX] = 0;
				
				int[][] temp = bomb;
				bomb = new int[bombCnt-1][];
				
				for(int i=1; i<bombCnt; i++)
					bomb[i-1] = temp[i];
				
				bombCnt--;
				
				
			}
			
			if(map[pY][pX] != BOMB)
				map[pY][pX] = 0;
			pY = y;
			pX = x;
			if(map[pY][pX] != BOMB)
				map[pY][pX] = PLAYER;
			
			
			
		}
		
		

	}

}
