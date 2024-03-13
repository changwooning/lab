package lv04;

import java.util.Scanner;

public class Ex11 {
	
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

		String menu = "====== ATM ======\n";
		menu += "1.회원가입\n2.회원탈퇴\n3.로그인\n4.로그아웃\n";
		menu += "5.입금\n6.이체\n7.잔액조회\n0.종료";
		
		while(true) {
			System.out.println("=== MEGA BANK ===");
			if(log != -1)
				System.out.printf("%d님 로그인 중....\n",accs[log]);
			System.out.println("=================");
			System.out.println(menu);
			System.out.println("=================");
			
			System.out.print("선택 : ");
			int sel = scan.nextInt();
			
			//예외처리
			if(log == -1 && (sel == 2 || sel == 4 || sel ==5 || sel ==6 || sel == 7)){
				System.out.println("로그인 후 이용가능합니다.");
				continue;
			}else if(log != -1 && (sel == 1 || sel == 3)) {
				System.out.println("로그아웃 후 이용가능합니다.");
				continue;
			}
			
			//회원가입
			if(sel == 1) {
				if(count == MAX) {
					System.out.println("정원이 마감되었습니다.");
					continue;
				}
				
				System.out.print("id : ");
				int id = scan.nextInt();
				System.out.print("pw : ");
				int pw = scan.nextInt();
				
				//중복 아이디 검사
				int idx = -1;
				for(int i=0; i<count; i++) {
					if(accs[i] == id)
						idx = i;
				}
				
				if(idx == -1) {
					//가입처리
					accs[count] = id;
					pwds[count] = pw;
					balances[count] = 1000;
					count ++;
					System.out.println("회원가입 완료");
				}else {
					System.out.println("중복 계정이 존재합니다.");
					continue;
				}
			}
			//회원탈퇴
			else if(sel == 2) {
				System.out.print("비밀번호 확인 : ");
				int pw = scan.nextInt();
				
				if(pwds[log] == pw) {
					//탈퇴처리
					for(int i=log; i<count; i++) {
						accs[i] = accs[i+1];
						pwds[i] = pwds[i+1];
						balances[i] = balances[i+1];
					}
					accs[count-1] = 0;
					pwds[count-1] = 0;
					balances[count-1] = 0;
					
					count --;
					log = -1;
					
					System.out.println("탈퇴 완료");
					
					
				}else {
					System.out.println("비밀번호가 불일치 합니다.");
				}
			}
			//로그인
			else if(sel == 3) {
				System.out.print("id : ");
				int id = scan.nextInt();
				System.out.print("pw : ");
				int pw = scan.nextInt();
				
				for(int i=0; i<count; i++) {
					if(accs[i] == id && pwds[i] == pw)
						log = i;
				}
				if(log == -1)
					System.out.println("회원정보를 확인하세요.");
				else
					System.out.println("로그인 완료");
			}
			//로그아웃
			else if(sel == 4) {
				log = -1;
				System.out.println("로그아웃 완료");
			}
			//입금
			else if(sel == 5) {
				System.out.print("입금 금액 : ");
				int money = scan.nextInt();
				
				if(money > 0) {
					balances[log] += money;
					System.out.println("입금 완료");
				}else {
					System.out.println("입금 금액은 1원 이상이여야 합니다.");
				}
				
				
			}
			//이체
			else if(sel == 6) {
				System.out.print("이체 할 계좌 ; ");
				int acc = scan.nextInt();
				
				int idx = -1;
				for(int i=0; i<count; i++) {
					if(accs[i] == acc)
						idx = i;
				}
				if(idx != -1 && idx != log) {
					//이체처리
					System.out.print("이체할 금액 : ");
					int money = scan.nextInt();
					
					if(money > 0 && money <= balances[log]) {
						balances[log] -= money;
						balances[idx] += money;
						System.out.println("이체 완료");
					}else {
						System.out.println("금액을 다시 확인하세요!");
						}
				}else {
					System.out.println("유효하지 않은 계좌입니다.");
				}
			}
			//잔액조회
			else if(sel == 7) {
				System.out.printf("현재 %d님의 계좌 잔액은 %d원입니다.\n", accs[log],balances[log]);
			}
			//종료
			else if(sel == 0) {
				System.out.println("종료합니다.");
				break;
			}
			
			
			
			
			
			
		}
		
		

	}

}
