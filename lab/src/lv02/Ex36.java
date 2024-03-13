package lv02;
import java.util.Scanner;
import java.util.Random;


public class Ex36 {
	
	//# 구구단 게임 [3단계]
		// 1. 구구단 게임을 5회 반복한다.
		// 2. 정답을 맞추면 개당 20점이다.
		// 3. 게임 종료 후 , 성적을 출력한다.
	
	// 1850
	// 18 55
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		
		int cnt = 0;
		int n = 1;
		// 5회 반복
		while(n <= 5) {
			//랜덤 값 2개 지정
			int ran = random.nextInt(9) + 1;
			int ran1 = random.nextInt(9) + 1;
			
			//문제 출제
			System.out.print(ran + " x " + ran1 + " = ");
			
			//입력받기
			int answer = scan.nextInt();
			
			//정답확인
			if(answer == (ran*ran1)) {
				//정답 개수 세기 -> 변수 필요
				cnt += 1;
			}
			
			
			
			
			
			n += 1;
		}
		// 성적 산출
		System.out.print("성적 : " + cnt * 20 + "원");
		
	}

}
