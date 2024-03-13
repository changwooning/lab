package lv04practice;

import java.util.Arrays;
import java.util.Scanner;

public class Practice01 {

	// 최대값 구하기
	// 1. 가장 큰 값을 찾아 입력한다.
	// 2. 정답이면 해당 값을 0으로 변경한다.
	// 3. arr배열의 모든 값이 0으로 변경되면 프로그램은 종료된다.
	// 예)
	// 11, 87, 42,100,24
	// 입력 : 100

	// 11,87,42,0,24
	// 입력 : 87
	// 11,0,42,0,24
	//

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] arr = { 11, 87, 42, 100, 24 };

		while (true) {
			System.out.println(Arrays.toString(arr));

			// 최댓값 구하기
			int max = 0;
			int idx = -1;
			for (int i = 0; i < 5; i++) {
				if (arr[i] > max) {
					max = arr[i];
					idx = i;
				}
			}
			
			//종료 조건
			if(idx == -1)
				break;
			
			// 입력받기
			System.out.print("MAX : ");
			int input = scan.nextInt();

			
			//찾아낸 max 값과 <--> input 비교
			if (max == input) {
				arr[idx] = 0;
			}
		
		
		}
		
	}

}
