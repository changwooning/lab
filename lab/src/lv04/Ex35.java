package lv04;

import java.util.Scanner;

public class Ex35 {

	// # 쇼핑몰 [장바구니]
	// 1. 로그인 후 쇼핑 메뉴를 선택하면, 다음과 같이 상품목록을 보여준다.
	// 1) 사과
	// 2) 바나나
	// 3) 딸기
	// 2. 번호를 선택해 상품을 장바구니에 담을 수 있다.
	// 3. 로그인 회원의 인덱스 번호는 각 행의 첫번째 열에 저장한다.
	// 4. 해당 회원이 구매한 상품의 인덱스 번호는 각 행의 두번째 열에 저장한다.
	// 예)
	// {
	// {0,1}, qwer회원 >사과구매
	// {1,2}, javaking회원 >바나나구매
	// {2,1}, abcd회원 >사과구매
	// {0,3}, qwer회원 >딸기구매
	// ...
	// }
	//

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String[] ids = null;
		String[] pws = null;

		int log = -1;
		int cnt = 0;
		int size = 0;
		int[][] jang = null;

		String[] items = { "사과", "바나나", "딸기" };

		while (true) {

			System.out.println("[MEGA MART");
			System.out.println("[1]회원가입");
			System.out.println("[2]탈   퇴");
			//탈퇴 시,구매 기록 삭제까지만
			//ㄴ 기존 log 인덱스에 대한 변경 생략
			System.out.println("[3]로 그 인");
			System.out.println("[4]로그아웃");
			System.out.println("[5]쇼   핑");
			System.out.println("[6]장바구니");

			// id : apple [0] 회원이 쇼핑
			// 사과구매
			// 바나나 구매
			// 딸기 구매
			// 사과 구매
			// 바나나 구매
			// 사과 구매
			// -> 장바구니

			// 사과3개
			// 바나나 2개
			// 딸기 1개
			//
			System.out.println("[0]종    료");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			// 예외처리
			// 로그인 후 이용가능 한것
			if (log == -1 && (sel == 2 || sel == 4 || sel == 5 || sel == 6)) {
				System.out.println("로그인 후 이용가능 합니다.");
				continue;
			}
			else if (log != -1 && (sel == 1 || sel == 3)) {
				System.out.println("로그아웃 후 이용가능 합니다.");
				continue;
			}
			
			if (sel == 1) {
				// 입력
				System.out.print("id : ");
				String id = scan.next();
				System.out.print("pw : ");
				String pw = scan.next();
				
				//중복검사
				int idx = -1;
				for(int i=0; i<cnt; i++) {
					if(ids[i] == id)
						idx = i;
				}
				if(idx == -1) {
					// 초기화 해야함
					String[] temp = ids;
					temp = pws;

					ids = new String[cnt + 1];
					pws = new String[cnt + 1];
					
					//구 주소를 새 주소에 복사
					for (int i = 0; i < cnt; i++) {
						ids[i] = temp[i];
						pws[i] = temp[i];
					}
					ids[cnt] = id;
					pws[cnt] = pw;
					cnt++;
					System.out.println("회원가입완료");
				}else {
					System.out.println("중복 계정이 존재합니다.");
				}

			} else if (sel == 2) {
				System.out.print("비밀번호 확인 : ");
				String pw = scan.next();
				
				if(pws[log].equals(pw)) {
					for(int i=log; i<cnt; i++) {
						ids[i] = ids[i+1];
						pws[i] = pws[i+1];
					}
					ids[cnt-1] = "";
					pws[cnt-1] = "";
					
					cnt --;
					log = -1;
					
					System.out.println("탈퇴 완료");
					
				}else
					System.out.println("비밀번호가 불일치 합니다.");
				
			} else if (sel == 3) {
				System.out.print("id : ");
				String id = scan.next();
				System.out.print("pw : ");
				String pw = scan.next();
				
				for(int i=0; i<cnt; i++) {
					if(ids[i].equals(id) && pws[i].equals(pw));
						log = i;
				}
				if(log == -1)
					System.out.println("회원정보를 확인하세요.");
				else
					System.out.println("로그인 완료");
				
			} else if (sel == 4) {
				//로그아웃
				log = -1;
				System.out.println("로그아웃 완료");
				
			} else if (sel == 5) {
				//쇼핑
				//출력
				for(int i=0; i<3; i++) {
					System.out.printf("%d) %s\n", i+1, items[i]);
				}
				//입력
				System.out.println("과일 선택 : ");
				String input = scan.next();
				
				
				//예외처리 1. 범위
				if(input.equals("사과")) {
					jang = new int[size+1][2];
					
					jang[size][0] = log;
					
					
					
				}else if(input.equals("바나나")) {
					
				}else if(input.equals("딸기")) {
					
				}else {
					//사과 바나나 딸기가 아닌것
					System.out.println("해당 과일 존재하지 않습니다.");
				}
					
				
				
			} else if (sel == 6) {
				//장바구니
				
			} else if (sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}

		}

	}

}
