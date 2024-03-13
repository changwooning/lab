package lv04;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Ex06 {

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

			int ball = 0;
			int strike = 0;
			// 1. me에 1~9 사이의 숫자 3개를 저장
			for (int i = 0; i < 3; i++) {
				int rNum = ran.nextInt(9) + 1;
				boolean check = true;
				for (int j = 0; j < i; j++) {
					if (me[j] == rNum) // 중복여부 체크
						check = false;
				}
				if (check)
					me[i] = rNum;
				else
					i--;
			}

			for (int i = 0; i < 3; i++) { // i : 0 1 2 //기준되는걸 잘 잡아야함
				for (int j = 0; j < 3; j++) { // j : 0 1 2 0 1 2 0 1 2
					if (com[i] == me[j]) { // ball 선언
						ball++;
					}
				}
				if (com[i] == me[i]) {
					strike++;
					ball--;
				}
			}

			System.out.println(Arrays.toString(com));
			System.out.println(Arrays.toString(me));

			System.out.println(strike + " ");
			System.out.println(ball + " ");

			if (strike == 3)
				break;
		}

	}

}
