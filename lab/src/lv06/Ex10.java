package lv06;

import java.util.Scanner;
import java.util.Random;
// # 1 to 50 [3단계] : 1 to 18
// 1. 구글에서 1 to 50 이라고 검색한다.
// 2. 1 to 50 순발력 게임을 선택해 게임을 실습해본다.
// 3. 위 게임을 숫자범위를 좁혀 1 to 18로 직접 구현한다.
// 4. 숫자 1~9는 front 배열에 저장하고,
// 	  숫자 10~18은 back 배열에 저장한다.

class OnetoEighteen {

	Scanner scan = new Scanner(System.in);
	Random ran = new Random();

	final int SIZE = 9;
	
	int[] front = new int[SIZE];
	int[] back = new int[SIZE];

	int gameNum = 1;
	
	// 기능의 단위로 메소드를 정의
	void setmap() {
		// set map
		for(int i=0; i<SIZE; i++) {
			front[i] = i+ 1;
			back[i] = i + 1 + SIZE;
		}
	}

	void shuffle() {
		// 셔플
		for(int i=0; i<300; i++) {
			int rIdx = (int)(Math.random()*SIZE);
			int temp = front[0];
			front[0] = front[rIdx];
			front[rIdx] = temp;
			
			rIdx = (int)(Math.random()*SIZE);
			temp = back[0];
			back[0] = back[rIdx];
			back[rIdx] = temp;
		}
	}
	
	void runPrint() {
		
		// print
		for(int i=0; i<SIZE; i++) {
			System.out.printf("[%2d]", front[i]);
			if(i % 3 == 2)
				System.out.println();
		}
		
	}
	
	int runInput() {
		
		// input
		System.out.print("idx : ");
		int idx = scan.nextInt();
		
		return idx;
	}
	
	void runEnd() {
		
		// end
		if(gameNum > SIZE * 2)
			break;
		
		
	}

	
	
	void run() {
		
		setmap();
		shuffle();
		
		
		
		
		// run
		while(true) {
			
			runPrint();
			runInput();
			
			
			// exception
			if(idx < 0|| idx > SIZE -1)
				continue;
			
			// 카드 뒤집기
			if(front[idx] == gameNum) {
				front[idx] = back[idx];
				back[idx] = 0;
				gameNum ++;
			}else 
				System.out.println("beep-");
			
		}
		// game end
		System.out.println("GAME CLEAR");
		
	}


}

public class Ex10 {

	public static void main(String[] args) {

		OnetoEighteen game = new OnetoEighteen();
		game.run();
		
		
		
	}

}
