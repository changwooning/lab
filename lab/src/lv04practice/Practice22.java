package lv04practice;

import java.util.Scanner;

public class Practice22 {
	
	// # 사다리 게임
		// 1. 인덱스 0~4를 하나선택한다.
		// 2. 숫자 0을 만나면 그냥 아래로 내려간다.
		// 3. 숫자 1을 만나면 오른쪽으로 이동후 내려간다.
		// 4. 숫자 2를 만나면 왼쪽으로 이동후 내려간다.
		// 5. 오늘의 매뉴 출력
		//
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String menu[] = { "떡라면", "돈까스", "짜장면", "쫄면", "된장찌개" };
 		final int SIZE = 9;
		final int LEFT = 1;
		final int RIGHT = 2;
		final int N = 5;

		boolean[] isOpen = new boolean[N];
		
		int ladder[][] = {
				{ 0, 0, 0, 0, 0 }, 
				{ 1, 2, 0, 1, 2 }, 
				{ 0, 1, 2, 0, 0 }, 
				{ 0, 0, 1, 2, 0 },
				{ 1, 2, 0, 0, 0 }, 
				{ 0, 1, 2, 0, 0 }, 
				{ 1, 2, 0, 0, 0 }, 
				{ 0, 0, 0, 1, 2 }, 
				{ 0, 0, 0, 0, 0 }, 
			};
		
		
		while(true) {
			for(int i=0; i<N; i++) {
				System.out.print(i+1 + " ");
			}
			System.out.println();
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<N; j++) {
					if(ladder[i][j] == LEFT)
						System.out.print("├─");
					else if(ladder[i][j] == RIGHT)
						System.out.print("┤ ");
					else
						System.out.print("│ ");
				}
				System.out.println();
			}
			System.out.println();
			
			
			//종료
			int cnt = 0;
			for(int i=0; i<N; i++) {
				if(isOpen[i])
					cnt ++;
			}
			if(cnt == N)
				break;
			
			//input
			System.out.print("\n번호 선택 : ");
			int x = scan.nextInt()-1;
			
			if(x < 0 || x > N-1) {
				System.out.println("입력범위는 1~5입니다.");
				continue;
			}
			
			//여기가 핵심 주요깊게 보기
			for(int y=0; y<SIZE; y++) {
				if(ladder[y][x] == LEFT)
					x++;
				else if(ladder[y][x] == RIGHT)
					x--;
			}
			if(isOpen[x]) {
				System.out.println("이미 고른 메뉴입니다.");
			}else {
				System.out.printf("$s 메뉴 당첨!\n", menu[x]);
				isOpen[x] = true;
			}
				
			
			
			
			
			
			
		}
		
		
		
		

	}

}
