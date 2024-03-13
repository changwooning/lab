package lv02;

import java.util.Scanner;

import java.util.Random;

public class Ex04 {
	
			//# 구구단 게임 [3단계]
			// 1. 구구단 게임을 5회 반복한다.
			// 2. 정답을 맞추면 개당 20점이다.
			// 3. 게임 종료 후 , 성적을 출력한다.

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		
		int count = 0;
		
		int dan = 1;
		while(dan <= 5) {
			// 1) 랜덤 구구단 문제 출력
			
			int x = random.nextInt(10) + 1;
			int y = random.nextInt(10) + 1;
			
			int result = x * y;
			
			System.out.printf("%d X %d = ",x ,y);
			int answer = scan.nextInt();
			
			// 정답이 맞을때
			if(result == answer) {
				count += 1;
				}
			// 2) 사용자에게 답안을 입력 받기
			// 3) 정답을 맞추면 -> 개수 세기
			dan += 1;
		}
		System.out.println("게임종료");
		System.out.println("성적 결과 : " + (count * 20));
		
		// 4)게임 종료 (반복문 종료 시점)
		// 5)ㄴ 성적을 출력 -> count * 20
	
		

	}

}
