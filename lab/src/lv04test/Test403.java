package lv04test;

import java.util.Scanner;

public class Test403 {

	// 쇼핑몰 관리자 - 벡터로 구현
	// 1. 카테고리와 아이템을 입력받아 아래의 예시와 같이 저장한다.
	// 2. 카테고리는 각 행의 첫번째 열에 저장한다.
	// 3. 아이템은 각 행의 두번째 열에 저장한다.
	// 단, 아이템은 여러개를 추가할 수 있도록 슬래시(/)를 구분자로 연결해준다.

	// 1122

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int itemCount = 0;
		String[][] items = null;

		while (true) {

			System.out.println("[쇼핑몰 관리자]");
			System.out.println("[1]카테고리 관리");
			System.out.println("[2]아이템 관리");
			System.out.println("[3]전체품목 출력");

			System.out.print("선택 : ");
			int sel = scan.nextInt();

			if (sel == 1) {

				System.out.print("추가할 카테고리 명 : ");
				String cateName = scan.next();

				// 중복검사
				boolean isDupl = false;
				for (int i = 0; i < itemCount; i++) {
					if (items[i][0].equals(cateName))
						isDupl = true;
				}
				if (!isDupl) {
					String[][] temp = items;
					items = new String[itemCount+1][2];

					for (int i = 0; i < itemCount; i++) {
						items[i] = temp[i];
					}
					
					items[itemCount][0] = cateName;
					items[itemCount][1] = "";
					itemCount++;

				} else
					System.out.println("중복이름이 존재합니다.");

			} else if (sel == 2) {
				
				for (int i = 0; i < itemCount; i++)
					System.out.printf("%d) %s\n", i + 1, items[i][0]);
				System.out.print("카테고리 번호 : ");
				int cateIdx = scan.nextInt()-1;

				if (cateIdx < 0 || cateIdx >= items.length) {
					System.out.println("번호 입력 오류");
					continue;
				}

				System.out.print("추가할 아이템 : ");
				String item = scan.next();

				items[cateIdx][1] += item + "/";
				
			} else if (sel == 3) {
				for (int i = 0; i < itemCount; i++) {
					System.out.printf("%d) %s : %s\n", i+1,items[i][0], items[i][1]);
				}

			}

		}

	}

}
