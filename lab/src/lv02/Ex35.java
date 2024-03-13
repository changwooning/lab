package lv02;
import java.util.Scanner;
import java.util.Random;


public class Ex35 {
	
	//# 구구단 게임 [3단계]
	// 1. 구구단 게임을 5회 반복한다.
	// 2. 정답을 맞추면 개당 20점이다.
	// 3. 게임 종료 후 , 성적을 출력한다.
	// 예) 5 x 5 = ?  ->  ? 입력받기

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int cnt = 0;
		int n = 1;
		// 5회 반복
		while(n <= 5) {
			
			// 1. 랜덤 값 2개를 초기화
			// 1-1 첫번째
			int ran = random.nextInt(9) + 1;
			
			// 1-2 두번째
			int ran1 = random.nextInt(9) + 1;
			
			// 2. 문제 출제
			
			System.out.println(ran + " x " + ran1 + " = ");
			
			// 3. 사용자에게 입력받기
			
			int answer = scanner.nextInt();
			
			// 4. 정답 확인
			
			if(answer == (ran * ran1)) {
				// 5. 정답 개수 세기
				cnt += 1;
			}
			
			
			
			
			
			
			n += 1;
		}
		
		// 6. 성적 산출
		
		System.out.println(cnt * 20);
		

	}

}
