package lv03practice;

import java.util.Scanner;

public class Practice44 {

	// 즉석복권
	// 1619

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] lotto = { 0, 0, 0, 0, 0, 7, 7, 7 };

		boolean isFound = false;

		System.out.println("1)복권 당첨확인");
		System.out.println("1.메뉴선택");
		int sel = scan.nextInt();

		int count = 0;

		if (sel == 1) {
			for (int i = 0; i < 8; i++) {
				if (lotto[i] == 7) 
					count ++;
				else
					count = 0;
				if(count == 3)
					isFound = true;
			}
			if(isFound)
				System.out.println("당첨");
			else
				System.out.println("꽝");
			
			
			
			
		}

	}

}
