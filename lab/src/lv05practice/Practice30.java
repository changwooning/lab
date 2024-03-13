package lv05practice;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Practice30 {

	// # ATM
	// 1425

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String[] ids = null;
		String[] pws = null;
		int[] money = null;

		int count = 0;
		int log = -1;

		String fileName = "atm2.txt";

		File file = new File(fileName);
		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br = null;

		while (true) {

			System.out.println("ATM");
			System.out.println("1.회원가입");
			System.out.println("2.회원탈퇴");
			System.out.println("3.로그인");
			System.out.println("4.로그아웃");
			System.out.println("5.입금");
			System.out.println("6.출금");
			System.out.println("7.이체");
			System.out.println("8.잔액조회");
			System.out.println("9.저장");
			System.out.println("10.로드");
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
					int[] tempMoney = money;

					ids = new String[count + 1];
					pws = new String[count + 1];
					money = new int[count + 1];

					for (int i = 0; i < count; i++) {
						ids[i] = tempIds[i];
						pws[i] = tempPws[i];
						money[i] = tempMoney[i];
					}

					ids[count] = id;
					pws[count] = pw;
					money[count] = 1000;
					count++;
					System.out.println("회원가입 완료!");
				} else {
					System.out.println("중복계정이 존재합니다.");
					continue;
				}

			} else if (sel == 2) {

				System.out.print("비밀번호 재확인 : ");
				String pw = scan.next();

				if (pws[log].equals(pw)) {
					String[] tempIds = ids;
					String[] tempPws = pws;
					int[] tempMoney = money;

					ids = new String[count - 1];
					pws = new String[count - 1];
					money = new int[count - 1];

					int idx = 0;
					for (int i = 0; i < count; i++) {
						if (i != log) {
							ids[idx] = tempIds[i];
							pws[idx] = tempPws[i];
							money[idx] = tempMoney[i];
							idx++;
						}
					}
					count--;
					System.out.println("회원탈퇴완료");
				} else {
					System.out.println("비밀번호 불일치 합니다.");
					continue;
				}

			} else if (sel == 3) {

				System.out.print("id : ");
				String id = scan.next();
				System.out.print("pw : ");
				String pw = scan.next();

				for (int i = 0; i < count; i++) {
					if (ids[i].equals(id) && pws[i].equals(pw))
						log = i;
				}
				if (log == -1) {
					System.out.println("회원정보를 다시 입력해주세요.");
					continue;
				} else
					System.out.printf("%s님 환영합니다.", ids[log]);
			} else if (sel == 4) {

				log = -1;
				System.out.println("로그아웃 완료");

			} else if (sel == 5) {

				System.out.print("입금 금액 : ");
				int moneys = scan.nextInt();

				if (moneys > 0) {
					money[log] += moneys;
					System.out.println("입금 완료");
				}
			} else if (sel == 6) {

				System.out.print("출금 금액 : ");
				int moneys = scan.nextInt();

				if (moneys > 0 || money[log] >= moneys) {
					money[log] -= moneys;
					System.out.println("출금 완료");
				}

			} else if (sel == 7) {

				System.out.print("이체할 계좌 : ");
				String acc = scan.next();
				System.out.print("이체할 금액 : ");
				int moneys = scan.nextInt();

				int idx = -1;
				for (int i = 0; i < count; i++) {
					if (ids[i].equals(acc))
						idx = i;
				}

				if (log == idx) {
					System.out.println("본인 계좌로는 입금이 불가능합니다.");
					continue;
				}

				if (moneys < 1) {
					System.out.println("입금 금액은 1원이상이여야 합니다.");
					continue;
				}

				if (money[log] < moneys) {
					System.out.println("금액이 부족합니다.");
					continue;
				}

				money[log] -= moneys;
				money[idx] += moneys;
				System.out.println("이체 완료");

			} else if (sel == 8) {

				System.out.printf("%s님의 현재 잔액은 %d원입니다.", ids[log], money[log]);

			} else if (sel == 9) {

				String data = "";

				for (int i = 0; i < count; i++) {
					data += ids[i] + "/" + pws[i] + "/" + money[i];
					if (i < count - 1)
						data += ",";
				}

				try {

					fw = new FileWriter(file);
					fw.write(data);
					fw.close();
					System.out.println("파일 저장 완료");

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("파일 저장 실패");
				}

			} else if (sel == 10) {

				String data = "";

				try {		// 오류가 나면 실행이 아예 안되고 오류가 나면 그부분만 실행이 안되고 나머지는 에러 
					fr = new FileReader(file);
					br = new BufferedReader(fr);

					while (br.ready()) {
						data += br.readLine();
					}
					br.close();
					fr.close();

					System.out.println("파일 로드 완료");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("파일 로드 실패");
				}
				String[] temp = data.split(",");
				
				count = temp.length;
				
				ids = new String[count];
				pws = new String[count];
				money = new int[count];
				
				for (int i = 0; i < count; i++) {
					String[] info = temp[i].split("/");
					
					ids[i] = info[0];
					pws[i] = info[1];
					money[i] = Integer.parseInt(info[2]);
				}

			} else if (sel == 0) {

				System.out.println("프로그램을 종료합니다.");
				break;
			}

		}

	}

}
