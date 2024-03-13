package lv03practice;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Practice53 {
	//# 기억력 게임
	//2149
	//2209
	
	
	public static void main(String[] args) {
		
		Random ran = new Random();
		Scanner scan = new Scanner(System.in);
		
		int[] front = {1,1,2,2,3,3,4,4,5,5};
		int[] back = new int[10];
		
		final int SIZE = 10;
		
		
		//front 랜덤 값 지정 
		for(int i=0; i<1000; i++) {
			int rIdx = ran.nextInt(10) + 0;	//front 인덱스
			//랜덤 값 교체
			int temp = front[0];
			front[0] = front[rIdx];
			front[rIdx] = temp;
		}
		int correct = 0;
		
		boolean isRun = true;
		while(isRun) {
			//맵출력
			for(int i=0; i<SIZE; i++) {
				System.out.print(i + " ");
				if(i<SIZE -1)
					System.out.print(",");
			}
			System.out.println();
			System.out.println(Arrays.toString(front));
			System.out.println(Arrays.toString(back));
			//입력
			System.out.print("idx1 : ");
			int idx1 = scan.nextInt();
			System.out.print("idx2 : ");
			int idx2 = scan.nextInt();
			
			//예외처리 1.인덱스 기준
			if(idx1 < 0 || idx1 > SIZE-1 || idx2 < 0 || idx2 > SIZE -1 || idx1 == idx2) {
				System.err.println("유효하지 않은 범위입니다.");
				continue;
			}
			//예외처리 2. 이미 뒤집어진 카드
			if(back[idx1] != 0) {
				System.err.println("이미 뒤집어진 카드입니다.");
				continue;
			}
			//예외처리 3. 오답일때
			if(front[idx1] != front[idx2]) {
				System.err.println("땡~!");
				continue;
			}
			
			//카드 뒤집기
			back[idx1] = 1;
			back[idx2] = 1;
			correct ++;
			
			//종료조건
			if(correct == SIZE/2) {
				System.out.println("GAME CLEAR");
				isRun = false;
			}
			
			
			
			
		}
		
		

	}

}
