package lv04;

import java.util.Random;

import java.util.Scanner;

public class Ex29 {
	// 랜덤 사다리버전

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		final int SIZE = 9;
		final int LEFT = 1;
		final int RIGHT = 2;

		int n = 0;
		while (n < 2) {
			System.out.print("참여 인원 수 : ");
			n = scan.nextInt();
		}

		String menu[] = new String[n];		// null 초기화 => scan.next();
		boolean[] isOpen = new boolean[n]; // {false, false,false,false,false}

		// 선생님 버전
		// 랜덤 사다리 생성
		int ladder[][] = new int[SIZE][n];
		boolean[] isHook = new boolean[n];

		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < n - 1; x++) {
				// 0 또는 1 -> 고리를 걸 때, 1-2 쌍으로 만들기
				ladder[y][x] = (int) (Math.random() * 2);
				if (ladder[y][x] == LEFT) {
					isHook[x] = true;
					x+=1;
					ladder[y][x] = RIGHT;
				}
			}
			// 맵이 완성된 후 검증
			if (y == SIZE - 1) {
				for (int i = 0; i < n - 1; i++) {
					if (!isHook[i]) { // 훅이 하나도 안걸린 상태
						ladder = new int[SIZE][n]; // 래더도 초기화
						y = -1; // 초기화 다시 그려라
						break;
					}
				}
			}
		}
		// ├ ─ ┤ │
		
		//참여 인원 수만큼 문자열 입력받기
		for(int i=0; i<n; i++) {
			System.out.printf("결과 값 %d : ", i+1);
			String str = scan.next();
			
			//문자열 비교 => 중요 equals
			// == 사용 x
			// 문자열변수.(equals()
			// ㄴ A.equls(B)
			boolean isDupl = false; 	// boolean 타입 반환
			for(int j=0; j<i; j++) {
				if(str.equals(menu[j]))
					isDupl = true;
			}
			
			if(!isDupl)
				menu[i] = str;
			else
				i--;
		}

		while (true) {
			// print
			for (int i = 0; i < n; i++) {
				System.out.print(i + 1 + " ");
			}
			System.out.println();
			// 맵출력
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
					System.out.print("◻︎");
				else
					System.out.print("︎◼");
			}
			// end
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				if (isOpen[i])
					cnt++;
			}
			if (cnt == n)
				break;

			// input
			System.out.print("\n번호 선택 : ");
			int x = scan.nextInt() - 1;

			if (x < 0 || x > n - 1) {
				System.out.printf("입력범위는 1~5입니다.",n);
				continue;
			}

			// 여기가 핵심 주요깊게 보기
			for (int y = 0; y < SIZE; y++) {
				if (ladder[y][x] == LEFT)
					x++;
				else if (ladder[y][x] == RIGHT)
					x--;
			}
			if (isOpen[x])
				System.out.println("이미 고른 메뉴입니다.");
			else {
				System.out.printf("%s 메뉴 당첨!\n", menu[x]);
				isOpen[x] = true;
			}

		}

	}

}
