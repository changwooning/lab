package lv01;

import java.util.Scanner;


public class Ex38 {
	/*
	 * # 지하철 요금 계산
	 * 1. 이용할 정거장 수를 입력받는다,
	 * 2. 다음과 같이 정거장 수에 따라 요금이 정산된다.
	 * 3. 요금표
	 * 1) 1~5 : 500원
	 * 2) 6~10 : 600원
	 * 3) 11,12 : 650원  (10정거장이후는 2정거장마다 50원 추가)
	 * 4) 13,14 : 700원  (10정거장이후는 2정거장마다 50원 추가)
	 * 5) 15,16 : 750원  (10정거장이후는 2정거장마다 50원 추가)
	 * ~~~~
	 */


	public static void main(String[] args) {
		
		//1. 정거장 수 입력 받기
		Scanner scan = new Scanner(System.in);
		System.out.print("정거장 수 : ");
		int num = scan.nextInt();
		int fee = 0;
		
		
		
		if(num < 6) {
			System.out.print(500 + "원");
			
		}
		else if(num < 11) {
			System.out.print(600 + "원");
		}
		//11,12에서 1를 추출해라!
	//짝수부터
		fee = (num-9)/2*50;
		
		if(num >= 11) {
			System.out.print(600 + fee);
		}
		// 홀수
		//fee1 = (num-9)/2*50;
		//if(num > 10 && num % 2 == 1) {
		//	System.out.print(600 + fee1);
		//}
		
	
		
	//11에서 출발해 -> 13 추 15 추 17 
	// 500원        550   600 650 	
	
	}


}
