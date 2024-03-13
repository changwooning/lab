package lv02;

import java.util.Scanner;

public class Ex16 {
	
	//소수찾기! 연습하기!

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int input = scan.nextInt();
		int div = 0;

		int n = input;
		while (n > 0) {
			if (input % n == 0) {
				div ++;
			}
			n ++;
		}

		if (div == 2)
			System.out.println("소수이다.");
		else
			System.out.println("소수가 아니다.");
	}

}
