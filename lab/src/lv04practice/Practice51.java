package lv04practice;

import java.util.Scanner;
import java.util.Arrays;

public class Practice51 {
	
	// # 사다리 게임
	//1150
	//1202

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		final int SIZE = 9;
		final int N = 5;
		final int LEFT = 1;
		final int RIGHT = 2;
		
		String menu[] = {"떡라면","쫄면","햄버거","짜장면","삼겹살"};
		
		boolean[] isOpen = new boolean[N];
		
		int ladder[][] = { 
				{ 0, 0, 0, 0, 0 }, 
				{ 1, 2, 0, 1, 2 }, 
				{ 0, 1, 2, 0, 0 }, 
				{ 0, 0, 1, 2, 0 },
				{ 1, 2, 0, 0, 0 }, 
				{ 0, 1, 2, 0, 0 }, 
				{ 1, 2, 0, 0, 0 }, 
				{ 0, 0, 0, 1, 2 }, 
				{ 0, 0, 0, 0, 0 }, 
			};
		
		//├ ─ ┤ │
		
		while(true) {
			
			//set map
			for(int i=0; i<N; i++) 
				System.out.print(i + 1 + " ");
			System.out.println();
			
			//print
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<N; j++) {
					if(ladder[i][j] == LEFT)
						System.out.print("├─");
					else if(ladder[i][j] == RIGHT)
						System.out.print("┤ ");
					else
						System.out.print("│ ");
				
				}
				System.out.println();
			}
			System.out.println();
			
			//end
			int cnt = 0;
			for(int i=0; i<N; i++) {
				if(isOpen[i])
					cnt++;
			}
			if(cnt == N)
				break;
			
			
			//input
			System.out.print("번호 선택 : ");
			int x = scan.nextInt()-1;
			
			//예외처리
			if(x < 0 || x > N-1) {
				System.out.println("입력범위는 1~5입니다.");
				continue;
			}
			
			//중요
			for(int y=0; y<SIZE; y++) {
				if(ladder[y][x] == LEFT)
					x++;
				else if(ladder[y][x] == RIGHT)
					x--;
			}
			
			
			if(isOpen[x]) {
				System.out.println("이미 고른 메뉴입니다.");
				continue;
			}else {
				System.out.printf("%s 메뉴 당첨", menu[x]);
				isOpen[x] = true;
			}
			
			
			
			
			
			
			
			
			
		}
		

	}

}
