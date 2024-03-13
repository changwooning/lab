package lv03practice;

import java.util.Arrays;
import java.util.Random;
public class Practice45 {
	
	// # 중복숫자 금지[1단계]
	// 1. 0~4 사이의 숫자를 arr배열에 저장한다.
	// 2. 단, 중복되는 숫자는 없어야 한다.
	// 힌트) 랜덤 숫자를 check배열의 인덱스로 활용한다.

	public static void main(String[] args) {
		
		Random ran = new Random();
		
		//for문
		
		int[] arr = new int[5];
		int[] check = new int[5];
		
		for(int i=0; i<5; i++) {
			int rNum = ran.nextInt(5) + 0;
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
