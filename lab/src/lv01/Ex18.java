package lv01;

import java.util.Scanner;

public class Ex18 {
	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);

		// 로그인 처리 [1단계]

		// 사용자는 데이터베이스에 저장된 아이디와 비밀번호를 입력하여
		// 두 개의 값이 모두 일치하면
		// "로그인 성공" 을 출력
		// 두 개의 값이 하나라도 일치하지 않으면
		// "회원정보가 일치하지 않습니다" 를 출력
		
		int dbId = 1111;
		int dbPw = 1212;

		System.out.print("ID : ");
		int id = scan.nextInt();   //변수명은 소문자로;;하자 창우

		System.out.print("PW : ");
		int pw = scan.nextInt();


		if (id == dbId && pw == dbPw) {
			System.out.println("로그인 성공");

		}

		if (id != dbId || pw != dbPw) {
			System.out.print("회원정보가 일치하지 않습니다.");
		}

	}

}
