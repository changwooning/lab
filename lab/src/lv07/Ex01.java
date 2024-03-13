package lv07;

import java.util.Arrays;
import java.util.Scanner;

// # 클래스 배열

class Person {
	String name, id, password, email;
	int age, gender;

	// 객체 자기 자신에 대한 정보( 자기소개 )
	void printInfo() {
		System.out.printf("%s/%s(%s,%s) %d세,%s\n",id,password,name,email,age,gender == 1 ? "남자" : "여자");
	}
}

class CMS {

	Scanner scan = new Scanner(System.in);
	int size;
	Person[] group;
	int log = -1;
	
	void inquiry(int id) {
		
//		System.out.printf("%s님 회원정보",group[log].id);
		
		
	}
	
	void reset() {
		
		System.out.print("현재 비밀번호 : ");
		String pw = scan.next();
		
		System.out.print("변경할 비밀번호 : ");
		String newPw = scan.next();
		
		if(group[log].password.equals(pw)) {
			group[log].password = newPw;
			System.out.println("비밀번호 변경완료");
		}
		
		
	}
	
	void logOut() {
		
		log = -1;
		System.out.println("로그아웃 완료");
		
	}

	void logIn() {

		System.out.print("id : ");
		String id = scan.next();
		System.out.print("pw : ");
		String pw = scan.next();

		for (int i = 0; i < size; i++) {
			if (group[i].id.equals(id) && group[i].password.equals(pw))
				log = i;
		}

		if (log == -1) {
			System.out.println("회원정보를 다시 입력하세요.");
		} else {
			System.out.printf("%s님 환영합니다!\n", group[log].id);
		}

	}

	void Withdrawal() {

		System.out.print("비밀번호 재확인 : ");
		String pw = scan.next();

		if (group[log].password.equals(pw)) {
			Person[] temp = group;
			group = new Person[size - 1];

			int idx = 0;
			for (int i = 0; i < size; i++) {
				if (i != log)
					group[idx++] = temp[i];
			}
			size--;
		} else {
			System.out.println("비밀번호가 불일치 합니다.");
		}

	}

	void join() {

		System.out.print("id : ");
		String id = scan.next();

		System.out.print("pw : ");
		String pw = scan.next();

		System.out.print("name : ");
		String name = scan.next();

		System.out.print("email : ");
		String email = scan.next();

		System.out.print("age : ");
		int age = scan.nextInt();

		boolean isDupl = false;
		for (int i = 0; i < size; i++) {
			if (id.equals(group[i].id))
				isDupl = true;

		}
		if (!isDupl) {

			Person[] temp = group;
			group = new Person[size + 1];

			for (int i = 0; i < size; i++) {
				group[i] = temp[i];
			}

			group[size] = new Person();
			group[size].id = id;
			group[size].password = pw;
			group[size].name = name;
			group[size].email = email;
			group[size].age = age;
			size++;
			System.out.println("회원가입 완료");
		} else {
			System.out.println("중복이름이 존재합니다.");
		}
	}

	int inputNumber() {

		int number = -1;
		try {
			String input = scan.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("숫자를 입력하세요.");
		}

		return number;
	}

	void subMenu(int sel) {

		if (sel == 1) {
			join();
		} else if (sel == 2) {
			Withdrawal();
		} else if (sel == 3) {
			logIn();
		} else if (sel == 4) {
			logOut();
		} else if (sel == 5) {
			reset();
		} else if (sel == 6) {
//			int id = inquiry(id);
		} 
			

	}

	void print() {

		System.out.println("회원관리 프로그램 만들기");
		System.out.println("1.회원가입");
		System.out.println("2.회원탈퇴");
		System.out.println("3.로그인");
		System.out.println("4.로그아웃");
		System.out.println("5.비밀번호 재설정");
		System.out.println("6.회원조회");	// 한명 조회,전체조회

	}

	void run() {
		
		while (true) {

			print();
			int sel = inputNumber();
			subMenu(sel);
		}

	}
}

public class Ex01 {

	public static void main(String[] args) {

//		Person[] group = null;
//		
//		group = new Person[1]; 		// {null};
//		
//		group[0] = new Person();	// {주소}
//		group[0].name = "손창우";

		// 회원관리 프로그램 만들기
		// ㄴ 회원가입
		// ㄴ 회원탈퇴
		// ㄴ 로그인/아웃
		// ㄴ 비밀번호 재 설정
		// ㄴ 회원조회
		// ㄴ 한명 조회
		// ㄴ 전체 조회

		CMS system = new CMS();
		system.run();

	}

}
