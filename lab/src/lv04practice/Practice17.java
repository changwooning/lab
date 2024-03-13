package lv04practice;

import java.util.Scanner;
import java.util.Random;

public class Practice17 {
	
	// 1 to 18
	//2145
	//2201
	
	

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		final int SIZE = 9;
		
		int[] front = new int[SIZE];
		int[] back = new int[SIZE];
		
		//set map
		for(int i=0; i<SIZE; i++) {
			front[i] = i + 1;
			back[i] = i + 1 + SIZE;
		}
		
		//셔플
		for(int i=0; i<100; i++) {
			//front
			int rIdx = (int)(Math.random() * SIZE);
			int temp = front[0];
			front[0] = front[rIdx];
			front[rIdx] = temp;
			//back
			rIdx =(int)(Math.random() * SIZE);
			temp = back[0];
			back[0] = back[rIdx];
			back[rIdx] = temp;
		}
		int gameNum = 1;
		
		while(true) {
			//출력 print
			for(int i=0; i<SIZE; i++) {
				System.out.printf("[%2d]",front[i]);
				if(i % 3 == 2)
					System.out.println();
			}
			
			//종료 조건
			if(gameNum > SIZE * 2)
				break;
			
			//입력 input
			System.out.print("입력 : ");
			int input = scan.nextInt();
			
			//예외처리 1. 인덱스 범위
			if(input < 0 || input > SIZE -1) {
				System.out.println("입력하신 값은 범위에 해당하지 않습니다.");
				continue;
			}
			
			//gameNum 등장
			if(front[input] == gameNum) {
				front[input] = back[input];
				back[input] = 0;
				gameNum ++;
			}else
				System.out.println("Beep-");

			
			
		}
		
		
	}

}
