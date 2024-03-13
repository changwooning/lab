package lv04practice;

import java.util.Scanner;

public class Practice42 {

	// ATM 4단계

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int MAX = 5;

		int[] accs = new int[MAX];
		int[] pwds = new int[MAX];
		int[] balances = new int[MAX];

		int count = 0;
		int log = -1;

		String menu = "====== ATM ======\n";
		menu += "1.회원가입\n2.회원탈퇴\n3.로그인\n4.로그아웃\n";
		menu += "5.입금\n6.이체\n7.조회\n0.종료";

		while (true) {

			System.out.println("=== MEGA BANK ===");
			if (log != -1)
				System.out.printf("%d님 로그인 중....\n", accs[log]);
			System.out.println("=================");
			System.out.println(menu);
			System.out.println("=================");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			// 예외처리
			if (log == -1 && (sel == 2 || sel == 4 || sel == 5 || sel == 6 || sel == 7)) {
				System.out.println("로그인 후 이용가능합니다.");
				continue;
			} else if (log != -1 && (sel == 1 || sel == 3)) {
				System.out.println("로그아웃 후 이용가능합니다.");
				continue;
			}

			if (sel == 1) {
				// 예외처리 1. 정원 마감
				if (count == 5) {
					System.out.println("정원이 마감되었습니다.");
					continue;
				}

				// 입력
				System.out.print("id : ");
				int id = scan.nextInt();
				System.out.print("pw : ");
				int pw = scan.nextInt();

				// 중복 아이디 검사
				int idx = -1;
				for (int i = 0; i < count; i++) {
					if (accs[i] == id)
						idx = i;
				}

				// 가입처리
				if (log == -1) {
					accs[count] = id;
					pwds[count] = pw;
					balances[count] = 1000;
					count++;
					System.out.println("회원가입 완료");
				} else {
					System.out.println("중복계정이 존재합니다.");
				}
			} else if (sel == 2) {
				// 회원탈퇴

				// 입력
				System.out.println("비밀번호 재확인 : ");
				int pw = scan.nextInt();

				int idx = -1;
				for (int i = 0; i < count; i++) {
					if (pwds[i] == pw) {
						idx = i;
					}
				}

				// 탈퇴처리
				if (log != -1 && log != idx) {
					for (int i = 0; i < count; i++) {
						accs[i] = accs[i + 1];
						pwds[i] = pwds[i + 1];
						balances[i] = balances[i + 1];
					}
					accs[count - 1] = 0;
					pwds[count - 1] = 0;
					balances[count - 1] = 0;
					count--;
					log = -1;
					System.out.println("탈퇴 완료");
				} else {
					System.out.println("비밀번호가 불일치 합니다.");
				}

			} else if (sel == 3) {
				// 로그인

				// 입력
				System.out.print("id : ");
				int id = scan.nextInt();
				System.out.print("pw : ");
				int pw = scan.nextInt();

				for (int i = 0; i < count; i++) {
					if (accs[i] == id && pwds[i] == pw)
						log = i;
				}

				if (log == -1) {
					System.out.println("회원정보를 다시 확인해주세요.");
				} else {
					System.out.println("로그인 완료");
				}
			} else if (sel == 4) {
				// 로그아웃
				log = -1;
				System.out.println("로그아웃완료");
			} else if (sel == 5) {
				// 입금

				// 입력
				System.out.print("입금 금액 : ");
				int money = scan.nextInt();

				if (money > 0) {
					balances[log] += money;
					System.out.println("입금 완료");
				} else {
					System.out.println("입금 금액은 1원이상이여야 합니다.");
					continue;
				}
			} else if (sel == 6) {
				// 이체

				// 입력
				System.out.print("이체할 계좌 :");
				int acc = scan.nextInt();

				int idx = -1;
				for (int i = 0; i < count; i++) {
					if (accs[i] == acc)
						idx = i;
				}

				if (log != -1 && log != idx) {
					//이체처리
					System.out.print("이체할 금액 : ");
					int money = scan.nextInt();

					if (money > 0 && money <= balances[log]) {
						balances[log] -= money;
						balances[idx] += money;
						System.out.println("이체 완료");
					}else
						System.out.println("금액을 다시 확인해주세요.");
				} else {
					System.out.println("유효하지 않은 계좌입니다.");
				}
			} else if (sel == 7) {
				// 잔액 조회
				System.out.printf("현재 %d님의 계좌 잔액은 %d원입니다.", accs[log], balances[log]);
			} else if (sel == 0) {
				System.out.println("시스템 종료");
				break;
			}
		}

	}

}
