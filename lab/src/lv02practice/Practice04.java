package lv02practice;

import java.util.Random;
import java.util.Scanner;


public class Practice04 {
	
	//# 구구단 게임 [3단계]
	// 1. 구구단 게임을 5회 반복한다.
	// 2. 정답을 맞추면 개당 20점이다.
	// 3. 게임 종료 후 , 성적을 출력한다.
	
	//1535
	//1543
	

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		int cnt = 0;
		//5회반복
		for(int i=1; i<=5; i++) {
			//랜덤 점수 2개 초기화 
			int num1 = ran.nextInt(8) + 2;
			int num2 = ran.nextInt(10) + 1;
			//문제 출제
			System.out.print(num1 + " X " + num2 + " = ");
			int answer = scan.nextInt();
			
			
			if(answer == num1*num2)
				cnt ++;
			
		}
		//성적 산출
		System.out.print("성적 : " + cnt*20);

	}

}
