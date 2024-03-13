package lv02test;

import java.util.Scanner;
import java.util.Random;

public class Test203 {

	// lv02 테스트
	// 카카오 택시
	// 1.손님을 태워 목적지까지 이동하는 게임이다.
	// 2.-10~10 사이의 랜덤 숫자 2개를 저장해 목적지로 설정한다.
	// 3.메뉴는 아래와 같다
	// 1)속도설정 : 1~3까지만 가능
	// 2)방향설정 : 동1 서2 남3 북4
	// 3)이동하기 : 설정된 방향으로 설정된 속도만큼 이동
	// 4.거리 1칸 당 50원씩 추가되어 도착시 요금도 출력한다.
	//
	// 1114
	// 1527

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random random = new Random();

		int speed = 0; // 속도
		int dir = 0; // 방향
		int dirX = 0;
		int dirY = 0;

		int input = 0;

		int fee = 0;

		int x = random.nextInt(21) - 10;
		int y = random.nextInt(21) - 10;

		boolean run = true;
		while (run) {

			System.out.println("===카카오 택시===");
			System.out.println("목적지 : " + x + "," + y);
			System.out.println("현재위치 : " + dirX + "," + dirY);
			System.out.println("방향 : " + dir);
			System.out.println("속도 : " + speed);

			System.out.println("1.속도설정");
			System.out.println("2.방향설정");
			System.out.println("3.이동하기");
			System.out.println("0.운행종료");
			int sel = scan.nextInt();

			// 속도설정
			if (sel == 1) {
				input = 0;
				while (input < 1 || input > 3) {
					System.out.print("속도 1~3 : ");
					input = scan.nextInt();
				}
				speed = input;
			} else if (sel == 2) {
				// 방향 설정
				System.out.print("방향 : 동1 서2 남3 북4");
				input = scan.nextInt();

				if (input > 0 && input <= 4) {

					dir = input;
				}
			} else if (sel == 3 && dir != 0) {
				// 이동하기

				if (dir == 1)
					dirX += speed;
				else if (dir == 2)
					dirX -= speed;
				else if (dir == 3)
					dirY -= speed;
				else if (dir == 4)
					dirY += speed;

				// 요금 산정
				fee += speed * 50;

			} else if (sel == 0) {
				run = false;
				System.out.print("시스템을 종료합니다.");
			}
		}
		// 목적지 도착 요금내역
		System.out.printf("목적지 도착, 요금은 %d원 입니다.", fee);
	}

}
