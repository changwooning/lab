package lv02practice;

import java.util.Random;
import java.util.Scanner;



public class Practice10 {
	
	// # up % down 게임 [2단계]
		// 1. com은 랜덤으로 1~100 사이를 저장한다.
		// 2. me는 1~100사이를 입력한다.
		// 3. com과 me를 비교해서 com 크면 "크다" , com 작으면 "작다" 힌트제공
		// 4. 정답을 맞춫면 게임은 종료된다.

	public static void main(String[] args) {
		
		Random ran = new Random();
		Scanner scan = new Scanner(System.in);
		
		
		//com 1~100랜덤값 초기화
		int com = ran.nextInt(100) + 1;
		//me 입력
		System.out.print("ME 1~100 : ");
		int me = scan.nextInt();
		
		
		while(com != me) {
		
			//me의범위값 지정
			if(me >0 && me <=100) {
				if(com > me)
					System.out.print("더 크다\n");
				else
					System.out.print("더 작다\n");
			}else
				System.out.println("재입력");
			
			System.out.print("ME 1~100 : \n");
			me = scan.nextInt();
			
		}
		
		//정답
		System.out.println("정답");
		System.out.println("게임종료");
		
		
		

	}

}
