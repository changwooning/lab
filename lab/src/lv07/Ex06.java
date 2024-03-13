package lv07;

import java.util.Scanner;

class User2 {

	// 기존에 생성되어 있는 Tms.seats 좌석 객체 중에 -> 예약 건만 바로가기로 저장
	int bookCnt;			// 예약된 좌석 수
	Seat2[] mySeats;		// 사용자가 예약한 좌석 배열

	String id, password;	// 사용자의 아이디와 비밀번호
	
	// 생성자 Constructor
	// ㄴ 클래스를 통해 객체를 생성하도록 하는 메소드
	// ㄴ 메소드와는 다르게, 리턴이 존재하지 않고
	// ㄴ 메소드와는 다르게 이름이 정해져 있음
	// ㄴ 별도로 정의하지 않으면 -> 컴파일러가 기본 생성자를 만들어줌
	// ㄴ 메소드와 같이 오버로딩 구현이 가능함 ( 파라미터의 개수 또는 타입이 서로 다르라면)
	
	// 문법) 클래스명(파라미터) { 실행문; }
//	User2(){
//		 
//	}
	
	// 사용자가 좌석을 예약할 때 호출되는 메소드
	User2(String id,String password){
		this.id = id;
		this.password = password;
	}
	
	// 이전에 예약한 좌석을 새로운 배열에 복사
	void recordBooking(Seat2 seat) {

		Seat2[] temp = mySeats;
		mySeats = new Seat2[bookCnt + 1];

		// 새로운 좌석 추가 및 예약된 좌석 수 증가
		for (int i = 0; i < bookCnt; i++)
			mySeats[i] = temp[i];
		
		// 새로운 좌석 추가 및 예약된 좌석 수 증가
		mySeats[bookCnt++] = seat;

	}
	
	// 사용자가 특정 좌석 예약을 취소할 때 호출되는 메소드
	void removeBooking(Seat2 seat) {

		int idx = -1;
		// 예약된 좌석 중에서 특정 좌석을 찾아 인덱스 저장
		for (int i = 0; i < bookCnt; i++)
			if (mySeats[i] == seat)
				idx = i;
		if (idx != -1) {
			Seat2[] temp = mySeats;
			mySeats = new Seat2[bookCnt - 1];

			// 삭제할 좌석을 제외하고 나머지 좌석을 새로운 배열에 복사
			int n = 0;
			for (int i = 0; i < bookCnt; i++)
				if (i != idx)
					mySeats[n++] = temp[i];
		}
	}

	// 사용자가 예약한 모든 좌석을 출력하는 메소드
	void printMySeatsAll() {

		for (int i = 0; i < bookCnt; i++) {
			Seat2 seat = mySeats[i];
			System.out.printf("%d좌석 [예약완료]\n", seat.code);
		}

	}

	// 사용자가 모든 예약을 취소하는 메소드
	int removeBookingAll() {

		int count = bookCnt;
		// 모든 예약된 좌석을 반복하면서 초기화
		for (int i = 0; i < bookCnt; i++) {
			Seat2 seat = mySeats[i];
			seat.userId = null;
			seat.isBooked = false;
		}
		
		// 예약된 좌석 수 초기화
		bookCnt = 0;
		return count;

	}

}

class Seat2 {

	int code; 			// 좌석번호
	boolean isBooked;	// 예약 상태
	String userId;		// 예약한 사용자의 아이디
	int price;			// 가격
	
	// *
	// 기본 생성자 생략 상태
	// Seat2(){}
	// *

	
	// toString 메소드를 오버라이드하여 좌석의 상태를 문자열로 표현
	@Override
	public String toString() {

		return isBooked ? "◼︎" : "◻︎";

	}

}

class Tms2 {

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

	int userCnt;		// 등록된 사용자 수
	User2[] users;		// 사용자 배열

	int bookCnt;		// 예약된 좌석 수
	Seat2[] seats;		// 좌석 배열

	int log = -1;

	boolean isExit;		// 프로그램 종료 여부

	void printTotal() {

	}

	// 현재 로그인한 사용자의 예약된 좌석을 출력하는 메소드
	void myPage() {

//		for (int i = 0; i < SIZE; i++) {
//			Seat2 seat = seats[i];
//			if (seat.isBooked && seat.userId.equals(users[log].id))
//				System.out.printf("%d번 좌석 [예약완료]\n", seat.code);
//		}

		User2 user = users[log];
		user.printMySeatsAll();

	}

	// 특정 사용자의 모든 예약을 취소하는 메소드
	void cancelAllById(String id) { // 파라미터는 삭제해도됨

//		for (int i = 0; i < SIZE; i++) {
//			Seat2 seat = seats[i];
//			if (seat.isBooked && users[log].id.equals(seat.userId)) {
//				seat.userId = null;
//				seat.isBooked = false;
//
//				bookCnt--;
//			}
//		}
		User2 user = users[log];
		bookCnt -= user.removeBookingAll();

	}

	// 사용자가 특정 좌석 예약을 취소하는 메소드
	void cancle() {

		myPage();
		int code = inputNumber();

		int idx = idxOfSeat(code);

		if (idx != -1) {
			Seat2 seat = seats[idx];

			if (seat.isBooked && !seat.userId.equals(users[log].id)) {
				System.err.println("본인이 예약한 좌석이 아닙니다.");
				return;
			}

			seat.userId = null;
			seat.isBooked = false;

			User2 user = users[log];
			user.removeBooking(seat);

			bookCnt--;
			System.out.println("예매 취소가 완료되었습니다.");
		}

	}

	// 좌석의 인덱스를 찾는 메소드
	int idxOfSeat(int code) {

		int idx = -1;
		for (int i = 0; i < SIZE; i++) {
			Seat2 seat = seats[i];
			if (code == seat.code)
				idx = i;
		}
		return idx;

	}

	// 사용자가 좌석을 예약하는 메소드
	void booking() {

		printSeatsAll();
		int code = inputNumber();

		int idx = idxOfSeat(code);

		if (idx == -1) {
			System.err.println("유효하지 않은 좌석입니다.");
			return;
		}
		
		if(seats[idx].isBooked) {
			System.out.println("이미 선택된 좌석입니다.");
			return;
		}

		String id = users[log].id;
		seats[idx].userId = id;
		seats[idx].isBooked = true;

		User2 user = users[log];
		Seat2 seat = seats[idx];
		user.recordBooking(seat);

		bookCnt++;
		System.out.println("예매가 완료되었습니다.");

	}

	void logout() {

		log = -1;
		System.out.println("로그아웃 완료");
	}

	void login() {

		String id = inputString("id");
		String password = inputString("password");

		int idx = idxOfUser(id);
		if (users[idx].password.equals(password))
			log = idx;

		if (log == -1)
			System.out.println("회원정보를 다시 입력하세요.");
		else
			System.out.println("로그인 완료");

	}

	void leave() {

		// 1. 비밀번호 확인 후,
		String password = inputString("password");
		if (!users[log].password.equals(password)) {
			System.err.println("패스워드가 불일치 합니다.");
			return;
		}
		
		// 회원의 예약내역 초기화
		// 2. 탈퇴할 회원의 예매내역 -> 원복
		cancelAllById(users[log].id);
		// 3. 회원삭제
		User2[] temp = users;
		users = new User2[userCnt - 1];

		int idx = 0;
		for (int i = 0; i < userCnt; i++)
			if (i != log)
				users[idx++] = temp[i];
		userCnt--;
		log = -1;
		System.out.println("회원탈퇴완료");

	}

	void join() {

		String id = inputString("id");
		String password = inputString("password");

//		User2 user = createUser(id, password);
		// 사용자 객체 생성
		User2 user = new User2(id, password);

		// 중복확인
		if (idxOfUser(user.id) != -1) {
			System.out.println("중복되는 아이디입니다.");
			return;
		}

		// 사용자 배열 확장
		User2[] temp = users;
		users = new User2[userCnt + 1];

		for (int i = 0; i < userCnt; i++)
			users[i] = temp[i];

		users[userCnt] = user;
		userCnt++;
		System.out.println("회원가입완료");

	}

//	User2 createUser(String id, String password) {
//
//		User2 user = new User2();		// 기본 생서자를 따로 정의하지 않으면 -> 사용이 불가
//		user.id = id;
//		user.password = password;
//
//		return user;
//
//	}


	// 사용자 아이디로 중복을 확인하는 메소드
	int idxOfUser(String id) { // 중복검사

		int idx = -1;
		for (int i = 0; i < userCnt; i++) {
			if (users[i].id.equals(id))
				idx = i;
		}

		return idx;
	}

	boolean isLogin() {

		return log == -1 ? false : true;

	}

	void runMenu(int select) {

		if (select == JOIN && !isLogin())
			join();
		else if (select == LEAVE && isLogin())
			leave();
		else if (select == LOG_IN && !isLogin())
			login();
		else if (select == LOG_OUT && isLogin())
			logout();
		else if (select == BOOKING && isLogin())
			booking();
		else if (select == CANCEL && isLogin())
			cancle();
		else if (select == MY_PAGE && isLogin())
			myPage();
		else if (select == EXIT)
			exit();
	}

	String inputString(String message) {

		System.out.print(message + " : ");
		return scan.next();

	}

	int inputNumber() {

		int number = -1;
		System.out.print("선택 : ");
		try {
			String input = scan.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("숫자만 입력하세요.");
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

	// 모든 좌석의 예약 상태를 출력하는 메소드
	void printSeatsAll() {

		for (int i = 0; i < SIZE; i++)
			System.out.print(seats[i].code + " ");
		System.out.println();

		for (int i = 0; i < SIZE; i++)
			System.out.print(seats[i] + " ");
		System.out.println();

	}

	// 예약 현황을 출력하는 메소드
	void printStatus() {

		System.out.printf("예매 현황 %d/%d\n", bookCnt, SIZE);
		printSeatsAll();

	}

	void exit() {

		isExit = true;
	}

	boolean isExit() {

		return isExit;

	}

	// 초기 좌석 설정을 수행하는 메소드
	void setSeats() {

		seats = new Seat2[SIZE];
		for (int i = 0; i < SIZE; i++) {
			seats[i] = new Seat2();	// 기본 생성자 호출
			seats[i].code = i + 1;
			seats[i].price = PRICE;

			if (seats[i].code > 5)
				seats[i].price += PRICE * 0.3;
		}

	}

	// 프로그램을 실행하는 메소드
	void run() {

		setSeats();
		while (!isExit()) {
			printSeatsAll();
			printMenu();
			int sel = inputNumber();
			runMenu(sel);
		}
		printTotal();
	}

}

public class Ex06 {

	public static void main(String[] args) {

		Tms2 system = new Tms2();
		system.run();

	}

}
