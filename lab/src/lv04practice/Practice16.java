package lv04practice;

import java.util.Scanner;
import java.util.Random;

public class Practice16 {
	
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
			rIdx = (int)(Math.random() * SIZE);
			temp = back[0];
			back[0] = back[rIdx];
			back[rIdx] = temp;
		}
			
		int gameNum = 1;
		
		//run
		while(true) {
			//맵출력 print
			for(int i=0; i<SIZE; i++) {
				System.out.printf("[%2d]",front[i]);	//%2d => 앞에 공간을 줌
				if(i % 3 == 2)
					System.out.println();
			}
			
			//종료조건
			if(gameNum > SIZE * 2)
				break;
			
			
			//input 입력
			System.out.print("입력 : ");
			int input = scan.nextInt()-1;	//질문
			
			//예외처리 1. 인덱스 범위
			if(input < 0 || input > SIZE -1) {
				System.out.println("입력하신 값은 범위에 해당하지 않습니다.");
				continue;
			}
			
			//gameNum => 등장 뭐냐면 1부터 시작한다라는 뜻으로
			if(front[input] == gameNum) {	//front 배열에 내가 입력한 값이 gameNum 이랑 같으면
				front[input] = back[input];
				back[input] = 0;
				gameNum ++;
			}else
				System.out.println("Beep-");
		}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
		
		
		
		
		
		

	}

}
