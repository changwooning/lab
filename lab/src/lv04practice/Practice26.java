package lv04practice;

import java.util.Scanner;

public class Practice26 {

	// # 쇼핑몰 [장바구니]
	// 1. 로그인 후 쇼핑 메뉴를 선택하면, 다음과 같이 상품목록을 보여준다.
	// 1) 사과
	// 2) 바나나
	// 3) 딸기
	// 2. 번호를 선택해 상품을 장바구니에 담을 수 있다.
	// 3. 로그인 회원의 인덱스 번호는 각 행의 첫번째 열에 저장한다.
	// 4. 해당 회원이 구매한 상품의 인덱스 번호는 각 행의 두번째 열에 저장한다.
	// 예)
	// {
	// {0,1}, qwer회원 >사과구매
	// {1,2}, javaking회원 >바나나구매
	// {2,1}, abcd회원 >사과구매
	// {0,3}, qwer회원 >딸기구매
	// ...
	// }
	//

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 아무것도 없는 상태
		String[] ids = null;
		String[] pws = null;

		int log = -1;
		int cnt = 0;
		int size = 0;

		int[][] jang = null;

		String[] items = { "사과", "바나나", "딸기" };

		while (true) {

			System.out.println("[MEGA MART]");
			System.out.println("[1]회원가입");
			System.out.println("[2]회원탈퇴");
			System.out.println("[3]로 그 인");
			System.out.println("[4]로그아웃");
			System.out.println("[5]쇼   핑");
			System.out.println("[6]장바구니");
			System.out.println("[0]종   료");

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
					if (id.equals(ids[i]))
						isDupl = true;
				}
				// 같지 않으면 초기화 저장이 가능한것
				if (!isDupl) {
					// 3. 초기화
					// 구 주소를 temp에 전달
					String[] tempIds = ids;
					String[] tempPws = pws;

					// 새 주소를 ids,pws에 초기화
					ids = new String[cnt + 1];
					pws = new String[cnt + 1];

					// 구 주소를 새주소에 복사
					for (int i = 0; i < cnt; i++) {
						ids[i] = tempIds[i];
						pws[i] = tempPws[i];
					}
					// 4. 회원처리
					ids[cnt] = id;
					pws[cnt] = pw;
					cnt++;
					System.out.println("회원가입 완료");
				} else
					System.out.println("중복 계정이 존재합니다.");
			} else if (sel == 2 && log != -1) {
				// 회원탈퇴
				// 1. 입력
				System.out.print("비밀번호 재확인 : ");
				String pw = scan.next();

				if (pws[log].equals(pw)) {
					// 회원정보 삭제
					// 구 주소를 temp 전달
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

					// 장바구니에 남아있는 log 삭제
					int delCnt = 0;
					for (int i = 0; i < size; i++) {
						if (jang[i][0] == log)
							delCnt++;
					}
					int[][] temp = jang;
					// 탈퇴한 회원 제외
					jang = new int[size - delCnt][];

					idx = 0;
					for (int i = 0; i < size; i++) {
						int tempLog = temp[i][0];
						if (tempLog != log) {
							// 기존 회원들의 log정보가 바뀌기 때문에
							// log 기준 뒤에 있던 인덱스 정보들을 -1씩 차감
							if (tempLog > log)
								temp[i][0]--;
							jang[idx] = temp[i];
							idx++;
						}
					}
					size -= delCnt;

					log = -1;
					System.out.println("탈퇴 완료");
				} else
					System.out.println("비밀번호가 불일치 합니다.");

			} else if (sel == 3 && log == -1) {
				// 로그인 => log가 인덱스로 활용
				// 입력
				System.out.print("id : ");
				String id = scan.next();
				System.out.print("pw : ");
				String pw = scan.next();

				for (int i = 0; i < cnt; i++) {
					if (ids[i].equals(id) && pws[i].equals(pw))
						log = i; // ==> 0번째 부터 저장 인덱스로 활용
				}
				if (log == -1) {
					System.out.println("회원정보를 다시 입력해 주세요.");
				} else {
					System.out.printf("%s님 환영합니다.", ids[log]);
				}
			} else if (sel == 4) {
				// 로그아웃
				log = -1;
				System.out.println("로그아웃 완료");
			} else if (sel == 5) {
				// 쇼핑!
				while (true) {
					// 출력
					for (int i = 0; i < items.length; i++)
						System.out.printf("%d) %s\n", i + 1, items[i]);

					// 입력
					System.out.print("상품번호 ; ");
					int itemNum = scan.nextInt();

					// 예외처리 1.범위
					if (itemNum < 1 || itemNum > items.length) // 왜 1보다 작으면인가
						continue;

					// 중요한 포인트
					// 장바구니 배열에 쇼핑 내력을 기록
					// {log,itemNum} =>
					int[][] temp = jang;

					jang = new int[size + 1][]; // => 다시 듣기

					for (int i = 0; i < size; i++)
						jang[i] = temp[i]; // 1차원 배열의 주소 재활용

					jang[size] = new int[2];
					jang[size][0] = log;
					jang[size][1] = itemNum;
					size++;
				}
			} else if (sel == 6 && log != -1) {
				// 장바구니 조회
				// 소계
				int[] itemCnt = new int[items.length];

				boolean isEmpty = true;
				for (int i = 0; i < size; i++) {
					if (jang[i][0] == log) { // 현재 로그인 중인 회원의 기록만 찾아
						int itemIdx = jang[i][1] - 1; // ? ? ?
						itemCnt[itemIdx]++;
						isEmpty = false;
					}
				}
				System.out.printf("=== %s님의 장바구니 내역 ===\n", ids[log]);
				for (int i = 0; i < itemCnt.length; i++) {
					if (itemCnt[i] > 0) // 설명 듣기
						System.out.printf("%s %d개\n", items[i], itemCnt[i]);
				}
				if (isEmpty)
					System.out.println("텅-");

			} else if (sel == 0) {
				System.out.println("시스템종료");
				break;
			}

		}

	}

}
