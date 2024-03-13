package lv02practice;

public class Practice02 {

	public static void main(String[] args) {

		// 문제1) 1~5까지의 합 출력
		// 정답1) 15
		int n = 1;
		int sum = 0;

		while (n <= 5) {
			sum += n;
			n++;
		}
		System.out.print(sum + " ");
		System.out.println();

		sum = 0;

		for (int i = 1; i <= 5; i++) {
			sum += i;
		}
		System.out.print(sum + " ");

		System.out.println();

		// 문제2) 1~10까지 반복해 3미만 7이상만 출력
		// 정답2) 1, 2, 7, 8, 9, 10
		int cnt = 0;
		sum = 0;

		n = 1;
		while (n <= 10) {
			if (n < 3 || n > 6) {
				cnt++;
				sum += n;
				System.out.print(n + " ");
			}
			n++;
		}
		System.out.println();

		for (int i = 1; i <= 10; i++) {
			if (i < 3 || i > 6) {
				cnt++;
				sum += i;
				System.out.print(i + " ");
			}
		}

		System.out.println();

		// 문제3) 문제2의 조건에 맞는 수들의 합 출력
		// 정답3) 37

		System.out.println(sum);

		// 문제4) 문제 2의 조건에 맞는 수들의 개수 출력
		// 정답4) 6

		System.out.println(cnt);

	}

}
