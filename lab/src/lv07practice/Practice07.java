package lv07practice;
import java.util.Scanner;

class Personp4{
	
	String id,password,name;
	
	// 객체 자시 자신에 대한 정보 (자기소개)
	void printInfo() {
		System.out.printf("%s) %s/%s", name,id,password);
	}
	
	
	// Method Override 메소드 오버라이딩
	// ㄴ 부모로부터 물려받은 메소드를 재정의 하는 것 
	@Override
	public String toString() {
		return String.format("%s) %s/%s", name,id,password);
	}
	
}

class CMSP4{
	
	Scanner scan = new Scanner(System.in);
	
	final int JOIN = 1;
	final int LEAVE = 2;
	final int LOG_IN = 3;
	final int LOG_OUT = 4;
	final int PASSWORD_RESET = 5;
	final int VIEW_USER = 6;
	
	final int SEARCH_USER = 1;
	final int SEARCH_USER_ALL = 2;
	
	
	int size;
	Personp4[] group;
	int log = -1;
	
	
	Personp4 createUser() {
		
		String name = inputString("name");
		String id = inputString("id");
		String password = inputString("password");
		
		Personp4 person = new Personp4();
		person.name = name;
		person.id = id;
		person.password = password;
		
		return person;
		
	}
	
	void passwordReset() {
		
		String password = inputString("현재 비밀번호");
		String newPassword = inputString("새 비밀번호");
		
		if(group[log].password.equals(password)) {
			group[log].password = newPassword;
			System.out.println("비밀번호 변경완료");
		}else {
			System.out.println("비밀번호가 불일치합니다.");
		}
		
	}
	
	void logout() {
		
		log = -1;
		System.out.println("로그아웃 완료");
		
	}
	
	void login() {
		
		String id = inputString("id");
		String password = inputString("password");
		int idx = searchUserById(id);
		
		if(idx != -1 && group[idx].password.equals(password)) {
			log = idx;
			System.out.println("로그인 완료");
		}
		
		if(log == -1) {
			System.out.println("회원정보를 다시 확인해주세요.");
		}
		
		
	}
	
	
	void leave() {
		
		String password = inputString("password");
		
		if(group[log].password.equals(password)) {
			
			Personp4[] temp = group;
			group = new Personp4[size - 1];
			
			int idx = 0;
			for(int i=0; i<size; i++) {
				if(i != log)
					group[idx++] = temp[i];
			}
			size--;
			log = -1;
		}else {
			System.out.println("회원탈퇴완료");
		}
	}
	
	void join() {
		
		Personp4 user = createUser();
		
		if(searchUserById(user.id) != -1) {
			System.out.println("중복되는 아이디입니다.");
			return;
		}
		
		Personp4[] temp = size == 0 ? null : group.clone();
		group = new Personp4[size + 1];
		
		for(int i=0; i<size; i++)
			group[i] = temp[i];
		
		group[size] = user;
		size ++ ;
		System.out.println("회원가입완료");
		
	}
	
	// 중복검사
	int searchUserById(String id) {
		
		for(int i=0; i<size; i++) {
			Personp4 user = group[i];
			if(user.id.equals(id))
				return i;
		}
		
		return -1;
		
	}
	
	
	// 한명 조회
	void printUserInfo() {
		
		String id = inputString("id");
		int idx = searchUserById(id);
		if(idx != -1)
			System.out.println(group[idx]);
		else
			System.out.println("존재하지 않는 회원입니다.");
		
	}
	
	void runSubMenu(int select) {
		
		if(select == SEARCH_USER)
			printUserInfo();
		else if(select == SEARCH_USER_ALL)
			printGroupInfo();
		
	}
	
	void subMenu(int select) {
		 
		if(select == JOIN)
			join();
		else if(select == LEAVE)
			leave();
		else if(select == LOG_IN)
			login();
		else if(select == LOG_OUT)
			logout();
		else if(select == PASSWORD_RESET)
			passwordReset();
		else if(select == VIEW_USER) {
			printSubMenu();
			int sel = inputNumber("메뉴");
			runSubMenu(sel);
		}
			
			
	}
	
	String inputString(String message) {
		
		System.out.print(message + " : ");
		return scan.next();
		
		
	}
	
	int inputNumber(String message) {
		
		int number = -1;
		try {
			System.out.println(message + " : ");
			String input = scan.next();
			number = Integer.parseInt(input);
		}catch(Exception e) {
			System.out.println("숫자를 입력하세요.");
		}
		
		return number;
		
	}
	
	void printSubMenu() {
		System.out.println("1.회원한명조회");
		System.out.println("2.회원전체조회");
	}
	
	void printMenu() {
		
		System.out.println("1.회원가입");
		System.out.println("2.회원탈퇴");
		System.out.println("3.로그인");
		System.out.println("4.로그아웃");
		System.out.println("5.비밀번호 변경");
		System.out.println("6.회원 조회");			// 한명 조회 전체조회
		
	}
	
	void printGroupInfo() {
		
		for(int i=0; i<size; i++) {
			System.out.println("\n" + i+1 + ". ");
			
			// 객체의 주소 -> override 한 toString 메소드를 통해
			// 나만의 문자열 출력
			System.out.println(group[i]);
			
		}
	}
	
	boolean isRun() {
		return true;
	}
	
	void run() {
		
		while(isRun()) {
			printGroupInfo();
			printMenu();
			int sel = inputNumber("MENU");
			subMenu(sel);
		}
		
		
	}
	
}
public class Practice07 {

	public static void main(String[] args) {
		
		CMSP4 system = new CMSP4();
		system.run();

	}

}
