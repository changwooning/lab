package lv06practice;
import java.util.Scanner;
import java.util.Random;
class Ladderp4{
	
	Scanner scan = new Scanner(System.in);
	final int SIZE = 9;
	final int HOOK = 1;
	
	int player;
	int[][] ladder;
	String[] menu;
	boolean[] isHook;
	boolean[] isOpen;
	
	void play(int number) {
		
		if(number < 1 || number > player)
			return;
		
		int x = number-1;
		
		for(int y=0; y<SIZE; y++) {
			if(ladder[y][x] == HOOK) {
				int cnt = 0;
				for(int i=0; i<x; i++) 
					if(ladder[y][i] == HOOK)
						cnt ++;
				if(cnt % 2 == 0)
					x --;
				else
					x++;
			}
		}
		
		
		for(int i=0; i<player; i++) {
			
			
			
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
			System.out.print(i+1 + " ");
		System.out.println();
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<player; j++) {
				// ├ ─ ┤ │
				if(ladder[i][j] == HOOK) {
					System.out.print("├─┤ ");
					j++;
				}
				else
					System.out.print("│ ");
			}
			System.out.println();
		}
		System.out.println();
		
		for(int i=0; i<player; i++) {
			System.out.print(isOpen[i] ? "O" : "X");
		}
		
		
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
		
		isOpen = new boolean[player];
		menu = new String[player];
		
		for(int i=0; i<player; i++) {
			System.out.printf("%d menu : ",i+1);
			menu[i] = scan.next();
		}
	}
	
	void setLadder() {
		
		Random ran = new Random();
		ladder = new int[SIZE][player];
		isHook = new boolean[player];
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<player; j++) {
				ladder[i][j] = ran.nextInt(3) == HOOK ? HOOK : 0;
				
				if(ladder[i][j] == HOOK) {
					isHook[j] = true;
					j += 1;
					ladder[i][j] = HOOK;
				}
			}
			if(i == SIZE -1) {
				if(!isHook[i]) {
					ladder = new int[SIZE][player];
					isHook = new boolean[player];
					i--;
					break;
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
public class Practice11 {

	public static void main(String[] args) {
		
		Ladderp4 game = new Ladderp4();
		game.run();
	}

}
