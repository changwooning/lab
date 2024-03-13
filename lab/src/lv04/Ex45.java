package lv04;

import java.util.Scanner;

import java.util.Random;

public class Ex45 {
	
	//빙고 플레이어1 ver

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		final int MAX_NUM = 5;
		final int MARK = 0;
		
		int[][] bingo = new int[MAX_NUM][MAX_NUM];
		
		int[] temp = new int[MAX_NUM * MAX_NUM];
		
		int size = 50;
		
		int win = 0;
		
		int n=0;
		while(n < 1 || n > MAX_NUM * 2 + 2) {
			System.out.print("몇 빙고? ");
			n = scan.nextInt();
		}
		
		// 1. 중복체크
		for(int i=0; i<temp.length; i++) {
			int rNum = ran.nextInt(50) + 1;
			boolean check = true;
			for(int j=0; j<i; j++) {
				if(temp[j] == rNum)
					check = false;
			}
			if(check)
				temp[i] = rNum;
			else
				i--;
		}
		
		// 2. temp -> bingo
		int idx = 0;
		for(int i=0; i<MAX_NUM; i++) {
			for(int j=0; j<MAX_NUM; j++) {
				bingo[i][j] = temp[idx];
				idx ++;
			}
		}
		
		
		while(true) {
			
			// 3. 출력
			for(int i=0; i<MAX_NUM; i++) {
				for(int j=0; j<MAX_NUM; j++) {
					System.out.printf("[%2d]",bingo[i][j]);		
				}
				System.out.println();
			}
			System.out.println();
			
			//종료 조건
			
			//입력 
			System.out.print("숫자 입력 : ");
			int number = scan.nextInt();
			
			//마킹처리
			for(int i=0; i<MAX_NUM; i++) {
				for(int j=0; j<MAX_NUM; j++) {
					if(bingo[i][j] == number)
						bingo[i][j] = MARK;
					
					
				}
			}
			
			
			
			
			
		}
		
		

	}

}
