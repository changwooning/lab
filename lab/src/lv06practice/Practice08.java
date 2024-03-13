package lv06practice;
import java.util.Scanner;
import java.util.Random;
// 랜덤 사다리 n 플레이어

class  LadderP1{
	
	Scanner scan = new Scanner(System.in);
	final int HOOK = 1;
	final int HEIGHT = 9;
	
	int player;
	int ladder[][];
	String[] menu;
	boolean[] isHook;
	boolean[] isOpen;
	
	void play(int number) {
		
		// 예외처리 후,
		if(number < 1 || number > player)
			return;
		
		int x = number-1;
	}
	
	
	void printLadder() {
		
		for(int i=0; i<player; i++)
			System.out.print(i + 1 + " ");
		System.out.println();
		// ├ ─ ┤ │
		
		for(int i=0; i<HEIGHT; i++) {
			for(int j=0; j<player; j++) {
				if(ladder[i][j] == HOOK) {
					System.out.print("├─┤");
					j ++;
				}else
					System.out.print("│ ");
			}
			System.out.println();
		}
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
	
	void setLadder() {
		
		Random ran = new Random();
		ladder = new int[HEIGHT][player];
		isHook = new boolean[player];
		
		for(int i=0; i<HEIGHT; i++) {
			for(int j=0; j<player; j++) {
				//왼쪽 후크달고 
				ladder[i][j] = ran.nextInt(3) == HOOK ? HOOK : 0;
				
				if(ladder[i][j] == HOOK) {
					isHook[j] = true;
					j += 1;
					ladder[i][j] = HOOK;
				}
			}
			if(i == HEIGHT -1) {
				for(int j=0; j<player-1; j++) {
					if(!isHook[j]) {	// 후크가 안걸렸을때
						ladder = new int[HEIGHT][player]; // 재초기화 
						isHook = new boolean[player];
						i = -1;
						break;
					}
				}
			}
		}
	}
	
	int inputNumber() {
		int number = -1;
		System.out.print("number : ");
		try {
			String input = scan.next();
			number = Integer.parseInt(input);
		}catch(Exception e) {
			System.out.println("숫자를 입력하세요.");
		}
		return number;
		
	}
	
	void setPlayer() {
		
		while(player < 2) {
			System.out.print("PLAYER");
			player = inputNumber();
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
public class Practice08 {

	public static void main(String[] args) {

	}

}
