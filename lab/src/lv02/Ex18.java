package lv02;

import java.util.Scanner;

public class Ex18 {
	
	//# 최대값 구하기 [2단계]
	// 1. 3회 반복을 하면서 정수를 입력받는다.
	// 2. 입력받은 3개의 숫자 중 가장 큰 값을 출력한다.
	//
	
	//다시 복습!!!!!!!
	

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = 1;
		int num = 0;
		int max = 0;
		
		while(n <= 3) {
			System.out.print("숫자 입력: ");
			num = scan.nextInt();
			
			if(num > max) {
				max = num;
			}
			
			
			
			n ++;
		}
		System.out.print("Max : " + max);
		
	}

}
