package lv04test;

import java.util.Scanner;

public class Test404 {

	// # 쇼핑몰 장바구니
	// 1.로그인 후 쇼핑 메뉴를 선택하면 , 다음과 같이 상품목록을 보여준다.
	// 1)사과
	// 2)바나나
	// 3)딸기
	// 2. 번호를 선택해 상품을 장바구이네 담을 수 있다.
	// 3. 로그인 회원의 인덱스 번호는 각 행의 첫번째 열에 저장한다.
	// 4. 해당 회원이 구매한 상품의 인덱스 번호는 각 행의 두번째 열에 저장한다.
	//

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int userCnt = 1;

		String[] ids = { "admin" };
		String[] pws = { "1234" };

		int jangCnt = 0;
		int[][] jang = null;

		int itemCnt = 3;
		String[] items = { "사과", "바나나", "딸기" };

		int log = -1;

		while (true) {

			System.out.println("[MEGA MART]");
			System.out.println("[1]회원가입");
			System.out.println("[2]회원탈퇴");
			System.out.println("[3]로그인");
			System.out.println("[4]로그아웃");
			System.out.println("[5]쇼핑");
			System.out.println("[6]장바구니");
			System.out.println("[7]관리자"); // admin/1234
			// [7-1] 아이템 추가
			// [7-2] 아이템 삭제
			System.out.println("[0]종료");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			if (log == -1 && (sel == 2 || sel == 4 || sel == 5 || sel == 6 || sel == 7)) {
				System.out.println("로그인 후 이용가능합니다.");
				continue;
			} else if (log != -1 && (sel == 1 || sel == 3)) {
				System.out.println("로그아웃 후 이용가능합니다.");
				continue;
			}

			if (sel == 1) {
				// 회원가입

				// 입력
				System.out.print("id : ");
				String id = scan.next();
				System.out.print("pw : ");
				String pw = scan.next();

				// 중복검사
				boolean isDupl = false;
				for (int i = 0; i < userCnt; i++) {
					if (ids[i].equals(id))
						isDupl = true;
				}
				if (!isDupl) {
					String[] tempIds = ids;
					String[] tempPws = pws;

					ids = new String[userCnt + 1];
					pws = new String[userCnt + 1];

					for (int i = 0; i < userCnt; i++) {
						ids[i] = tempIds[i];
						pws[i] = tempPws[i];
					}
					ids[userCnt] = id;
					pws[userCnt] = pw;
					userCnt++;
					System.out.println("회원가입 완료");
				} else {
					System.out.println("중복된 계정이 존재합니다.");
				}
			} else if (sel == 2) {
				// 회원탈퇴
				System.out.print("비밀번호 재확인 : ");
				String pw = scan.next();

				if (pws[log].equals(pw)) {
					String[] tempIds = ids;
					String[] tempPws = pws;

					ids = new String[userCnt - 1];
					pws = new String[userCnt - 1];

					int idx = 0;
					for (int i = 0; i < userCnt; i++) {
						if (i != log) {
							ids[idx] = tempIds[i];
							pws[idx] = tempPws[i];
							idx++;
						}
					}
					userCnt--;

					// 장바구니에 있는 log 삭제
					int delCnt = 0;
					for (int i = 0; i < jangCnt; i++) {
						if (jang[i][0] == log)
							delCnt++;
					}
					int[][] temp = jang;
					jang = new int[jangCnt - delCnt][];

					idx = 0;
					for (int i = 0; i < jangCnt; i++) {
						if (temp[i][0] != log) {
							if (temp[i][0] > log)
								temp[i][0]--;
							jang[idx] = temp[i];
							idx++;
						}
					}
					jangCnt -= delCnt;

					log = -1;
					System.out.println("탈퇴완료");
				} else {
					System.out.println("비밀번호가 불일치 합니다.");
				}

			} else if (sel == 3) {
				// 로그인
				System.out.print("id : ");
				String id = scan.next();
				System.out.print("pw : ");
				String pw = scan.next();

				for (int i = 0; i < userCnt; i++) {
					if (id.equals(ids[i]) && pw.equals(pws[i]))
						log = i;
				}
				if (log == -1) {
					System.out.println("회원정보를 다시 확인해주세요.");
				} else {
					System.out.printf("%s님 환영합니다.\n", ids[log]);
				}

			} else if (sel == 4) {
				// 로그아웃
				log = -1;
				System.out.println("로그아웃 완료");
			} else if (sel == 5) {
				// 쇼핑
				while (true) {

					for (int i = 0; i < items.length; i++) {
						System.out.printf("%d) %s\n", i + 1, items[i]);
					}

					System.out.print("상품 번호 : ");
					int itemNum = scan.nextInt();

					// 종료
					if (itemNum == 0)
						break;

					if (itemNum < 1 || itemNum > items.length)
						continue;

					int[][] temp = jang;
					jang = new int[jangCnt + 1][];

					for (int i = 0; i < jangCnt; i++)
						jang[i] = temp[i];

					jang[jangCnt] = new int[2];
					jang[jangCnt][0] = log;
					jang[jangCnt][1] = itemNum;
					jangCnt++;
				}

			} else if (sel == 6) {
				// 장바구니
				// 소계
				int[] itemsCnt = new int[items.length];
				
				boolean isEmpty = true;
				for (int i = 0; i < jangCnt; i++) {
					if (jang[i][0] == log) {
						int itemIdx = jang[i][1] -1;
						itemsCnt[itemIdx]++;
						isEmpty = false;
					}
				}
				System.out.printf("==== %s님의 장바구니 내역 ====\n", ids[log]);
				for(int i=0; i<itemsCnt.length; i++) {
					if(itemsCnt[i] > 0)
						System.out.printf("%s %d개\n", items[i], itemsCnt[i]);
				}
				if (isEmpty) {
					System.out.println("텅-");
				}

			} else if (sel == 7) {
				// 관리자
				// 아이템추가 삭제
				System.out.println("[1]아이템 추가");
				System.out.println("[2]아이템 삭제");

				System.out.print("선택 : ");
				int adSel = scan.nextInt();

				if (adSel == 1) {

					// 추가입력
					System.out.print("추가할 아이템 : ");
					String adItem = scan.next();

					// 전달
					String[] tempItems = items;
					// 초기화
					items = new String[itemCnt + 1];

					// 복사
					for (int i = 0; i < itemCnt; i++)
						items[i] = tempItems[i];

					items[itemCnt] = adItem;
					itemCnt++;
					System.out.println("아이템 추가완료!");

				} else if (adSel == 2) {
					
					for(int i=0; i<items.length; i++) {
						System.out.printf("%d) %s\n",i+1,items[i]);
					}
					// 입력
					System.out.print("삭제할 아이템번호 : ");
					int delItem = scan.nextInt()-1;
					
					if(delItem < 0 || delItem > items.length) {
						System.out.println("번호 입력 오류");
					}

					String[] tempItems = items;
					items = new String[itemCnt - 1];

					int idx = 0;
					for (int i = 0; i < itemCnt; i++) {
						if(i != delItem) {
							items[idx] = tempItems[i];
							idx ++;
						}
					}
					itemCnt--;
					System.out.println("삭제완료");
				}

			} else if (sel == 0) {

				System.out.println("시스템을 종료합니다.");
				break;
			}

		}

	}

}
