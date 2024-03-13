package lv04practice;

import java.util.Arrays;
import java.util.Scanner;


public class Practice02 {

	//최대값 구하기
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
		int[] arr = { 11, 87, 42, 100, 24 };
		
		while(true) {
		
		System.out.println(Arrays.toString(arr));
		
		int max = 0;
		int idx = -1;
		for(int i=0; i<5; i++) {
			if(arr[i] > max) {
				max = arr[i];
				idx = i;
			}
		}
		
		//종료 조건	==> 잘 이해안감
		if(idx == -1)
			break;
		
		//입력
		System.out.print("Max : ");
		int input = scan.nextInt();
		
		if(max == input) {
			arr[idx] = 0;
		}
		
		
		}
		

	}

}
