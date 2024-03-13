package lv03practice;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Practice55 {
	
	// # 1 to 4

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		final int SIZE = 4;
		int gameNum = 1;
		
		int[] arr = new int[SIZE];
		int[] check = new int[SIZE];
		
		
		//arr 배열 초기화
		for(int i=0; i<SIZE; i++) {
			int rNum = ran.nextInt(SIZE) + 1;
			
			//사용확인
			if(check[rNum - 1] == 0) {
				arr[i] = rNum;
				check[rNum - 1] = 1;
			}else
				i--;
		}
		
		boolean isRun = true;
		while(isRun) {
			//출력
			System.out.println(Arrays.toString(arr));
			
			//입력
			System.out.print("인덱스 : ");
			int idx = scan.nextInt();
			
			//예외처리 1.인덱스 범위
			if(idx < 0 || idx > 3) {
				System.err.println("유효하지 않은 범위입니다.");
				continue;
			}
			//예외처리 2. 오답일때
			if(arr[idx] != gameNum) {
				System.out.println("땡");
				continue;
			}
			
			arr[idx] = 9;
			gameNum ++;
			
			//종료조건
			if(gameNum > SIZE) {
				System.out.println("GAME CLEAR");
				isRun = false;
			}
			
			
			
			
			
			
		}

	}

}
