package lv01test;

import java.util.Scanner;

public class Test_0601 {
	
	/*
	 * 문제 6) 
	 * 시험점수 3개를 입력받고 학점 출력 
	 * 조건 1) 3과목의 평균을 가지고 점수를 매긴다. 
	 * 조건 2) 3과목의 평균이 90~100 ==> a 
	 * 조건 3) 3과목의 평균이 80~89 ==> b 
	 * 조건 4) 3과목의 평균이 70~79 ==> c 조건 5) 69이하 ===> 재시험
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
		
		int avg = (math * eng * kor) / 3 ; 
		int grade = 0;
		
		if((math >= 0 && math <= 100) || (eng >= 0 && eng <= 100) || (kor >= 0 && kor <= 100)) {
			
		}
		
		
		
		
		if(avg < 70) {
			System.out.print("재시험");
		}else {
			String grade = "";
			
			if(avg >= 90) {
				grade += "A";
			}
			else if (avg >=80) {
				grade += "B";
			}
			else if (avg >= 70) {
				grade += "C";
			}
		}

	}

}
