package lv04practice;

import java.util.Random;
import java.util.Arrays;

public class Practice69 {
	
	//# 당첨복권
	// 0238
	// 0250

	public static void main(String[] args) {
		
		Random ran = new Random();
		
		int[][] lottoSet = new int[5][7];
		
		int goalIdx = -1;
		for(int i=0; i<lottoSet.length; i++) {
			int cnt = 0;
			for(int j=0; j<lottoSet[i].length; j++) {
				lottoSet[i][j] = ran.nextInt(2) == 1 ? 3 : 0;
				if(lottoSet[i][j] == 3)
					cnt ++;
				else
					cnt = 0;
				if(cnt == 3 && (goalIdx == -1 || goalIdx == i))
						goalIdx = i;
				else if(cnt == 3 && goalIdx != -1) {
					i--;
					break;
				}
			}
			//당첨이 없는경우
			if(i == lottoSet.length -1 && goalIdx == -1)
				i--;
		}
		for(int i=0; i<lottoSet.length; i++) {
			if(i == goalIdx) 
				System.out.print("골");
			System.out.println(Arrays.toString(lottoSet[i]));
		}
		
		
		

	}

}
