package lv01;

import java.util.Scanner;

public class Ex44 {
	/*
	 * # 점수 유효성 검사 : 유효한지 여부에 대한 검증 1. 점수를 입력 받는다. 2. 점수가 60점 이상이면 합격, 60점 미만이면
	 * 불합격이다. 3. 단, 입력받은 정수가 음수이거나 100점을 초과하면, "예외 메세지"를 출력한다. (예외 처리) 예) 점수를
	 * 잘못입력했습니다.
	 */

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 점수를 입력 받는다.
		System.out.print("점수 : ");
		int score = scan.nextInt();

		// 점수가 >=60 합격 , 점수가 < 60 불합격.
		if (score >= 0 && score <= 100) {
			if (score >= 60) {
				System.out.print("합격");
			}
			if (score < 60) {
				System.out.print("불합격");
			}

		}
		//예외 메세지
		if (score < 0 || score > 100) {
			System.out.print("점수를 잘못 입력했습니다.");

		}

	}

}
