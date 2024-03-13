package lv04practice;

import java.util.Scanner;

public class Practice27 {

	// # 쇼핑몰[장바구니]

	// 2341

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String[] ids = null;
		String[] pws = null;

		int log = -1;
		int cnt = 0;
		int size = 0;

		int[][] jang = null;

		String[] items = { "사과", "바나나", "딸기" };

		while (true) {

			System.out.println("==MAGA MART==");
			System.out.println("1.회원가입");
			System.out.println("2.회원탈퇴");
			System.out.println("3.로 그 인");
			System.out.println("4.로그아웃");
			System.out.println("5.쇼   핑");
			System.out.println("6.장바구니");
			System.out.println("7,종   료");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			if (sel == 1 && log == -1) {
				// 회원가입

				// 1. 입력
				System.out.print("id : ");
				String id = scan.next();
				System.out.print("pw : ");
				String pw = scan.next();

				// 2. 중복처리

				boolean isDupl = false;
				for (int i = 0; i < cnt; i++) {
					if (ids[i].equals(id))
						isDupl = true;
				}
				if (!isDupl) {
					// 초기화
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
					System.out.println("회원가입 완료");
				} else
					System.out.println("중복 아이디가 존재합니다.");
			} else if (sel == 2 && log != -1) {
				// 회원탈퇴

				// 1. 입력
				System.out.print("비밀번호 재입력 : ");
				String pw = scan.next();

				if (pws[log].equals(pw)) {
					// 회원정보 삭제
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

				}

			} else if (sel == 3) {
				//로그인
				System.out.print("id : ");
				String id = scan.next();
				System.out.print("pw : ");
				String pw = scan.next();
				
				//중복검사
				
				
				
			} else if (sel == 4) {
			} else if (sel == 5) {
			} else if (sel == 6) {
			} else if (sel == 0) {
			}

		}

	}

}
