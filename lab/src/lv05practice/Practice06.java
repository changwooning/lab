package lv05practice;

import java.util.Scanner;

public class Practice06 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		final String ADMIN = "admin";
		final String MENUS = "24567";
		
		int jangCount = 0;
		int[][] jang = null;
		
		int count = 1;
		String[] ids = {"admin"};
		String[] pws = {"1234"};
		
		int itemCount = 3;
		String[] items = {"사과","바나나","딸기"};
		
		int log = -1;
		
		String jangFileName = "jang.txt";
		String userFileName = "user.txt";
		
		while(true) {
			
			System.out.println("[SHOP]");
			System.out.println("[1]회원가입");
			System.out.println("[2]회원탈퇴");
			System.out.println("[3]로그인");
			System.out.println("[4]로그아웃");
			System.out.println("[5]쇼핑");
			System.out.println("[6]장바구니");
			System.out.println("[7]관리자");	// 아이템 추가,삭제
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			//회원가입
			if(sel == 1) {
				System.out.print("id : ");
				String id = scan.next();
				System.out.print("id : ");
				String pw = scan.next();
				
				boolean isDupl = false;
				for(int i=0; i<count; i++) {
					if(ids[i].equals(id))
						isDupl = true;
				}
				if(!isDupl) {
					String[] tempIds = ids;
					String[] tempPws = pws;
					
					ids = new String[count + 1];
					pws = new String[count + 1];
					
					for(int i=0; i<count; i++) {
						ids[i] = tempIds[i];
						pws[i] = tempPws[i];
					}
					ids[count] = id;
					pws[count] = pw;
					count ++;
					System.out.println("회원가입 성공");
				}else {
					System.out.println("중복된 계정이 존재합니다.");
					continue;
				}
			}
			//회원탈퇴
			if(sel == 2) {
				System.out.print("비밀번호 재입력: ");
				String pw = scan.next();
				
				if(pws[log].equals(pw)) {
					String[] tempIds = ids;
					String[] tempPws = pws;
					
					ids = new String[count - 1];
					pws = new String[count = 1];
					
					int idx = 0;
					for(int i=0; i<count; i++) {
						if(i != log) {
							ids[idx] = tempIds[i];
							pws[idx] = tempPws[i];
							idx++;
						}
					}
					//장바구니 내역 삭제
					int delCnt = 0;
					for(int i=0; i<jangCount; i++) {
						if(jang[i][0] == log)
							delCnt++;
					}
					
					int[][] tempJang = jang;
					jang = new int[jangCount - delCnt][];
					
					idx = 0;
					for(int i=0; i<jangCount; i++) {
						if(tempJang[i][0] != log) {
							if(tempJang[i][0] > log)
								tempJang[i][0] -= 1;
							jang[idx] = tempJang[i];	//	1차원 주소 복사
							idx ++;
						}
					}
					jangCount -= delCnt;
					count --;
					log = -1;
					
				}else {
					System.out.println("비밀번호가 불일치 합니다.");
				}
			}
			//로그인
			if(sel == 3) {
				System.out.print("id : ");
				String id = scan.next();
				System.out.print("pw : ");
				String pw = scan.next();
				
				for(int i=0; i<count; i++) {
					if(ids[i].equals(id) && pws[i].equals(pw))
						log = i;
				}
				if(log == -1) {
					System.out.println("회원정보를 다시 확인하세요.");
				}else {
					System.out.printf("%s님 환영합니다~",ids[log]);
				}
				
			}
			//로그아웃
			if(sel == 4) {
				log = -1;
				System.out.println("로그아웃 완료");
			}
			//쇼핑
			if(sel == 5) {
				
				while(true) {
					
					for(int i=0; i<itemCount; i++) {
						System.out.printf("%d) %s\n", i+1,items[i]);
					}
					System.out.println("0) 뒤로가기");
					System.out.print("아이템 선택 : ");
					int itemNum = scan.nextInt();
					
					if(itemNum == 0)
						break;
					
					if(itemNum < 1 || itemNum > itemCount)
						continue;
					
					// 구매이력을 jang에 기록
					int[][] tempJang = jang;
					jang = new int[jangCount + 1][];
					
					for(int i=0; i<jangCount; i++) {
						jang[i] = tempJang[i];
					}
					
					jang[jangCount] = new int[2];
					jang[jangCount][0] = log;
					jang[jangCount][1] = itemNum;
					jangCount ++;
				}
			}
			//장바구니
			if(sel == 6) {
				// 소계 출력용 item count 배열 선언 및 초기화
				int[] tempCount = new int[itemCount];
				
				for(int i=0; i<jangCount; i++) {
					int itemIdx = jang[i][1]-1;
					if(jang[i][0] == log) 
						tempCount[itemIdx] += 1;
				}
				
				// 소계 출력
				for(int i=0; i<itemCount; i++) {
					if(tempCount[i] > 0)
						System.out.printf("%s) %d개\n",items[i],tempCount[i]);
				}
			}
			//관리자
			if(sel == 7) {
				
				if(!ids[log].equals(ADMIN)) {
					System.out.println("관리자 계정만 이용가능합니다.");
					continue;
				}
				
				while(true) {
					System.out.println("1) 아이템추가");
					System.out.println("2) 아이템삭제");
					System.out.println("0) 뒤로가기");
					
					System.out.print("선택 : ");
					int subSel = scan.nextInt();
					
					if(subSel == 0)
						break;
					
					if(subSel == 1) {
						
						System.out.print("추가할 아이템 명 : ");
						String itemName = scan.next();
						
						//중복검사
						boolean isDupl = false;
						for(int i=0; i<itemCount; i++) {
							if(items[i].equals(itemName))
								isDupl = true;
						}
						if(isDupl) {
							System.out.println("중복 이름이 존재합니다.");
							continue;
						}
							
						String[] tempItems = items;
						items = new String[itemCount + 1];
						
						for(int i=0; i<itemCount; i++) {
							items[i] = tempItems[i];
						}
						
						items[itemCount] = itemName;
						itemCount ++;
						System.out.println("아이템 추가완료");
						
					}else if(subSel == 2) {
						
						for(int i=0; i<itemCount; i++) {
							System.out.printf("%d) %s\n", i+1,items[i]);
						}
						
						System.out.print("삭제할 아이템 번호 : ");
						int delItem = scan.nextInt()-1;
						
						if(delItem < 0 || delItem > itemCount -1)
							continue;
						
						String[] tempItem = items;
						items = new String[itemCount - 1];
						
						int idx = 0;
						for(int i=0; i<itemCount; i++) {
							if(i != log) {
								items[idx] = tempItem[i];
								idx ++;
							}
						}
						itemCount --;
						
						//장바구니 이력 정리
						int delCnt = 0;
						for(int i=0; i<jangCount; i++) {
							if(jang[i][1] == delItem + 1)
								delCnt ++;
						}
						
						int[][] tempJang = jang;
						jang = new int[jangCount - delCnt][];
						
						idx = 0;
						for(int i=0; i<jangCount; i++) {
							if(tempJang[i][1] > delItem + 1)
								tempJang[i][1] -= 1;
							if(tempJang[i][1] != delItem + 1)
								jang[i] = tempJang[i];
						}
						jangCount -= delCnt;
						
						
						
						
					}
					
					
				}
				
				
				
				
				
				
				
				
				
				
				
				
			}
			if(sel == 0) {}
			
			
			
			
			
		}
		

	}

}
