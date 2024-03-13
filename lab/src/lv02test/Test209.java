package lv02test;

public class Test209 {

	// lv02 테스트

	// 1654

	public static void main(String[] args) {

		// 문제9)

		// 1. 8과 12의 최소 공배수를 구하시오
		// 최소 공배수란 각 수의 배수를 나열한다음 처음으로 같은 숫자를 말한다.
		// 예) 8 16 24...
		// 예) 12 24...
		// 여기서 24가 최소공배수다.
		int max = 0;
		int n = 1;
		while (n <= 12) {
			if (8 % n == 0 && 12 % n == 0) {
				if (n > max)
					max = n;
			}
			n += 1;
		}
		System.out.print(8 * 12 / max);
		System.out.println();

		// 2. 수인이는 4일 마다 수영장을 가고 형주는 6일마다 수영장에 간다.
		// 두사람이 4월 3일에 만났다면 다음에 만날날은 언제인가?

		max = 0;
		n = 1;
		while (n <= 6) {
			if (4 % n == 0 && 6 % n == 0)
				if (n > max)
					max = n;
			n += 1;
		}
		System.out.print(3 + (4 * 6) / max);
		System.out.println();

		// 3. 가로가 12이고 세로가 8인 직사각형모양의 종이를 늘어놓아
		// 만들수있는 가장 작은 정사각형을 만들려고한다. 직사각형은 몇장이 필요한가?
		// 답 : 6

		max = 0;
		n = 1;
		while (n <= 12) {
			if (12 % n == 0 && 8 % n == 0) {
				if (n > max)
					max = n;
			}
			n += 1;
		}
		System.out.println((12/max) * (8/max));

	}

}
