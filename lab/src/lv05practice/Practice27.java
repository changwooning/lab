package lv05practice;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

public class Practice27 {

	// # ATM
	// 1502
	// 1543

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		final int SIZE = 5;
		int count = 0;
		int log = -1;

		String[] accs = new String[SIZE];
		String[] pws = new String[SIZE];
		int[] money = new int[SIZE];

		String fileName = "atm.txt";
		File file = new File(fileName);
		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br = null;

		while (true) {

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

			System.out.print("선택 : ");
			int sel = scan.nextInt();

			// 회원가입
			if (sel == 1 && log == -1) {

				System.out.print("id : ");
				String id = scan.next();
				System.out.print("pw : ");
				String pw = scan.next();

				boolean isDupl = false;
				for (int i = 0; i < count; i++) {
					if (accs[i].equals(id))
						isDupl = true;
				}
				if (!isDupl) {
					String[] tempAccs = accs;
					String[] tempPws = pws;
					int[] tempMoney = money;

					accs = new String[count + 1];
					pws = new String[count + 1];
					money = new int[count + 1];

					for (int i = 0; i < count; i++) {
						accs[i] = tempAccs[i];
						pws[i] = tempPws[i];
						money[i] = tempMoney[i];
					}
					accs[count] = id;
					pws[count] = pw;
					money[count] = 1000;
					count++;
					System.out.println("회원가입완료!");
				} else {
					System.out.println("중복계정이 존재합니다.");
					continue;
				}

			}
			// 회원탈퇴
			else if (sel == 2 && log != -1) {

				System.out.print("비밀번호 재확인 : ");
				String pw = scan.next();

				if (pws[log].equals(pw)) {
					String[] tempAccs = accs;
					String[] tempPws = pws;
					int[] tempMoney = money;

					accs = new String[count - 1];
					pws = new String[count - 1];
					money = new int[count - 1];

					int idx = 0;
					for (int i = 0; i < count; i++) {
						if (i != log) {
							accs[idx] = tempAccs[i];
							pws[idx] = tempPws[i];
							money[idx] = tempMoney[i];
							idx++;
						}
					}
					count--;
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

				int idx = -1;
				for (int i = 0; i < count; i++) {
					if (accs[i].equals(id))
						idx = i;
				}
				if (log == -1) {
					System.out.println("회원정보를 다시 확인해 주세요.");
					continue;
				} else
					System.out.printf("환영합니다.%s님", accs[log]);

			}
			// 로그아웃
			else if (sel == 4 && log != -1) {

				log = -1;
				System.out.println("로그아웃 완료!");
			}

			// 입금
			else if (sel == 5 && log != -1) {

				System.out.print("입금 금액 : ");
				int moneys = scan.nextInt();

				if (moneys > 0) {
					money[log] += moneys;
					System.out.println("입금완료");
				} else {
					System.out.println("입금 금액은 1원이상이여야합니다.");
					continue;
				}

			}
			// 출금
			else if (sel == 6 && log != -1) {

				System.out.print("출금할 금액 : ");
				int moneys = scan.nextInt();

				if (moneys > 0 && money[log] >= moneys) {
					money[log] -= moneys;
					System.out.println("출금완료");
				} else {
					System.out.println("금액이 부족합니다.");
					continue;
				}
			}
			// 이체
			else if (sel == 7 && log != -1) {

				System.out.print("이체할 계좌 : ");
				String acc = scan.next();
				System.out.print("이체할 금액 : ");
				int moneys = scan.nextInt();

				int idx = -1;
				for (int i = 0; i < count; i++) {
					if (accs[i].equals(acc))
						idx = i;
				}

				if (idx == log) {
					System.out.println("본인계좌로는 이체할 수 없습니다.");
					continue;
				}

				if (moneys < 1) {
					System.out.println("이체 금액은 1원 이상이여야 합니다.");
					continue;
				}
				if (money[log] < moneys) {
					System.out.println("금액이 부족합니다.");
					continue;
				}

				money[log] -= moneys;
				money[idx] += moneys;
				System.out.println("이체완료");

			}
			// 잔액 조회
			else if (sel == 8 && log != -1) {

				System.out.printf("%s님의 현재 잔액은 %d원입니다.", accs[log], money[log]);

			}
			// 저장
			else if (sel == 9) {

				String data = "";

				for (int i = 0; i < count; i++) {

					data += accs[i] + "/" + pws[i] + "/" + money[i];
					if (i < count - 1)
						data += "\n";
				}

				try {

					fw = new FileWriter(fileName);
					fw.write(data);
					fw.close();
					System.out.println("파일저장 완료");

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("파일저장 실패");
				}

			}
			// 로드
			else if (sel == 10) {

				String data = "";
				count = 0;

				accs = new String[SIZE];		// 방을 만들어준다는 개념이네
				pws = new String[SIZE];
				money = new int[SIZE];

				if (file.exists()) {

					try {
						fr = new FileReader(fileName);
						br = new BufferedReader(fr);

						while (br.ready()) {
							
							
							String[] info = br.readLine().split("/");

							accs[count] = info[0];
							pws[count] = info[1];
							money[count] = Integer.parseInt(info[2]);
							count++;

						}
						br.close();
						fr.close();

						System.out.println("파일로드 완료");

					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("파일로드 완료");
					}
					
					
					
					
					
					
					
				}else {
					System.out.println("파일이 존재하지 않습니다,");
				}

			}
			// 종료
			else if (sel == 0) {
				System.out.println("시스템을 종료합니다.");
				break;
			}

		}

	}

}
