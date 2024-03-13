package lv06;

import java.util.Scanner;
import java.util.Random;
// # 숫자이동
// 1. 숫자 8은 캐릭터이다.
// 2. 숫자 1을 입력하면, 캐릭터가 왼쪽으로 이동한다.
// 3. 숫자 2를 입력하면, 캐릭터가 오른쪽으로 이동한다.
// 4. 좌우 끝에 도달했을 때 에러가 발생하지 않도록 예외처리를 한다.

class Mario {

	Scanner scan = new Scanner(System.in);

	final int SIZE = 10;
	final int MARIO = 8;

	int[] move = new int[SIZE];

	int x; // 플레이어 랜덤 좌표에서 시작
	
	void resetPlayer(int pX) {
		
		// 플레이어 재배치
		move[x] = 0;
		x = pX;
		move[x] = MARIO;
		
	}
	
	int movePlayer(int input) {
		
		int pX = x;
		
		if(input == 1)
			pX --;
		else if(input == 2)
			pX ++;
		
		if(pX < 0 || pX > SIZE -1)
			return x;		// 이동 전 좌표
		
		return pX;			// 이동 후 좌표
	}
	
	int inputPlayer() {
		
		// input
		System.out.println("이동 : 왼쪽1 오른쪽2");
		int input = scan.nextInt();
		
		if(input < 0 || input > SIZE-1)
			return input;
		
		return input;
		
	}
	
	void printMap() {
		
		// 현재 랜덤 위치
		move[x] = MARIO;
		
		// print
		for (int i = 0; i < SIZE; i++) {
			if (move[i] == MARIO)
				System.out.print("M_");
			else
				System.out.print("__");
		}
		
	}
	
	void coordinate() {
		
		// 랜덤 좌표
		Random ran = new Random();
		x = ran.nextInt(SIZE);
		
	}
	
	void reset() {
		
		// 플레이어 초기화
		for (int i = 0; i < SIZE; i++) {
			if (move[i] == x)
				x = i;
		}
		
	}

	void run() {

		reset();
		coordinate();
		while (true) {

			printMap();
			int input = inputPlayer();
			int move = movePlayer(input);
			resetPlayer(move);
		}

	}

}

public class Ex16 {

	public static void main(String[] args) {
		
		Mario mario = new Mario();
		mario.run();

	}

}
