package lv06;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class MemoryGame2 {

	Scanner scan = new Scanner(System.in);
	final int SIZE = 10;
	final int FLIPED = 1;

	int[] front;
	int[] back;

	int cnt;

	void setGame() {

		cnt = 0;
		front = new int[SIZE];
		back = new int[SIZE];

		for (int i = 0; i < SIZE; i++)
			front[i] = (i + 2) / 2;

		shuffle(front);

	}

	void shuffle(int[] front) {

		Random ran = new Random();
		for (int i = 0; i < SIZE * 10; i++) {
			int rIdx = ran.nextInt(SIZE);
			int temp = front[0];
			front[0] = front[rIdx];
			front[rIdx] = temp;

		}

	}

	boolean isRun() {

		return cnt == SIZE / 2 ? false : true;

	}

	void printQuiz() {		// 맵출력 문제

		System.out.print("[");
		for (int i = 0; i < SIZE; i++) {
			System.out.print(i + 1);
			if (i < SIZE - 1)
				System.out.print(", ");
		}
		System.out.print("]");
		System.out.println();
		System.out.println(Arrays.toString(front));
		System.out.println(Arrays.toString(back));

	}

	int inputIndex(int[] array) {
		int index = -1;
		while (true) {
			try {
				System.out.print("index : ");
				String input = scan.next();
				index = Integer.parseInt(input)-1;

			} catch (Exception e) {
				System.out.println("숫자를 입력해주세요.");
			}

			if (index >= 0 && index < array.length)
				break;

		}
		return index;
	}
	
	boolean flipCards(int firstIndex, int secondIndex) {
		
		if(firstIndex == secondIndex)
			return false;
		
		if(front[firstIndex] != front[secondIndex])
			return false;

		if(back[firstIndex] == FLIPED)
			return false;
		
		back[firstIndex] = FLIPED;
		back[secondIndex] = FLIPED;
		cnt++;
		
		return true;
		
	}
	
	void printResult(boolean success) {
		
		if(success)
			System.out.println("카드가 뒤집혔습니다.");
		else
			System.err.println("카드 뒤집기 실패-");
		
	}

	void run() {

		setGame();
		while (isRun()) {

			printQuiz();
			int index1 = inputIndex(front);
			int index2 = inputIndex(front);
			printResult(flipCards(index1, index2));

		}

	}

}

public class Ex19 {

	public static void main(String[] args) {

		MemoryGame2 mg = new MemoryGame2();
		mg.run();
	}

}
