package lv04practice;

import java.util.Scanner;

public class Practice08 {

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
			
			
			System.out.print("선택 : ");
			int sel = scan.nextInt();
			
			//예외처리 1.로그인시에만 가능한것
			if(log == -1 && (sel == 2 || sel == 4 || sel == 5 || sel == 6 || sel == 7)) {
				System.out.println("로그인 후 이용가능합니다.");
				continue;
			}else if(log != -1 && (sel == 1 || sel == 3)) {
				System.out.println("로그아웃 후 이용가능합니다.");
				continue;
			}
			
			if(sel == 1) {
				if(count == MAX) {
					System.out.println("정원이 마감되었습니다.");
					continue;
				}
				//입력
				System.out.print("id : ");
				int id = scan.nextInt();
				System.out.print("pw : ");
				int pw = scan.nextInt();
				
				//중복 아이디 검사
				int idx = -1;
				for(int i=0; i<MAX; i++) {
					if(accs[i] == id) 
						idx = i;
				}
				
				//가입처리
				if(idx == -1) {
					accs[count] = id;
					pwds[count] = pw;
					balances[count] = 1000;
					count ++;
				}else {
					System.out.println("중복 계정이 존재합니다.");
					continue;
				}
			}else if(sel == 2) {
				
				System.out.print("비밀번호 확인 : ");
				int pw = scan.nextInt();
				
				if(pwds[log] == pw) {
					//탈퇴처리
					for(int i=log; i<count; i++) {
						accs[i] = accs[i+1];
						pwds[i] = pwds[i+1];
						
					}
					accs[count-1] = 0;
					pwds[count-1] = 0;
					balances[count -1] = 0;
					
					count --;
					log = -1;
					
					System.out.println("탈퇴 완료");
				}else
					System.out.println("비밀번호가 불일치 합니다.");
			}else if(sel == 3) {

			
			
			}
				
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
