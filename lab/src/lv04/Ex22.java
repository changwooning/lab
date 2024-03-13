package lv04;

import java.util.Scanner;

public class Ex22 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		final int SIZE = 9;

		int[][] apt = { 
				{ 101, 102, 103 }, // 0 1 2
				{ 201, 202, 203 }, // 3 4 5
				{ 301, 302, 303 } // 6 7 8
		};
		int[][] pay = { 
				{ 1000, 2100, 1300 }, 
				{ 4100, 2000, 1000 }, 
				{ 3000, 1600, 800 } 
		};

		// 문제1) 각층별 관리비 합 출력
		// 정답1) 4400,7100,5400
		// 3,3
		for (int i = 0; i < 3; i++) {
			int sum = 0;
			for (int j = 0; j < 3; j++) {
				sum += pay[i][j];
			}
			System.out.print(sum + " ");
		}

//				if(i % 3 == 0)
//					sum1 += pay[i][j];
//				else if(i % 3 == 1)
//					sum2 += pay[i][j];
//				else if(i % 3 == 2) {
//					sum3 += pay[i][j];
//				}
		
		System.out.println();
		// 문제2) 호를 입력하면 관리비 출력
		// 예) 입력 : 202 관리비 출력 : 2000
		
		System.out.print("호 입력: ");
		int ho = scan.nextInt();
		
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(apt[i][j] == ho) {
					System.out.print(pay[i][j]);
				}
			}
		}
		
		int idx1 = -1;
		int idx2 = -1;
		

		// 문제3) 관리비가 가장 많이 나온 집, 적게 나온 집 출력
		// 정답3) 가장 많이 나온 집(201), 가장 적게 나온 집(303)

		// 문제4) 호 2개를 입력하면 관리비 교체

	}

}
