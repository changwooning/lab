package lv03;

import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class Ex29 {

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

		int[] front = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 };
		int[] back = new int[10]; // 뒤집힌 카드 확인용 (1: 뒤짚힘)

		// 카드섞기 (front)
		// ㄴ 배열 값 교체 활용
		// {1,2,5,4,3,3,1,4,2,5}

		for (int i = 0; i < 1000; i++) {
			int rIdx = ran.nextInt(10);

			int temp = front[0]; // 기준
			front[0] = front[rIdx];
			front[rIdx] = temp;
		}
		
		// 게임 실행 
		boolean isRun = true;
		while(isRun) { 
			System.out.println(Arrays.toString(front));
			System.out.println(Arrays.toString(back));
			// 여기서 숫자는 카드의 인덱스!
			System.out.print("입력 1 : ");
			int num1 = scan.nextInt();
			System.out.print("입력 2 : ");
			int num2 = scan.nextInt();
			
			//입력한 인덱스를 입력했을때 인덱스의값이 같아야한다.
			if(num1 > 0 && num1 <= 5)
			if(front[num1] == front[num2]) {
				back[num1] = 1;
				back[num2] = 1;
			}
			
			
			
		}
			
			
		

	}

}
