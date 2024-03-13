package lv05practice;

import java.util.Scanner;

public class Practice51 {
	
	// 이동하기

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int game[][] = { 
				{ 1, 2, 3, 4 }, 
				{ 5, 6, 7, 8 }, 
				{ 9, 10, 11, 12 }, 
				{ 13, 14, 15, 0 } 
				};

		int move = 0; // 2
		int yx[][] = null;
		
		int y = 0;
		int x = 0;
		
		while(true) {
			
			for(int i=0; i<game.length; i++) {
				for(int j=0; j<game[i].length; j++) {
					System.out.printf("[%2d]", game[i][j]);
					
					if(game[i][j] == 0) {
						y = i;
						x = j;
					}
				}
				System.out.println();
			}
			System.out.println();
			
			System.out.print("상w하s좌a우d 되돌리기 r");
			int dir = scan.next().charAt(0);
			
			int yy = y;
			int xx = x;
			
			if(dir == 'a')
				xx --;
			else if(dir == 'd')
				xx ++;
			else if(dir == 'w')
				yy--;
			else if(dir == 's')
				yy++;
			else if(dir == 'r') {
				
				if(move == 0) {
					System.out.println("더 이상 움직일 수 없습니다.");
					continue;
				}
				
				yy = yx[move -1][0];
				xx = yx[move -1][1];
				
				int[][] temp = yx;
				yx = new int[move-1][];
				
				for(int i=0; i<move-1; i++)
					yx[i] = temp[i];
				
				move --;
			}
			
			if(yy < 0 || yy > game.length-1 || xx < 0 || xx > game[0].length-1)
				continue;
			
			// 이동이 발생하면 -> yx 변수에 현재 좌표 -> 기록
			if("adws".contains(String.valueOf((char)dir))){ 	// r을 제외하기 위
				int[][] temp = yx;
				yx = new int[move+1][];
				
				for(int i=0; i< move ; i++)
					yx[i] = temp[i];
				
				yx[move] = new int[2];
				yx[move][0] = y;
				yx[move][1] = x;
				move ++;
				
			}
			
			// 이동
			int temp = game[yy][xx];
			game[yy][xx] = game[y][x];
			game[y][x] = temp;
			
		}
		

	}

}
