package lv07practice;
import java.util.Scanner;
class Personp5{
	
	String name,id,password;
	
	void printInfo() {
		System.out.printf("%s %s/%s",name,id,password);
	}

	@Override
	public String toString() {
		return String.format("%s %s/%s",name,id,password);
	}
	
}
class CMSP5{
	
	Scanner scan = new Scanner(System.in);
	
	final int JOIN = 1;
	final int LEAVE = 2;
	final int LOG_IN = 3;
	final int LOG_OUT = 4;
	final int PASSWORD_RESET = 5;
	final int VIEW_USER = 6;
	
	final int SEARCH_USER = 1;
	final int SEARCH_USER_ALL = 2;
	
	int log = -1;
	int size;
	Personp5[] group;
	
	Personp5 createUser() {
		
		String name = inputString("name");
		String id = inputString("id");
		String password = inputString("password");
		
		Personp5 person = new Personp5();
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
			System.out.println("비밀번호가 일치하지 않습니다.");
		}
		
	}
	
	void logout() {
		log = -1;
		System.out.println("로그아웃완료");
	}
	
	void login() {
		
		String id = inputString("id");
		String password = inputString("password");
		int idx = searchUserById(id);
		
		if(idx != -1 && group[idx].password.equals(password)) {
			log = idx;
			System.out.println("로그인완료");
		}
		
		if(log == -1)
			System.out.println("회원정보를 다시 확인해주세요.");
	}
	
	void leave() {
		
		String password = inputString("password");
		
		if(group[log].password.equals(password)) {
			Personp5[] temp = group;
			group = new Personp5[size - 1];
			
			int idx = 0 ;
			for(int i=0; i<size; i++) 
				if(i != log)
					group[idx ++] = temp[i];
			size --;
			log = -1;
			System.out.println("회원탈퇴완료");
		}else {
			System.out.println("비밀번호가 불일치 합니다.");
		}
	}
	
	void join() {
		
		Personp5 user = createUser();
		
		if(searchUserById(user.id) != -1) {
			System.out.println("중복이름이 존재합니다.");
			return;
		}
		
		Personp5[] temp = size == 0 ? null : group.clone();
		group = new Personp5[size + 1];
		
		for(int i=0; i<size; i++)
			group[i] = temp[i];
		
		group[size++] = user;
		System.out.println("회원가입완료");		
	}
	
	// 중복검사
	int searchUserById(String id) {
		
		
		for(int i=0; i<size; i++) {
			Personp5 user = group[i];
			if(user.id.equals(id))
				return i;
		}
		
		return -1;
	}
	
	void runSubMenu(int sel) {
		
		if(sel == SEARCH_USER)
			printUserInfo();
		else if(sel == SEARCH_USER_ALL)
			printGroupInfo();
		
	}
	
	void runMenu(int sel) {
		
		if(sel == JOIN)
			join();
		else if(sel == LEAVE)
			leave();
		else if(sel == LOG_IN)
			login();
		else if(sel == LOG_OUT)
			logout();
		else if(sel == PASSWORD_RESET)
			passwordReset();
		else if(sel == VIEW_USER) {
			printSubMenu();
			int select = inputNumber("MENU");
			runSubMenu(select);
		}
	}
	
	
	
	String inputString(String message) {
		System.out.print(message + " : ");
		return scan.next();
	}
	
	int inputNumber(String message) {
		int number = -1;
		try {
			System.out.print(message + " : ");
			String input = scan.next();
			number = Integer.parseInt(input);
		}catch(Exception e) {
			System.out.println("숫자를 입력하세요.");
		}
		return number;
	}
	
	void printSubMenu() {
		System.out.println("회원한명조회");
		System.out.println("회원전체조회");
	}
	
	void printMenu() {
		
		System.out.println("CMS");
		System.out.println("1.회원가입");
		System.out.println("2.회원탈퇴");
		System.out.println("3.로그인");
		System.out.println("4.로그아웃");
		System.out.println("5.비밀번호변경");
		System.out.println("6.회원조회");
	}
	
	void printUserInfo() {
		
		String id = inputString("id");
		int idx = searchUserById(id);
		if(idx != -1)
			System.out.println(group[idx]);
		else
			System.out.println("존재하지 않는 회원입니다.");
	}

	void printGroupInfo() {
		for(int i=0; i<size; i++) {
			Personp5 person = new Personp5();
			
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
			runMenu(sel);
		}
		
		
	}
	
	
}
public class Practice08 {

	public static void main(String[] args) {

	}

}
