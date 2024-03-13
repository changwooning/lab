package lv05;

import java.util.Random;

public class Ex38 {
	
	// # 경마 게임
	// 5마리의 말이 랜덤으로 한번에 일정거리 이동가능하다.(0~3 범위)
	// 이동한거리의 합이 20이상이면 도착
	// 등수 출력
	// 조건) 단! 동시도착 예외처리
	
	// ㅡ ㅡ ㅡ ㅡ ㅡ 말 ㅡ  -> jump 1
	// ㅡ ㅡ ㅡ ㅡ 말 ㅡ ㅡ  -> jump 1
	// ㅡ ㅡ ㅡ ㅡ ㅡ 말 ㅡ  -> jump 1

	public static void main(String[] args) {
		
		Random ran = new Random();
		
		final int MAX = 20;
		int horse[][] = new int[5][MAX];
		
		int rank[] = new int[5];		// 말 등수
		int total[] = new int[5];		// 말의 좌표 (옵션)
		
		for(int i=0; i<horse.length; i++) {
			for(int j=0; j<horse[i].length; j++) {
				horse[i][0] = 1;
			}
		}
		
		while(true) {
			// print
			System.out.println("RACE =>>>>");
			for(int i=0; i<horse.length; i++) {
				for(int j=0; j<horse[i].length; j++) {
					if(horse[i][j] == 0)
						System.out.print("___");
					else
						System.out.print("말__");
				}
				System.out.println();
			}
			System.out.println();
			
			// 종료조건
			
			
			// 이동하기
			// ㄴ 토탈에 랜덤값 지정해주고
			// ㄴ 지정한걸 홀스에 반영
			for(int i=0; i<horse.length; i++) {
				int move = (int)(Math.random()*4);
					horse[i][total[i]] = 0;
					total[i] += move;
					horse[i][total[i]] = 1;
					// 범위지정해줘야함
					// 인덱스가 16일때 점프 3을하면 19 까지 도달하게
					if(total[i] > MAX) {
						System.out.println("끝지점에 도달");
						break;
					}
			}
			
			
			try {
				Thread.sleep(300);		// 딜레이를 걸 시간을 ms 밀리세컨드 1/1000 초
			}catch(Exception e) {
			}
			
			
			
			
			
		}
		
		

	}

}
