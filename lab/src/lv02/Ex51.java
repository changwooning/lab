package lv02;

import java.util.Scanner;

public class Ex51 {
	
	//소수찾기

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int input = scan.nextInt();
		boolean isPrime = true;
		
		int n = input -1;
		while(n > 1) {
			if(input % 2 == 0)
				isPrime = false;
			n -= 1;
		}
		
		if(isPrime)
			System.out.println("소수이다.");
		else
			System.out.println("소수가 아니다.");
		

	}

}
