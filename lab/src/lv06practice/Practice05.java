package lv06practice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

// 1 to 18

class ont{
	
	Scanner scan = new Scanner(System.in);
	final int SIZE = 9;
	
	int gameNum;
	
	int[] front = new int[SIZE];
	int[] back = new int[SIZE];
	
	void printResult() {
		
		System.out.println("GAME CLEAR");
		
	}
	
	void flipCard(int index) {
		
		if(index < 0 || index > SIZE -1)
			return;
		
		if(front[index] == gameNum) {
			front[index] = back[index];
			back[index] = 0;
			gameNum ++;
		}
		
	}
	
	int inputIndex() {
		
		int index = -1;
		try {
			String input = scan.next();
			index = Integer.parseInt(input);
		}catch(Exception e) {
			System.out.println("숫자를 입력하세요.");
		}
		
		return index;
		
		
	}
	
	boolean isRun() {	// 	종료조건 ?
		
		return gameNum > SIZE * 2 ? false : true;
		
	}
	
	void printMap() {
		
		for(int i=0; i<SIZE; i++) {
			System.out.printf("%2d ", front[i]);
			
			if(i % 3 == 2)
				System.out.println();
		}
		
	}
	
	void suffle(int[] array) {
		Random ran = new Random();
		
		for(int i=0; i<array.length; i++) {
			int rIdx = ran.nextInt(array.length);
			int temp = array[0];
			array[0] = array[rIdx];
			array[rIdx] = temp;
		}
		
		
	}
	
	void setMapArray(int[] array, int start) {
		
		for(int i=0; i<array.length; i++)
			array[i] = start + i;
		
		suffle(array);
		
	}
	
	void setMap() {
		
		gameNum = 1;
		setMapArray(front,1);		// front 초기화
		setMapArray(front,SIZE+1);	// back 초기화
		
	}
	
	void run() {
		
		setMap();
		while(isRun()) {
			printMap();
			int idx = inputIndex();
			flipCard(idx);
		}
		printResult();
		
		
	}
			
}


public class Practice05 {

	public static void main(String[] args) {
		
		

	}

}
