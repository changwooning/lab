package lv02;

import java.util.Random;

public class Ex54 {
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

		int pass = 0;
		int total = 0;

		int max = 0;
		int top = 0;

		// 10회 반복
		int n = 1;
		while (n <= 10) {
			// 랜덤 값 1~100 초기화하기
			int score = random.nextInt(100) + 1;
			total += score;
			// 60점 이상은 합격생
			if (score >= 60) {
				pass += 1;
			}
			// 1등 점수
			if (score > max) {
				top = n;
				max = score;
			}
			System.out.printf("%d번 학생 %d점 [%s]\n",n , score, score >= 60);

			n += 1;
		}
		System.out.println("=================");
		System.out.printf("전교생 총점 : %d 평균 : %d\n", total, total / n);
		System.out.printf("합격자 수 : %d명\n", pass);
		System.out.printf("1등학생 번호 : %d 점수 : %d", top, max);

	}

}
