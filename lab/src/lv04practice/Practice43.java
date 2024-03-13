package lv04practice;

public class Practice43 {
	
	// # 정렬하기
	// 1.인덱스 0번이 나머지를 검사한다.
	// 2.제일 큰 값을 찾아 교환한다.
	// 3.인덱스 1증가한다.
	// 4. [1~3]을 끝까지 반복한다.
	// 예)
	// 10,50,30,40,80,7
	// 80,50,30,40,10,7
	// 80,50,30,40,10,7
	// 10,50,40,30,10,7

	public static void main(String[] args) {
		
		int[] score = {10,50,30,40,80,7};
		
		//selection sort
		for(int i=0; i<6-1; i++) {
			int idx = i;
			//최대값 찾기
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
