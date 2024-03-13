package lv02;

import java.util.Random;

public class Ex19 {

	// # 랜덤 학생
	// 1. 10회 반복을 한다.
	// 2. 1~100 사이의 랜덤 숫자를 저장한다. (학생의 성적)
	// 3. 성적이 60점 이상이면 합격생이다.
	// -----------------------------------------
	// . 전교생 (10명)의 총점과 평균을 출력한다.
	// . 합격자 수를 출력한다.
	// . 1등 학생의 번호와 성적을 출력한다.

	public static void main(String[] args) {

		Random random = new Random();

		int n = 1;
		int count = 0;
		while (n <= 10) {

			// 1~100 사이의 숫자 저장
			int ran = random.nextInt(100) + 1;
			// System.out.println(ran);

			// 전교생 10명의 총점과 평균을 출력
			
			
			
			// 합격자 수
			if (ran >= 60) {
				// System.out.println(ran);
				count += 1;
			}

			n++;
		}
		System.out.println("합격자 수 : " + count);

	}

}
