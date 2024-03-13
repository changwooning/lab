package lv04practice;

import java.util.Scanner;
import java.util.Random;

public class Practice13 {
	
	// # 숫자 야구 게임
		// 1. me에 1~9 사이의 숫자 3개를 저장
		// 단,중복되는 숫자는 저장 불가
		// 2. com과 me를 비교해 정답을 맞출 때까지 반복
		// 3. 숫자와 자리가 같으면 strike +=1
		// 숫자만 같고 자리가 틀리면 ball +=1
		// 예)
		// 정답 : 1 7 3
		// 3 1 5 : 2b
		// 1 5 6 : 1s
		// ...
		//

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		
		int[] com = { 1, 7, 3 };
		int[] me = new int[3];
		
		while(true) {
			//입력 & me 배열 초기화
			for(int i=0; i<3; i++) {
				System.out.printf("숫자 %d번째 입력 : ", i+1);
				int input = scan.nextInt();
				
				int idx = -1;
				for(int j=0; j<i; j++) {
					if(me[j] == input)
						idx = j;
				}
				
				//예외처리 1.범위
				if(idx == -1 && input > 0 && input <= 9)
					me[i] = input;
				else {
					System.out.println("유효하지 않은 값입니다.");
					i--;
				}
			}
			
			//검토
			int ball =0;
			int strike = 0;
			
			for(int i=0; i<3; i++) {
				
				for(int j=0; j<3; j++) {
					if(com[i] == me[j]) {
						if(i==j)
							strike ++;
						else
							ball ++;
					}
				}
			}
			
			
			
			
			
			
			
			
		}
		

	}

}
