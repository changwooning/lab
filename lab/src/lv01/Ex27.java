package lv01;

import java.util.Random;

import java.util.Scanner;


public class Ex27 {
	
	// 제어문 : 프로그램의 흐름을 제어
	// 1) 조건문 : if문 , if-else문
	// 2) 반복문
	// 3) 보조 제어문
	
	// if-else 문 사용 방법
	// if(조식){실행문}
	// else if(조건식2) {실행문}
	// else if(조건식3) {실행문}
	// else {실행문;}

	public static void main(String[] args) {

		/*
		 * # 홀짝 게임 
		 * 1. 1~100사이의 랜덤 숫자를 저장한다, 
		 * 2. 저장된 랜덤 숫자를 보여주고, 
		 * 3. 해당 숫자가 홀수인지 짝수인지 맞추는 게임이다.
		 * 
		 */
		
		
		Random random = new Random();
		Scanner scan = new Scanner(System.in);

		int rNum = random.nextInt(100) + 1;
		System.out.println("숫자 : " + rNum);
		//System.out.println("rNum : " + rNum);
		
		int answer = 0;
		
		if(rNum % 2 == 0) {
			answer = 2;
		}
		
		if(rNum % 2 == 1) {
			answer = 1;
		}
		
		
		
		System.out.println("홀(1)짝수(2)");
		int user = scan.nextInt();
		
		if(user == answer) {
			System.out.println("정답");
		}
		if(user != answer) {
			System.out.print("오답");
		}
		
		
		
	}

}
