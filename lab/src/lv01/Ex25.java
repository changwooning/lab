package lv01;

import java.util.Random;


public class Ex25 {

	public static void main(String[] args) {
		
		Random ran = new Random();
		
		
		// 문제 1 1~10
		// 문제 2 3~7
		// 문제 3 -3~3
		// 문제 4 2~5
		// 문제 5 1000~9999
		
		
		// 난수 개수 범위 (max-min)+1
		
		int ranNum1 = ran.nextInt(10) + 1;
		System.out.println(ranNum1);
		
		int ranNum2 = ran.nextInt(5) + 3;
		System.out.println(ranNum2);
		
		int ranNum3 = ran.nextInt(7) -3;
		System.out.println(ranNum3);
		
		int ranNum4 = ran.nextInt(4) + 2;
		System.out.println(ranNum4);
		
		int ranNum5 = ran.nextInt(9000) + 1000;
		System.out.println(ranNum5);
		

	}

}
