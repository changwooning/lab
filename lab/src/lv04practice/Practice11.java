package lv04practice;

import java.util.Random;
import java.util.Arrays;
public class Practice11 {
	
	// #중복숫자 금지[3단계]
		// 1. arr배열에 1~10 사이의 랜덤 숫자 5개를 저장한다.
		// 2. 단, 중복되는 숫자가 없어야 한다.
		//

	public static void main(String[] args) {
		
		Random ran = new Random();
		
		int[] arr = new int[5];
		
		for(int i=0; i<5; i++) {
			int rNum = ran.nextInt(10)+ 1;
			arr[i] = rNum;
			for(int j=0; j<i; j++) {
				if(arr[j] == arr[i])
					i--;
			}
		}
		
		System.out.println(Arrays.toString(arr));
		

	}

}
