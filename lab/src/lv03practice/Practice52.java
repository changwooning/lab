package lv03practice;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Practice52 {

	
	// # 기억력 게임
		// 1. 같은 숫자의 위치를 2개 입력해 정답을 맞추는 게임이다.
		// 2. 정답을 맞추면 back에 해당 숫자를 저장해,
		// back에 모든 수가 채워지면 게임은 종료된다.
		// 예)
		// front = [1,1,2,2,3,3,4,4,5,5]
		// back = [0,0,0,0,0,0,0,0,0,0]
		// 입력1 : 0
		// 입력2 : 1

		// front = [1,1,2,2,3,3,4,4,5,5]
		// back = [1,1,0,0,0,0,0,0,0,0]
		//

	public static void main(String[] args) {
		
		Random ran = new Random();
		Scanner scan = new Scanner(System.in);
		
		final int SIZE = 10;
		
		int[] front = {1,1,2,2,3,3,4,4,5,5};
		int[] back = new int[10];
		
		//카드섞기 (front)
		// ㄴ 배열 값 교체 활용
		// {1,2,5,4,3,3,1,4,2,5}
		for(int i=0; i<1000; i++) {	//1000번정도 돌리라고했음
			//랜덤값초기화
			int rIdx = ran.nextInt(10);	//front 의 인덱스로 사용
			//값 변경
			int temp = front[0]; 	//0위치로 기준
			front[0] = front[rIdx];
			front[rIdx] = temp;
		}
		int correct = 0;	// 종료 조건을 사용하기 위한
		
		boolean isRun = true;
		while(isRun) {
			for(int i=0; i<SIZE; i++) {
				//번호 출력
				System.out.print(i + " ");
				if(i < SIZE-1) {	//9전까지만 ,를 넣겠다.
					System.out.print(",");
				}
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
			//예외처리 1. 인덱스(기준)범위
			if(idx1 < 0 || idx1 > SIZE-1 || idx2 <0 || idx2 > SIZE-1 || idx1 == idx2) {
				System.err.println("범위에 벗어난 값입니다.");
				continue;
			}
			//예외처리 2. 이미 뒤집어진 카드
			if(back[idx1] != 0) {	//1이라는 소리
				System.err.println("이미 뒤집어진 카드입니다.");
				continue;
			}
			//예외처리 3. 오답
			if(front[idx1] != front[idx2]) {
				System.err.println("땡!!");
				continue;
			}
			
			//카드 뒤집기
			back[idx1] = 1;
			back[idx2] = 1;
			//종료조건 때문에
			correct ++;
			
			//종료조건
			if(correct == SIZE/2) {
				System.out.println("GAME CLEAR~");
				isRun = false;
			}
			
			
		}
		
		

	}

}
