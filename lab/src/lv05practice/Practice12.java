package lv05practice;

import java.util.Scanner;
import java.util.Random;

public class Practice12 {
	
	// 타자연습
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
		
		String[] data = {"mysql","java","spring","jsp"};
		
		
		for(int i=0; i<100; i++) {
			int rIdx = ran.nextInt(4);
			String temp = data[0];
			data[0] = data[rIdx];
			data[rIdx] = temp;
		}
		
		
		for(int i=0; i<data.length; i++) {
			
			System.out.println("문제 : " + data[i]);
			System.out.print("입력 : ");
			String input = scan.next();
			
			if(!input.equals(data[i]))
				i--;
		}
		
		System.out.println("game clear!~");
		
		
		
		
		
	}

}
