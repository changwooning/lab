package lv06test;

import java.util.Scanner;
//2. 영화관 좌석예매 : 클래스 + 메서드
//1. 사용자로부터 좌선번호(Index)를 입력받아 예매하는 시스템이다.
//2. 예매가 완료되면 해당 좌석 값을 1로 변경한다(예메 취소가 되면 해당 좌석 값을 0으로 변경)
//3. 이미 예매가 완료된 좌석은 구매할 수 없다.
//4. 한 좌석당 예매가격은 12000원이다.
//5. 프로그램 종료 후, 해당 영화관의 종 매출액을 출력한다.

class Theater {

	// test6 2번
	// 1028
	// 1126
	Scanner scan = new Scanner(System.in);

	int seat[];
	int total = 0;
	int price = 12000;

	final int SIZE = 9;

	void result() {

		System.out.println("총 매출액 : " + total);

	}

	void Termination() {

		System.out.println("예매를 종료합니다.");
		return;

	}

	void seatOut() {

		System.out.print("\n좌석 취소 : ");
		int idx = scan.nextInt() - 1;

		if (idx < 0 || idx > SIZE - 1)
			return;

		if (seat[idx] == 0) {
			System.out.println("예매가 가능한 자리입니다.");
			return;
		}

		seat[idx] = 0;
		total -= price;

	}

	void seatInput() {


		System.out.print("\n좌석선택 : ");
		int idx = scan.nextInt() - 1;

		if (idx < 0 || idx > SIZE - 1)
			return;

		if (seat[idx] == 1) {
			System.out.println("이미 예매된 좌석입니다.");
			return;
		}

		seat[idx] = 1;

		total += price;

	}
	
	void mapPrint() {
		
		for (int i = 0; i < SIZE; i++)
			System.out.print(i + 1 + " ");
		
		System.out.println();
		
		for (int i = 0; i < SIZE; i++) {
			if (seat[i] == 0)
				System.out.print("◻ ");
			else
				System.out.print("◼ ");
		}
		
	}

	void setPrint() {

		System.out.println("===영화관===");
		System.out.println("1.좌석예매");
		System.out.println("2.좌석취소");
		System.out.println("0.종료");
		System.out.print("선택 : ");

	}

	void setGame() {

		seat = new int[SIZE];

	}

	void run() {

		setGame();
		while (true) {
			setPrint();
			int sel = scan.nextInt();
			if (sel == 1) {
				mapPrint();
				seatInput();
			}
			else if (sel == 2) {
				mapPrint();
				seatOut();
			}
			else if (sel == 0) {
				Termination();
				break;
			}
		}
		result();
		

	}

}

public class Test602 {

	public static void main(String[] args) {

		Theater theater = new Theater();
		theater.run();

	}

}
