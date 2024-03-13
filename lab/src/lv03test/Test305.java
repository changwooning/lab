package lv03test;

import java.util.Scanner;

public class Test305 {

	// 소수찾기 2[단계]
	// 정수 한 개를 입력받아, 2부터 해당 숫자까지의 모든 소수 출력
	// 2, 3,5,7,11,
	
	

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("정수 입력 : ");
		int input = scan.nextInt();

		for (int i = 2; i <= input; i++) {  // i : 2 3 4 ...
			int cnt = 0;
			for (int j = 1; j<=i; j++) {		// j : 
				if (i % j == 0) 
					cnt++;
			}
			if (cnt == 2)
				System.out.print(i + " ");
		}

	}

}
