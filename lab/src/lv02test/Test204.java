package lv02test;

import java.util.Scanner;

public class Test204 {

	// lv02 테스트
	// 문제4)

	// 1. 5회 반복을 하면서 정수를 입력 받는다.
	// 2. 입력받은 정수를 전부 합을 출력한다.
	// 3. 만약에 입력받은 합이 100이상이면 반복이 5회가 아닐지라도 즉시 종료

	// 1221
	// 1232

	// 예) 7 ==> 합 : 7, 14 ==> 합 : 21 , 1000 ==> 합 : 1021 !종료

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int sum = 0;
		int n = 1;
		while (n <= 5) {
			System.out.print("정수 입력 : ");
			int num = scan.nextInt();

			if (sum < 100) {
				sum += num;
				if (sum >= 100) {
					break;
				}
			}

			n += 1;
		}

		System.out.print("합 : " + sum);

	}

}
