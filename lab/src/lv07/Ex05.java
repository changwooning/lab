package lv07;
import java.util.Scanner;
// 티켓예매 시스템 완성
// ㄴ 사용자는 회원가입 및 로그인 후, 좌석 예매가 가능하다.
// ㄴ 사용자의 마이페이지에는 예매완료 내역을 확인할 수 있다.

class User{
	
	// Seat[] mySeats;
	String id,pw,name;
	
}

class Seat{
	
	// 시스템(Tms), 사용자(User), 좌석(Seat)
	
	// 회원가입/탈퇴 로그인/로그아웃 후 예매가능
	int code; // 좌석 번호
	boolean isBooked;
	String userId;
	int price;
	
}

class Tms{
	
	Scanner scan = new Scanner(System.in);
	
	final int SIZE = 7;
	
	final int JOIN = 1;
	final int LEAVE = 2;
	final int LOG_IN = 3;
	final int LOG_OUT = 4;
	final int RESERVATION = 5;
	final int RECORD = 6;
	
	final int TYPE_IN = 1;
	final int TYPE_OUT = 2;
	
	int log = -1;
	
	
	User[] user;	// 가입/탈퇴/로그인/로그아웃
	Seat[] seat;	// 예매
	
	
	
	
	void seatException() {
		
		String input = inputString("좌석 선택 : ");
		int idx = scan.nextInt();
		
		if(idx < 1 || idx > SIZE -1)
			return;
		
		seat[idx]. = 1;
		
	}
	
	String inputString(String message) {
		
		System.out.print(message + " : ");
		return scan.next();
		
	}
	
	int inputNumber(int message) {
		
		int number = -1;
		System.out.print(message  + " : ");
		try {
			String input = scan.next();
			number = Integer.parseInt(input)-1;
		}catch(Exception e) {
			System.out.println("숫자만 입력하세요.");
		}
		return number;
		
	}
	
	void seatPrint() {
		
		for(int i=0; i<SIZE; i++) {
			System.out.print(seat[i]);
		}
		System.out.println();
	}
	
	
	boolean checkLog(int typeCode) {
		
		boolean result = false;
		
		if(typeCode == TYPE_IN) {
			if(log != -1)
				result = true;
			else
				System.out.println("로그인 후 사용가능합니다.");
		}else if(typeCode == TYPE_OUT) {
			if(log == -1)
				result = true;
			else
				System.out.println("로그아웃 후 사용가능합니다.");
		}
		
		return result;
		
	}
	
	void subMenu(int sel) {
		
		if(sel == JOIN && checkLog(TYPE_OUT))
			join();
//		else if(sel == LEAVE && checkLog(TYPE_IN))
//			leave();
//		else if(sel == LOG_IN && checkLog(TYPE_OUT))
//			login();
//		else if(sel == LOG_OUT && checkLog(TYPE_IN))
//			logout();
		else if(sel == RESERVATION && checkLog(TYPE_IN)) {
			//reservation();
			seatPrint();
		}
//		else if(sel == RECORD && checkLog(TYPE_IN))
//			record();
		
	}
	
	void join() {
		
		String id = inputString("id");
		String pw = inputString("pw");
		
		
	}
	
	void duplicatedInspection() {
		
		
		
		
	}
	
	
	void printSubMenu() {
		
		System.out.println("[1]티켓 예매");
		System.out.println("[2]예매완료 내역");
		
	}
	
	
	void printMap() {
		
		System.out.println("[티켓예매시스템]");
		System.out.println("[1]회원가입");
		System.out.println("[2]회원탈퇴");
		System.out.println("[3]로그인");
		System.out.println("[4]로그아웃");
		
	}
	
	boolean isRun() {
		
		return true;
		
	}
	
	void seatMap() {
		
		seat = new Seat[SIZE];
		
		for(int i=0; i<SIZE; i++) {
			seat[i] = new Seat();
		}
		
	}
	
	void userMap() {
		
		
		
	}
	
	void setMap() {
		
		seatMap();
		userMap();
		
	}
	
	void run() {
		
		setMap();
		while(isRun()) {
			printMap();
			int sel = inputNumber();
			subMenu(sel);
			
			// 가입처리
		}
//		printResult();
		
	}
	
	
}
public class Ex05 {

	public static void main(String[] args) {
		
		Tms system = new Tms();
		system.run();

	}

}
