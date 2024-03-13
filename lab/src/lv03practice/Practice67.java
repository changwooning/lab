package lv03practice;

import java.util.Scanner;

public class Practice67 {

	// 즉석복권

	// 1707

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] lotto = { 0, 0, 0, 7, 7, 0, 0, 0 };

		boolean isFound = false;

			System.out.println("1.복권당첨결과확인");
			System.out.print("1).확인하기");
			int sel = scan.nextInt();

			if (sel == 1) {
				// 7이 연속 3개면 당첨

				int cnt = 0;
				for (int i = 0; i < 7; i++) {
					if (lotto[i] == 7)
						cnt++;
					else
						cnt = 0;
					if(cnt == 3)
						isFound = true;
				}
				
				if(isFound)
					System.out.println("당첨!!");
				else
					System.out.println("꽝!");
				
				
			}
		

	}

}
