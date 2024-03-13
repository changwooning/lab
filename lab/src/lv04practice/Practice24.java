package lv04practice;

import java.util.Scanner;

public class Practice24 {

	// 쇼핑몰 관리자

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String[][] items = new String[100][2];

		for (int i = 0; i < items.length; i++) {
			items[i][0] = "";
			items[i][1] = "";
		}

		int itemCount = 0;

		while (true) {

			System.out.println("[관리자 모드]");
			System.out.println("[1]카테고리 관리");
			System.out.println("[2]아 이 템 관리");
			System.out.println("[3]전체품목 출력");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			if (sel == 1) {
				//입력 전 예외처리 범위
				if(items.length == itemCount) {
					System.out.println("더 이상 추가할 수 없습니다.");
					continue;
				}
				// 입력
				System.out.print("추가할 카테고리 명 : ");
				String input = scan.next();

				// 중복여부
				boolean isDupl = false;
				for (int i = 0; i < itemCount; i++) {
					if (items[i][0].equals(input))
						isDupl = true;
				}
				if (!isDupl) {
					items[itemCount][0] = input;
					itemCount++;
				}else
					System.out.println("중복 이름이 존재합니다.");
					

			} else if (sel == 2) {
				// 카테고리 출력
				for (int i = 0; i < itemCount; i++)
					System.out.printf("%d) %s\n", i + 1, items[i][0]);

				// 카테고리 선택
				System.out.print("카테고리 선택(번호) : ");
				int cateIdx = scan.nextInt()-1;

				// 예외처리 1.인덱스 범위
				if (cateIdx < 0 || cateIdx > itemCount - 1) {
					System.out.println("번호 입력 오류");
					continue;
				}
				
				// 입력 아이템
				System.out.print("추가할 아이템 입력 : ");
				String item = scan.next();

				items[cateIdx][1] += item + "/";

			} else if (sel == 3) {
				// 전체품목 출력
				for (int i = 0; i < itemCount; i++) {
					System.out.printf("%d) %s : %s\n", i + 1, items[i][0], items[i][1]);
				}
			}

		}

	}

}
