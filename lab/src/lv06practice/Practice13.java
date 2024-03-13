package lv06practice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

class Atmp2 {

	Scanner scan = new Scanner(System.in);

	final int JOIN = 1;
	final int LEAVE = 2;
	final int LOG_IN = 3;
	final int LOG_OUT = 4;
	final int INCOME = 5;
	final int TRANSFER = 6;
	final int BALANCE = 7;

	final int TYPE_OUT = 1;
	final int TYPE_IN = 2;

	int[] accs;
	String[] pws;
	int[] moneys;

	String name;
	int log = -1;
	int size;
	
	void balance() {
		
		System.out.printf("%d 회원님 현재 잔액은 %d원입니다.", accs[log],moneys[log]);
	}
	
	void transfer() {
		
		System.out.print("이체할 계좌 : ");
		int acc = scan.nextInt();
		
		System.out.print("이체할 금액 : ");
		int money = scan.nextInt();
		
		int idx = -1;
		for(int i=0; i<size; i++) {
			if(accs[i] == acc)
				idx = i;
		}
		
		if(idx == log || money < 1 || idx == -1)
			return;
		
		if(money > moneys[log])
			return;
		
		moneys[log] -= money;
		moneys[idx] += money;
		System.out.println("이체완료");
		
	}
	
	void income() {
		
		System.out.print("입금 금액 : ");
		int money = scan.nextInt();
		
		if(money < 1)
			return;
		
		moneys[log] += money;
		System.out.println("입금 완료");
		
	}
	
	void logout() {
		
		System.out.println("로그아웃 완료");
		log = -1;
	}
	
	void login() {
		
		System.out.print("id : ");
		int id = scan.nextInt();
		System.out.print("pw : ");
		String pw = scan.next();
		
		for(int i=0; i<size; i++) {
			if(accs[i] == id && pws[i].equals(pw))
				log = i;
		}
		
		if(log == -1) {
			System.out.println("회원정보를 다시 확인해 주세요.");
			return;
		}else
			System.out.printf("%d 회원님 환영합니다.",accs[log]);
		
		
	}
	
	void leave() {
		
		System.out.print("비밀번호 재 입력 : ");
		String pw = scan.next();
		
		if(!pws[log].equals(pw)) {
			System.out.println("비밀번호가 불일치 합니다.");
			return;
		}
		
		int[] tempAccs = accs;
		String[] tempPws = pws;
		int[] tempMoneys = moneys;
		
		accs = new int[size - 1];
		pws = new String[size -1];
		moneys = new int[size - 1];
		
		int idx = 0;
		for(int i=0; i<size; i++) {
			if(i != log) {
				accs[idx] = tempAccs[i];
				pws[idx] = tempPws[i];
				moneys[idx] = tempMoneys[i];
				idx ++;
			}
		}
		size --;
		System.out.println("회원탈퇴완료");
		
	}

	void join() {
		
		int acc = randomAccount();
		System.out.print("비밀번호 : ");
		String pw = scan.next();
		
		int[] tempAccs = accs;
		String[] tempPws = pws;
		int[] tempMoneys = moneys;
		
		accs = new int[size + 1];
		pws = new String[size + 1];
		moneys = new int[size + 1];
		
		for(int i=0; i<size; i++) {
			accs[i] = tempAccs[i];
			pws[i] = tempPws[i];
			moneys[i] = tempMoneys[i];
		}
		
		accs[size] = acc;
		pws[size] = pw;
		moneys[size] = 1000;
		size ++;
		System.out.println("회원가입완료");

	}

	boolean checkLog(int typeCode) {

		boolean result = false;
		if (typeCode == TYPE_OUT) {
			if (log == -1)
				result = true;
			else
				System.out.println("로그아웃 후 이용가능합니다.");
		} else if (typeCode == TYPE_IN) {
			if (log != -1)
				result = true;
			else
				System.out.println("로그인 후 이용가능합니다.");
		}

		return result;
	}

	void subMenu(int select) {

		if (select == JOIN)
			join();
		else if (select == LEAVE && checkLog(TYPE_OUT))
			leave();
		else if (select == LOG_IN && checkLog(TYPE_IN))
			login();
		else if (select == LOG_OUT && checkLog(TYPE_OUT))
			logout();
		else if (select == INCOME && checkLog(TYPE_IN))
			income();
		else if (select == TRANSFER && checkLog(TYPE_IN))
			transfer();
		else if (select == BALANCE && checkLog(TYPE_IN))
			balance();

	}

	int randomAccount() {

		Random ran = new Random();
		
		int acc = 0;

		while (true) {

			acc = ran.nextInt(9000) + 1000;

			boolean isDupl = false;
			for (int i = 0; i < size; i++) {
				if (accs[i] == acc)
					isDupl = true;
			}
			if (!isDupl)
				break;
		}
		
		return acc;
	}

	int inputNumber() {

		int number = -1;
		try {
			String input = scan.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("숫자를 입력하세요.");
		}
		return number;

	}

	void printMenu() {

		System.out.println("=== " + name + " ATM ===");
		System.out.println("1.회원가입");
		System.out.println("2.회원탈퇴");
		System.out.println("3.로그인");
		System.out.println("4.로그아웃");
		System.out.println("5.입금하기");
		System.out.println("6.이체하기");
		System.out.println("7.조회하기");

	}

	void subName(String name) {

		this.name = name;
	}

	void printState() {

		System.out.println(Arrays.toString(accs));
		System.out.println(Arrays.toString(pws));
		System.out.println(Arrays.toString(moneys));

	}

	void run() {

		while (true) {

			printState();
			printMenu();
			int sel = inputNumber();
			subMenu(sel);

		}

	}

}

public class Practice13 {

	public static void main(String[] args) {
		
		Atmp2 game = new Atmp2();
		game.run();

	}

}
