package lv03practice;

import java.util.Random;
import java.util.Arrays;


public class Practice46 {
	
	//중복 숫자 금지
	//1632
	//1635

	public static void main(String[] args) {
		
		Random ran = new Random();
		
		int[] check = new int[5];
		int[] arr = new int[5];
		
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
