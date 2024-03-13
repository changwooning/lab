package lv06;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
// ATM
// System.out.println("=== "+ name + " ===");
// System.out.println("1.회원가입");
// System.out.println("2.회원탈퇴");
// System.out.println("3.로그인");
// System.out.println("4.로그아웃");
// System.out.println("5.입금하기");
// System.out.println("6.이체하기");
// System.out.println("7.조회하기");

class ATM {

	Scanner scan = new Scanner(System.in);
	String name;
	int size; // 계좌수

	int[] accs; // 4자리 랜덤 번호 발급(1000~9999)
	String[] pws;
	int[] money; // 가입 축하금 1000원

	int log = -1;

	void setCheck() {

		System.out.printf("%s님의 현재 잔액은 %d원입니다.", accs[log], money[log]);
	}

	void setTransfer() {

		System.out.print("이체할 계좌 : ");
		int acc = scan.nextInt();

		System.out.print("이체할 금액 : ");
		int moneys = scan.nextInt();

		int idx = -1;
		for (int i = 0; i < size; i++) {
			if (accs[i] == acc) {
				idx = i;
			}
		}
		if (idx == log) {
			System.out.println("본인한테는 입금이 불가능합니다.");
		}

		if (moneys < 1 || moneys > money[log]) {
			System.out.println("금액이 부족합니다.");
		}

		money[idx] += moneys;
		money[log] -= moneys;
		System.out.println("이체완료");

	}

	void setDeposit() {

		System.out.print("입금 금액 : ");
		int moneys = scan.nextInt();

		if (moneys < 1) {
			System.out.println("입금 금액은 1원 이상이여야 합니다.");
		} else {
			money[log] += moneys;
			System.out.println("입금완료");
		}

	}

	void setLogOut() {

		log = -1;
		System.out.println("로그아웃 완료");

	}

	void setLogIn() {

		System.out.print("id : ");
		int id = scan.nextInt();
		System.out.print("pw : ");
		String pw = scan.next();

		for (int i = 0; i < size; i++) {
			if (accs[i] == id && pws[i].equals(pw))
				log = i;
		}
		

		if (log == -1) {
			System.out.println("회원정보를 다시 확인해주세요.");
		} else {
			System.out.printf("%d님 환영합니다.\n", accs[log]);
		}

	}

	void setAccOut() {

		System.out.println("비밀번호 재확인 : ");
		String pw = scan.next();

		if (pws[log].equals(pw)) {
			int[] tempAccs = accs;
			String[] tempPws = pws;
			int[] tempMoney = money;

			accs = new int[size - 1];
			pws = new String[size - 1];
			money = new int[size - 1];

			int idx = 0;
			for (int i = 0; i < size; i++) {
				if (i != log) {
					accs[idx] = tempAccs[i];
					pws[idx] = tempPws[i];
					money[idx] = tempMoney[i];
					idx++;
				}
			}
			size--;
			log = -1;
			System.out.println("회원탈퇴완료");
		} else {
			System.out.println("비밀번호가 불일치 합니다..");
		}

	}

	void setAccIn() {

		int rNum = 0;
		Random ran = new Random();

		while (true) {
			boolean isDupl = false;
			rNum = ran.nextInt(9000) + 1000;
			for (int i = 0; i < size; i++) {
				if (accs[i] == rNum)
					isDupl = true;
			}
			if (!isDupl)
				break;
			else
				System.out.println("중복계정이 존재합니다.");
		}

		System.out.println("accs : " + rNum);
		System.out.print("pw : ");
		String pw = scan.next();

		int[] tempAccs = accs;
		String[] tempPws = pws;
		int[] tempMoney = money;

		accs = new int[size + 1];
		pws = new String[size + 1];
		money = new int[size + 1];

		for (int i = 0; i < size; i++) {
			accs[i] = tempAccs[i];
			pws[i] = tempPws[i];
			money[i] = tempMoney[i];
		}
		accs[size] = rNum;
		pws[size] = pw;
		money[size] = 1000;
		size++;
		System.out.println("회원가입 완료");

	}

	void printMenu() {

		while (true) {
			System.out.println(Arrays.toString(accs));
			System.out.println(Arrays.toString(pws));
			System.out.println(Arrays.toString(money));
			System.out.println(log);
			System.out.println(size);
			
			System.out.println("1.회원가입");
			System.out.println("2.회원탈퇴");
			System.out.println("3.로그인");
			System.out.println("4.로그아웃");
			System.out.println("5.입금하기");
			System.out.println("6.이체하기");
			System.out.println("7.조회하기");

			int sel = scan.nextInt();

			if (sel == 1)
				setAccIn();
			else if (sel == 2)
				setAccOut();
			else if (sel == 3)
				setLogIn();
			else if (sel == 4)
				setLogOut();
			else if (sel == 5)
				setDeposit();
			else if (sel == 6)
				setTransfer();
			else if (sel == 7)
				setCheck();
		}

	}

	void run() {

		printMenu();
	}

}

public class Ex14 {

	public static void main(String[] args) {

		ATM atm = new ATM();
		atm.run();

	}

}
