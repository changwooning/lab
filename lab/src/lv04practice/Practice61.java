package lv04practice;

import java.util.Scanner;

public class Practice61 {
	
	// # 쇼핑몰 [장바구니]
		// 1. 로그인 후 쇼핑 메뉴를 선택하면, 다음과 같이 상품목록을 보여준다.
		// 1) 사과
		// 2) 바나나
		// 3) 딸기
		// 2. 번호를 선택해 상품을 장바구니에 담을 수 있다.
		// 3. 로그인 회원의 인덱스 번호는 각 행의 첫번째 열에 저장한다. : 0 인덱스
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
		
		String[] items = {"사과","바나나","딸기"};
		
		while(true) {
			
			System.out.println("[MEGA MART]");
			System.out.println("[1]회원가입");
			System.out.println("[2]회원탈퇴");
			System.out.println("[3]로그인");
			System.out.println("[4]로그아웃");
			System.out.println("[5]쇼핑");
			System.out.println("[6]장바구니");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(log == -1 && (sel == 2 || sel == 4 || sel == 5 || sel == 6)) {
				System.out.println("로그인 후 이용가능합니다.");
				continue;
			}else if(log != -1 && (sel == 1 || sel == 3)) {
				System.out.println("로그아웃 후 이용가능합니다.");
				continue;
			}
			
			if(sel == 1) {
				//회원가입
				
				//입력
				System.out.print("id : ");
				String id = scan.next();
				System.out.print("pw : ");
				String pw = scan.next();
				
				//중복검사
				boolean isDupl = false;
				for(int i=0; i<cnt; i++) {
					if(id.equals(ids[i]))
						isDupl = true;
				}
				if(!isDupl) {
					String[] tempIds = ids;
					String[] tempPws = pws;
					
					ids = new String[cnt + 1];
					pws = new String[cnt + 1];
					
					for(int i=0; i<cnt ; i++) {
						ids[i] = tempIds[i];
						pws[i] = tempPws[i];
					}
					ids[cnt] = id;
					pws[cnt] = pw;
					cnt ++;
					System.out.println("회원가입 완료");
				}else {
					System.out.println("중복회원이 존재합니다.");
				}
				
			}else if(sel == 2) {
				//회원 탈퇴
				
				//입력
				System.out.print("비밀번호 재확인 : ");
				String pw = scan.next();
				
				if(pw.equals(pws[log])) {
					String[] tempIds = ids;
					String[] tempPws = pws;
					
					ids = new String[cnt -1];
					pws = new String[cnt -1];
					
					int idx = 0;
					for(int i=0; i<cnt; i++) {
						if(i != log) {
							ids[idx] = tempIds[i];
							pws[idx] = tempPws[i];
							idx ++;
						}
					}
					cnt --;
					
					int delCnt = 0;
					for(int i=0; i<size; i++) {
						if(jang[i][0] == log)
							delCnt++;
					}
					int[][] temp = jang;
					jang = new int[size - delCnt][];
					
					idx = 0;
					for(int i=0; i<size; i++) {
						int tempLog = temp[i][0];
						if(tempLog != log) {
							if(tempLog > log)
								temp[i][0]--;
							jang[idx] = temp[i];
							idx ++;
						}
					}
					size  -= delCnt;
					
					log = -1;
					System.out.println("탈퇴 완료");
				}else {
					System.out.println("비밀번호가 불일치 합니다.");
				}
					
			}else if(sel == 3) {
				//로그인
				
				//입력
				System.out.print("id : ");
				String id = scan.next();
				System.out.print("pw : ");
				String pw = scan.next();
				
				//중복검사
				for(int i=0; i<cnt; i++) {
					if(ids[i].equals(id) && pws[i].equals(pw))
						log = i;
				}
				if(log == -1) {
					System.out.println("회원정보를 다시 확인해주세요.");
				}else
					System.out.printf("%s님 환영합니다.", ids[log]);
			}else if(sel == 4) {
				//로그아웃
				log = -1;
				System.out.println("로그아웃 완료");
			}else if(sel == 5) {
				//쇼핑
				while(true) {
					for(int i=0; i<items.length; i++) {
						System.out.printf("%d) %s\n", i+1,items[i]);
					}
					System.out.print("상품 번호 : ");
					int itemNum = scan.nextInt();
					
					//종료조건 while문 추가
					if(itemNum == 0)
						break;
					
					//예외처리
					if(itemNum < 1 || itemNum > items.length)
						continue;
					
					//장바구니 배열에; 쇼핑 내역ㄹ을 기록
					//{log, itemNum} 
					int[][] temp = jang;
					jang = new int[size + 1][];
					
					for(int i=0; i<size; i++)
						jang[i] = temp[i];
					
					jang[size] = new int[2];
					jang[size][0] = log;
					jang[size][1] = itemNum;
					size ++;
				}
			}else if(sel == 6) {
				//장바구니
				//소계
				int[] itemCnt = new int[items.length];
				
				boolean isEmpty = true;
				for(int i=0; i<size; i++) {
					if(jang[i][0] == log) {
						int itemIdx = jang[i][1] -1;
						itemCnt[itemIdx] ++;
						isEmpty = false;
					}
				}
				System.out.printf("--- %s님의 장바구니 내역 ---\n", ids[log]);
				for(int i=0; i<itemCnt.length; i++) {
					if(itemCnt[i] > 0)
						System.out.printf("%s %d개\n", items[i],itemCnt[i]);
				}
				if(isEmpty)
					System.out.println("텅-");
			}else if(sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			
		}
		
		

	}

}
