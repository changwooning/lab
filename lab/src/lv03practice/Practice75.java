package lv03practice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;


public class Practice75 {
	
	/*
	 * # 기억력 게임
	 * 1. 같은 숫자의 위치를 2개 입력해 정답을 맞추는 게임이다.
	 * 2. 정답을 맞추면 back에 해당 숫자를 저장해,
	 *    back에 모든 수가 채워지면 게임은 종료된다.
	 * 예)
	 * front = [1, 1, 2, 2, 3, 3, 4, 4, 5, 5]
	 * back  = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	 * 입력1 : 0
	 * 입력2 : 1
	 * 
	 * front = [1, 1, 2, 2, 3, 3, 4, 4, 5, 5]
	 * back  = [1, 1, 0, 0, 0, 0, 0, 0, 0, 0]
	 */


	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		final int SIZE = 10;
		
		int[] front = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
		int[] back = new int[SIZE];
		
		//카드섞기 (front)
		for(int i=0; i<1000; i++) {	//1000번정도 랜덤
			//랜덤값 초기화
			int rIdx = ran.nextInt(10);	//front 의 인덱스로 사용 0~9
			//값 변경
			int temp = front[0];	//0위치로 기준
			front[0] = front[rIdx];
			front[rIdx] = temp;
			
		}		
		
		int correct = 0;
		
		boolean run = true;
		while(run) {
			
			for(int i=0; i<SIZE; i++) {
				//번호출력
				System.out.print(i + " ");
				if(i<SIZE-1)
					System.out.print(",");
			}
			System.out.println();
			//카드출력
			System.out.println(Arrays.toString(front));
			System.out.println(Arrays.toString(back));
			//카드입력
			System.out.print("idx1 : ");
			int idx1 = scan.nextInt();
			System.out.print("idx2 : ");
			int idx2 = scan.nextInt();
			
			//예외처리 1. 인덱스 범위
			if(idx1 < 0 || idx1 > SIZE-1 || idx2 < 0 || idx2 > SIZE-1) {
				System.out.println("범위에 벗어난 값입니다.");
				continue;
			}
			//예외처리 2. 이미뒤집어진 카드
			if(back[idx1] != 0) {
				System.out.println("이미 뒤집어진 카드입니다.");
			}
			//예외처리 3. 오답일때
			if(front[idx1] != front[idx2]) {
				System.out.println("땡!");
				continue;
			}
			
			//카드뒤집기
			back[idx1] = 1;
			back[idx2] = 1;
			
			//종료조건
			correct++;
			
			if(correct == SIZE/2) {
				System.out.println("GAME CLEAR~");
				run = false;
			}
		
		}
		
		
		
		
		

	}

}
