package lv06practice;
import java.util.Scanner;
import java.util.Random;
// # 사다리
class Laddderp2{
	
	Scanner scan = new Scanner(System.in);
	final int HOOK = 1;
	final int SIZE = 9;
	
	int player;
	int ladder[][];
	boolean[] isHook;
	boolean[] isOpen;
	String[] menu;
	
	void play(int number) {		//	 이동처리
		
		// 예외처리 후 , 
		if(number < 1 || number > player)
			return;
		
		int x = number -1;
		
		for(int y=0; y<SIZE; y++) {
			if(ladder[y][x] == HOOK) {
				int cnt = 0;
				for(int i=0; i<x; i++)
					if(ladder[y][i] == HOOK)
						cnt ++;
				if(cnt % 2 == 0)
					x ++;
				else
					x--;
			}
		}
		if(!isOpen[x]) {
			System.out.printf("결과 %s 당첨\n", menu[x]);
			isOpen[x] = true;
		}else {
			System.out.println("이미 고른 번호입니다.");
		}
		
	}
	
	int inputNumber() {
		int number = -1;
		try {
			String input = scan.next();
			number = Integer.parseInt(input);
		}catch(Exception e) {
			System.out.println("숫자를 입력하세요.");
		}
		return number;
		
	}
	
	void printLadder() {
		
		for(int i=0; i<player; i++)
			System.out.print(i + 1 + " ");
		System.out.println();
		
		// ├ ─ ┤ │
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<player; j++) {
				if(ladder[i][j] == HOOK)
					System.out.print("├─┤");
				else
					System.out.print("│ ");
			}
			System.out.println();
		}
		System.out.println();
		
		for(int i=0; i<player; i++)
			System.out.print(isOpen[i] ? "O" : "X");
		System.out.println();
		
		
		
	}
	
	boolean isRun() {
		
		boolean isEnd = true;
		
		for(int i=0; i<player; i++) {
			if(!isOpen[i])
				isEnd = false;
		}
		
		return !isEnd;
	}
	
	void setResult() {
		
		menu = new String[player];
		isOpen = new boolean[player];
		
		for(int i=0; i<player; i++) {
			System.out.printf("%d menu : ", i+1);
			menu[i] = scan.next();
		}
		
	}
	
	void setLadder() {	// 후크 달고
		
		Random ran = new Random();
		ladder = new int[SIZE][player];
		isHook = new boolean[player];
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<player; j++) {
				// 왼쪽 후크
				ladder[i][j] = ran.nextInt(3) == HOOK ? HOOK : 0;
				
				if(ladder[i][j] == HOOK) {
					isHook[j] = true;
					j += 1;
					ladder[i][j] = HOOK; // 오른쪽 후크
				}
			}
			
			if(i == SIZE -1) {	// 후크가 달리지 않았을때
				for(int j=0; j<player -1; j++) {
					if(!isHook[j]) {
						ladder = new int[SIZE][player];
						isHook = new boolean[player];
						i--;
						break;
					}
				}
			}
		}
		
	}
	
	void setPlayer() {
		
		while(player < 2) {
			System.out.print("player");
			player = scan.nextInt();
		}
	}
	
	void setGame() {
		
		setPlayer();
		setLadder();
		setResult();
		
		
	}
	
	void run() {
		
		setGame();
		while(isRun()) {
			printLadder();
			int num = inputNumber();
			play(num);
		}
		
	}
	
}

public class Practice09 {
	
	

	public static void main(String[] args) {
	}

}
