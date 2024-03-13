package lv02practice;

import java.util.Random;
import java.util.Scanner;



public class Practice03 {
	
	//# 구구단 게임 [3단계]
	// 1. 구구단 게임을 5회 반복한다.
	// 2. 정답을 맞추면 개당 20점이다.
	// 3. 게임 종료 후 , 성적을 출력한다.
	
	//1517
	//1529
	

	public static void main(String[] args) {
		
		Random ran = new Random();
		Scanner scan = new Scanner(System.in);
		
		int cnt = 0;
		
		//5회반복
		int n = 1;
		while(n<=5) {
			//문제 출제 => 랜덤 번호가 안나오나?! 랜덤초기화 변수 while문 안에 넣기
			int num1 = ran.nextInt(8) + 2;
			int num2 = ran.nextInt(9) + 1;
			System.out.print(num1 + " X " + num2 + " = ");
			//입력
			int answer = scan.nextInt();		
			//정답 확인
			if(answer == num1 * num2) {
				//정답 개수 확인 cnt
				cnt ++;
			}
			n++;
		}
		//게임종료
		System.out.println("게임종료");
		//성적산출
		System.out.println("성적 : " + cnt*20+"점");
		

	}

}
