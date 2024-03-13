package lv05practice;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Practice29 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[][] jang = null;
		int jangCnt = 0;

		String[] ids = { "admin" };
		String[] pws = { "1234" };
		int count = 1;

		int itemCnt = 3;
		String[] items = { "사과", "바나나", "딸기" };

		int log = -1;

		String jangFileName = "jang2.txt";
		String userFileName = "user2.txt";

		File jangFile = new File(jangFileName);
		File userFile = new File(userFileName);
		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br = null;

		while (true) {

			System.out.println("shop");
			System.out.println("1.회원가입");
			System.out.println("2.회원탈퇴");
			System.out.println("3.로그인");
			System.out.println("4.로그아웃");
			System.out.println("5.쇼핑");
			System.out.println("6.장바구니");
			System.out.println("7.관리자");
			System.out.println("0.종료");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			if (sel == 1) {

				System.out.print("id : ");
				String id = scan.next();
				System.out.print("pw : ");
				String pw = scan.next();

				boolean isDupl = false;
				for (int i = 0; i < count; i++) {
					if (ids[i].equals(id))
						isDupl = true;
				}
				if (!isDupl) {
					String[] tempIds = ids;
					String[] tempPws = pws;

					ids = new String[count + 1];
					pws = new String[count + 1];

					for (int i = 0; i < count; i++) {
						ids[i] = tempIds[i];
						pws[i] = tempPws[i];
					}
					ids[count] = id;
					pws[count] = pw;
					count++;
					System.out.println("회원가입완료");
				} else {
					System.out.println("중복계정이 존재합니다.");
				}

			} else if (sel == 2) {

				System.out.print("비밀번호 재확인 : ");
				String pw = scan.next();

				if (pws[log].equals(pw)) {
					String[] tempIds = ids;
					String[] tempPws = pws;

					ids = new String[count - 1];
					pws = new String[count - 1];

					int idx = 0;
					for (int i = 0; i < count; i++) {
						if (i != log) {
							ids[idx] = tempIds[i];
							pws[idx] = tempPws[i];
							idx++;
						}
					}
					count--;

					// 장바구니 내역 삭제
					int delCnt = 0;
					for (int i = 0; i < jangCnt; i++) {
						if (jang[i][0] == log)
							delCnt++;
					}

					int[][] tempJang = jang;
					jang = new int[jangCnt - delCnt][];

					idx = 0;
					for (int i = 0; i < jangCnt; i++) {
						if (tempJang[i][0] != log) {
							if (tempJang[i][0] > log)
								tempJang[i][0] -= 1;
							jang[idx] = tempJang[i];
							idx++;
						}
					}

					jangCnt -= delCnt;
					log = -1;

				}

			} else if (sel == 3) {
			} else if (sel == 4) {
			} else if (sel == 5) {

				while (true) {

					for (int i = 0; i < itemCnt; i++) {
						System.out.printf("%d) %s\n", i + 1, items[i]);
					}
					System.out.print("아이템 번호선택 : ");
					int itemIdx = scan.nextInt();

					if (itemIdx == 0)
						break;

					if (itemIdx < 1 || itemIdx > itemCnt)
						continue;

					int[][] tempJang = jang;
					jang = new int[jangCnt + 1][];

					for (int i = 0; i < jangCnt; i++) {
						jang[i] = tempJang[i];
					}

					jang[jangCnt] = new int[2];
					jang[jangCnt][0] = log;
					jang[jangCnt][1] = itemIdx;
					jangCnt++;

				}

			} else if (sel == 6) {

				// 소계
				int[] tempCnt = new int[itemCnt];		// 

				for (int i = 0; i < jangCnt; i++) {
					if (jang[i][0] == log)
						tempCnt[jang[i][1] - 1]++;	//	인덱스 번호를 하나 줄임 쇼핑에서 인덱스 번ㅎ
				}

				// 소계 출력
				for (int i = 0; i < itemCnt; i++) {
					if (tempCnt[i] > 0)
						System.out.printf("%s) %d개\n", items[i], tempCnt[i]);
				}

			} else if (sel == 7) {

				while (true) {

					System.out.println("아이템 추가");
					System.out.println("아이템 삭제");
					int subSel = scan.nextInt();

					if (subSel == 1) {

						System.out.println("추가할 아이템");
						String itemName = scan.next();

						boolean isDupl = false;
						for (int i = 0; i < itemCnt; i++) {
							if (items[i].equals(itemName))
								isDupl = true;
						}

						if (isDupl) {
							System.out.println("중복이름이 존재합니다.");
							continue;
						}

						String[] tempItems = items;
						items = new String[itemCnt + 1];

						for (int i = 0; i < itemCnt; i++)
							items[i] = tempItems[i];

						items[itemCnt] = itemName;
						itemCnt++;
						System.out.println("아이템 추가완료");
					} else if (subSel == 2) {

						for (int i = 0; i < itemCnt; i++)
							System.out.printf("%d) %s\n", i + 1, items[i]);

						System.out.println("삭제할 아이템 번호 : ");
						int delIdx = scan.nextInt() - 1;

						if (delIdx < 0 || delIdx > itemCnt - 1)
							continue;

						String[] tempItems = items;
						items = new String[itemCnt - 1];

						int idx = 0;
						for (int i = 0; i < itemCnt; i++) {
							if (i != delIdx) {
								items[idx] = tempItems[i];
								idx++;
							}
						}

						itemCnt--;

						// 장바구니 내역 정리
						int delCnt = 0;
						for (int i = 0; i < jangCnt; i++) {
							if (jang[i][1] == delIdx + 1)
								delCnt++;
						}

						int[][] tempJang = jang;
						jang = new int[jangCnt - delCnt][];

						idx = 0;
						for (int i = 0; i < jangCnt; i++) {
							if (tempJang[i][1] == delIdx + 1)
								tempJang[i][1] -= 1;
							if (tempJang[i][1] != delIdx + 1) {
								jang[idx] = tempJang[i];
								idx++;
							}
						}

						jangCnt -= delCnt;

					}

				}

			} else if (sel == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}

		}

	}

}
