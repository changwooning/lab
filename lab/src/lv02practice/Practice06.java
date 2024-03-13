package lv02practice;

import java.util.Scanner;
import java.util.Random;


public class Practice06 {
	
	//구구단게임
	//1551
	//1556

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		// 개수변수초기화
		int cnt = 0; 
		//5회반복
		for(int i=1; i<=5; i++) {
			//랜덤 값 두개 초기화
			int num1 = ran.nextInt(8) + 2;
			int num2 = ran.nextInt(9) + 1;
			//문제 출력
			System.out.print(num1 + " X " + num2 + " = ");
			//입력
			int answer = scan.nextInt();
			//정답확인
			if(answer == num1*num2) {
				//정답 개수확인
				cnt++;
			}
		}
		
		//게임종료
		System.out.println("게임종료");
		//성적산출 개수 당 20점
		System.out.println("성적 : " + cnt*20 + "점");

	}

}
