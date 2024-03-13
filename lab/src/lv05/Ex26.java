package lv05;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;

public class Ex26 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int size = 5;
		int count = 0;
		int log = -1;

		String[] accs = new String[size];
		String[] pws = new String[size];
		int[] moneys = new int[size];

		String fileName = "atm.txt";
		File file = new File(fileName);
		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br = null;
		String data = "";
		

		while (true) {
			System.out.println(Arrays.toString(accs));
			System.out.println(Arrays.toString(pws));
			System.out.println(Arrays.toString(moneys));

			System.out.println("ATM");
			System.out.println("[1]회원가입");
			System.out.println("[2]회원탈퇴");
			System.out.println("[3]로그인");
			System.out.println("[4]로그아웃");
			System.out.println("[5]입금");
			System.out.println("[6]출금");
			System.out.println("[7]이체");
			System.out.println("[8]잔액조회");
			System.out.println("[9]저장");
			System.out.println("[10]로드");
			System.out.println("[0]종료");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			if (log == -1 && (sel == 2 || sel == 4 || sel == 5 || sel == 6 || sel == 7 || sel == 8)) {
				System.out.println("로그인 후 이용가능합니다.");
				continue;
			} else if (log != -1 && (sel == 1 || sel == 3)) {
				System.out.println("로그아웃 후 이용가능합니다.");
				continue;
			}

			if (sel == 1) {

				System.out.print("id : ");
				String id = scan.next();
				System.out.print("pw : ");
				String pw = scan.next();

				boolean isDupl = false;
				for (int i = 0; i < count; i++) {
					if (accs[i].equals(id)) {
						isDupl = true;
					}

				}
				if (!isDupl) {
					accs[count] = id;
					pws[count] = pw;
					moneys[count] = 0;
					count++;
					System.out.println("회원가입 완료");
				} else {
					System.out.println("중복된 아이디입니다.");
					continue;
				}
			} else if (sel == 2) {
				// 회원탈퇴
				System.out.print("비밀번호 재입력 : ");
				String pw = scan.next();

				if (pws[log].equals(pw)) {
					for (int i = log; i < count; i++) {
						accs[i] = accs[i + 1];
						pws[i] = pws[i + 1];
						moneys[i] = moneys[i + 1];
						count--;
						log = -1;
						System.out.println("탈퇴 완료");
					}
				} else {
					System.out.println("비밀번호가 불일치 합니다.");
					continue;
				}
			} else if (sel == 3) {
				// 로그인
				System.out.print("id : ");
				String id = scan.next();
				System.out.print("pw : ");
				String pw = scan.next();

				for (int i = 0; i < count; i++) {
					if (accs[i].equals(id) && pws[i].equals(pw))
						log = i;
				}
				if (log == -1) {
					System.out.println("회원정보를 확인하세요.");
				} else {
					System.out.printf("%s님 환영합니다.", accs[log]);
				}
			} else if (sel == 4) {
				// 로그아웃
				log = -1;
				System.out.println("로그아웃 완료");
			} else if (sel == 5) {
				// 입금
				System.out.print("입금 금액 : ");
				int money = scan.nextInt();

				if (money > 0) {
					moneys[log] += money;
					System.out.println("입금 완료");
				} else {
					System.out.println("입금금액은 0원이상이여야 합니다.");
				}

			} else if (sel == 6) {
				// 출금
				System.out.print("출금 금액 : ");
				int money = scan.nextInt();

				if (money > 0 && money <= moneys[log]) {
					moneys[log] -= money;
					System.out.println("출금완료");
				}

			} else if (sel == 7) {

				// 이체
				System.out.print("이체할 계좌 : ");
				String acc = scan.next();

				int idx = -1;
				for (int i = 0; i < count; i++) {
					if (accs[i].equals(acc))
						idx = i;
				}
				if (idx != -1 && idx != log) {
					System.out.print("이체할 금액 : ");
					int money = scan.nextInt();

					if (money > 0 && money <= moneys[log]) {
						moneys[log] -= money;
						moneys[idx] += money;
						System.out.println("이체완료");
					} else {
						System.out.println("유효하지 않은 계좌입니다.");
					}
				}

			} else if (sel == 8) {
				// 잔액 조회
				System.out.printf("%s님의 잔액은 %d원입니다.", accs[log], moneys[log]);

			} else if (sel == 9) {
				// 저장
				String temp = "";

				for (int i = 0; i < count; i++) {
					temp += accs[i] + "/" + pws[i] + "/" + moneys[i];

					if (i < count - 1)
						temp += ",";
				}

				try {
					fw = new FileWriter(fileName);

					fw.write(temp);
					fw.close();
					System.out.println("저장완료");

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("저장실패");
				}

			} else if (sel == 10) {
				// 로드
				if (file.exists()) {
					try {
						fr = new FileReader(fileName);
						br = new BufferedReader(fr);

						while (br.ready()) {
							data += br.readLine();
						}
						br.close();
						fr.close();
						System.out.println("로드완료");
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("로드실패");
					}
					String[] temp = data.split(",");

					count = temp.length;

					accs = new String[size];
					pws = new String[size];
					moneys = new int[size];

					for (int i = 0; i < count; i++) {
						
						String[] temp2 = temp[i].split("/");
						accs[i] = temp2[0];
						pws[i] = temp2[1];
						moneys[i] = Integer.parseInt(temp2[2]);
					}
				} else {
					System.out.println("파일이 존재하지 않습니다.");
				}

			} else if (sel == 0) {
				System.out.println("시스템을 종료합니다.");
				break;
			}

		}

	}

}
