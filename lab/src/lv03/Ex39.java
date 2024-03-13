package lv03;

import java.util.Scanner;

public class Ex39 {
	
	//소수찾기 [2단계]
	//정수 한개를 입력받아, 2부터 해당 숫자까지의 모든 소수 출력
	//예)
	//입력: 20
	//2, 3,5, 7, 11, 13, 17, 19
	
	//2차원 for문 활용

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = scan.nextInt();
		
		if(input < 2) {
			System.out.println("유효하지 않은 값입니다.");
		}else {
			//소수찾기
			for(int i=2; i<=input; i++) {  // i : 소수인지 확인할 검증 대상
				int cnt = 0;
				for(int j=1; j<=i; j++) {	// i에서 나누어줄 대상 값
					if(i % j == 0)			
						cnt ++;
				}
				if(cnt == 2)  
					System.out.print(i + " ");
			}
		}
		
		
		
		

	}

}
