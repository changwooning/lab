package lv03practice;

import java.util.Scanner;

public class Practice63 {

	// 회원가입
	// 0152
	// 0208
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] ids = { 1001, 1002, 0, 0, 0 };
		int[] pws = { 1111, 2222, 0, 0, 0 };

		int cnt = 2;

		while (true) {
			// 출력
			for (int i = 0; i < 5; i++) {
				System.out.printf("%d) %d/%d\n", i + 1, ids[i], pws[i]);
			}

			System.out.println("1.가입");
			System.out.println("2.탈퇴");

			System.out.print("선택 : ");
			int sel = scan.nextInt();

			if (sel == 1) {
				if (cnt == 5) {
					System.out.print("가입정원이 마감되었습니다.");
				}

				// 입력
				System.out.print("id : ");
				int id = scan.nextInt();
				System.out.print("pw : ");
				int pw = scan.nextInt();

				// 중복처리
				int idx = -1;
				for (int i = 0; i < cnt; i++) {
					if (ids[i] == id)
						idx = i;
				}

				// 가입처리
				if (idx == -1) {
					ids[cnt] = id;
					pws[cnt] = pw;
					cnt++;
					System.out.println("가입완료");
				} else
					System.out.println("이미 사용중인 회원입니다.");

			} else if (sel == 2) {
				// 입력
				System.out.print("id : ");
				int id = scan.nextInt();
				System.out.print("pw : ");
				int pw = scan.nextInt();

				// 예외처리
				int idx = 0;
				for (int i = 0; i < 5; i++) {
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
					System.out.println("가입완료");
				} else
					System.out.println("회원정보가 잘못되었습니다.");
			}

		}

	}

}
