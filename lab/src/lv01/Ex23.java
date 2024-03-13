package lv01;

import java.util.Scanner;

public class Ex23 {
	public static void main(String[]args) {
		
		Scanner scan = new Scanner(System.in);
		
		/*
		 * # 최대값 구하기 [1단계]
		 * 
		 * 1. 숫자 3개를 입력 받는다.
		 * 2. 입력받은 3개의 수를 비교하여,
		 * 3. 가장 큰 수 (MAX)를 출력한다.
		 */
		
		// 숫자 3개를 입력하고 비교하기 가장 큰수 출력
		
		int max = 0;
		
		System.out.print("숫자 입력 : ");
		int num1 = scan.nextInt();
		
		System.out.print("숫자 입력 : ");
		int num2 = scan.nextInt();
		
		System.out.print("숫자 입력 : ");
		int num3 = scan.nextInt();
		
		max = num1;
		
		if(max < num2) {
			max = num2;
		}
		
		if(max < num3) {
			max = num3;
		}
		
		System.out.print("MAX : " + max);
		
		
	}

}
