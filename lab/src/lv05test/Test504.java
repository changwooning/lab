package lv05test;

import java.util.Random;

public class Test504 {
	
	// lv5 test
	// # 경마 게임
	// ㄴ 5마리의 말이 랜덤으로 한번에 일정거리 이동가능하다.
	// ㄴ 각 말에 대한 등수 출력
	// 조건) 단! 동시도착 예외처리
	// 1408
	// 1529
	

	public static void main(String[] args) {
		
		Random ran = new Random();
		
		final int FINISH = 20;
		final int HORSE = 5;
		
		int rank[] = new int[HORSE]; // 말 등수
		int x[] = new int[HORSE];		//  말 좌표
		
		int[][] horse = new int[HORSE][FINISH];
		
		int record = 1;
		
		// 말 좌표 갱신
		for(int i=0; i<horse.length; i++) {
			int a = x[i];
			horse[i][a] = HORSE;
		}
		
		while(true) {

			System.out.println("RACE >>>>>>>>");
			for(int i=0; i<HORSE; i++) {
				for(int a=0; a<FINISH; a++) {
					if(horse[i][a] == HORSE)
						System.out.print("_말");
					else
						System.out.print("__");
				}
				System.out.println();
			}
			System.out.println();
			
			if(record > HORSE)
				break;

			boolean isGoal = false;
			for(int i=0; i<HORSE; i++) {
				
				if(rank[i] != 0)
					continue;

				int a = x[i];
				int jump = ran.nextInt(4);
				
				horse[i][a] = 0;
				a += jump;
				
				if(a >= FINISH-1) {
					
					if(isGoal) {
						i--;
						continue;
					}
					a = FINISH -1;
					rank[i] = record++;
					isGoal = true;
				}
				x[i] = a;
				horse[i][a] = HORSE;
			}
			
			try {
				Thread.sleep(300);
			}catch(Exception e) {
			}
			
		}
		for(int i=0; i<rank.length; i++)
			System.out.printf("%d번 말 : %d\n", i+1,rank[i]);
		
		
	}

}
