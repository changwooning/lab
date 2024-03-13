package lv05;

import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileWriter;

public class Ex28 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int jangCount = 0;
		int[][] jang = null; // {log,itemNum}

		int count = 1;
		String[] ids = { "admin" };
		String[] pws = { "1234" };

		int itemCount = 3;
		String[] items = { "사과", "바나나", "딸기" };

		String jangFileName = "jang.txt";
		String userFileName = "user.txt";

		File jangFile = new File(jangFileName);
		File userFile = new File(userFileName);

		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br = null;

		int log = -1;

		
		while (true) {

			System.out.println("[SHOP]");
			System.out.println("[1]회원가입");
			System.out.println("[2]회원탈퇴");
			System.out.println("[3]로그인");
			System.out.println("[4]로그아웃");
			System.out.println("[5]쇼핑");
			System.out.println("[6]장바구니");
			System.out.println("[7]관리자"); // 아이템 추가,삭제
			System.out.println("[8]저장");
			System.out.println("[9]로드");
			System.out.println("[0]종료");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			// 회원가입
			if (sel == 1 && log == -1) {
				System.out.print("id : ");
				String id = scan.next();
				System.out.print("pw : ");
				String pw = scan.next();

				// 중복처리
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
					System.out.println("회원가입 성공!");
				} else {
					System.out.println("중복된 계정이 존재합니다.");
					continue;
				}
			}
			// 회원탈퇴
			else if (sel == 2 && log != -1) {
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

					// 장바구니
					int delCnt = 0;
					for (int i = 0; i < jangCount; i++) {
						if (jang[i][0] == log)
							delCnt++;
					}
					int[][] temp = jang;
					jang = new int[jangCount - delCnt][];

					idx = 0;
					for (int i = 0; i < jangCount; i++) {
						int tempLog = temp[i][0];
						if (tempLog != log) {
							if (tempLog > log)
								temp[i][0]--;
							jang[idx] = temp[i];
							idx++;
						}
					}
					jangCount -= delCnt;
					log = -1;
					System.out.println("회원탈퇴 완료!");
				} else {
					System.out.println("비밀번호가 불일치 합니다.");
					continue;
				}

			}
			// 로그인
			else if (sel == 3 && log == -1) {
				System.out.print("id : ");
				String id = scan.next();
				System.out.print("pw : ");
				String pw = scan.next();

				for (int i = 0; i < count; i++) {
					if (id.equals(ids[i]) && pw.equals(pws[i]))
						log = i;
				}
				if (log == -1) {
					System.out.println("회원정보를 다시 확인해주세요.");
				} else {
					System.out.printf("%s님 환영합니다.", ids[log]);
				}

			}
			// 로그아웃
			else if (sel == 4 && log != -1) {
				log = -1;
				System.out.println("로그아웃 성공!");

			}
			// 쇼핑
			else if (sel == 5 && log != -1) {

				while (true) {

					for (int i = 0; i < items.length; i++) {
						System.out.printf("%d) %s\n", i + 1, items[i]);
					}

					System.out.print("상품 번호 : ");
					int itemNum = scan.nextInt();

					if (itemNum == 0)
						break;

					if (itemNum < 1 || itemNum > items.length) {
						System.out.println("번호 입력 오류");
					}

					int[][] temp = jang;
					jang = new int[jangCount + 1][];

					for (int i = 0; i < jangCount; i++)
						jang[i] = temp[i];

					jang[jangCount] = new int[2];
					jang[jangCount][0] = log;
					jang[jangCount][1] = itemNum;
					jangCount++;
				}

			}
			// 장바구니
			else if (sel == 6 && log != -1) {

				// 소계
				int[] itemCnt = new int[items.length];

				boolean isEmpty = true;
				for (int i = 0; i < jangCount; i++) {
					if (jang[i][0] == log) {
						int itemIdx = jang[i][1] - 1;
						itemCnt[itemIdx]++;
						isEmpty = false;
					}
				}
				System.out.printf("=== %s님의 장바구니 내역 ===\n", ids[log]);
				for (int i = 0; i < itemCnt.length; i++) {
					if (itemCnt[i] > 0) {
						System.out.printf("%s %d개\n", items[i], itemCnt[i]);
					}
				}
				if (isEmpty)
					System.out.println("텅텅-");

			}
			// 관리자
			else if (sel == 7 && log == -1) {

				System.out.print("admin id : ");
				String id = scan.next();
				System.out.print("admin pw : ");
				String pw = scan.next();
				if (id.equals(ids[0]) && pw.equals(pws[0]))
					log = 0;
				if(log != 0) {
					System.out.println("관리자 아이디가 아닙니다.");
					continue;
				}
				System.out.printf("%s관리자님 환영합니다.\n", ids[0]);

				// 아이템 추가
				System.out.println("아이템 추가");
				System.out.println("아이템 삭제");

				System.out.print("선택 : ");
				int sel2 = scan.nextInt();

				if (sel2 == 1) {
					// 아이템 추가
					for (int i = 0; i < items.length; i++) {
						System.out.printf("%d) %s\n", i + 1, items[i]);
					}

					System.out.print("추가할 아이템 : ");
					String item = scan.next();

					String[] tempItems = items;
					items = new String[itemCount + 1];

					for (int i = 0; i < itemCount; i++) {
						items[i] = tempItems[i];
					}

					items[itemCount] = item;
					itemCount++;
					System.out.println("아이템 추가완료!");
				} else if (sel2 == 2) {
					// 아이템 삭제
					for (int i = 0; i < itemCount; i++) {
						System.out.printf("%d) %s\n", i + 1, items[i]);
					}

					System.out.print("삭제할 아이템 번호 : ");
					int delItem = scan.nextInt() - 1;

					if (delItem < 0 || delItem > itemCount - 1) {
						System.out.println("번호 입력 오류");
					}
					String[] tempItems = items;
					items = new String[itemCount - 1];

					int idx = 0;
					for (int i = 0; i < itemCount; i++) {
						if (i != delItem) {
							items[idx] = tempItems[i];
							idx++;
						}
					}
					itemCount--;
					System.out.println("아이템 삭제완료");
				}

			}
			// 저장
			else if (sel == 8) {

				String data = "";
				for (int i = 0; i < count; i++) {
					data += ids[i] + "/" + pws[i];
					if (i < count - 1)
						data += ",";
				}

				try {
					fw = new FileWriter(userFile);
					fw.write(data);
					fw.close();
					System.out.println("파일저장 성공");
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("파일저장 실패");
				}
				
				String temp = "";
				for(int i=0; i<itemCount; i++) {
					temp += items[i] + "/";
				}
				temp = temp.substring(0,temp.length()-1);
					
				temp += "\n";
				for(int i=0; i<jangCount; i++) {
					temp += jang[i][0] + "/" + jang[i][1] + ",";
				}
				temp = temp.substring(0,temp.length()-1);
				
				try {
					fw = new FileWriter(jangFile);
					fw.write(temp);
					fw.close();
					System.out.println("파일저장 성공");
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("파일저장 성공");
				}
				
			}
			// 로드
			else if (sel == 9) {
				
				
				if(userFile.exists()) {
					
					String data = "";
					
					try {
						fr = new FileReader(jangFile);
						br = new BufferedReader(fr);
						
						while(br.ready()) {
							data += br.readLine();
							count++;
						}
						br.close();
						fr.close();
						System.out.println("로드완료");
						
					}catch(Exception e) {
						System.out.println("로드실패");
					}
					String[] temp = data.split(",");
					count = temp.length;
					
					ids = new String[count];
					pws = new String[count];
					for(int i=0; i<count; i++) {
						String[] temp2 = temp[i].split("/");
						ids[i] = temp2[0];
						pws[i] = temp2[1];
					}
					
				}else{
					System.out.println("파일이 존재하지 않습니다.");
				}
				
				
				
				
				

			}
			// 종료
			else if (sel == 0) {
				System.out.println("종료합니다.");
				break;
			}

		}

	}

}
