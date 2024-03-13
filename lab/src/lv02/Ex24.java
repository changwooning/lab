package lv02;

import java.util.Scanner;

public class Ex24 {

	// #ATM
	// 1. 로그인
	// .로그인 후 재 로그인 불가
	// .로그아웃 상태에서만 이용 가능
	// 2. 로그아웃
	// .로그인 후 이용가능
	//

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int dbAcc1 = 1111;
		int dbPw1 = 1234;

		int dbAcc2 = 2222;
		int dbPw2 = 2345;

		int log = -1; // -1(로그아웃), 1(dbAcc1로그인), 2(dbAcc2로그인)

		boolean run = true;
		while (run) {

			System.out.println("1.로그인");
			System.out.println("2.로그아웃");
			System.out.println("3.종료");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			int id = 0;
			int pw = 0;
			//int id2 = 0;
			//int pw2 = 0;
			
			
			if (sel == 1) {
				

				while (dbAcc1 != id || dbPw1 != pw) {
					
					System.out.print("id : ");
					id = scan.nextInt();
					System.out.print("pw : ");
					pw = scan.nextInt();
					
				}
				System.out.println("로그인 성공");
				log = 1;
				
			} else if (sel == 2) {
				
				while(log != 1 || log != 2) {
					
					System.out.print("로그아웃");
				}
				
				System.out.println("로그인 해주세요");

			} else if (sel == 3) {
				run = false;
				System.out.println("프로그램 종료");
			}

		}

	}

}
