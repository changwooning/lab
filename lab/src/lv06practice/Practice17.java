package lv06practice;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
class Memoryp2{
	
	Scanner scan = new Scanner(System.in);
	
	final int SIZE = 10;
	final int FLIPED = 1;
	
	int[] front;
	int[] back;
	
	int cnt; // 정답 개수 확인
	
	void printResult(boolean success) {
		
		if(success)
			System.out.println("카드가 뒤집혔습니다.");
		else
			System.out.println("카드 뒤집기 실패!");
		
	}
	
	boolean flipCard(int firstIndex,int secondIndex) {	// boolean 타입으로
		
		if(firstIndex == secondIndex)
			return false;
		
		if(back[firstIndex] != 0)
			return false;
		
		if(front[firstIndex] != front[secondIndex])
			return false;
		
		back[firstIndex] = FLIPED;
		back[secondIndex] = FLIPED;
		cnt++;
		
		return true;
		
	}
	
	int inputIndex(int[] array) {
		
		int index = -1;
		while(true) {
			System.out.print("index : ");
			try {
				String input = scan.next();
				index = Integer.parseInt(input)-1;
			}catch(Exception e) {
				System.out.println("숫자만 입력하세요.");
			}
			
			if(index >= 0 && index < array.length)
				break;
		}
		
		return index;
		
		
	}
	
	void printMap() {
		
		for(int i=0; i<SIZE; i++) {
			System.out.print(i+1);
			if(i < SIZE -1)
				System.out.print(", ");
		}
		
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
		
		for(int i=0; i<SIZE; i++) {	// 1,1,2,2,3,3,4,4,5,5}
			front[i] = (i+2)/2;   
		}
		
		shuffle(front);
		
	}
	
	void run() {
		
		setGame();
		while(isRun()) {
			printMap();
			int index1 = inputIndex(front);
			int index2 = inputIndex(front);
			printResult(flipCard(index1,index2));
		}
		
		
	}
	
}
public class Practice17 {

	public static void main(String[] args) {

	}

}
