package lv02;

import java.util.Scanner;

public class Ex25 {
	
	//연습하

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int dbAcc1 = 1111;
		int dbPw1 = 1234;

		int dbAcc2 = 2222;
		int dbPw2 = 2345;

		int log = -1; // -1(로그아웃), 1(dbAcc1로그인), 2(dbAcc2로그인)

		boolean run = true;
		while (run) {

			System.out.println("1.로그인");
			System.out.println("2.로그아웃");
			System.out.println("3.종료");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			int id = 0;
			int pw = 0;
			//int id2 = 0;
			//int pw2 = 0;
			
			
			if (sel == 1) {
				if(log == 1) {
					System.out.print("acc : ");
					int inputAcc = scan.nextInt();
					
					System.out.print("acc : ");
					int inputPw = scan.nextInt();
					//if(dbAcc1 == inputAcc && dbPw1 == inputPw)
					
					
					
					
				}else {
					//int user = 0;
				//	if(log == 1)
						//user == dbAcc1;
				}
					System.out.printf("사용자님이%d님이 이미 로그인 중입니다.\n", log);				

				
				
				
			} else if (sel == 2) {
				
				

			} else if (sel == 3) {
				run = false;
				System.out.println("프로그램 종료");
			}

		}

	}

}
