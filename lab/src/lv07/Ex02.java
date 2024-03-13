package lv07;

import java.util.Scanner;
class Person2 {
	String name, id, password, email;
	int age, gender;

	// 객체 자기 자신에 대한 정보( 자기소개 )
	void printInfo() {
		System.out.printf("%s/%s(%s,%s) %d세,%s\n",id,password,name,email,age,gender == 1 ? "남자" : "여자");
	}
	
	// Method Overriding 메소드 오버라이딩
	// ㄴ 부모로부터 물려받은 메소드를 재정의 하는 것 (다시 작성)
	public String toString() {
		return String.format("%s/%s(%s,%s) %d세,%s\n",id,password,name,email,age,gender == 1 ? "남자" : "여자");
	}
}

class CMS2{
	
	Scanner scan = new Scanner(System.in);
	
	final int JOIN = 1;
	final int LEAVE = 2;
	final int LOG_IN = 3;
	final int LOG_OUT = 4;
	final int RESET_PASSWORD = 5;
	final int VIEW_USER = 6;
	
	final int SEARCH_USER = 1;
	final int SEARCH_USER_ALL = 2;
	
	
	int size;
	int log = -1;
	Person2[] group;
	
	Person2 createUser() {
		
		String name = inputString("name");
		String id = inputString("id");
		String email = inputString("email");
		String password = inputString("password");
		int age = inputNumber("age");
		int gender = inputNumber("1) 남자 2) 여자");
		
		Person2 person = new Person2();
		person.name = name;
		person.id = id;
		person.password = password;
		person.email = email;
		person.age = age;
		person.gender = gender;
		
		
		return person;
		
	}
	
	int searchUserById(String id) {
		
		for(int i=0; i<size; i++) {
			Person2 user = group[i];
			if(user.id.equals(id))
				return i;
		}
		return -1;
	}
	
	void join() {
		
		Person2 user = createUser();
		
		// id 중복 예외처리
		if(searchUserById(user.id) != -1)  {
			System.err.println("중복되는 아이디입니다.");
			return;
		}
		
		
		// group 배열의 크기를 늘리고
		// 기존 값 옮겨놓고
		Person2[] temp = size == 0 ? null : group.clone();
		group = new Person2[size +1];
		
		for(int i=0; i<size; i++) {
			group[i] = temp[i];
		}
			
		// 마지막 인덱스에 새로운 Person 객체를 추가
		// group[size] : null; -> new Person2()
		group[size++] = user;
		System.out.println("회원가입완료");
		
	}
	
	void leave() {
		
		String password = inputString("password");
		
		if(group[log].password.equals(password)) {
			
			Person2[] temp = group.clone();
			group = new Person2[size -1];
			
			int idx = 0;
			for(int i=0; i<size; i++)
				if(i != log)
					group[idx ++] = temp[i];
			
			size --;
			logout();
		}else {
			System.out.println("비밀번호가 일치하지 않습니다.");
		}
		
	}
	
	void login() {
		
		String id = inputString("id");
		String password = inputString("password");
		int idx = searchUserById(id);
		
		if(idx != -1 && group[idx].password.equals(password)) {
			log = idx;
			System.out.println("로그인 완료");
		}
		
		if(log == -1)
			System.err.println("회원정보를 다시 확인해주세요.");
		
	}
	
	void logout() {
		
		log = -1;
		System.out.println("로그아웃 완료");
	}
	
	void resetPassword() {
		
		String password = inputString("현재 비밀번호");
		String newPassword = inputString("새 비밀번호");
		
		if(group[log].password.equals(password)) {
			group[log].password = newPassword;
			System.out.println("비밀번호 변경 완료");
		}else {
			System.err.println("비밀번호가 불일치합니다.");
		}
	}
	
	void runMenu(int select) {
		
		if(select == JOIN && !isLogin())
			join();
		else if(select == LEAVE && isLogin())
			leave();
		else if(select == LOG_IN && !isLogin())
			login();
		else if(select == LOG_OUT && isLogin())
			logout();
		else if(select == RESET_PASSWORD && isLogin())
			resetPassword();
		else if(select == VIEW_USER && isLogin()) {
			printSubMenu();
			int sel = inputNumber("메뉴");
			runSubMenu(sel);
			
		}
		
	}
	
	boolean isLogin() {
		
		return log == -1 ? false : true;
	}
	
	
		
	void printUserInfo() {
		
		String id = inputString("id");
		int idx = searchUserById(id);
		if(idx != -1)
			System.out.println(group[idx]);
		else
			System.out.println("존재하지 않는 회원입니다.");
		
	}
		
	void runSubMenu(int select) {
		
		if(select == SEARCH_USER) {
			printUserInfo();
		}else if(select == SEARCH_USER_ALL) {
			printGroupInfo();
		}
		
		
		
	}
	
	boolean isRun() {
		
		return true;
		
	}
	
	void printSubMenu() {
		
		System.out.println("1) 회원 조회");
		System.out.println("2) 회원 전체 조회");
	}
	
	void printMenu() {
		System.out.println("cms");
		System.out.println("1.회원가입");
		System.out.println("2.회원탈퇴");
		System.out.println("3.로그인");
		System.out.println("4.로그아웃");
		System.out.println("5.비밀번호 변경");
		System.out.println("6.회원정보 조회");
	}
	
	String inputString(String message) {
		System.out.print(message + " : ");
		return scan.next();
		
	}
	
	int inputNumber(String message) {
		int number = -1;
		System.out.print(message + " : ");
		try {
			String input = scan.next();
			number = Integer.parseInt(input);
		}catch(Exception e) {
			System.err.println("숫자를 입력하세요.");
		}
		
		return number;
	}
	
	void printGroupInfo() {
		for(int i=0; i<size; i++) {
			System.out.println("\n"+(i+1) + ". ");
//			Person2  user = group[i];
//			user.printInfo();
			
			// 객체의 주소 -> override 한 toString 메소드를 통해
			// 나만의 문자열 출력
			System.out.println(group[i]);
		}
	}
	
	void run() {
		
		while(isRun()) {
			printGroupInfo();
			printMenu();
			int sel = inputNumber("menu");
			runMenu(sel);
			
			
		}
	}
	
	
}
public class Ex02 {

	public static void main(String[] args) {
		
		CMS2 system = new CMS2();
		system.run();

	}

}
