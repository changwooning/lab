package lv04practice;

import java.util.Scanner;
import java.util.Random;

public class Practice54 {

	// 랜덤 사다리 버전
	// 1400

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		final int SIZE = 9;
		final int LEFT = 1;
		final int RIGHT = 2;

		// 참여인원수
		int n = 0;
		while (n < 2) {
			System.out.print("참여 인원 수 : ");
			n = scan.nextInt();
		}

		boolean[] isOpen = new boolean[n];
		int[][] ladder = new int[SIZE][n];

		String[] menu = new String[n];
		boolean[] isHook = new boolean[n];
		
		for(int y=0; y<SIZE; y++) {
			for(int x=0; x<n-1; x++) {
				//0 또는 1 -> 고리를 걸때, 1-2 쌍으로 만들기
				ladder[y][x] = (int)(Math.random()*2);	// 0 OR 1
				if(ladder[y][x] == LEFT) {				// 1이면 
					isHook[x] = true;
					x += 1;
					ladder[y][x] = RIGHT;				// 오른쪽에도 2걸어주기 
				}
			}
			//맵이 완성된 후 검증
			if(y == SIZE - 1) {							// y 즉, 행이 마지막일때
				for(int i=0; i<n-1; i++) {				// -> 각 열에 후크가 하나도 없는 경우를 확인 
					if(!isHook[i]) {
						ladder = new int[SIZE][n];		// 맵 초기화 
						y = -1;							// y for문을 다시 처음부터 시작 -> 0부터 시작 
						break;
					}
				}
			}
		}
		
		//참여 인원 수만큼 문자열 입력받기
		for(int i=0; i<n; i++) {
			System.out.printf("메뉴 %d : ", i+1);
			String str = scan.next();
			
			//중복여부
			boolean isDupl = false;
			for(int j=0; j<i; j++) {
				if(str.equals(menu[j]))
					isDupl = true;
			}
			if(!isDupl)
				menu[i] = str;
			else
				i--;
		}
		
		

		// ├ ─ ┤ │
		while (true) {
			// set map
			for (int i = 0; i < n; i++)
				System.out.print(i + 1 + " ");
			System.out.println();

			// print
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < n; j++) {
					if (ladder[i][j] == LEFT)
						System.out.print("├─");
					else if (ladder[i][j] == RIGHT)
						System.out.print("┤ ");
					else
						System.out.print("│ ");
				}
				System.out.println();
			}
			for(int i=0; i<n; i++) {
				if(isOpen[i])
					System.out.print("◻");
				else
					System.out.print("◼");
			}
			//end
			int cnt = 0;
			for(int i=0; i<n; i++) {
				if(isOpen[i])
					cnt++;
			}
			if(cnt == n)
				break;
			
			// input
			System.out.print("번호 선택 : ");
			int x = scan.nextInt() - 1;

			// 예외처리
			if (x < 0 || x > n - 1) {
				System.out.printf("입력범위는 1~5입니다.", n);
				continue;
			}

			for (int y = 0; y < SIZE; y++) {
				if (ladder[y][x] == LEFT)
					x++;
				else if (ladder[y][x] == RIGHT)
					x--;
			}

			if (isOpen[x]) {
				System.out.println("이미 고른 메뉴입니다.");
				continue;
			} else {
				System.out.printf("%s 메뉴 당첨!", menu[x]);
				isOpen[x] = true;
			}
		}
	}

}
