package lv03;

import java.util.Scanner;

public class Ex36 {

	// # 회원가입
	// 1. 가입
	// . 아이디와 비밀번호를 입력받아 가입
	// . 아이디 중복검사
	// 2. 탈퇴
	// . 아이디를 ㄹ입력 받아 탈퇴
	//

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] ids = { 1001, 1002, 0, 0, 0 };
		// int[] ids = {1001,1002,0,0,0}; 1001이 탈퇴시
		int[] pws = { 1111, 2222, 0, 0, 0 };
		// int[] pws = {1111,2222,0,0,0}; 1001이 탈퇴시

		int cnt = 2;

		while (true) {
			for (int i = 0; i < 5; i++) {
				System.out.printf("%d) %d/%d\n", i + 1, ids[i], pws[i]);
			}
			System.out.println("1) 가입");
			System.out.println("2) 탈퇴");

			System.out.println("선택 : ");
			int sel = scan.nextInt();

			if (sel == 1) {
				if (cnt == 5) {

					System.out.println("가입 정원이 마감되었습니다.");
					continue;
				}
				System.out.print("id : ");
				int id = scan.nextInt();
				System.out.print("pw : ");
				int pw = scan.nextInt();

				// 사용자가 입력한 id가 중복여부 확인 => 아주 중요한 부분 앞으로 많이 사용
				int index = -1;
				for (int i = 0; i < cnt; i++) {
					if (ids[i] == id)
						index = i;
				}
				// 가입처리
				if (index == -1) {
					ids[cnt] = id;
					pws[cnt] = pw;
					cnt++;
					System.out.println("가입완료");
				} else
					System.out.println("이미 사용중인 아이디입니다.");

			} else if (sel == 2) {
				System.out.print("id : ");
				int id = scan.nextInt();
				System.out.print("pw : ");
				int pw = scan.nextInt();

				int index = -1;
				for (int i = 0; i < cnt; i++) {
					if (ids[i] == id && pws[i] == pw)
						index = i;
				}
				// 탈퇴처리
				if (index != -1) {
					for (int i = index; i < cnt - 1; i++) {
						ids[i] = ids[i + 1];
						pws[i] = pws[i + 1];
					}
					ids[cnt - 1] = 0;
					pws[cnt - 1] = 0;
					cnt--;

					System.out.println("탈퇴 완료");
				} else
					System.out.print("회원정보가 잘못되었습니다.");

			}

			System.out.println();
		}

	}

}
