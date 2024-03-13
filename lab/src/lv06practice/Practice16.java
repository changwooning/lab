package lv06practice;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

class Memoryp1{
	
	Scanner scan = new Scanner(System.in);
	
	final int SIZE = 10;
	final int FLIPED = 1;
	
	int[] front;
	int[] back;
	
	int cnt;
	
	void printResult(boolean success) {
		
		if(success)
			System.out.println("카드가 뒤집혔습니다.");
		else
			System.out.println("카드 뒤집기 실패");
	}
	
	boolean flipCards(int firstIndex, int secondIndex) {	// 카드뒤집기 및 예외처리 boolean 타입으로
		
		if(firstIndex == secondIndex)
			return false;
		
		if(front[firstIndex] != front[secondIndex])
			return false;
		
		if(back[firstIndex] == FLIPED)	// 이미 뒤집혀진 카드
			return false;
		
		back[firstIndex] = FLIPED;
		back[secondIndex] = FLIPED;
		cnt++;	// 정답을 맞춘개수 
		
		return true;
		
	}
	
	int inputIndex(int[] array) {
		
		int index = -1;
		while(true) {		// 정답을 다 맞출때까지 반복을 해야하니까
			try {
				System.out.print("index : ");
				String input = scan.next();
				index = Integer.parseInt(input)-1;
			}catch(Exception e) {
				System.out.println("숫자를 입력하세요.");
			}
			
			if(index >= 0 && index < array.length)
				break;
		}
		
		return index;
		
		
	}
	
	void printQuiz() {
		
		for(int i=0; i<SIZE; i++) {
			System.out.print(i+1);
			if(i<SIZE-1)
				System.out.print(", ");
		}
		System.out.println();
		System.out.println(Arrays.toString(front));
		System.out.println(Arrays.toString(back));
		
	}
	
	boolean isRun() {
		
		return cnt == SIZE / 2 ? false : true;
		
	}
	
	void shuffle(int[] front) {
		
		Random ran = new Random();
		for(int i=0; i<400; i++) {
			int rIdx = ran.nextInt(SIZE);
			int temp = front[0];
			front[0] = front[rIdx];
			front[rIdx] = temp;
		}
		
		
	}
	
	void setGame() {
		
		cnt = 0;
		front = new int[SIZE];
		back = new int[SIZE];
		
		for(int i=0; i<SIZE; i++) 
			front[i] = (i+2)/2;
		
		shuffle(front);
		
	}
	
	void run() {
		
		setGame();
		while(isRun()) {
			printQuiz();
			int idx1 = inputIndex(front);
			int idx2 = inputIndex(front);
			printResult(flipCards(idx1,idx2));
		}
		
	}
	
}
public class Practice16 {

	public static void main(String[] args) {

	}

}
