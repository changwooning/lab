package lv02;

import java.util.Scanner;

import java.util.Random;

public class Ex23 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random random = new Random();

		// 목적지(destination)
		int desX = random.nextInt(21) - 10;
		int desY = random.nextInt(21) - 10;

		// 현재 위치
		int x = 0;
		int y = 0;

		// 방향(direction)
		int dir = 0;

		// 속도
		int speed = 0;

		// 요금
		int fee = 0;

		boolean run = true;
		while (run) {

			System.out.println("===카카오 택시===");
			System.out.println("목적지 : " + desX + "," + desY);
			System.out.println("현위치 : " + x + "," + y);
			System.out.println("방향 : " + dir);
			System.out.println("속도 : " + speed);
			System.out.println("=========");

			// 드라이버가 주체
			System.out.println("1.방향설정");
			System.out.println("2.속도설정");

			// 악셀 느낌.
			System.out.println("3.이동하기");
			System.out.println("0.운행종료");

			System.out.println("메뉴 선택 : ");
			int sel = scan.nextInt();

			// 방향 설정
			if (sel == 1) {
				
				System.out.print("동1 서2 남3 북 4 : ");
				int input = scan.nextInt();

				if (input > 0 && input <= 4)
					dir = input;
				else
					System.out.print("beep");

			}
			// 속도설정
			else if (sel == 2) {
				int input = 0;
				while (input < 1 || input > 3) {
					System.out.print("속도 1~3 : ");
					input = scan.nextInt();

				}
				speed = input;

			}
			// 이동하기 설정된 방향으로 지정된 속도만큼 이동
			else if (sel == 3 && dir != 0) {
				// 좌표 변경 x,y
				if (dir == 1)
					x += speed;
				else if (dir == 2)
					x -= speed;
				else if (dir == 3)
					y -= speed;
				else if (dir == 4)
					y += speed;

				// 요금 산정
				fee = speed * 50;
			} else if (sel == 0) {
				run = false;
				System.out.println("시스템이 종료됩니다.");
			}
		}
		// 목적지 도달 -> 반복문 종료
		System.out.printf("목적지 도착, 요금은 %d원입니다.", fee);

	}
}
