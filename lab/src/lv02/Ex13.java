package lv02;

public class Ex13 {

	// # 369게임
	// 1. 1~50까지 반복을 한다.
	// 2. 그 안에서 해당 숫자의 369게임의 결과를 출력한다.
	// 예) 1 2 짝 4 5 짝 7 8 짝 10 11 12 짝 ...
	//

	public static void main(String[] args) {

		// 1. 1~50 반복
		int n = 1;

		while (n <= 50) {

			// 둘다 일때
			// 십의 자리 : n / 10 == 3 , 6, 9
			// 일의 자리 : n % 10 == 3, 6, 9

			if ((n / 10 == 3 || n / 10 == 6 || n / 10 == 9) && (n % 10 == 3 || n % 10 == 6 || n % 10 == 9)) {

				System.out.print("짝짝 ");

			}
			// 십의자리일때만
			else if (n / 10 == 3 || n / 10 == 6 || n / 10 == 9) {

				System.out.print("짝 ");
			}
			// 일의자리일때만
			else if (n % 10 == 3 || n % 10 == 6 || n % 10 == 9) {

				System.out.print("짝 ");
			} else {
				System.out.print(n + " ");
			}

			n++;
		}

	}

}
