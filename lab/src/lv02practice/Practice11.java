package lv02practice;

import java.util.Scanner;
import java.util.Random;


public class Practice11 {
	
	 //# up % down 게임 [2단계]
	
	//1921
	//1926
	

	public static void main(String[] args) {
		
		Scanner scan = new  Scanner(System.in);
		Random ran = new Random();
		
		//com랜덤값 초기화
		int com = ran.nextInt(100) + 1;
		//me 입력받기
		System.out.print("ME 1~100 : ");
		int me = scan.nextInt();
		
		while(com != me) {
			if(me >0 && me <=100) {
				if(com > me)
					System.out.println("더 크다");
				else
					System.out.println("더 작다");
			}else
				System.out.println("재입력");
			System.out.print("ME 1~100 : ");
			me = scan.nextInt();
		}
		System.out.println("정답");
		System.out.println("게임종료");
		
		

	}

}
