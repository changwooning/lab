package lv06practice;
import java.util.Scanner;
import java.util.Random;
class Mariop2{
	
	// 1422
	// 1432
	Scanner scan = new Scanner(System.in);
	
	final int SIZE = 9;
	final int MARIO = 8;
	
	final int LEFT = 1;
	final int RIGHT = 2;
	
	int[] move = new int[SIZE];
	
	int x; // 랜덤 좌표
	
	void moveRight() {
		
		if(x == SIZE - 1) {
			System.out.println("쿠웅-");
			return;
		}
		
		move[x] = 0;
		x++;
		move[x] = MARIO;
	}
	
	void moveLeft() {
		
		if(x == 0) {
			System.out.println("꽝-");
			return;
		}
		
		move[x] = 0;
		x--;
		move[x] = MARIO;
		
	}
	
	void move(int direction) {
		
		if(direction == LEFT)
			moveLeft();
		else if(direction == RIGHT)
			moveRight();
		
	}
	
	int inputNumber() {
		
		int number = 0;
		try {
			String input = scan.next();
			number = Integer.parseInt(input);
		}catch(Exception e) {
			System.out.println("숫자를 이동하세요.");
		}
		return number;
		
	}
	
	void printMap() {
		
		for(int i=0; i<SIZE; i++) {
			if(move[i] == MARIO)
				System.out.print("M_");
			else
				System.out.print("__");
		}
		System.out.println();
	}
	
	void setGame() {
		
		Random ran = new Random();
		
		x = ran.nextInt(SIZE);
		
		move[x] = MARIO;
		
		
	}
	
	void run() {
		
		setGame();
		while(true) {
			printMap();
			int dir = inputNumber();
			move(dir);
			
		}
		
	}
	
}
public class Practice15 {

	public static void main(String[] args) {

	}

}
