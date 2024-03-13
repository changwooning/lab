package lv03practice;

import java.util.Scanner;

public class Practice80 {
	
	// # 미니마블
		// 1. 플레이어는 p1과 p2 2명이다.
		// 2. 번갈아가며 1~3 사이의 숫자를 입력해 이동한다.
		// 3. 이동하다가 다음 플레이어와 같은 위치에 놓이게 되면,
		// 상대 플레이어는 잡히게 되어 원점으로 되돌아간다.
		// 4. 먼저 3바퀴를 돌면 이긴다.

		// [p2] 1~3
		// 1 2 3 4 5 6 7 8
		// 0 1 0 0 0 0 0 0 p1
		// 0 0 0 2 0 0 0 0 p2

		// [p1] 1~3 입력 : 2
		// [p1]이 p2를 잡았다!

		// 1 2 3 4 5 6 7 8
		// 0 0 0 1 0 0 0 0
		// 2 0 0 0 0 0 0 0
		//

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		final int SIZE = 8;
		final int P1 = 1;
		final int P2 = 2;
		
		
		int[] game = new int[SIZE];
		int[] p1 = new int[SIZE];
		int[] p2 = new int[SIZE];
		
		int turn = P1;
		
		//각 플레이어 현 좌표 (인덱스)
		int idx1 = 0;
		int idx2 = 0;
		
		//바퀴수 기억
		int cnt1 = 0;
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
		boolean run = true;
		while(run) {
			//맵출력
			System.out.println("====미니마블====");
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
			
			//입력 input
			System.out.printf("\n[P%d] jump(1~3) : ", turn);
			int jump = scan.nextInt();
			
			//예외처리 1. 인덱스 범위
			if(jump < 1 || jump > 3) 
				continue;
			
			//이동
			if(turn == P1) {
				p1[idx1] = 0;	//플레이어 지우기
				idx1 += jump;	//점프
				if(idx1 >= SIZE)	//위치가 사이즈를 초과 -> 바퀴수 증가
					cnt1 ++;
				idx1 %= SIZE;	//유효한 인덱스로 재초기화
				p1[idx1] = P1;	// 플레이어 다시 그리기
				
				if(idx1 == idx2) {
					System.out.println("[P1]이 P2를 잡았다!!");
					p2[idx2] = 0;	//상대 플레이어 지우기
					idx2 = 0;		//상대 플레이어 좌표 0 초기화
					p2[idx2] = P2;	//상대 플레이어 재배치
				}
			}else if(turn == P2) {
				p2[idx2] = 0;
				idx2 += jump;
				if(idx2 >= SIZE)
					cnt2 ++;
				idx2 -= SIZE;
				p2[idx2] = P2;
				
				if(idx1 == idx2) {
					System.out.println("[P2]가 P1를 잡았다!!!");
					p1[idx1] = 0;
					idx1 = 0;
					p1[idx1] = P1;
				}
			}
			
			//종료 end
			if(cnt1 == 3 || cnt2 == 3) {
				System.out.printf("[P%d] WIN!!!", cnt1 == 3 ? P1 : P2);
				run = false;
			}
			
			//턴변경 switch turn
			turn = turn == P1 ? P2 : P1;
			
			
			
			
			
			
		}
		
		
		
		
		
		

	}

}
