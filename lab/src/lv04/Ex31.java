package lv04;

import java.util.Arrays;
import java.util.Scanner;

public class Ex31 {
	
	//arr 배열을 heap에 복제

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[][] arr = {
				{10,20,30},
				{10,20,30,40,50},
				{10,20,30,40}
		};
		
		int[][] temp = new int[arr.length][];
		// temp : {null,null,null}
		//  ㄴ type : int[] 주소를 값으로 가질 수 있다.
		//  ㄴ		: 1차원 배열의 초기화 (heap 메모리 추가 할당)
		
		for(int i=0; i<temp.length; i++) {
			// temp[i] = arr[i]; => 주소복사한거임
			// arr = temp; 		 => 주소복사
			
			int size = arr[i].length;
			temp[i] = new int[size];	// null -> {}
			//값 복제
			for(int j=0; i<size; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		
		System.out.println(Arrays.toString(temp));

	}

}
