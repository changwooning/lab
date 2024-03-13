package lv03practice;

import java.util.Scanner;

public class Practice43 {

	// #즉석복권
	// 1. 숫자 7이 연속으로 3번 등장하면, "당첨" 출력

	// 1609
	// 1618

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// {0,0,0,0,0,0,0,0,}
		int[] lotto = {0,0,0,0,0,7,7,7};

		int count = 0;

		System.out.println("1)복권 당첨확인");
		System.out.println("1.메뉴 선택 : ");
		int sel = scan.nextInt();

		boolean isFound = false;
		
		
		if (sel == 1) {
			for (int i = 0; i < 8; i++) {
				if (lotto[i] == 7)
					count++;
				else
					count = 0;
				
				if (count == 3)
					isFound = true;
			}
		}
		if(isFound)
			System.out.println("당첨");
		else
			System.out.println("꽝");

	}

}
