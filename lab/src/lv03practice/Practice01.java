package lv03practice;

import java.util.Arrays;

public class Practice01 {

	public static void main(String[] args) {
		
		int[] arr = new int[5];
		
		//문제1) 10부터 50까지 arr 배열에 저장
		//정답1) 10 20 30 40 50
		int sum = 0;
		
		for(int i =0; i<5; i++) {
			arr[i] = i;
			//sum += arr[i];
		}
		System.out.println(Arrays.toString(arr));
		
		
		//문제2) 전체 합 출력
		//정답2) 150
		System.out.println(sum);
		
		
	}

}
