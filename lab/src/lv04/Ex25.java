package lv04;

import java.util.Arrays;

public class Ex25 {

	public static void main(String[] args) {
		
		
		int[][] arr = { 
				{ 101, 102, 103, 104 },
				{ 201, 202, 203, 204 }, 
				{ 301, 302, 303, 304 } 
				};

		int[] garo = new int[3];
		int[] sero = new int[4];
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				//arr[i][j]
				garo[i] += arr[i][j];
				sero[j] += arr[i][j];
			}
		}
		System.out.println(Arrays.toString(garo));
		System.out.println(Arrays.toString(sero));
		
		
		
		
		
		
		

	}

}
