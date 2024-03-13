package lv04practice;

import java.util.Arrays;
import java.util.Random;

public class Practice12 {
	
	// #중복숫자 금지[3단계]
			// 1. arr배열에 1~10 사이의 랜덤 숫자 5개를 저장한다.
			// 2. 단, 중복되는 숫자가 없어야 한다.
			//

	public static void main(String[] args) {
		
		Random ran = new Random();
		
		int[] arr = new int[5];
		
		//arr배열의 전체 값을 초기화
		for(int i=0; i<5; i++) {
			int rNum = ran.nextInt(10)+1;
			boolean check = true;
			for(int j=0; j<i; j++) {
				if(arr[j] == rNum)
					check = false;
			}
			if(check)
				arr[i] = rNum;
			else
				i--;
		}
		System.out.println(Arrays.toString(arr));
		

	}

}
