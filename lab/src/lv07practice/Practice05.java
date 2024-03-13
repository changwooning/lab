package lv07practice;
import java.util.Scanner;
class Userp1{
	
	// 기존에 생성되어 있는 Tms.seats 좌석 객체 중에 -> 예약 건만 바로가기로 저장
	int bookCnt;
	Seatp1[] mySeats;
	
	String id,password;
	
	// 생성자 Constructor
	// ㄴ 클래스를 통해 객체를 생성하도록 하는 메소드
	// ㄴ 메소드와는 다르게, 리턴이 존재하지 않고
	// ㄴ 메소드와는 다르게 이름이 정해져 있음.
	// ㄴ 별도로 정의하지 않으면 -> 컴파일러가 기본 생성자를 만들어줌
	// ㄴ 메소드와 같이 오버로딩 구현이 가능함 (파라미터의 개수 또는 타입이 서로 다르다면)
	
	// 문법) 클래스명(파라미터) { 실행문; }
	
//	Userp1(){
//		
//	}
	
	Userp1(String id, String password){
		this.id = id;
		this.password = password;
	}
	
	void recordBooking(Seatp1 seat) {
		
		Seatp1[] temp = mySeats;
		mySeats = new Seatp1[bookCnt + 1];
		
		for(int i=0; i<bookCnt; i++)
			mySeats[i] = temp[i];
		mySeats[bookCnt++] = seat;
	}
	
	void removeBooking(Seatp1 seat) {
		
		int idx = -1;
		for(int i=0; i<bookCnt; i++)
			if(mySeats[i] == seat)
				idx = i;
		if(idx != -1) {
			Seatp1[] temp = mySeats;
			mySeats = new Seatp1[bookCnt - 1];
			
			int n = 0;
			for(int i=0; i<bookCnt; i++)
				if(i != idx)
					mySeats[n++] = temp[i];
		}
	}
	
	void printMySeatsAll() {
		
		for(int i=0; i<bookCnt; i++) {
			Seatp1 seat = mySeats[i];
			System.out.printf("%d좌석 [예약완료]\n", seat.code);
		}
		
	}
	
	int removeBookingAll() {
		
		int count = bookCnt;
		for(int i=0; i<bookCnt; i++) {
			Seatp1 seat = mySeats[i];
			seat.userId = null;
			seat.isBooked = false;
		}
		bookCnt = 0;
		return count;
		
	}
	
	
	
}

class Seatp1{
	
	int code;
	boolean isBooked;
	String userId;
	int price;
	
	@Override
	public String toString() {
		return isBooked ? "◼︎" : "◻︎";
	}
	
	
}

class Tmsp1{
	
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
	Userp1[] users;
	
	int bookCnt;
	Seatp1[] seats;
	
	int log = -1;
	
	boolean isExit;
	
//	Userp1 createUser(String id,String password) {
//		
//		Userp1 user = new Userp1();
//		user.id = id;
//		user.password = password;
//		
//		return user;
//		
//	}
	
	void myPage() {
		
//		for(int i=0; i<SIZE; i++) {
//			Seatp1 seat = seats[i];
//			if(seat.isBooked && seat.userId.equals(users[log].id))
//				System.out.printf("%d번 좌석 [예약완료]\n",seat.code);
//		}
		
		Userp1 user = users[log];
		user.printMySeatsAll();
		
	}
	
	void cancelAllById(String id) {
		
//		for(int i=0; i<SIZE; i++) {
//			Seatp1 seat = seats[i];
//			if(seat.isBooked && users[log].id.equals(seat.userId)) {
//				seat.userId = null;
//				seat.isBooked = false;
//				
//				bookCnt--;
//			}
//		}
		
		Userp1 user = users[log];
		bookCnt -= user.removeBookingAll();
	}
	
	void cancel() {
		
		myPage();
		int code = inputNumber();
		
		int idx = idxOfSeat(code);
		if(idx != -1) {
			Seatp1 seat = seats[idx];
			
			if(seat.isBooked && !seat.userId.equals(users[log].id)) {
				System.out.println("본인이 예약한 좌석이 아닙니다.");
				return;
			}
			
			seat.userId = null;
			seat.isBooked = false;
			
			Userp1 user = users[log];
			user.removeBooking(seat);
			
			bookCnt--;
			System.out.println("예매가 취소 되었습니다.");
		
		
		}
	}
	
	int idxOfSeat(int code) {
		
		int idx = -1;
		for(int i=0; i<SIZE; i++) {
			Seatp1 seat = seats[i];
			if(code == seat.code)
				idx = i;
		}
		
		return idx;
	}
	
	void booking() {
		
		printSeatsAll();	// 맵 보여주고
		int code = inputNumber(); // 입력받아야지 자리선택
		
		int idx = idxOfSeat(code);
		if(idx == -1) {
			System.out.println("유효하지 않은 좌석입니다.");
			return;
		}
		
		if(seats[idx].isBooked) {
			System.out.println("이미 선택된 좌석입니다.");
			return;
		}
		
		String id = users[log].id;
		seats[idx].userId = id;
		seats[idx].isBooked = true;
		
		Userp1 user = users[log];
		Seatp1 seat = seats[idx];
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
		if(users[idx].password.equals(password))
			log = idx;
		
		if(log == -1)
			System.out.println("회원정보를 다시 확인해 주세요.");
		else
			System.out.println("로그인완료");
		
	}
	
	void leave() {
		
		// 1. 비밀번호 확인 후,
		String password = inputString("password");
		if(!users[log].password.equals(password)) {
			System.out.println("비밀번호가 불일치 합니다.");
			return;
		}
		// 2. 탈퇴할 회원의 예매내역 -> 원복
		cancelAllById(users[log].id);
		// 3. 회원삭제
		Userp1[] temp = users;
		users = new Userp1[userCnt - 1];
		
		int idx = 0;
		for(int i=0; i<userCnt; i++)
			if(i != log)
				users[idx++] = temp[i];
		userCnt--;
		log = -1;
		System.out.println("회원탈퇴완료");
		
	}
	
	void join() {
		
		String id = inputString("id");
		String password = inputString("password");
		
//		Userp1 user = createUser(id,password);
		Userp1 user = new Userp1(id,password);
		
		if(idxOfUser(user.id) != -1) {
			System.out.println("중복되는 아이디입니다.");
			return;
		}
		
		Userp1[] temp = users;
		users = new Userp1[userCnt + 1];
		
		for(int i=0; i<userCnt; i++)
			users[i] = temp[i];
		
		users[userCnt] = user;
		userCnt++;
		System.out.println("회원가입완료");
		
		
	}
	
	int idxOfUser(String id) {		// 아이디 중복검사
		
		int idx = -1;
		for(int i=0; i<userCnt; i++) {
			if(users[i].id.equals(id))
				idx = i;
		}
		return idx;
		
	}
	
	boolean isLogin() {
		
		return log == -1 ? false : true;
		
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
		}catch(Exception e) {
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
		System.out.println("0.종료하기");
		
	}
	
	void printStatus() {
		
		System.out.printf("예매현황 %d/%d \n", bookCnt,SIZE);
		printSeatsAll();
		
	}
	
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
	
	void setSeats() {		// 
		
		seats = new Seatp1[SIZE];
		for(int i=0; i<SIZE; i++) {
			seats[i] = new Seatp1();
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
			int sel = inputNumber();
			runMenu(sel);
		}
//		printTotal();
		
	}
	
}
public class Practice05 {

	public static void main(String[] args) {
		
		Tmsp1 system = new Tmsp1();
		system.run();

	}

}
