package lv04;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Ex08 {

	// # 1 to 50
	// 1. 구글에서 1 to 50 이라고 생각한다.
	// 2. 1 to 50 순발력 게임을 선택해 게임을 실습해본다.
	// 3. 위 게임을 숫자범위를 좁혀 1 to 18로 직접 구현한다.
	// 4. 숫자 1~9 는 front 배열에 저장하고,
	// 숫자 10~18은 back 배열에 저장한다.

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		final int SIZE = 9;

		int[] front = new int[SIZE]; // 1~9 => 셔플
		int[] back = new int[SIZE]; // 10~18 => 셔플

		// 중복없이 랜덤 값 지정
		for (int i = 0; i < SIZE; i++) {
			int rNum = ran.nextInt(9) + 1;
			front[i] = rNum;
			for (int j = 0; j < i; j++) {
				if (front[j] == front[i])
					i--;
			}
		}
		
		for (int i = 0; i < SIZE; i++) {
			int rNum = ran.nextInt(9) + 10;
			back[i] = rNum;
			for (int j = 0; j < i; j++) {
				if (back[j] == back[i])
					i--;
			}
		}

		while (true) {

			for (int i = 0; i < SIZE; i++) {
				System.out.print("[" + front[i] + "]");
				if (i % 3 == 2)
					System.out.println();
			}

			// 입력
			System.out.print("입력 : ");
			int input = scan.nextInt();

			if (input < 0 || input > 8) {
				System.out.println("입력한 값은 범위에 해당하지 않습니다.");
				continue;
			} 
			
			int idx = -1;
			int min = front[0];
			for(int i=0; i<SIZE; i++) {
				if(front[i] < min) {
					min = front[i];
				}
			}
			if(front[input] == min) {
				//카드 뒤집기
				
				
			}

			
			
			
			

		}

	}

}
