package lv04;

import java.util.Scanner;

public class Ex10 {

	// # ATM[4단계] : 전체 기능구현
	// 1. 회원가입
	// id와 pw를 입력받아 가입
	// 가입 시 돈 1000원을 부여
	// id중복체크
	// 2. 회원탈퇴
	// 로그인시에만 이용가능
	// 3. 로그인
	// id와 pw를 입력받아 로그인
	// 로그아웃 상태에서만 이용가능
	// 4. 로그아웃
	// 로그인시에만 이용가능
	// 5. 입금
	// 로그인시에만 이용가능
	// 6. 이체
	// 로그인시에만 이용가능
	// 7.잔액조회
	// 로그인시에만 이용가능

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int MAX = 5;

		int[] accs = new int[MAX];
		int[] pwds = new int[MAX];
		int[] balances = new int[MAX];

		int count = 0;
		int log = -1;
		int total = 0;

		String menu = "=== ATM ===\n";
		menu += "1.회원가입\n2.회원탈퇴\n3.로그인\n4.로그아웃\n";
		menu += "5.입금\n6.이체\n7.잔액조회\n0.종료";

		while (true) {

			System.out.println(menu);
			int sel = scan.nextInt();

			if (sel == 1) {
				//회원가입
				for (int i = 0; i < MAX; i++) {
					System.out.printf("%d) %d/%d\n", i + 1, accs[i], pwds[i]);
				}

				if (count == 5) {
					System.err.println("가입정원이 마감되었습니다.");
					continue;
				}

				// 입력
				System.out.print("id : ");
				int id = scan.nextInt();
				System.out.print("pw : ");
				int pw = scan.nextInt();

				// 예외처리 중복확인
				int idx = -1;
				for (int i = 0; i < count; i++) {
					if (accs[i] == id)
						idx = i;
				}

				// 가입처리
				if (idx == -1) {
					accs[count] = id;
					pwds[count] = pw;
					count++;
					System.out.println("가입완료");
					balances[count] += 1000;
				} else {
					System.err.println("이미 사용중인 회원입니다.");
					continue;
				}
			} else if (sel == 2) {
				//회원탈퇴
				for (int i = 0; i < MAX; i++) {
					System.out.printf("%d) %d/%d\n", i + 1, accs[i], pwds[i]);
				}
				// 입력
				System.out.print("id : ");
				int id = scan.nextInt();
				System.out.print("pw : ");
				int pw = scan.nextInt();

				// 예외처리
				int idx = -1;
				for (int i = 0; i < MAX; i++) {
					if (accs[i] == id && pwds[i] == pw)
						idx = i;
				}

				// 탈퇴처리
				if (idx != -1) {
					for (int i = idx; i < count - 1; i++) {
						accs[i] = accs[i + 1];
						pwds[i] = pwds[i + 1];
					}
					accs[count - 1] = 0;
					pwds[count - 1] = 0;
					count--;
					System.out.println("탈퇴완료");
				} else {
					System.out.println("회원정보가 일치하지 않습니다.");
					continue;
				}
			} else if (sel == 3) {
				//로그인
				if (log == -1) {
					// 입력
					System.out.print("id : ");
					int id = scan.nextInt();
					System.out.print("pw : ");
					int pw = scan.nextInt();

					// 로그이시 아이디와 같은지 여부
					for (int i = 0; i < count; i++) {
						if (accs[i] == id && pwds[i] == pw) {
							log = 1;
							System.out.println("로그인 성공");
						} else {
							System.out.println("회원정보가 일치하지 않습니다.");
							continue;
						}
					}

				} else {
					System.out.println("이미 로그인 상태입니다.");
					continue;
				}

			} else if (sel == 4) {
				//로그아웃
				if (log == 1) {
					// 입력
					System.out.print("id : ");
					int id = scan.nextInt();
					System.out.print("pw : ");
					int pw = scan.nextInt();

					// 예외처리 1.회원정보 일치여부
					for (int i = 0; i < count; i++) {
						if (accs[i] == id && pwds[i] == pw) {
							log = -1;
							System.out.println("로그아웃완료");

						} else {
							System.out.println("회원정보가 일치하지 않습니다.");
							continue;
						}
					}

				} else {
					System.out.println("로그아웃 상태입니다.");
					continue;
				}

			} else if (sel == 5) {
				//입금
				if (log == 1) {
					// 입력
					System.out.print("입금 금액 : ");
					int money = scan.nextInt();

					// 예외처리
					for (int i = 0; i < count; i++) {
						if (money > 0)
							balances[count] += money;
					}
				}

			} else if (sel == 6) {
				//이체
				if (log == 1) {
					// 이체
					System.out.print("이체 할 계좌번호 : ");
					int id = scan.nextInt();

					for (int i = 0; i < count; i++) {
						if (accs[count] == id) {
							System.out.print("이체 금액 : ");
							int money = scan.nextInt();

							if (money <= balances[count]) {
								balances[count] += money;
								System.out.println("이체완료");

							} else {
								System.out.println("금액이 부족합니다.");
								continue;
							}
						}
					}

				}

			} else if (sel == 7) {
				
				if(log == 1) {
					
					
					
					
				}
				
				
				
				
			} else if (sel == 0) {
				System.out.println("종료합니다.");
				break;
			}

		}

	}

}
