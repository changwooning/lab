package lv07practice;
import java.util.Scanner;
class Personp3{
	
	String name, id, password;
	int age, gender;
	
	void printInfo() {
		System.out.printf("%s/%s (%s) %d세, %s\n",id,password,name,age,gender == 1 ? "남자" : "여자");
	}
	
	@Override
	public String toString() {
		return String.format("%s/%s (%s) %d세, %s\n",id,password,name,age,gender == 1 ? "남자" : "여자");
		
	}
	
	
}

class CMSP3{
	
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
	Personp3[] group;
	
	Personp3 createUser() {
		
		String name = inputString("name");
		String id = inputString("id");
		String password = inputString("password");
		int age = inputNumber("age");
		int gender = inputNumber("gender");
	
		Personp3 person = new Personp3();
		person.name = name;
		person.id = id;
		person.password = password;
		person.age = age;
		person.gender = gender;
		
		return person;
		
	}
	
	void join() {
		
		Personp3 user = createUser();
		
		// 중복검사
		if(searchUserById(user.id) != -1) {
			System.out.println("중복되는 아이디입니다.");
			return;
		}
		
		// group 배열의 크기를 늘리고
		// 기존 값 옮겨놓고
		Personp3[] temp = size == 0 ? null : group.clone();
		group = new Personp3[size + 1];
		
		for(int i=0; i<size; i++)
			group[i] = temp[i];
		
		group[size] = user;
		size ++;
		System.out.println("회원가입완료");
		
	}
	
	void leave() {
		
		String password = inputString("password");
		
		if(group[log].password.equals(password)) {
			
			Personp3[] temp = group.clone();
			group = new Personp3[size - 1];
			
			int idx = 0;
			for(int i=0; i<size; i++) {
				if(i != log)
					group[idx++] = temp[i];
			}
			size --;
			System.out.println("회원탈퇴가 완료");
		}else
			System.out.println("비밀번호가 불일치 합니다.");
		
		
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
		
		String password = inputString("현재 비밀번호 : ");
		String newPassword = inputString("새 비밀번호 : ");
		
		if(group[log].password.equals(password)) {
			group[log].password = newPassword;
			System.out.println("비밀번호 변경 완료");
		}else
			System.out.println("현재 비밀번호가 불일치 합니다.");
		
	}
	
	
	int searchUserById(String id) {
		
		for(int i=0; i<size; i++) {
			Personp3 user = group[i];
			if(user.id.equals(id))
				return i;
		}
		
		return -1;
		
	}
	
	void printUserInfo() { 		// 회원조회 한명
		
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
	
	boolean isLogin() {
		
		return log == -1 ? false : true;
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
			System.out.println("숫자만 입력하세요.");
		}
		return number;
	}
	
	void printSubMenu() {
		
		System.out.println("1) 회원 조회");
		System.out.println("2) 회원 전체 조회");
		
	}
	
	
	void printMenu() {
		
		System.out.println("CMS");
		System.out.println("1.회원가입");
		System.out.println("2.회원탈퇴");
		System.out.println("3.로그인");
		System.out.println("4.로그아웃");
		System.out.println("5.비밀번호 변경");
		System.out.println("6.회원정보 조회");	// 한명 or 전체
		
	}
	
	void printGroupInfo() {		// 회원 전체 조회
		
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
			int sel = inputNumber("menu");
			runMenu(sel);
		}
		
		
	}
}
public class Practice04 {

	public static void main(String[] args) {
		
		CMSP3 system = new CMSP3();
		system.run();

	}

}
