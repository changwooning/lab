package lv01test;

import java.util.Scanner;

public class Test_06 {

	// 시작 16:06
	// 종료 16:29
	// 소요 00:00

	/*
	 * 문제 6) 시험점수 3개를 입력받고 학점 출력 조건 1) 3과목의 평균을 가지고 점수를 매긴다. 조건 2) 3과목의 평균이 90~100
	 * ==> a 조건 3) 3과목의 평균이 80~89 ==> b 조건 4) 3과목의 평균이 70~79 ==> c 조건 5) 69이하 ===>
	 * 재시험
	 * 
	 * 추가조건 ) 각점수대별로 끝자리가 7점 이상은 + 가 붙는다. 예) 98 ==> a+ 예) 89 ==> b+ 예) 79 ==> c+
	 */

	public static void main(String[] args) {

		int math = 0;
		int eng = 0;
		int kor = 0;

		Scanner scan = new Scanner(System.in);

		System.out.print("math : ");
		math = scan.nextInt();

		System.out.print("eng : ");
		eng = scan.nextInt();

		System.out.print("kor : ");
		kor = scan.nextInt();
		
		// 수학 영어 국어 

		int average = ((math + eng + kor) / 3);
		int num = (average % 10);
		int num1 = (average / 10);

		if (average >= 70 && average <= 100) {
			if (average >= 90 && average <= 100) {
				System.out.print("A");
				if (num >= 7 || num1 == 10) {
					System.out.print("+");
				}
			} else if (average >= 80 && average < 90) {
				System.out.print("B");
				if (num >= 7) {
					System.out.print("+");
				}
			} else if (average >= 70 && average < 80) {
				System.out.print("C");
				if (num >= 7) {
					System.out.print("+");
				}

			}

		} else {
			System.out.print("재시험");
		}
	}
}
