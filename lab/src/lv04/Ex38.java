package lv04;

import java.util.Arrays;
import java.util.Random;

public class Ex38 {
	
	// # 당첨복권 1셋트
	// 1. 3이 연속으로 3번 등장하면 당첨복권이다. (0 또는 3으로 랜덤 부여)
	// 2. 랜덤으로 5개의 복권을 생성하되,
	//	  당첨복권은 단 한 개만 생성되도록 설정한다.
	//

	public static void main(String[] args) {
		
		Random ran = new Random();
		
		int[][] lottoSet = new int[5][7];
		
		boolean isGoal = false;
		int cnt = 0;
		
		for(int i=0; i<lottoSet.length; i++) {
			for(int j=0; j<lottoSet[i].length; j++) {
				lottoSet[i][j] = ran.nextInt(2);
				if(lottoSet[i][j] == 1) {
					lottoSet[i][j] = 3;
					cnt ++;
				}
			}
			if(cnt == 3) {
				
			}
			System.out.println();
		}
		System.out.println();
		
		
		
		
	}

}
