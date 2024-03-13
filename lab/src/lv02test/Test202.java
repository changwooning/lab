package lv02test;

import java.util.Random;

public class Test202 {

	// lv02 테스트
	// 문제 2)
	// 1. 10회 반복을 한다.
	// 2. 1~100 사이의 랜덤 숫자를 저장한다.(학생의 성적)
	// 3. 성적이 60점 이상이면 합격생이다.
	// -----------------------------
	// . 전교생(10명)의 총점과 평균을 출력한다.
	// . 합격자 수를 출력한다.
	// . 1등 학생의 번호와 성적을 출력한다.
	// ...

	// 시작 1028
	// 종료

	public static void main(String[] args) {

		Random random = new Random();

		int top = 0;
		int max = 0;

		int score = 0;
		int cnt = 0;
		int total = 0;

		// 10회 반복
		int n = 1;
		while (n <= 10) {

			// 1~100 랜덤값 초기화
			score = random.nextInt(100) + 1;
			total += score;

			System.out.printf("%d번학생 %d점 [%s]\n", n, score, score >= 60);

			// 합격자 수
			if (score >= 60) {
				cnt += 1;
			}

			// 1등 학생 점수 및 번호
			if (score > max) {
				max = score;
				top = n;
			}
			n += 1;
		}

		// 총점값 학생들 점수 다 더한것

		System.out.printf("총점 : %d점 평균 %d점\n", total, total / 10);
		System.out.printf("합격자 수 : %d명\n", cnt);
		System.out.printf("1등학생 번호 : %d 점수 : %d", top, max);

	}

}
