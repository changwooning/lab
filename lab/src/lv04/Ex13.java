package lv04;

import java.util.Arrays;
public class Ex13 {
	
	// # 석차 출력
	// 성적 순으로 이름 출력
	//

	public static void main(String[] args) {
		
		String[] name = {"홍길동","김영","자바킹","민병철","메가맨"};
		int[] score   = {	 87,	42,	 100,	  11,    98}; 
		//%d등 %s : %3d점\n
		
		
		
		for(int i=0; i<5; i++) {
			int maxIdx = i;
			for(int j=i+1; j<5; j++) {
				if(score[maxIdx] < score[j]) {
					maxIdx = j;
				}
			}
			//값교체	점수
			int temp = score[i];
			score[i] = score[maxIdx];
			score[maxIdx] = temp;
			//값교체	이름
			String tmp = name[i];
			name[i] = name[maxIdx];
			name[maxIdx] = tmp;
			
			System.out.printf("%d등 %s : %3d점\n",i+1,name[i],score[i]);
		}
		
		
		
		for(int i =0; i<5; i++) {
			System.out.print(name[i] + " ");
		}
		
		
		
		

	}

}
