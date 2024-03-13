package lv07practice;
import java.util.Scanner;
class Userp4{
	
	// 기존에 생성되어 있는 tms.seats 좌석 객체 중에 -> 예약 건만 바로가기로 저장
	
	String id ,password;
	
	Userp4(String id,String password){
		this.id = id;
		this.password = password;
	}
	
}
class Seatp4{
	
	int code;
	boolean isBooked;
	String userId;
	int price;
	
	// toString 메소드를 오버라이드하여 좌석의 상태를 문자열로 표현
	@Override
	public String toString() {
		return isBooked ? "◼" : "◻︎";
	}
	
}
class Tmsp4{
	
	Scanner scan = new Scanner(System.in);
	
	final int SIZE = 10;
	final int JOIN = 1;
	final int LEAVE = 2;
	final int LOG_IN = 3;
	final int LOG_OUT = 4;
	final int BOOKING = 5;
	final int CANCEL = 6;
	final int MY_PAGE = 7;
	final int EXIT = 0;
	
	final int PRICE = 12000;
	
	int userCnt;
	Userp4[] users;
	
	int bookCnt;
	Seatp4[] seats;
	
	int log = -1;
	
	boolean isExit;
	
	void runMenu(int select) {
		if(select == JOIN)
		else if(select == LEAVE)
		else if(select == LOG_IN)
		else if(select == LOG_OUT)
		else if(select == BOOKING)
		else if(select == CANCEL)
		else if(select == MY_PAGE)
		else if(select == EXIT)		
		
		
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
	
	// 모든 좌석의 예약상태를 출력하는 메소드
	void printSeatsAll() {
		for(int i=0; i<SIZE; i++)
			System.out.print(seats[i].code + " ");
		System.out.println();
		for(int i=0; i<SIZE; i++)
			System.out.print(seats[i] + " ");
		System.out.println();
	}
	
	
	void exit() {
		isExit = true;
	}
	
	boolean isExit() {
		return isExit;
	}
	
	// 초기 좌석 설정을 수행하는 메소드
	void setSeats() {
		seats = new Seatp4[SIZE];
		for(int i=0; i<SIZE; i++) {
			seats[i] = new Seatp4();	// 기본 생성자 호출
			seats[i].code = i + 1;
			seats[i].price = PRICE;
			
			if(seats[i].code > 5)
				seats[i].price += PRICE * 0.3;
		}
	}
	
	void run() {
		
		setSeats();
		while(!isExit()) {
			printSeatsAll();
			printMenu();
			int sel = inputNumber("MENU");
			runMenu(sel);
		}
		
	}
	
}
public class Practice09 {

	public static void main(String[] args) {

	}

}
