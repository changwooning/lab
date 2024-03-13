package lv03test;

import java.util.Scanner;

public class Test304 {

	// lv Test 3

	// 회원가입
	// 1. 가입
	// 아이디와 비밀번호를 입력받아 가입
	// 아이디 중복검사
	// 2. 탈퇴
	// 아이디와 비밀번호 입력받아 탈퇴
	// 탈퇴 시 비어있는 인덱스까지 값 당기기

	// 0212
	// 0233

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		final int MAX = 5;
		int cnt = 0;

		int[] ids = new int[MAX];
		int[] pws = new int[MAX];

		while (true) {

			// 출력
			for (int i = 0; i < MAX; i++) {
				System.out.printf("%d) %d/%d\n", i + 1, ids[i], pws[i]);
			}

			System.out.println("1.가입");
			System.out.println("2.탈퇴");

			System.out.print("선택 : ");
			int sel = scan.nextInt();

			if (sel == 1) {
				if (cnt == 5) {
					System.out.println("가입정원이 마감되었습니다.");
					continue;
				}

				// 입력
				System.out.print("id : ");
				int id = scan.nextInt();
				System.out.print("pw : ");
				int pw = scan.nextInt();

				// 중복확인
				int idx = -1;

				// 가입처리
				if (idx == -1) {
					ids[cnt] = id;
					pws[cnt] = pw;
					cnt++;
					System.out.println("가입완료");
				} else
					System.out.println("이미 사용중인 회원입니다.");

			} else if (sel == 2) {
				System.out.print("id : ");
				int id = scan.nextInt();
				System.out.print("pw : ");
				int pw = scan.nextInt();

				// 예외
				int idx = -1;
				for (int i = 0; i < cnt; i++) {
					if (ids[i] == id && pws[i] == pw)
						idx = i;
				}

				// 탈퇴처리
				if (idx != -1) {
					for (int i = idx; i < cnt - 1; i++) {
						ids[i] = ids[i + 1];
						pws[i] = pws[i + 1];
					}
					ids[cnt - 1] = 0;
					pws[cnt - 1] = 0;
					cnt--;
					System.out.println("탈퇴완료");
				} else
					System.out.println("회원정보가 잘못되었습니다.");

			}

		}

	}

}
