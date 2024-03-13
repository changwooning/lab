package lv06;

import java.util.Random;
import java.util.Scanner;

class Mario2{
	Scanner scan = new Scanner(System.in);

	final int SIZE = 10;
	final int MARIO = 8;
	
	final int LEFT = 1;
	final int RIGHT = 2;
	

	int[] move = new int[SIZE];

	int x; // 플레이어 랜덤 좌표에서 시작
	
	void printMap() {
		
		for(int i=0; i<SIZE; i++) {
			if(move[i] == MARIO)
				System.out.print("M_");
			else
				System.out.print("__");
		}
		System.out.println();
	}
	
	int inputNumber() {
		int number = 0;
		try {
			String input = scan.next();
			number = Integer.parseInt(input);
		}catch(Exception e) {
			System.err.println("숫자를 입력하세요.");
		}
		
		return number;
		
	}
	
	void setGame() {
		
		Random ran = new Random();
		x = ran.nextInt(SIZE);
		move[x] = MARIO;
		
	}
	
	void moveLeft() {
		if(x == 0) {
			System.err.println("꽝!");
			return;
		}
		
		move[x] = 0;
		move[--x] = MARIO;
		
	}
	
	void moveRight() {
		if(x == SIZE-1) {
			System.err.println("쿠웅-");
			return;
		}
		
		move[x] = 0;
		move[++x] = MARIO;
	}
	
	void move(int direction) {
		if(direction == LEFT)
			moveLeft();
		else if(direction == RIGHT)
			moveRight();
		
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

public class Ex17 {

	public static void main(String[] args) {

		Mario2 mario = new Mario2();
		mario.run();
	}

}
