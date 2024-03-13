package lv02;
import java.util.Scanner;


public class Ex49 {
	
	//소수찾기
	// # 소수찾기[1단계]
		// 1. 소수란, 1과 자기자신으로만 나눠지는 수
		// 2. 예 2, 3, 5, 7, 11, 13 ****
		// 3. 힌트
		// 1) 해당 숫자를 1부터 자기자신까지 나눈다.
		// 2) 나머지가 0일 때마다 카운트를 센다.
		// 3) 그 카운트 값이 2이면 소수이다.
		// 4) 6/1 6/2 6/3 6/4 6/5 6/6 cnt = 4 소수x

		// 정수 한 개를 입력 받아, 해당 숫자가 소수인지 아닌지 판별한다.

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int input = scan.nextInt();
		
		boolean isPrime = true;
		
		int n = input -1;
		while(n > 1) {
			if(input % n == 0) 
				isPrime = false;
			n -= 1;
		}
		
		if(isPrime)
			System.out.print("소수이다.");
		else
			System.out.print("소수가 아니다.");

	}

}
