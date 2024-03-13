package lv03practice;

import java.util.Scanner;

public class Practice32 {

	// 즉석복권
	// 7이 연속 3번이면 당첨
	// 2116
	//2121

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		 int[] lotto = {0,0,7,7,7,0,0,0};

		// Test case
		 //int[] lotto = {7,0,7,7,0,7,0,7};
		// int[] lotto = {7,7,7,7,0,7,0,7};
		//int[] lotto = {7,7,7,7,7,7,7,7};
		//int[] lotto = {0,0,0,0,0,0,7,7};
		//int[] lotto = { 0, 0, 0, 0, 0, 7, 7, 7 };

		System.out.println("1)복권 확인");
		System.out.println("1.메뉴 선택 : ");
		int sel = scan.nextInt();

		int count = 0;

		if (sel == 1) {

			boolean isFound = false;
			// count 변수로 해보기
			for (int i = 0; i < 8; i++) {
				if (lotto[i] == 7)
					count++;
				else
					count = 0;
				
				if (count == 3)
					isFound = true;

			}
			if(isFound)
				System.out.println("당첨");
			else
				System.out.println("꽝");
				

		}

	}

}
