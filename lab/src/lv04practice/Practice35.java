package lv04practice;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Practice35 {

	// 숫자 야구 게임
	// 1900
	//1911

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		int[] com = { 1, 7, 3 };
		int[] me = new int[3];

		while (true) {
			for (int i = 0; i < 3; i++) {

				// 입력 및 배열 초기화
				System.out.printf("숫자 %d 번째 입력 : ", i + 1);
				int input = scan.nextInt();

				int idx = 1;
				for (int j = 0; j < i; j++) {
					if (me[j] == input)
						idx = j;
				}

				// 예외처리
				if (idx == -1 && input > 0 && input <= 9) 
					me[i] = input;
				else {
					System.out.println("유효하지 않은 값 입니다.");
					i--;
				}
			}
			// 검토
			int strike = 0;
			int ball = 0;
			
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					if(com[i] == me[j]) {
						if(i == j)
							strike ++;
						else
							ball ++;
					}
				}
			}
			
			System.out.println("com : " + Arrays.toString(com));
			System.out.println("me : " + Arrays.toString(me));
			System.out.printf("strike %d,ball %d", strike,ball);
			
			//종료조건
			if(strike == 3)
				break;
		}
		System.out.println("GAME CLEAR~");
		
		

	}

}
