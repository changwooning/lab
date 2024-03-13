package lv02test;

public class Test208 {

	// 1613
	// 1649

	public static void main(String[] args) {

		// lv02 테스트

		// 문제 8)
		// 1. 7의 배수를 차례대로 출력했을때 8번째 배수를 출력
		int max = 0;
		int cnt = 0;
		int n = 7;
		while (n % 7 == 0) {
			cnt += 1;
			if (cnt == 8) {
				System.out.print(n);
				break;
			}
			n += 7;
		}
		System.out.println();

		// 2. 6과 8의 공약수를 모두 출력
		// 공약수란 각수의 공통인 약수를 말한다.
		// 예) 6 ==> 1,2,3,6
		// 8 ==> 1,2,4,8
		// 공약수는 1,2

		max = 0;
		n = 1;
		while (n <= 8) {
			if (6 % n == 0 && 8 % n == 0) {
				System.out.print(n + " ");
				if (n > max)
					max = n;
			}
			n += 1;
		}

		System.out.println();

		// 3. 위 수의 최대 공약수를 출력
		// 최대 공약수란 공약수중에서 가장 큰수
		System.out.print(max);

		System.out.println();

		// 4. 25,75의 최대 공약수를 출력

		n = 1;
		while (n <= 75) {
			if (25 % n == 0 && 75 % n == 0) {
				if (n > max)
					max = n;
			}
			n += 1;
		}
		System.out.print(max);
		System.out.println();

		// 5. 연필 42자루와 지우개 28개를 최대한 많은 학생애가 남김없이 똑같이 나누어 주려고 합니다.
		// 몇 명까지 나누어 줄 수 있는지 출력
		max = 0;
		int pen = 42;
		int eraser = 28;
		n = 1;
		while (n > 0) {
			if (pen % n == 0 && eraser % n == 0) {
				if (n > max)
					max = n;
			}
			n += 1;
		}
		System.out.print(max);

	}

}
