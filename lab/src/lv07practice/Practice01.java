package lv07practice;
import java.util.Scanner;
class Personp1{
	
	String name,id,password,email;
	int age,gender;
	
	// 객체 자기 자신에 대한 정보(자기소개)
	void printInfo() {
		System.out.printf("%s/%s(%s,%s) %d세,%s\n",id,password,name,email,age,gender == 1 ? "남자" : "여자");
	}
	
	// Method overriding 메소드 오버라이딩
	// ㄴ 부모로부터 물려받은 메소드를 재정의 하는 것
	@Override
	public String toString() {
		return String.format("%s/%s(%s,%s) %d세,%s\n",id,password,name,email,age,gender == 1 ? "남자" : "여자");
	}
}

class CMSP1{
	
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
	Personp1[] group;	// 사용자 그룹배열
	
	Personp1 createUser() {
		
		String name = inputString("name");
		String id = inputString("id");
		String password = inputString("password");
		String email = inputString("email");
		int age = inputNumber("age");
		int gender = inputNumber("1)남자 2)여자");
		
		Personp1 person = new Personp1();
		person.name = name;
		person.id = id;
		person.password = password;
		person.email = email;
		person.age = age;
		person.gender = gender;
		
		return person;
		
	}
	
	void resetPassword() {
		
		String password = inputString("현재 비밀번호");
		String newPassword = inputString("새 비밀번호");
		
		if(group[log].password.equals(password)) {
			group[log].password = newPassword;
			System.out.println("비밀번호 변경완료");
		}else
			System.out.println("비밀번호가 불일치 합니다.");
		
	}
	
	void logout() {
		
		log = -1;
		System.out.println("로그아웃 완료");
	}
	
	void login() {
		
		String id = inputString("id");
		String password = inputString("password");
		int idx = searchUserById(id);	// 서치유저에서 i를 idx 로 치환한것
		
		if(idx != -1 && group[idx].password.equals(password)) {
			log = idx;				// 결국 log = i랑 같은말
			System.out.println("로그인 완료");
		}
		
		if(log == -1)
			System.out.println("회원정보를 다시 입력하세요.");
		
	}
	
	void leave() {
		
		String password = inputString("password");
		
		if(group[log].password.equals(password)) {
			
			Personp1[] temp = group.clone();
			group = new Personp1[size - 1];
			
			int idx = 0;
			for(int i=0; i<size; i++) 
				if(i != log)
					group[idx] = temp[i];
			size --;
			logout();
		}else 
			System.out.println("비밀번호가 일치하지 않습니다.");
		
	}
	
	void join() {
		
		Personp1 user = createUser();
		
		if(searchUserById(user.id) != -1) {
			System.err.println("중복되는 아이디입니다.");
			return;
		}
		
		Personp1[] temp = size == 0 ? null : group.clone();
		group = new Personp1[size + 1];
		
		for(int i=0; i<size; i++)
			group[i] = temp[i];
		
		group[size] = user;
		size ++;
		System.out.println("회원가입완료");
		
	}
	
	
	int searchUserById(String id) {		
		
		for(int i=0; i<size; i++) {
			Personp1 user = group[i];
			if(user.id.equals(id))
				return i;
		}
		
		return -1;
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
		
		if(select == SEARCH_USER)
			printUserInfo();
		else if(select == SEARCH_USER_ALL)	
			printGroupInfo();
	}
	
	void printSubMenu() {
		
		System.out.println("1) 회원 조회");
		System.out.println("2) 회원 전체 조회");
	}
	
	boolean isLogIn() {
		
		return log == -1 ? false : true;
		
	}
	
	void runMenu(int select) {
		
		if(select == JOIN && !isLogIn())
			join();
		else if(select == LEAVE && isLogIn())
			leave();
		else if(select == LOG_IN && !isLogIn())
			login();
		else if(select == LOG_OUT && isLogIn())
			logout();
		else if(select == RESET_PASSWORD && isLogIn())
			resetPassword();
		else if(select == VIEW_USER && isLogIn()) {
			printSubMenu();
			int sel = inputNumber("메뉴");
			runSubMenu(sel);
		}
		
		
	}
	
	String inputString(String message) {		// 스트링타입으로 입력 하나 받고
		
		System.out.print(message + " : ");
		return scan.next();
		
	}
	
	int inputNumber(int message) {		//	인트타입으로 입력 하나 받고
		
		int number = -1;
		System.out.print(message + " :");
		try {
			String input = scan.next();
			number = Integer.parseInt(input);
		}catch(Exception e) {
			System.out.println("숫자를 입력하세요.");
		}
		
		return number;
		
	}
	
	void printMenu() {
		
		System.out.println("CMS");
		System.out.println("1.회원가입");
		System.out.println("2.회원탈퇴");
		System.out.println("3.로그인");
		System.out.println("4.로그아웃");
		System.out.println("5.비밀번호 변경");
		System.out.println("6.회원정보 조회");
		
	}
	
	void printGroupInfo() {
		
		// 사용자 그룹 정보를 출력하는 메소드
		for(int i=0; i<size; i++) {
			System.out.println("\n"+i+1 + ". ");
			// Personp1 user = group[i];
			// user.printInfo();
			
			// 객체의 주소 -> override 한 toString 메소드를 통해
			// 나만의 문자열 출력
			System.out.print(group[i]);
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
			runMenu(sel);
		}
		
	}
	
	
	
	
	
}

public class Practice01 {

	public static void main(String[] args) {
		
		CMSP1 system = new CMSP1();
		system.run();

	}

}
