package lv02practice;

import java.util.Scanner;
import java.util.Random;


public class Practice05 {
	//구구단게임
	//1544
	//1550
	

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		int cnt = 0;
		
		int n = 1;
		while(n<=5) {
			//랜덤 값 두개 초기화
			int num1 = ran.nextInt(8) + 2;
			int num2 = ran.nextInt(9) + 1;
			//문제 출제
			System.out.print(num1 + " X " + num2 + " = ");
			int answer = scan.nextInt();
			//정답 확인
			if(answer == num1*num2) {
				//정답 개수 확인 cnt 변수 필요
				cnt ++;
			}
			n++;
		}
		//게임종료
		System.out.println("게임종료");
		//성적 산출  개수 당 20점
		System.out.println("성적 : " + cnt*20 + "점");
		
		

	}

}
