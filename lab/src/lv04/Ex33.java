package lv04;

import java.util.Scanner;

public class Ex33 {
	
	// # 쇼핑몰 [관리자]
	// 1. 카테고리와 아이템을 입력받아 아래의 예시와 같이 저장한다.
	// 2. 카테고리는 각 행의 첫번째 열에 저장한다. (중복 예외처리)
	// 3. 아이템은 각 행의 두번째 열에 저장한다.
	//		단, 아이템은 여러개를 추가할 수 있도록 슬래시(/)를 구분자로 연결해준다.
	//예)
	//{
	//		{"과일","사과/포도/"},
	//		{"과자","홈런볼/쪼리퐁/"},
	//		{"음료","콜라/"},
	//		{"육류","소고기/"}
	//		...
	//}
	//

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		final int SIZE = 100;
		final int N = 2;
		
		
		String[][] items = new String[100][2];
		
		for(int i=0; i<items.length; i++) {
			items[i][0] = "";
			items[i][1] = "";
		}
		
 		
		int itemsCount = 0;
		
		
		
		while(true) {
			
			System.out.println("[관리자모드]");
			System.out.println("[1]카테고리 관리");
			System.out.println("[2]아 이 템 관리");
			System.out.println("[3]전체품목 출력");
			
			System.out.print(": ");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				//입력
				System.out.print("입력 : ");
				String input = scan.next();
				
				//저장
				for(int i=0; i<SIZE; i++) {
					if(items[i][0].equals("")) {
						items[i][0] = input;
						break;
					}
				}
				for(int i=0; i<SIZE; i++) {
					System.out.print("카테고리 : " + items[i][0]);
					System.out.println();
					break;
				}
				
			}
			else if(sel == 2) {
				//입력
				System.out.print("입력 : ");
				String input = scan.next();
				
				for(int i=0; i<SIZE; i++) {
					if(items[i][1].equals("")) {
						items[i][1] = input;
						break;
					}
				}
				for(int i=0; i<SIZE; i++) {
					System.out.print("종류 : " + items[i][1]);
					System.out.println();
					break;
				}
				
				
			}
			else if(sel == 3) {}
			
			
			
			
		}
		
		
		
		
		
		

	}

}
