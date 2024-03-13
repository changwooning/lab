package lv02;

public class Ex34 {

	// 연습 1!
	// while , for 사용하기 2가지 다

	public static void main(String[] args) {

		// 문제1) 1~10까지 반복해 5~9 출력
		// 정답1) 5,6,7,8,9

		// 1-1
		int n = 1;
		while (n <= 10) {
			if (n >= 5 && n < 10)
				System.out.print(n + " ");
			n += 1;
		}

		System.out.println();
		// 1-2

		for (int i = 1; i <= 10; i += 1) {
			if (i >= 5 && i < 10)
				System.out.print(i + " ");
		}
		System.out.println();

		// 문제2) 10~1까지 반복해 6~3 거꾸로 출력
		// 정답2) 6,5,4,3

		// 2-1

		n = 10;
		while (n > 0) {
			if (n > 2 && n < 7)
				System.out.print(n + " ");
			n -= 1;
		}
		System.out.println();
		// 2-2

		for (int i = 10; i > 0; i -= 1) {
			if (i > 2 && i < 7)
				System.out.print(i + " ");
		}
		System.out.println();
		// 문제3) 1~10까지 반복해 짝수만 출력
		// 정답3) 2,4,6,8,10

		// 3-1

		n = 1;
		while (n <= 10) {
			if (n % 2 == 0)
				System.out.print(n + " ");
			n += 1;
		}
		System.out.println();

		// 3-2

		for (int i = 1; i <= 10; i += 1) {
			if (i % 2 == 0)
				System.out.print(i + " ");
		}
		System.out.println();

		// 문제1) 1~5까지의 합 출력
		// 정답1) 15

		// 1-1
		n = 1;
		int sum = 0;
		while (n <= 5) {
			sum += n;
			n += 1;
		}
		System.out.print(sum);
		System.out.println();

		// 1-2
		for (int i = 1; i <= 5; i += 1) {
			sum += i;
		}
		System.out.print(sum);
		System.out.println();

		// 문제2) 1~10까지 반복해 3미만 7이상만 출력
		// 정답2) 1, 2, 7, 8, 9, 10

		// 2-1

		n = 1;
		sum = 0;
		int cnt = 0;
		while (n <= 10) {
			if (n < 3 || n >= 7) {
				System.out.print(n + " ");
			sum += n;
			cnt += 1;
			}
			n += 1;
		}
		System.out.println();

		// 2-2

		for(int i=1; i <=10; i +=1) {
			if(i < 3 || i >= 7)
				System.out.print(i + " ");
		}
		System.out.println();

		// 문제3) 문제2의 조건에 맞는 수들의 합 출력
		// 정답3) 37
		System.out.println(sum + " ");

		// 문제4) 문제 2의 조건에 맞는 수들의 개수 출력
		// 정답4) 6

		System.out.print(cnt + " ");
	}

}
