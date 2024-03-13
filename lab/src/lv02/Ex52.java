package lv02;

import java.util.Scanner;


public class Ex52 {
	
	//# 최대값 구하기 [2단계]
		// 1. 3회 반복을 하면서 정수를 입력받는다.
		// 2. 입력받은 3개의 숫자 중 가장 큰 값을 출력한다.
		//

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int max = 0;
		int sel = 0;
		
		int n = 1;
		while(n <= 3) {
			System.out.print("숫자 입력 : ");
			sel = scan.nextInt();
			
			if(sel > max)
				max = sel;
			n += 1;
		}
		System.out.println("Max : " + max);

	}

}
