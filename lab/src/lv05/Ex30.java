package lv05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Ex30 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		final String ADMIN = "admin";
		final String MENUS = "24567";

		int jangCount = 0;
		int[][] jang = null; // {log,itemNum}

		int count = 1;
		String[] ids = { "admin" };
		String[] pws = { "1234" };

		int itemCount = 3;
		String[] items = { "사과", "바나나", "딸기" };

		String jangFileName = "jang2.txt";
		String userFileName = "user2.txt";

		File jangFile = new File(jangFileName);
		File userFile = new File(userFileName);

		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br = null;

		int log = -1;

		// 모든 파일을 로드 -> 각 배열에 정보 저장

		if (jangFile.exists()) {

			String data = "";

			try {
				fr = new FileReader(jangFile);
				br = new BufferedReader(fr);

				// 아이템 가져오기
				items = br.readLine().split("/"); // 첫 줄은 아이템들 (,)
				itemCount = items.length;

				while (br.ready()) {
					data += br.readLine() + "\n";
					jangCount++;
				}
				br.close();
				fr.close();

				System.out.println("장바구니 파일 로드 성공");
			} catch (Exception e) {
				System.out.println("장바구니 파일 로드 실패");
			}

			jang = new int[jangCount][2];

			String[] temp = data.split("\n");

			for (int i = 0; i < jangCount; i++) {
				String[] info = temp[i].split("/");

				jang[i][0] = Integer.parseInt(info[0]);
				jang[i][1] = Integer.parseInt(info[1]);
			}

		}
		if (userFile.exists()) {

			try {
				fr = new FileReader(userFile);
				br = new BufferedReader(fr);

				// 첫 줄에 count

				count = Integer.parseInt(br.readLine());

				ids = new String[count];
				pws = new String[count];

				for (int i = 0; i < count; i++) {
					String[] info = br.readLine().split("/");

					ids[i] = info[0];
					pws[i] = info[1];

				}

				br.close();
				fr.close();
				System.out.println("유저 파일 로드 성공");

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("유저 파일 로드 실패");

			}

		}

		while (true) {

			boolean isUserUpdate = false;
			boolean isJangUpdate = false;

			System.out.println("[SHOP]");
			System.out.println("[1]회원가입");
			System.out.println("[2]회원탈퇴");
			System.out.println("[3]로그인");
			System.out.println("[4]로그아웃");
			System.out.println("[5]쇼핑");
			System.out.println("[6]장바구니");
			System.out.println("[7]관리자"); // 아이템 추가,삭제
			System.out.println("[0]종료");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			// 로그상태에 대한 메뉴 선택 예외처리
			if (log == -1 && MENUS.contains(String.valueOf(sel))) {
				System.out.println("로그인 후 이용가능합니다.");
				continue;
			}
			if (sel != 0 && log != -1 && !MENUS.contains(sel + "")) {
				System.out.println("로그아웃 후 이용가능합니다.");
				continue;
			}

			if (sel == 1) {
				System.out.print("id: ");
				String id = scan.next();
				System.out.print("pw: ");
				String pw = scan.next();

				int idx = -1;
				for (int i = 0; i < count; i++) {
					if (id.equals(ids[i]))
						idx = i;
				}
				if (idx != -1) {
					System.out.println("중복계정이 존재합니다.");
					continue;
				}

				// add user
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
				isUserUpdate = true;

			} else if (sel == 2) {
				System.out.println("비밀번호 재입력 : ");
				String pw = scan.next();

				if (ids[log].equals(ADMIN)) {
					System.out.println("관리자 계정은 사측에 문의하세요.");
					continue;
				}

				if (!pw.equals(pws[log])) {
					System.out.println("패스워드가 일치하지 않습니다.");
					continue;
				}
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

				// 장바구니 내역 삭제
				int delCnt = 0;
				for (int i = 0; i < jangCount; i++) {
					if (jang[i][0] == log)
						delCnt++;
				}

				int[][] tempJang = jang;
				jang = new int[jangCount - delCnt][];

				idx = 0;
				for (int i = 0; i < jangCount; i++) {
					if (tempJang[i][0] != log) {
						if (tempJang[i][0] > log)
							tempJang[i][0] -= 1;
						jang[idx] = tempJang[i]; // 1차원 배열의 주소 복사
						idx++;
					}
				}
				jangCount -= delCnt;

				count--;
				log = -1;

				isUserUpdate = true;
				isJangUpdate = true;

			} else if (sel == 3) {
				System.out.print("id: ");
				String id = scan.next();
				System.out.print("pw: ");
				String pw = scan.next();

				for (int i = 0; i < count; i++) {
					if (id.equals(ids[i]) && pw.equals(pws[i]))
						log = i;
				}
				if (log == -1) {
					System.out.println("회원정보를 다시 확인하세요.");
				} else {
					System.out.printf("%s님 환영합니다.", ids[log]);
				}

			} else if (sel == 4) {
				log = -1;
				System.out.println("로그아웃 완료");
			} else if (sel == 5) {

				while (true) {
					for (int i = 0; i < itemCount; i++) {
						System.out.printf("%d) %s\n", i + 1, items[i]);
					}

					System.out.println("0) 뒤로가기");
					System.out.print("아이템 번호 선택 : ");
					int itemNum = scan.nextInt();

					if (itemNum == 0)
						break;

					if (itemNum < 1 || itemNum > itemCount)
						continue;

					// 구매이력을 jang에 기록
					int[][] tempJang = jang;
					jang = new int[jangCount+1][];

					for (int i = 0; i < jangCount; i++) {
						jang[i] = tempJang[i];
					}

					jang[jangCount] = new int[2];
					jang[jangCount][0] = log;
					jang[jangCount][1] = itemNum;
					jangCount++;

					isJangUpdate = true;
				}

			} else if (sel == 6) {
				// 소계 출력용 item count 배열 선언 & 초기화
				int[] tempCount = new int[itemCount];

				for (int i = 0; i < jangCount; i++) {
					int itemIdx = jang[i][1] - 1;
					if (jang[i][0] == log)
						tempCount[itemIdx]++;
				}

				// 소계 출력
				for (int i = 0; i < itemCount; i++) {
					if (tempCount[i] > 0)
						System.out.printf("%s) %d개\n", items[i], tempCount[i]);
				}

			} else if (sel == 7) {

				if (!ids[log].equals(ADMIN)) {
					System.out.println("관리자 계정만 이용가능합니다.");
					continue;
				}

				while (true) {
					System.out.println("1)아이템추가");
					System.out.println("2)아이템삭제");
					System.out.println("0)뒤로가기");
					System.out.print("선택 : ");
					int subSel = scan.nextInt();

					if (subSel == 0)
						break;

					if (subSel == 1) {
						System.out.print("아이템 명 : ");
						String itemName = scan.next();

						boolean isDupl = false;
						for (int i = 0; i < itemCount; i++) {
							if (itemName.equals(items[i])) {
								isDupl = true;
							}
						}

						if (isDupl) {
							System.out.println("중복이름이 존재합니다.");
							continue;
						}

						// 아이템 추가
						String[] tempItems = items;
						items = new String[itemCount + 1];

						for (int i = 0; i < itemCount; i++) 
							items[i] = tempItems[i];

						items[itemCount] = itemName;
						itemCount++;
						System.out.println("아이템 추가완료");
						isJangUpdate = true;
						

					} else if (subSel == 2) {
						for (int i = 0; i < itemCount; i++) {
							System.out.printf("%d) %s\n", i + 1, items[i]);

						}

						System.out.print("삭제할 아이템 번호 : ");
						int delIdx = scan.nextInt() - 1;

						if (delIdx < 0 || delIdx > itemCount - 1)
							continue;

						// 아이템 삭제
						String[] tempItems = items;
						items = new String[itemCount - 1];

						int idx = 0;

						for (int i = 0; i < itemCount; i++) {
							if (i != delIdx) {
								items[idx] = tempItems[i];
								idx++;
							}
						}
						itemCount--;

						// 장바구니 이력 정리
						int delCnt = 0;
						for (int i = 0; i < jangCount; i++) {
							if (jang[i][1] == delIdx + 1)
								delCnt++;
						}

						int[][] tempJang = jang;
						jang = new int[jangCount - delCnt][];

						idx = 0;
						for (int i = 0; i < jangCount; i++) {
							if (tempJang[i][1] > delIdx + 1)
								tempJang[i][1] -= 1;
							if (tempJang[i][1] != delIdx + 1) {
								jang[idx] = tempJang[i];
								idx ++;
							}
						}

						jangCount -= delCnt;
						isJangUpdate = true;

					}

				}

			} else if (sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}

			if (isUserUpdate) {
				String data = "";
				data += count + "\n";

				for (int i = 0; i < count; i++) {
					data += ids[i] + "/" + pws[i];
					if (i < count - 1)
						data += "\n";
				}

				try {
					fw = new FileWriter(userFile);
					fw.write(data);
					fw.close();

					System.out.println("유저파일저장완료");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("유저파일저장실패");
				}

			}
			if (isJangUpdate) {

				// 아이템명1/아이템명2
				// log/itemNum
				// log/itemNum
				// log/itemNum
				// log/itemNum

				// log/itemNum
				String data = "";

				for (int i = 0; i < itemCount; i++) {
					data += items[i];
					if (i < itemCount - 1)
						data += "/";
				}
				data += "\n";

				// 장바구니 내역 확장

				for (int i = 0; i < jangCount; i++) {
					data += jang[i][0] + "/" + jang[i][1];
					if (i < jangCount - 1)
						data += "\n";
				}
				
				try {
					fw = new FileWriter(jangFile);
					fw.write(data);
					fw.close();

					System.out.println("장바구니 파일 저장 완료");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("장바구니 파일 저장 실패");
				}

			}

		}

	}

}
