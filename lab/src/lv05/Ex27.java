package lv05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Ex27 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		final int SIZE = 5;
		int count = 0;
		int log = -1;

		String[] accs = new String[SIZE];
		String[] pws = new String[SIZE];
		int[] moneys = new int[SIZE];

		String fileName = "atm.txt";
		File file = new File(fileName);
		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br = null;

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

			if (sel == 1 && log == -1) {
				// 회원가입
				if (count == SIZE) {
					System.out.println("더 이상 회원가입이 불가합니다.");
				}
				System.out.print("id : ");
				String id = scan.next();
				System.out.print("pw : ");
				String pw = scan.next();

				// 중복예외처리
				boolean isDupl = false;
				for (int i = 0; i < count; i++) {
					if (id.equals(accs[i]))
						isDupl = true;
				}
				if (!isDupl) {
					String[] accsTemp = accs;
					String[] pwsTemp = pws;
					int[] moneysTemp = moneys;

					accs = new String[count + 1];
					pws = new String[count + 1];
					moneys = new int[count + 1];

					for (int i = 0; i < count; i++) {
						accs[i] = accsTemp[i];
						pws[i] = pwsTemp[i];
						moneys[i] = moneysTemp[i];
					}
					accs[count] = id;
					pws[count] = pw;
					moneys[count] = 1000;
					System.out.println("회원 가입 완료!");
				} else {
					System.out.print("중복된 계정입니다.");
				}

			} else if (sel == 2 && log != -1) {

			} else if (sel == 3 && log == -1) {
				System.out.print("id : ");
				String id = scan.next();
				System.out.print("pw : ");
				String pw = scan.next();

				for (int i = 0; i < count; i++) {
				}

			} else if (sel == 4 && log != -1) {
			} else if (sel == 5 && log != -1) {
			} else if (sel == 6 && log != -1) {

				System.out.println("출금 금액 : ");
				int money = scan.nextInt();

				if (moneys[log] >= money && money > 0) {
					moneys[log] -= money;
					System.out.println("출금와뇰");
				}

			} else if (sel == 7 && log != -1) {
				System.out.println("이체할 계좌 : ");
				String acc = scan.next();
				System.out.println("이체할 금액 : ");
				int money = scan.nextInt();

				int targetIdx = -1;
				for (int i = 0; i < count; i++) {
					if (acc.equals(accs[i])) {
						targetIdx = i;
					}
				}
				if (targetIdx == log) {
					System.out.println("본인 계좌로의 이체는 불가합니다.");
				}
				if (money < 1) {
					System.out.println("이체 가능한 금액이 아닙니다.");
				}
				if (moneys[log] < money) {
					System.out.println("잔액이 부족합니다.");
				}
				moneys[log] -= money;
				moneys[targetIdx] += money;
				System.out.println("이체완료");

			} else if (sel == 8 && log != -1) {

				System.out.printf("현재 %s님의 계좌 잔액은 %d원입니다.", accs[log], moneys[log]);

			} else if (sel == 9) {
				// 저장

				// acc/pw/moneys

				String data = "";
				for (int i = 0; i < count; i++) {
					String acc = accs[i];
					String pw = pws[i];
					int money = moneys[i];

					data += acc + "/" + pw + "/" + money;

					if (i < count - 1)
						data += "\n";
				}

				try {
					fw = new FileWriter(file);
					fw.write(data);
					fw.close();
					System.out.println("파일쓰기 성공");

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("파일쓰기 실패");
				}

			} else if (sel == 10) {

				accs = new String[SIZE];
				pws = new String[SIZE];
				moneys = new int[SIZE];

				count = 0;

				if (file.exists()) {

					try {
						fr = new FileReader(file);
						br = new BufferedReader(fr);

						while (br.ready()) {
							String[] info = br.readLine().split("/");

							accs[count] = info[0];
							pws[count] = info[1];
							moneys[count] = Integer.parseInt(info[2]);
							count++;

						}

						br.close();
						fr.close();
						System.out.println("파일읽기 성공");

					} catch (Exception e) {
						System.out.println("파일읽기 실패");

					}

				} else {
					System.out.println("파일이 존재하지 않습니다.");
				}

			}

		}

	}

}
