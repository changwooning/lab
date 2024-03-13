package lv02;

import java.util.Scanner;

public class Ex21 {

	// # 쇼핑몰 뒤로가기
	// 문제) 쇼핑몰 메인메뉴에서 남성의류를 선택해서
	// 뒤로가기 누르기전까지 남성의류 페이지 를 유지하려고 한다.
	// 힌트) 계층 별로 반복문을 추가 해주면 된다.
	// 1. 남성의류
	// 1) 티셔츠
	// 2) 바지
	// 3) 뒤로가기
	// 2. 여성의류
	// 1) 가디건
	// 2) 치마
	// 3) 뒤로가기
	// 3. 종료
	//

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		boolean run = true;
		while (run) {
			System.out.println("1.남성의류");
			System.out.println("2.여성의류");
			System.out.println("3.종료");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();


			if (sel == 1) {
				// 3번 입력하면 종료
				while (sel != 3) {

					System.out.println("1) 티셔츠");
					System.out.println("2) 바지");
					System.out.println("3) 뒤로가기");

					System.out.println("상품 선택 : ");
					sel = scan.nextInt();

				}
			}

			else if (sel == 2) {
				boolean isExited = false;
				while (!isExited) {

					System.out.println("1) 가디건");
					System.out.println("2) 치마");
					System.out.println("3) 뒤로가기");

					System.out.println("상품 선택 : ");
					sel = scan.nextInt();
					
					if(sel == 3)
						isExited = true;

				}

			} else if (sel == 3) {
				run = false;
				System.out.println("프로그램 종료");

			} else {
				System.out.println("다시입력해주세요.");
			}
		}

	}

}
