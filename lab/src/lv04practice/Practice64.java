package lv04practice;

import java.util.Scanner;

public class Practice64 {

	// # 쇼핑몰 장바구니
	// 0116
	// 0155

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String[] ids = null;
		String[] pws = null;

		int log = -1;
		int cnt = 0;
		int size = 0;

		String[] items = { "바나나", "딸기", "사과" };

		int[][] jang = null;

		while (true) {

			System.out.println("=== MEGA MART ===");
			System.out.println("[1]회원가입");
			System.out.println("[2]회원탈퇴");
			System.out.println("[3]로그인");
			System.out.println("[4]로그아웃");
			System.out.println("[5]쇼핑");
			System.out.println("[6]장바구니");
			System.out.println("[0]종료");

			System.out.print("선택 : ");
			int sel = scan.nextInt();

			if (log == -1 && (sel == 2 || sel == 4 || sel == 5 || sel == 6)) {
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
				for (int i = 0; i < cnt; i++) {
					if (ids[i].equals(id))
						isDupl = true;
				}
				if (!isDupl) {
					String[] tempIds = ids;
					String[] tempPws = pws;

					ids = new String[cnt + 1];
					pws = new String[cnt + 1];

					for (int i = 0; i < cnt; i++) {
						ids[i] = tempIds[i];
						pws[i] = tempPws[i];
					}
					ids[cnt] = id;
					pws[cnt] = pw;
					cnt++;
					System.out.println("회원가입 완료!");
				} else
					System.out.println("중복 계정이 존재합니다.");
			} else if (sel == 2) {
				// 회원탈퇴

				// 입력
				System.out.print("비밀번호 재확인 : ");
				String pw = scan.next();

				if (pws[log].equals(pw)) {
					String[] tempIds = ids;
					String[] tempPws = pws;

					ids = new String[cnt - 1];
					pws = new String[cnt - 1];

					int idx = 0;
					for (int i = 0; i < cnt; i++) {
						if (i != log) {
							ids[idx] = tempIds[i];
							pws[idx] = tempPws[i];
							idx++;
						}
					}
					cnt--;

					// 장바구니에 있는 log 삭제
					int delCnt = 0;
					for (int i = 0; i < size; i++) {
						if (jang[i][0] == log)
							delCnt++;
					}
					int[][] temp = jang;
					jang = new int[size - delCnt][];

					idx = 0;
					for (int i = 0; i < size; i++) {
						int tempLog = jang[i][0];
						if (tempLog != log) {
							if (tempLog > log)
								temp[i][0]--;
							jang[idx] = temp[i];
							idx++;
						}
					}
					size -= delCnt;
					log = -1;
					System.out.println("탈퇴완료");
				} else
					System.out.println("비밀번호가 불일치 합니다.");
			} else if (sel == 3) {

				System.out.print("id : ");
				String id = scan.next();
				System.out.print("pw : ");
				String pw = scan.next();

				for (int i = 0; i < cnt; i++) {
					if (ids[i].equals(id) && pws[i].equals(pw))
						log = i;
				}
				if (log == -1) {
					System.out.println("회원정보를 다시 확인해주세요.");
				} else {
					System.out.printf("%s님 환영합니다.", ids[log]);
				}
			} else if (sel == 4) {
				log = -1;
				System.out.println("탈퇴 완료");
			} else if (sel == 5) {
				// 쇼핑

				while (true) {
					for (int i = 0; i < items.length; i++) {
						System.out.printf("%d) %s\n", i + 1, items[i]);
					}

					System.out.print("상품 선택 : ");
					int itemNum = scan.nextInt();

					// 종료
					if (itemNum == 0)
						break;

					if (itemNum < 1 || itemNum > items.length)
						continue;

					int[][] temp = jang;
					jang = new int[size + 1][];

					for (int i = 0; i < size; i++)
						jang[i] = temp[i];

					jang[size] = new int[2];
					jang[size][0] = log;
					jang[size][1] = itemNum;
					size++;
				}
			} else if (sel == 6) {
				// 장바구니 조회
				// 소계
				int[] itemCnt = new int[items.length];

				boolean isEmpty = true;
				for (int i = 0; i < size; i++) {
					if (jang[i][0] == log) {
						int itemIdx = jang[i][1] - 1;
						itemCnt[itemIdx]++;
						isEmpty = false;
					}
				}
				System.out.printf("=== %s님의 장바구니 내역 ===\n", ids[log]);
				for (int i = 0; i < items.length; i++) {
					if (itemCnt[i] > 0)
						System.out.printf("%s %d개\n", items[i], itemCnt[i]);
				}
				if (isEmpty) {
					System.out.println("텅-");
				}

			}

		}

	}

}
