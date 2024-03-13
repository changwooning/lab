package lv03practice;

import java.util.Random;
import java.util.Arrays;

public class Practice69 {
	
	/*
	 * # 중복숫자 금지[1단계]
	 * 1. 0~4 사이의 숫자를 arr배열에 저장한다.
	 * 2. 단, 중복되는 숫자는 없어야 한다.
	 * 힌트) 랜덤 숫자를 check배열의 인덱스로 활용한다.
	 * 
	 * 예)
	 * 랜덤숫자 : 1
	 * check = {0, 1, 0, 0, 0}
	 * arr   = {1, 0, 0, 0, 0}
	 * 랜덤숫자 : 3
	 * check = {0, 1, 0, 1, 0}
	 * arr   = {1, 3, 0, 0, 0}
	 * 랜덤숫자 : 2
	 * check = {0, 1, 1, 1, 0}
	 * arr   = {1, 3, 2, 0, 0}
	 */

	public static void main(String[] args) {
		
		Random ran = new Random();
		
		
		int[] check = new int[5];
		int[] arr = new int[5];
		
		//중복처리
		for(int i=0; i<5; i++) {
			int rNum = ran.nextInt(5);
			if(check[rNum] == 0) {
				arr[i] = rNum;
				check[rNum] = 1;
			}else
				i--;
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(check));
		
		
		
		

	}

}
