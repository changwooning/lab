package lv01;

import java.util.Scanner;

import java.util.Random;

public class Ex35 {

	/*
	 * # 가운데 숫자 맞추기 게임 
	 * 1. 150~250 사이의 랜덤 숫자 저장 
	 * 2. 랜덤 숫자의 가운데 숫자를 맞추는 게임이다.
	 * 예) 249 : 4
	 */

	public static void main(String[] args) {

		Random random = new Random();
		Scanner scan = new Scanner(System.in);

		int rNum = random.nextInt(101) + 150;
		System.out.println("quiz : " + rNum);
		
		System.out.print("가운데 숫자는? : ");
		int answer = scan.nextInt();
		
		
		int x = rNum / 10 % 10;


		if (answer == x) {

			System.out.print("good!");
		} else {

			System.out.print("sorry~");
		}

		// 1. 랜덤 값 지정
		// 2. 중간값 찾기
		// 3. 비교하기
		// 4. 출력

	}

}
