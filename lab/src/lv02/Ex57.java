package lv02;

import java.util.Scanner;
import java.util.Random;

public class Ex57 {

	// # 카카오 택시
	// 1. 손님을 태워 목적지까지 이동하는 게임이다.
	// 2. -10~10 사이의 램덤 숫자 2개를 저장해 목적지로 설정한다.
	// 3. 메뉴는 아래와 같다.
	// 1) 속도설정 : 1~3까지만 가능
	// 2) 방향설정 : 동(1)서(2)남(3)북(4)
	// 3) 이동하기 : 설정된 방향으로 지정된 속도만큼 이동
	// 4. 거리 1칸 당 50원씩 추가되어 도착시 요금도 출력한다.


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

			if (sel == 1) {
				// 방향설정
				System.out.print("동1 서2 남3 북4 : ");
				int input = scan.nextInt();
				
				if(input > 0 && input <= 4)
					dir = input;
				else
					System.out.print("beep!");


			} else if (sel == 2) {
				// 속도설정
				int input = 0;
				while (input < 1 || input > 3) {
					System.out.print("속도 1~3 : ");
					input = scan.nextInt();
				}
				speed = input;

			} else if (sel == 3 && dir != 0) {
				// x,y 좌표변경
				if (dir == 1)
					x += speed;
				else if (dir == 2)
					x -= speed;
				else if (dir == 3)
					y -= speed;
				else if (dir == 4)
					y += speed;

				// 요금산정
				fee += speed * 50;

			} else if (sel == 0) {
				// 시스템 종료
				run = false;
				System.out.println("시스템이 종료됩니다.");

			}

		}
		// 목적지 도착 요금산정
		System.out.printf("목적지 도착, 요금은 %d원 입니다.", fee);

	}

}
