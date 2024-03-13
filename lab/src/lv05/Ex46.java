package lv05;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Ex46 {
	
	// 

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int game[][] = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,0}
		};
		
		int move = 0;			// 2
		int yx [][] = null;		// { {y,x},{y,x}....}
		
		// 문제1) 0이 플레이어이다.
		// a) left d) right w) up s) down r) 되감기
		// 번호를 입력받고 해당위치로 이동 ==> 이동할 때 값을 서로 교환한다.
		// 예) a (왼쪽 이동) ==>
		//
		// {1,2,3,4},
		// {5,6,7,8},
		// {9,10,11,12},
		// {13,14,0,15}
		//
		
		
		// 현좌표
		int pY = 3;
		int pX = 3;
		
		while(true) {
			
			for(int i=0; i<move; i++) {
				System.out.println(Arrays.toString(yx[i]));
			}
			
			for(int i=0; i<game.length; i++) {
				for(int j=0; j<game[i].length; j++) {
					System.out.print(game[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			
			
			System.out.println("a) left d) right w) up s) down r) 되감기");
			int mov = scan.next().charAt(0);

			int y = pY;
			int x = pX;
			
			if(mov == 'a') {
				x--;
			}
			else if(mov == 'd') {
				x++;
			}
			else if(mov == 'w') {
				y--;
			}
			else if(mov == 's') {
				y++;
			}
			
			if(x < 0 || x > game.length-1 || y < 0 || y > game.length-1)
				continue;
			
			if(move == 'r') {
				
				for(int i=yx.length-1; i>=0; i--) {
					yx[i] = yx[i+1];
					
					continue;
					
				}
					
						
			}

			int[][] temp = yx;
			yx = new int[move+1][];
			
			for(int i=0; i<move; i++)
				yx[i] = temp[i];
			
			yx[move] = new int[2];
			yx[move][0] = pY;
			yx[move][1] = pX;
			move++;
			
			game[pY][pX] = game[y][x];
			pY = y;
			pX = x;
			game[pY][pX] = 0;
			
			
			
		}
		
		
		
		// 문제2) 심화 ==> 한칸한칸이동할때마다 yx 배열에 이동한경로를 저장했다가 
		// N번 입력할 때마다 ==> 왔던길로 되돌아가기 한다.
		
		
		

	}

}
