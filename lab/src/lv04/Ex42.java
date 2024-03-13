package lv04;

import java.util.Scanner;
import java.util.Arrays;

public class Ex42 {

	// 문제1) 1~백만 사이의 숫자를 입력받고 가운데 숫자 출력
	// (단 ! 짝수자리의 수는 짝수자리라고 출력
	// 예) 123 ===> 2
	// 예) 1234 ==> 짝수의 자리이다.
	// 예) 1 =====> 1
	// 예) 1234567 => 4

	// 힌트 자리수를 구하고 배열을 만든다음 하나씩 저장
	// 예) ==> 123 ==> 3 ==> arr[] = new int[3];

	public static void main(String[] args) {

		// int (integer)가 담을 수 있는 최대값 => 21억..

		Scanner scan = new Scanner(System.in);

		System.out.printf("정수 입력 (~%d): ", Integer.MAX_VALUE);
		int number = scan.nextInt();

		int temp = number;
		int digit = 0;
		while (temp > 0) {
			temp /= 10;
			digit++;
		}
		System.out.print(digit);

		if (digit % 2 == 0)
			System.out.println("짝수의 자리이다.");
		else {
			//풀이 1번
			int[] arr = new int[digit];

			for (int i = digit - 1; i >= 0; i--) { // i: arr배열의 인덱스
				arr[i] = number % 10;
				number /= 10;
			}
			System.out.println(Arrays.toString(arr));
			
			int center = digit/2;
			System.out.println(arr[center]);
			
			//풀이 2번
			int cnt = digit/2;	//자리수때문에
			while(cnt > 0) {
				number /= 10;
				cnt--;
			}
			System.out.println(number % 10);
		}

	}

}
