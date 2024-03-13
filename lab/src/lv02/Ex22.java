package lv02;

import java.util.Scanner;

import java.util.Random;

public class Ex22 {

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
		// 랜덤;
		Random random = new Random();

		// 목적지(destination)
		int desX = 0;
		int desY = 0;

		// 현재 위치
		int x = 0;
		int y = 0;

		// 방향(direction)
		int dir = 0;

		// 속도
		int speed = 0;

		// 요금
		int fee = 0;

		// 도착
		// int Arrival = 0;

		// -10 ~ 10까지 2개 랜덤 숫자 목적지
		desX = random.nextInt(21) - 10;
		desY = random.nextInt(21) - 10;

		// x = random.nextInt(21) - 10;
		// y = random.nextInt(21) - 10;

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


			// 방향설정 dir 방향함수 동(1)서(2)남(3)북(4) 이동가능
			if (sel == 1) {

			}
			// 속도설정
			else if (sel == 2) {

			}
			// 이동하기 설정된 방향으로 지정된 속도만큼 이동
			else if (sel == 3) {

			}
			// 운행종료
			else if (sel == 0) {
				System.out.println("운행종료");
			}


		}

	}

}
