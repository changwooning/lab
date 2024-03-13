package lv02;

import java.util.Scanner;

public class Ex26 {

	// # ATM[4단계]
	// 1. 로그인
	// . 로그인 후 재 로그인 불가
	// 2. 로그아웃
	// . 로그인 후 이용가능
	// 3. 입금
	// . 로그인 후 이용가능
	// 4. 출금
	// . 로그인 후 이용가능
	// 5. 이체
	// . 로그인 후 이용가능
	// 6. 조회
	// . 로그인 후 이용가능
	// 7. 종료
	// .
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int dbAcc1 = 1111;
		int Pw1 = 1234;
		int dbMoney1 = 50000;

		int dbAcc2 = 2222;
		int Pw2 = 2345;
		int dbMoney2 = 70000;

		int log = -1; // -1 로그아웃 1 로그인(1) 2 로그인(2)

		int money = 0; // 입금 변수
		int money1 = 0; // 출금 변수
		int money2 = 0; // 이체할 변수

		boolean run = true;
		while (run) {
			
			//검수용 출력문
			
			//ㄴ 로그인 정보
			System.out.printf("log : %d\n", log == 1 ? dbAcc1 : dbAcc2);
										 // 블린(조건식) ? true    : false
										// **삼항 연산자 
										// ㄴ 둘 중 택 1의 결과로 서로 다른 값이 사용해야하는 경우 유용
			//dbAcc1의 잔액
			//dbAcc2의 잔액

			System.out.println("1. 로그인");
			System.out.println("2. 로그아웃");
			System.out.println("3. 입금");
			System.out.println("4. 출금");
			System.out.println("5. 이체");
			System.out.println("6. 조회");
			System.out.println("0. 종료");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			if (sel == 1) {
				if (log == -1) { // 로그아웃 상태일때만 로그인 가능;

					// 계좌 번호 입력
					System.out.print("acc : ");
					int inputAcc = scan.nextInt();
					// 비밀번호 입력
					System.out.print("pw : ");
					int inputPw = scan.nextInt();

					// 계좌 1) 일치 여부
					if (dbAcc1 == inputAcc && Pw1 == inputPw) {
						log = 1;
						System.out.println("로그인 완료"); 
					}
					// 계좌 2) 일치 여부
					else if (dbAcc2 == inputAcc && Pw2 == inputPw) {
						log = 2;
						System.out.println("로그인 완료");
					}
					// 일치 하지 않을때
					else {
						System.out.println("회원정보가 올바르지 않습니다.");
					}

				} else { // 로그인 상태 여부 -> log = 1, 2 일때
					int user = 0;
					if (log == 1)
						user = dbAcc1;
					else if (log == 2)
						user = dbAcc2;
					System.err.printf("사용자 %d님이 이미 로그인 중입니다.");
				}

			} else if (sel == 2) { // 로그아웃 상태
				if (log != -1) { // 로그인 상태 -> 1, 2 니까
					log = -1; // 로그아웃 상태로 만들어줌
					System.out.println("로그아웃 완료");

				} else {
					System.err.println("로그아웃 상태입니다."); // err 뜻여부?

				}

			} else if (sel == 3) {

				if (log == 1) {
					System.out.println("입금할 금액 : ");
					money = scan.nextInt();

					if (money > 0)
						System.out.print("입금완료");
				} else if (log == 2) {
					System.out.println("입금할 금액 : ");
					money = scan.nextInt();

					if (money > 0)
						System.out.println("입금완료");
				}

			} else if (sel == 4) {

				if (log == 1) {
					System.out.print("출금할 금액 : ");
					money1 = scan.nextInt();

					if (money1 <= dbMoney1)
						System.out.println("출금완료");
					else
						System.out.println("현금이 부족합니다.");

				} else if (log == 2) {
					System.out.print("출금할 금액 : ");
					money1 = scan.nextInt();

					if (money1 <= dbMoney2)
						System.out.println("출금완료");
					else
						System.out.println("현금이 부족합니다.");
				}

			} else if (sel == 5) {//이체
				// 1번이 2번한테 이체!
				
					
					System.out.print("이체할 계좌입력 : ");
					//inputAcc = scan.next();
					
					System.out.print("이체할 금액 : ");
					money2 = scan.nextInt();
					
					
					
					
				
				
				
				
				

			} else if (sel == 6) {

			} else if (sel == 0) {

				run = false;
				System.out.println("프로그램 종료");

			}

		}

	}

}
