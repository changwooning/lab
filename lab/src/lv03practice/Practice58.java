package lv03practice;

import java.util.Scanner;

public class Practice58 {
	
	//미니마블

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		final int SIZE = 8;
		final int P1 = 1;
		final int P2 = 2;
		
		int[] game = new int[SIZE];
		int[] p1 = new int[SIZE];
		int[] p2 = new int[SIZE];
		
		int turn = P1;
		
		//각 플레이어의 현 좌표(인덱스)
		int idx1 = 0;
		int idx2 = 0;
		
		//바퀴수 기억
		int cnt1= 0;
		int cnt2 = 0;
		
		//set map
		game = new int[SIZE];
		p1 = new int[SIZE];
		p2 = new int[SIZE];
		
		for(int i=0; i<SIZE; i++) {
			game[i] = i + 1;
		}
		
		//게임 시작 전, 플레이어 위치
		p1[idx1] = P1;
		p2[idx2] = P2;
		
		//run game
		boolean Run = true;
		while(Run) {
			//맵출력
			System.out.println("=====미니마블=====");		
			System.out.printf("[P1]이 %d바퀴째 도는중...",cnt1);		
			System.out.printf("\n[P2]이 %d바퀴째 도는중...\n",cnt2);
			for(int i=0; i<SIZE; i++) 
				System.out.print(game[i] + " ");
			System.out.println();
			for(int i=0; i<SIZE; i++) {
				if(i == idx1)
					System.out.print("웃_");
				else
					System.out.print("__");
			}
			System.out.println();
			for(int i=0; i<SIZE; i++) {
				if(i == idx2)
					System.out.print("훗_");
				else
					System.out.print("__");
			}

			//input
			System.out.printf("[P%d] jump(1~3) : ",turn);
			int jump = scan.nextInt();
			
			//jump 범위
			if(jump < 1 || jump > 3) 
				continue;
			
			//move 이동
			if(turn == P1) {
				//플레이어 지우기
				p1[idx1] = 0;
				//점프
				idx1 += jump;
				if(idx1 >= SIZE) {
					cnt1 ++;
				}
				//유효한 인덱스로 재초기화
				idx1 %= SIZE;
				//플레이어 다시 그리기
				p1[idx1] = P1;
				
				if(idx1 == idx2) {
					System.out.println("[P1]이 P2를 잡았다!");
					//상대 플레이어 지우기
					p2[idx2] = 0;
					//상대 플레이어 좌표 0 초기화
					idx2 = 0;
					//상대 플레이어 재배치
					p2[idx2] = P2;
				}
				
			}else if(turn == P2) {
				//플레이어 지우기
				p2[idx2] = 0;
				//점프
				idx2 += jump;
				if(idx2 >= SIZE) 
					cnt2 ++;
				idx2 -= SIZE;
				p2[idx2] = P2;
			}
		}
		
		//종료
		if(cnt1 == 3 || cnt2 == 3) {
			System.out.printf("[P%d] WIN!!",cnt1 == 3 ? P1 : P2);
			Run = false;
		}
		
		//턴 변경
		turn = turn == P1 ? P2 : P1;
		
		
		
		

	}

}
