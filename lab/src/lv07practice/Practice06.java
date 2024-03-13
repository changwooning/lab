package lv07practice;
import java.util.Scanner;
class Userp3{
	
	// 기존에 생성되어 있는 Tms.seats 좌석 객체 중에 -> 예약 건만 바로가기로 저장
	
	
	String id,password;
	
}

class Seatsp3{
	
	int code; 			// 좌석번호
	boolean isBooked; 	// 예약상태
	String userId; 		// 예약한 사용자의 아이디
	int price;
	
	// toString 메소드를 오버라이드하여 좌석의 상태를 문자열로 표현
	@Override
	public String toString() {
		
		return isBooked ? "◼" : "◻︎";
		
	}
	
}

class Tmsp3{
	
	Scanner scan = new Scanner(System.in);
	
	final int SIZE = 10;
	final int PRICE = 12000;
	
	final int JOIN = 1;
	final int LEAVE = 2;
	final int LOG_IN = 3;
	final int LOG_OUT = 4;
	final int BOOKING = 5;
	final int CANCEL = 6;
	final int MY_PAGE = 7;
	final int EXIT = 0;
	
	int userCnt;
	Userp3[] users;
	
	int bookCnt;
	Seatsp3[] seats;
	
	int log = -1;
	
	boolean isExit;
	
	Userp3 createUser(String id,String password) {
		
		Userp3 user = new Userp3();
		user.id = id;
		user.password = password;
		
		return user;
		
	}
	
	void booking() {
		
		printSeatsAll();
		int code = inputNumber();
		
			
	}
	
	void idxOfSeat(int code) {
		
	}
	
	void logout() {
		
		log = -1;
		System.out.println("로그인 완료");
		
	}
	
	void login() {
		
		String id = inputString("id");
		String password = inputString("password");
		
		int idx = idxOfUser(id);
		if(users[idx].password.equals(password))
			log = idx;
		
		if(log == -1)
			System.out.println("회원정보를 다시 확인하세요.");
		else
			System.out.println("로그인 완료");
		
	}
	
	void leave() {
		
		String password = inputString("password");
		
		if(users[log].password.equals(password)) {
			Userp3[] temp = users;
			users = new Userp3[userCnt - 1];
			
			int idx = 0;
			for(int i=0; i<userCnt; i++) {
				if(i != log) 
					users[idx++] = temp[i]; 
			}
			userCnt--;
		}else
			System.out.println("비밀번호가 불일치 합니다.");
	
		
	}
	
	
	void join() {
		
		String id = inputString("id");
		String password = inputString("password");
		
		Userp3 user = createUser(id,password);
		
		if(idxOfUser(user.id) != -1) {
			System.out.println("중복되는 아이디입니다.");
			return;
		}
		
		Userp3[] temp = users;
		users = new Userp3[userCnt + 1];
		
		for(int i=0; i<userCnt; i++)
			users[i] = temp[i];
		
		users[userCnt] = user;
		userCnt++;
		System.out.println("회원가입 완료");
			
	}
	
	int idxOfUser(String id) {
		
		int idx = -1;
		for(int i=0; i<userCnt; i++) {
			if(users[i].id.equals(id))
				idx = i;
		}
		return idx;
	}
	
	void runMenu(int select) {
		
		if(select == JOIN)
			join();
		else if(select == LEAVE)
			leave();
		else if(select == LOG_IN)
			login();
		else if(select == LOG_OUT)
			logout();
		else if(select == BOOKING)
			booking();
		else if(select == CANCEL)
			cancel();
		else if(select == MY_PAGE)
			myPage();
		else if(select == EXIT)
			exit();
		
	}
	
	String inputString(String message) {
		
		System.out.print(message + " : ");
		return scan.next();
		
	}
	
	int inputNumber() {
		
		int number = -1;
		try {
			System.out.print("선택 : ");
			String input = scan.next();
			number = Integer.parseInt(input);
		}catch(Exception e) {
			System.out.println("숫자를 입력하세요.");
		}
		return number;
	}
	
	void printMenu() {
		
		System.out.println("1.회원가입");
		System.out.println("2.회원탈퇴");
		System.out.println("3.로그인");
		System.out.println("4.로그아웃");
		System.out.println("5.예매하기");
		System.out.println("6.예매취소");
		System.out.println("7.마이페이지");
		System.out.println("0.종료");
		
	}
	
	void printSeatsAll() {		// 모든 좌석의 예약 상태를 출력하는 메소드
		
		for(int i=0; i<SIZE; i++)
			System.out.print(seats[i].code);
		System.out.println();
		for(int i=0; i<SIZE; i++)
			System.out.print(seats[i]+ " ");	// 출력맵
		System.out.println();
		
	}
	
	void printStatus() {
		
		System.out.printf("예매 현황 %d/%d\n",bookCnt,SIZE);
		printSeatsAll();
		
	}
	
	void exit() {
		
		isExit = true;
		
	}
	
	// 프로그램 종료 여부를 확인하는 메소드
	boolean isExit() {
		
		return isExit;
	}
	
	void setSeats() {
		
		seats = new Seatsp3[SIZE];
		for(int i=0; i<SIZE; i++) {
			seats[i] = new Seatsp3();	// 기본생성자 호출
			seats[i].code = i + 1;		// 좌석 번호 보여주는 것
			seats[i].price = PRICE;
			
			if(seats[i].price > 5)
				seats[i].price += PRICE * 0.3;
		}
		
	}
	
	void run() {
		
		setSeats();						// 초기 좌석 설정을 수행하는 메소드
		while(!isExit()) {				// 
			printSeatsAll();			// 사용자가 특정 좌석 예약을 취소할 때 호출되는 메소드
			printMenu();				// 
			int sel = inputNumber();
			runMenu(sel);
		}
		
		
	}
	
	
}
public class Practice06 {

	public static void main(String[] args) {

	}

}
