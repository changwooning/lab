package lv05;

import java.util.Scanner;
import java.util.Random;


public class Ex45 {
	
	// # 스네이크 게임
	// 1. 10x10 배열을 0으로 채운다
	// 2. 스네이크는 1234로 표시한다.
	// 3. 상하좌우로 이동이 가능하며, 꼬리가 따라온다.
	// 4. 자기몸하고 부딪히면, 사망한다.
	// 5. 랜덤으로 아이템을 생성해
	//	  아이템을 먹으면 꼬리 1개가 자란다.
	//

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		final int SIZE = 10;
		final int ITEM = -1;		// 스네이크 바디도 아니고 로드도 아닌 값
		
		int[][] map = new int[SIZE][SIZE];
		
		// 뱀의 크기 (아이템을 먹으면 자라날) count 값이라 생각하면 된다
		int snake = 4;
		
		// 뱀의 좌표
		int[] x = new int[snake];
		int[] y = new int[snake];
		
		// 뱀 배치
		for(int i=0; i<snake; i++) {
			x[i] = i;					// x좌표만 다르게 해서
			map[y[i]][x[i]] = i + 1;	// 배치
		}
		
		while(true) {
			
			// 랜덤 아이템
			int pick = ran.nextInt(3);
			if(pick == 1) {
				
				int rY = ran.nextInt(SIZE);
				int rX = ran.nextInt(SIZE);
				
				if(map[rY][rX] == 0)
					map[rY][rX] = ITEM;
			}
			
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<SIZE; j++) {
					if(map[i][j] == 0)
						System.out.print(" + ");
					else if(map[i][j] == ITEM)
						System.out.print(" ● ");
					else
						System.out.printf("%2d ", map[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			
			System.out.print("a)left d)right w)up s)down : ");
			int sel = scan.next().charAt(0);
			
			// 머리 좌표를 임시 변수로 가지기
			int yy = y[0];
			int xx = x[0];
			
			if(sel == 'a') 
				xx--;
			else if(sel == 'd') 
				xx++;
			else if(sel == 'w') 
				yy--;
			else if(sel == 's') 
				yy++;
			
			if(yy < 0 || yy > SIZE -1 || xx < 0 || xx > SIZE -1)
				continue;
			
			if(map[yy][xx] != 0 && map[yy][xx] != ITEM)
				break;
			
			// 아이템 먹기
			if(map[yy][xx] == ITEM) {
				int[] tempY = y;
				int[] tempX = x;
				
				y = new int[snake + 1];
				x = new int[snake + 1];
				
				for(int i=0; i<snake; i++) {
					y[i] = tempY[i];
					x[i] = tempX[i];
				}
				snake ++;
			}
				
			
			// 이동처리
			// 1) 꼬리 자르기
			map[y[snake-1]][x[snake-1]] = 0;
			// 2) 바디에 좌표 물려주기
			for(int i=snake-1; i>0; i--) {		// 값이 유실되기 때문에
				y[i] = y[i-1];
				x[i] = x[i-1];
			}
			// 3) 머리 좌표 업데이트
			y[0] = yy;
			x[0] = xx;
			
			// 4) 뱀 다시 그리기 (재배치)
			for(int i=0; i<snake; i++)
				map[y[i]][x[i]] = i + 1;
			
		}
		
		System.err.println("snake is dead...");		

	}

}
