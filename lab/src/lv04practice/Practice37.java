package lv04practice;

import java.util.Scanner;
import java.util.Random;

public class Practice37 {
	
	// # 1 to 50
		// 1. 구글에서 1 to 50 이라고 생각한다.
		// 2. 1 to 50 순발력 게임을 선택해 게임을 실습해본다.
		// 3. 위 게임을 숫자범위를 좁혀 1 to 18로 직접 구현한다.
		// 4. 숫자 1~9 는 front 배열에 저장하고,
		// 숫자 10~18은 back 배열에 저장한다.


	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		final int SIZE = 9;
		
		int[] front = new int[SIZE];
		int[] back = new int[SIZE];
		
		//set map
		for(int i=0; i<SIZE; i++) {
			front[i] = i+1;
			back[i] = i + 1 + SIZE;
		}
		
		//셔플
		for(int i=0; i<SIZE; i++) {
			int rIdx = (int)(Math.random() * SIZE);
			int temp = front[0];
			front[0] = front[rIdx];
			front[rIdx] = temp;
			
			rIdx = (int)(Math.random()* SIZE);
			temp = back[0];
			back[0] = back[rIdx];
			back[rIdx] = temp;
		}
		
		//run
		int gameNum = 1;
		while(true) {
			//출력
			for(int i=0; i<SIZE; i++) {
				System.out.printf("[%2d]", front[i]);
				if(i % 3 == 2)
					System.out.println();
			}
			
			//종료조건
			if(gameNum > SIZE * 2)
				break;
			
			//입력
			System.out.print("idx : ");
			int idx = scan.nextInt();
			
			//예외처리
			if(idx < 0 || idx > SIZE-1) {
				System.out.println("유효하지 않은 값 입니다.");
				continue;
			}
			
			//카드 뒤집기
			if(front[idx] == gameNum) {
				front[idx] = back[idx];
				back[idx] = 0;
				gameNum++;
			}else
				System.out.println("Beep-");
			
		}
		System.out.println("GAME CLEAR~");
		

	}

}
