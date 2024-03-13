package lv02;

import java.util.Random;
import java.util.Scanner;

public class Ex41 {

	// # up % down 게임 [2단계]
	// 1. com은 랜덤으로 1~100 사이를 저장한다.
	// 2. me는 1~100사이를 입력한다.
	// 3. com과 me를 비교해서 com 크면 "크다" , com 작으면 "작다" 힌트제공
	// 4. 정답을 맞춫면 게임은 종료된다.

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random random = new Random();

		// 랜덤 값 1개 초기화 1~100
		int com = random.nextInt(100) + 1;
		// me 값 지정하기
		System.out.print("me : ");
		int me = scan.nextInt();

		// com = me 같을때 종료
		while (com != me) {
			if (me > 0 && me <= 100) {
				if (com > me) {
					System.out.println("크다");
				} else
					System.out.println("작다");
			} else
				System.out.println("재입력");

			System.out.print("me : ");
			me = scan.nextInt();
		}

		System.out.println("정답");
		System.out.println("게임종료");

	}

}
