package lv05practice;

import java.util.Random;

public class Practice43 {

	// # 경마 게임
	
	
	public static void main(String[] args) {
		
		Random ran = new Random();
		
		final int MAX = 20;
		final int HORSE = 1;
		
		int[][] horse = new int[5][MAX];
		
		int[] rank = new int[5];
		int[] total = new int[5];
		
		// 출발 선상에 말 두기
		for(int i=0; i<horse.length; i++) {
			int x = total[i];
			horse[i][x] = HORSE;
		}
		
		int record = 1;
		
		while(true) {
			
			System.out.println("RACE >>>>>");
			for(int i=0; i<horse.length; i++) {
				for(int x=0; x<MAX; x ++) {
					if(horse[i][x] == HORSE)
						System.out.print("_말");
					else
						System.out.print("__");
				}
				System.out.println();
			}
			System.out.println();

			// end
			if(record > horse.length)
				break;
			
			boolean isGoal = false;	// 동시 도착 예외처리 용도
			
			for(int i=0; i<horse.length; i++) {// 모든 말이 각각 랜덤 점프
				
				if(rank[i] != 0)	// 이미 도착한 말 제외 넘어가기
					continue;
				
				int x = total[i];	// i번째 말의 현 위치
				int jump = ran.nextInt(4);	// 0~4
				
				horse[i][x] = 0;	// 말 지우기
				x += jump;
				
				if(x >= MAX -1) {	// 도착지점
					
					if(isGoal) { 	// 동시에 도착한 말이 있으면
						i--;
						continue;
					}
					x = MAX -1;
					rank[i] = record++;
					isGoal = true; // 	도착을 했으니까
				}
				
				horse[i][x] = HORSE;	// 말 다시 그리기
				total[i] = x;	// 좌표 갱신
				
				try {
					Thread.sleep(300);
				}catch(Exception e) {
				}
				
			}
			// 성적표 출력
			for(int i=0; i<rank.length; i++)
				System.out.printf("%d번 말 : %d등\n", i+1,rank[i]);
		}
		
		
		

	}

}
