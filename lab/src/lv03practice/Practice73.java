package lv03practice;

import java.util.Scanner;

public class Practice73 {
	
	/*
	 * # 숫자이동[1단계]
	 * 1. 숫자2는 캐릭터이다.
	 * 2. 숫자1을 입력하면, 캐릭터가 왼쪽으로
	 * 	    숫자2를 입력하면, 캐릭터가 오른쪽으로 이동한다.
	 * 3. 단, 좌우 끝에 도달했을 때, 예외처리를 해야한다.
	 * 4. {0, 0, 2, 0, 0, 0, 0};  ==> 왼쪽 ==> {0, 2, 0, 0, 0, 0, 0};
	 * 
	 */
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] game = {0,0,2,0,0,0,0};
		
		
		//플레에어 초기화
		int x = -1;
		for(int i= 0; i<7; i++) {
			if(game[i] == 2)
				x = i;
		}
		boolean run = true;
		while(run) {
			
			
			//맵출력
			for(int i=0; i<7; i++) {
				if(game[i] == 2)
					System.out.print("훗_");
				else
					System.out.print("__");
			}
			
			//입력
			System.out.println("1.왼쪽 2.오른쪽");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				
					if(x > 0) {
						game[x-1] = 2;
						game[x] = 0;
						x--;
					}
					else
						System.out.println("빠직!");
					
			}else if(sel == 2) {
				
					if(x < 6) {
						game[x+1] = 2;
						game[x] = 0;
						x ++;
					}else
						System.out.println("꽝!!");
				
			}
			
				
			
			
			
			
			
		}
		
		
		
		

	}

}
