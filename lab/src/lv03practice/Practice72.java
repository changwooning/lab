package lv03practice;

import java.util.Arrays;

public class Practice72 {

	public static void main(String[] args) {
		
		int arr[] = {
				0,0,0,
				3,3,3,
				3,3,3
		};
		
		for(int i=0; i<9; i++) {
			System.out.print(arr[i] + " ");
			if(i % 3 == 2)
				System.out.println();
		}
		
		
		//문제2) 만약에 가로에 3이 연속으로 3개있으면 "빙고" 출력
		boolean isFound = false;
		
		for(int i=0; i<9; i+=3) {
			if(arr[i] == 3 && arr[i+1] == 3 && arr[i+2] == 3) 
				isFound = true;
		}
		if(isFound)
			System.out.println("빙고~");
		else
			System.out.println("꽝..");
		
		
		

	}

}
