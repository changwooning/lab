package lv04practice;

public class Practice44 {

	public static void main(String[] args) {
		
		int[] score = {10,50,30,40,80,7};
		
		for(int i=0; i<6-1; i++) {
			int idx = i;
			for(int j=i+1; j<6; j++) {
				if(score[idx] < score[j])
					idx = j;
			}
			//값 교체
			int temp = score[i];
			score[i] = score[idx];
			score[idx] = temp;
		}
		for(int i=0; i<6; i++) {
			System.out.print(score[i] + " ");
		}

	}

}
