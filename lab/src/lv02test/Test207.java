package lv02test;

public class Test207 {

	// 문제 7)

	// 1600
	// 1612

	public static void main(String[] args) {

		// 1. 36의 약수를 전부 출력
		// 약수는 36과 나눠서 나머지가 0인수를 말한다.
		// 1,2,3,4,6...

		int n = 1;
		while (n <= 36) {
			if (36 % n == 0)
				System.out.print(n + " ");
			n += 1;
		}
		System.out.println();

		// 2. 24의 약수중에서 2의 배수만 출력

		n = 1;
		while (n <= 24) {
			if (24 % n == 0) {
				if (n % 2 == 0)
					System.out.print(n + " ");
			}
			n += 1;
		}
		System.out.println();

		// 3. 18의 약수의 갯수 더하기 21의 약수의 갯수를 출력
		int cnt = 0;
		n = 1;
		while (n <= 21) {
			if (18 % n == 0) {
				cnt += 1;
			}
			if (21 % n == 0) {
				cnt += 1;
			}
			n += 1;
		}
		System.out.print(cnt);
		System.out.println();

		// 4. 50부터 100까지의 자연수중에서 9의 배수는 모두 몇개?

		n = 50;
		while (n <= 100) {
			if (n % 9 == 0) {
				cnt += 1;
			}
			n += 1;
		}
		System.out.print(cnt);

	}

}
