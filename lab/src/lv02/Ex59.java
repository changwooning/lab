package lv02;
import java.util.Scanner;


public class Ex59 {

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

			System.out.println("1. 로그인");
			System.out.println("2. 로그아웃");
			System.out.println("3. 입금");
			System.out.println("4. 출금");
			System.out.println("5. 이체");
			System.out.println("6. 조회");
			System.out.println("0. 종료");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 0) {
				System.out.print("시스템을 종료합니다.");
				run = false;
			}else {
				if(log == -1) {
					if(sel == 1) {
						// 로그인처리
						System.out.print("acc : ");
						int acc = scan.nextInt();
						System.out.print("Pw : ");
						int pw = scan.nextInt();
						
						if(acc == dbAcc1 && pw == Pw1) 
							log = 1;
						else if(acc == dbAcc2 && pw == Pw2) 
							log = 2;
						else
							System.out.print("회원정보를 다시 입력해주세요.");
					}else {
						System.err.print("로그인 후 사용가능한 메뉴입니다.");
					}
				}else {
					if(sel == 1) {
						System.err.println("이미 로그인 중입니다.");
					}else {
						//로그아웃
						if(sel == 2) {
							log = -1;
							System.out.println("로그아웃 완료");
						}
						//입금
						else if(sel == 3) {
							System.out.println("입금 금액 : ");
							money = scan.nextInt();
							
							if(money > 0) {
								if(log == 1) {
									dbMoney1 += money;
								}else if(log == 2) {
									dbMoney2 += money;
								}
								System.out.println("입금완료");
							}else {
								System.err.println("유효하지 않은 금액입니다.");
							}
							
						}
						//출금
						else if(sel == 4) {
							System.out.println("출금 금액 : ");
							money = scan.nextInt();
							
							if(money > 0) {
								if(log == 1 && dbMoney1 >= money) {
									dbMoney1 -= money;
									System.out.println("출금 완료");
								}else if(log == 2 && dbMoney2 >= money) {
									dbMoney2 -= money;
									System.out.println("츨금완료");
								}else {
									System.err.println("잔액이 부족합니다.");
								}
							}else {
								System.err.println("유효하지 않은 금액입니다.");
							}
						}
						//이체
						else if(sel == 5) {
							System.out.print("이체할 계좌번호 : ");
							int acc = scan.nextInt();
							
							if((log == 1 && acc == dbAcc2) || (log == 2 && acc == dbAcc1)){
								
							}
						}
					}
				}
			}
				
		}
	}

}
