package lv04practice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Practice06 {

	// # 숫자 야구 게임
	// 1. me에 1~9 사이의 숫자 3개를 저장
	// 단,중복되는 숫자는 저장 불가
	// 2. com과 me를 비교해 정답을 맞출 때까지 반복
	// 3. 숫자와 자리가 같으면 strike +=1
	// 숫자만 같고 자리가 틀리면 ball +=1
	// 예)
	// 정답 : 1 7 3
	// 3 1 5 : 2b
	// 1 5 6 : 1s
	// ...
	//

	public static void main(String[] args) {

		Random ran = new Random();
		Scanner scan = new Scanner(System.in);

		int[] com = { 1, 7, 3 };
		int[] me = new int[3];

		while (true) {
			// 입력 & me 배열 초기화
			for (int i = 0; i < 3; i++) {
				System.out.printf("숫자 %d번째 입력 : ", i + 1);
				int input = scan.nextInt();

				int idx = -1;
				for (int j = 0; j < i; j++) {
					if (me[j] == input)
						idx = j;
				}

				if (idx == -1 && input > 0 && input <= 9)
					me[i] = input;
				else {
					System.out.println("유효하지 않은 값입니다.");
					i--;
				}
			}

			// 검토

			int ball = 0;
			int strike = 0;

			for (int i = 0; i < 3; i++) { // i : com 배열의 인덱스
				
				for (int j = 0; j < 3; j++) {
					if (com[i] == me[j]) {
						if (i == j)
							strike++;
						else
							ball++;
					}
				}
			}
			
			//출력
		    System.out.println("=============최강야구============");
			System.out.println("com : " + Arrays.toString(com));
			System.out.println("me : " + Arrays.toString(me));
			System.out.println("===============================");
			System.out.printf("strike %d,ball %d\n", strike,ball);
			System.out.println("===============================");

			//종료 조건
			if(strike == 3)
				break;
		}

	}

}
