package lv05practice;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Practice31 {

	// SHOP
	// 1547

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[][] jang = null;
		int jangCnt = 0;

		String[] items = { "사과", "바나나", "딸기" };
		int itemCnt = 3;

		String[] ids = {"admin"};
		String[] pws = {"1234"};
		int count = 1;
		int log = -1;

		String jangFileName = "jangFile2.txt";
		String userFileName = "userFile2.txt";

		File jangFile = new File(jangFileName);
		File userFile = new File(userFileName);
		
		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		if(userFile.exists()) {
			
			String data = "";
			
			try {
				
				fr = new FileReader(userFileName);
				br = new BufferedReader(fr);
				
				while(br.ready()) {
					data += br.readLine() + "\n";
					count ++;
				}
				
				br.close();
				fr.close();
				System.out.println("유저 파일 로드 완료");
				
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("유저 파일 로드 실패");
			}
			String[] temp = data.split("\n");
			
			count = temp.length;
			
			ids = new String[count];
			pws = new String[count];
			
			for(int i=0; i<count; i++) {
				String[] info = temp[i].split("/");
				
				ids[i] = info[0];
				pws[i] = info[1];
			}
			
		}else {
			System.out.println("유저 파일이 존재하지 않습니다.");
		}
		
		
		if(jangFile.exists()) {
			
			String data = "";
			
			try {
				
				fr = new FileReader(jangFile);
				br = new BufferedReader(fr);
				
				items = br.readLine().split(",");
				itemCnt = items.length;
				
				while(br.ready()) {
					data += br.readLine() + "\n";
					jangCnt++;
				}
				br.close();
				fr.close();
				System.out.println("장바구니 파일 로드 완료");
				
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("장바구니 파일 로드 실패");
			}
			
			jang = new int[jangCnt][2];
			String[] temp = data.split("\n");
			
			for(int i=0; i<jangCnt; i++) {
				String[] info = temp[i].split("/");
				
				jang[i][0] = Integer.parseInt(info[0]);
				jang[i][1] = Integer.parseInt(info[1]);
				
			}
		}else {
			System.out.println("장바구니 파일이 존재하지 않습니다.");
		}
		
		
		
		
		

		while (true) {
			
			boolean isUserUpdate = false;
			boolean isJangUpdate = false;
			
			System.out.println(Arrays.toString(ids));
			System.out.println(Arrays.toString(pws));
			System.out.println(Arrays.toString(items));
			for(int i=0; i<jangCnt; i++) {
				System.out.println(Arrays.toString(jang[i]));
			}
			
			System.out.println("SHOP");
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
					continue;
				}
				
				isUserUpdate = true;

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
							if(tempJang[i][0] > log)
								tempJang[i][0]--;
							jang[idx] = tempJang[i];
							idx++;
						}
					}

					jangCnt -= delCnt;
					log = -1;
					System.out.println("회원탈퇴 완료");
				} else {
					System.out.println("비밀번호가 불일치 합니다.");
					continue;
				}
				
				isUserUpdate = true;
				isJangUpdate = true;

			} else if (sel == 3) {

				System.out.print("id : ");
				String id = scan.next();
				System.out.print("pw : ");
				String pw = scan.next();

				for (int i = 0; i < count; i++) {
					if (ids[i].equals(id) && pws[i].equals(pw)) {
						log = i;
					}
				}
				if (log == -1) {
					System.out.println("회원정보를 다시 확인해 주세요.");
					continue;
				} else {
					System.out.printf("%s님 환영합니다~!", ids[log]);
				}

			} else if (sel == 4) {

				log = -1;
				System.out.println("로그아웃 완료");
			} else if (sel == 5) {

				while (true) {

					for (int i = 0; i < itemCnt; i++) {
						System.out.printf("%d) %s\n", i + 1, items[i]);
					}

					System.out.println("0) 뒤로가기");
					System.out.print("아이템 선택(번호) : ");
					int itemNum = scan.nextInt();

					if (itemNum == 0)
						break;

					if (itemNum < 1 || itemNum > itemCnt)
						continue;

					int[][] tempJang = jang;
					jang = new int[jangCnt + 1][];
					
					for(int i=0; i<jangCnt; i++)
						jang[i] = tempJang[i];

					jang[jangCnt] = new int[2];
					jang[jangCnt][0] = log;
					jang[jangCnt][1] = itemNum;
					jangCnt++;
				}
				
				isJangUpdate = true;

			} else if (sel == 6) {

				// 소계 출력용 item count
				int[] tempCnt = new int[itemCnt];
				
				for(int i=0; i<jangCnt; i++) {
					if(jang[i][0] == log)
						tempCnt[jang[i][1] -1] ++;
				}

				for (int i = 0; i < itemCnt; i++) {
					if (tempCnt[i] > 0)
						System.out.printf("%s) %d\n", items[i], tempCnt[i]);
				}

			} else if (sel == 7) {

				while (true) {

					System.out.println("0) 뒤로가기");
					System.out.println("1) 아이템 추가");
					System.out.println("2) 아이템 삭제");
					int subSel = scan.nextInt();

					if (subSel == 0)
						break;

					if (subSel == 1) {

						System.out.print("추가할 아이템 : ");
						String itemName = scan.next();

						boolean isDupl = false;
						for (int i = 0; i < itemCnt; i++) {
							if (items[i].equals(itemName))
								isDupl = true;
						}
						if (!isDupl) {
							String[] tempItems = items;
							items = new String[itemCnt + 1];

							for (int i = 0; i < itemCnt; i++)
								items[i] = tempItems[i];

							items[itemCnt] = itemName;
							itemCnt++;
						} else {
							System.out.println("중복이름이 존재합니다.");
							continue;
						}

					} else if (subSel == 2) {

						for (int i = 0; i < itemCnt; i++)
							System.out.printf("%d) %s\n", i + 1, items[i]);

						System.out.print("삭제할 아이템 번호 : ");
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

						// 장바구니 내역 삭제
						int delCnt = 0;
						for (int i = 0; i < jangCnt; i++) {
							if (jang[i][1] == delIdx + 1)
								delCnt++;
						}

						int[][] tempJang = jang;
						jang = new int[jangCnt - delCnt][];

						idx = 0;
						for (int i = 0; i < jangCnt; i++) {
							if (tempJang[i][1] > delIdx + 1)
								tempJang[i][1]--;
							if (tempJang[i][1] != delIdx + 1) {
								jang[idx] = tempJang[i];
								idx++;
							}
						}
						jangCnt -= delCnt;
					}
					
					isJangUpdate = true;
				}

			} else if (sel == 0) {
				
				System.out.println("프로그램 종료");
				break;
			}
			
			if(isUserUpdate) {
				
				String data = "";
				
				for(int i=0; i<count; i++) {
					data += ids[i] + "/" + pws[i];
					if(i < count - 1)
						data += "\n";
				}
				
				try {
					
					fw = new FileWriter(userFileName);
					fw.write(data);
					fw.close();
					
					System.out.println("유저 파일저장 완료");
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("유저 파일저장 완료");
				}
			}
			
			if(isJangUpdate) {
				
				String data = "";
				
				for(int i=0; i<itemCnt; i++) {
					data += items[i];
					if(i < itemCnt - 1)
						data += ",";
				}
				data += "\n";
				
				for(int i=0; i<jangCnt; i++) {
					data += jang[i][0] + "/" + jang[i][1];
					if(i < jangCnt-1)
						data += "\n";
				}
				
				try {
					
					fw = new FileWriter(jangFileName);
					fw.write(data);
					fw.close();
					System.out.println("장바구니 파일저장 완료");
					
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("장바구니 파일저장 실패");
				}
				
			}
			
			
			

		}

	}

}
