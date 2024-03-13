package lv06;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
// # 기억력 게임 : 클래스 + 메서드
// 1. front 배열 카드 10장을 섞는다.
// 2. front 배열에서 같은 카드를 골라 카드의 위치를 입력한다.
// 3. 선택한 2장의 카드가 같은 카드이면, back 배열에 표시한다.
// 4. 모든 카드가 뒤집히면 (back 배열의 0이 사라지면) 게임은 종료된다.

class MemoryGame {

	final int SIZE = 10;

	int[] front;
	int[] back;

	int cnt;		// 정답을 맞춘 개수

	void shuffle() {

		Random ran = new Random();
		// 셔플
		for (int i = 0; i < 500; i++) {
			int rIdx = ran.nextInt(SIZE);
			int temp = front[0];
			front[0] = front[rIdx];
			front[rIdx] = temp;
		}

	}

	void reset() {
		
		
		int[] front = {1,1,2,2,3,3,4,4,5,5};
		this.front = front;
		back = new int[SIZE];
		
		shuffle();

	}

	void printState() {

		System.out.println(Arrays.toString(front));
		System.out.println(Arrays.toString(back));

	}

	int inputNumber() {

		Scanner scan = new Scanner(System.in);
		int idx = -1;
		try {
			System.out.print("idx : ");
			idx = scan.nextInt();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return idx;

	}

	void exception(int idx1, int idx2) {

		if (idx1 < 0 || idx1 > SIZE - 1 || idx2 < 0 || idx2 > SIZE - 1 || idx1 == idx2)
			return;

		if (back[idx1] != 0)
			return;

		if (front[idx1] != front[idx2])
			return;

	}

	void flip(int idx1,int idx2) {

		back[idx1] = 1;
		back[idx2] = 1;
		cnt++;

	}

	void end() {

		if (cnt == SIZE / 2) {
			System.out.println("GAME CLEAR~");
			return;
		}

	}
	
	boolean isRun() {
		
		return false;
		
	}

	void run() {

		reset();

		while (isRun()) {

			printState();
			int input1 = inputNumber();
			int input2 = inputNumber();
			exception(input1,input2);
			flip(input1,input2);
			end();

		}

	}
}

public class Ex18 {

	public static void main(String[] args) {

		MemoryGame mg = new MemoryGame();
		mg.run();

	}

}
