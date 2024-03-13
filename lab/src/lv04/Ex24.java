package lv04;

import java.util.Arrays;

public class Ex24 {

	public static void main(String[] args) {

		int[][] arr = { 
				{ 101, 102, 103, 104 },
				{ 201, 202, 203, 204 }, 
				{ 301, 302, 303, 304 } 
				};

		int[] garo = new int[3];
		int[] sero = new int[4];

		// 문제1) 가로합 출력
		// 정답1) 410,810,1210

		for (int i = 0; i < 3; i++) { // 이건 i => 가로
			for (int j = 0; j < 4; j++) { // 이건 j => 세로
				garo[i] += arr[i][j];
				sero[j] += arr[i][j];
			}
		}
		System.out.println(Arrays.toString(garo));
		// 문제2) 세로 합 출력
		// 정답2) 603,606,609,612

		System.out.println(Arrays.toString(sero));

	}

}
