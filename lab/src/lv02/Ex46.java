package lv02;
import java.util.Scanner;


public class Ex46 {
	
	// 31게임

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int br = 0;
		int turn = 0;
		int input = 0;
		
		
		
		// 1. br 31이상이면 종료
		while(br < 31) {
			//br 값 보여주기 [br]
			System.out.printf("br [%d]\n", br);
			
			//플레이어 입력 받기 반복
			System.out.printf("P%d (1~3) : ", turn % 2 + 1);
			input = scan.nextInt();
			
			//input 1~3사이 범위지정
			if(input > 0 && input <= 3) {
				//br 증가
				br += input;
				turn += 1;
			}
		}
		
		//승리자 출력
		System.out.printf("P%d WIN!!!", turn % 2 + 1);

	}

}
