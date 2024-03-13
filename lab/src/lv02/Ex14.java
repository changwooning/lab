package lv02;

public class Ex14 {

	public static void main(String[] args) {

		int n = 1;
		while (n <= 50) {
			int x = n / 10; // 십의 자리
			int y = n % 10; // 일의 자리

			int count = 0;
			
			//십의 자리 박수증가
			if (x % 3 == 0 && x != 0)
				count++;
			//일의 자리 박수증가
			if (y % 3 == 0 && y != 0)
				count++;
			
			//이해하기! -> 아직 어려움
			if (count > 0) {
				while (count > 0) {
					System.out.print("짝");
					count--;
				}

			} else {
				System.out.print(n + " ");
			}

			n++;
		}

	}

}
