package lv05;

import java.util.Scanner;
import java.util.Random;

public class Ex10 {

	// # 타자연습 게임[1단계]
	// 1. 문제를 섞는다.(shuffle)
	// 2. 순서대로 문제를 출제하고, 문제를 다 맞추면 게임 종료
	// 3. 문제 출제시 랜덤한 위치에 *별 찍기 (캐릭터 숨기기)
	// 4. 정답이 아니면 별 위치가 변하면 x
	// 5. word[i]의 문자열과 일치하면 정답
	// 예)
	// 문제 : m*sql
	// 입력 : mydb
	// 문제 : m*sql
	// 입력 : mysql <-- 정답을 맞추면, 다음 문제 제시
	// 문제 : *sp

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		String[] word = { "java", "mysql", "jsp", "spring" };

		for (int i = 0; i < 100; i++) {
			int rIdx = ran.nextInt(4);
			String temp = word[0];
			word[0] = word[rIdx];
			word[rIdx] = temp;
		}

		for (int i = 0; i < word.length; i++) {
			System.out.println("문 제 : " + word[i]);
			System.out.print("입 력 : ");
			String input = scan.next();

			if (!word[i].equals(input)) {
				i--;	// 오답일때 다음문제로 넘어가지않고 대기하는 것
			}
		}
		
		
		
		
		
		

	}

}
