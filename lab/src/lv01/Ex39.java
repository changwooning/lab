package lv01;

import java.util.Scanner;

public class Ex39 {
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

		Scanner scan = new Scanner(System.in);
	

		System.out.print("정거장 수 : ");
		int move = scan.nextInt();
		
		int fee = 500;
		

		if (move > 0) {
			if (move > 5) {
				fee += 100;
			}
			if (move > 10) {
				if (move % 2 == 1) {
					move += 1;
				}
				move -= 10;
				move /= 2;

				fee += move * 50;
			}
		}
	}

}
