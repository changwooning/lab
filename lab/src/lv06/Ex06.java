package lv06;

import java.util.Scanner;

// 클래스가 가지는 요소 두 가지
// 1) 멤버 변수 (속성)
// 2) 멤버 메소드 (기능)

class Theater {
	Scanner scan = new Scanner(System.in);

	int total;
	int[] seat = new int[7];

	final int PRICE = 12000;


	// 메소드 : 클래스 안에 정의된 함수
	// ㄴ 리턴타입 메소드명(파라미터) {실행문; }
	// * void 타입은 리턴값이 없는 것을 의미한다.

	void run() {

		int size = seat.length;

		while (true) {

			System.out.println("[GGV]");
			System.out.println("[1]좌석예매");
			System.out.println("[2]종료하기");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			if (sel == 1) {

				for (int i = 0; i < size; i++) {
					System.out.printf(" %d ", i + 1);
				}
				System.out.println();
				// print
				for (int i = 0; i < size; i++) {
					if (seat[i] == 0)
						System.out.print(" ◻ ");
					else
						System.out.print(" ◼ ︎");
				}
				System.out.println();

				// 좌석예매
				System.out.printf("좌석선택 : ");
				int input = scan.nextInt() - 1;

				if (input < 0 || input > size - 1)
					continue;

				if (seat[input] == 1) {
					System.out.println("이미 예매된 좌석입니다.");
					continue;
				}
				// 예매처리
				seat[input] = 1;
				// 총 매출액
				total += PRICE;

			} else if (sel == 2) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}

		System.out.printf("총 매출액은 %d원입니다.", total);
	}
}


public class Ex06 {

	// # 영화관 좌석예매 : 클래스 + 변수
	// 1. 사용자로부터 좌석번호(index)를 입력받아 예매하는 시스템이다.
	// 2. 예매가 완료되면 해당 좌석 값을 1로 변경한다.
	// 3. 이미 예매가 완료된 좌석은 재구매할 수 없다.
	// 4. 한 좌석당 예매 가격은 12000원이다.
	// 5. 프로그램 종료 후, 해당 영화관의 총 매출액을 출력한다.

	public static void main(String[] args) {

		Theater ggv = new Theater();

		// 메소드 호출(사용)
		// ㄴ 참조변수 뒤에 .닷을 붙여서 메소드를 불러오고 뒤에 ()소괄호를 붙이면됨
		ggv.run();

	}

}
