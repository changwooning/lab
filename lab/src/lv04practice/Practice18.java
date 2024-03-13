package lv04practice;

import java.util.Scanner;

public class Practice18 {

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

			System.out.print("선택 : ");
			int sel = scan.nextInt();

			// 예외처리 1.로그인 후 가능한것
			if (log == -1 && (sel == 2 || sel == 4 || sel == 5 || sel == 6 || sel == 7)) {
				System.out.println("로그인 후 이용가능합니다.");
				continue;
			}
			// 예외처리 2. 로그아웃 후 가능한 것
			else if (log != -1 && (sel == 1 || sel == 3)) {
				System.out.println("로그아웃 후 이용가능합니다.");
				continue;
			}
			// 회원가입
			if (sel == 1) {
				// 예외처리
				if (count == 5) {
					System.out.println("정원이 마감되었습니다.");
					continue;
				}
				// 입력
				System.out.print("id : ");
				int id = scan.nextInt();
				System.out.print("pw : ");
				int pw = scan.nextInt();

				// 예외처리 1. 중복검사 (아이디)
				int idx = -1;
				for (int i = 0; i < count; i++) {
					if (accs[i] == id)
						idx = i;
				}
				// 가입처리
				if (idx == -1) {
					accs[count] = id;
					pwds[count] = pw;
					balances[count] = 1000;
					count++;
				} else {
					System.out.println("중복 계정이 존재합니다.");
					continue;
				}
			}
			// 회원탈퇴
			else if (sel == 2) {
				// 입력=> 비밀번호 확인 이미 로그인한 상태
				System.out.print("비밀번호 확인 : ");
				int pw = scan.nextInt();

				// 탈퇴처리
				if (pwds[log] == pw) { // => log 사용의 유무!?
					for (int i = log; i < count; i++) {
						accs[i] = accs[i + 1];
						pwds[i] = pwds[i + 1];
						balances[i] = balances[i + 1];
					}
					accs[count - 1] = 0;
					pwds[count - 1] = 0;
					balances[count - 1] = 0;

					count--;
					log = -1;
					System.out.println("탈퇴완료");
				} else {
					System.out.println("비밀번호가 불일치 합니다.");
					continue;
				}
			}
			// 로그인
			else if (sel == 3) {
				// 입력
				System.out.print("id : ");
				int id = scan.nextInt();
				System.out.print("pw : ");
				int pw = scan.nextInt();

				// 검사
				for (int i = 0; i < count; i++) {
					if (accs[i] == id && pwds[i] == pw)
						log = i; // log를 인덱스로 사용하겠다
				}
				if (log == -1)
					System.out.println("회원정보를 확인하세요.");
				else
					System.out.println("로그인 완료");
			}
			// 로그아웃
			else if (sel == 4) {
				log = -1; // => 이해잘안됨
				System.out.println("로그아웃 완료");

			}
			// 입금
			else if (sel == 5) {
				System.out.print("입금할 금액 : ");
				int money = scan.nextInt();

				// 예외처리 1. 머니 범위
				if (money > 0) {
					balances[log] += money;
					System.out.println("입금완료");
				} else
					System.out.println("입금 금액은 1원 이상이여야 합니다.");
			}
			// 이체
			else if (sel == 6) {
				// 입력
				System.out.print("이체할 계좌 : ");
				int acc = scan.nextInt();

				int idx = -1;
				for (int i = 0; i < count; i++) {
					if (accs[i] == acc)
						idx = i;
				}
				// 예외처리 1.
				if (idx != -1 && idx != log) {
					System.out.print("이체할 금액 : ");
					int money = scan.nextInt();

					if (money > 0 && money <= balances[log]) { // 범위 이해안감
						balances[log] -= money;
						balances[log] += money;
						System.out.println("이체완료");
					} else
						System.out.println("금액을 다시 확인해 주세요.");
				} else
					System.out.println("유효하지 않은 계좌입니다.");
			}
			// 잔액조회
			else if (sel == 7) {
				System.out.printf("현재 %d님의 계좌 잔액은 %d원입니다.\n", accs[log], balances[log]);
			}
			// 종료
			else if (sel == 0) {
				System.out.println("종료합니다.");
				break;
			}

		}

	}

}
