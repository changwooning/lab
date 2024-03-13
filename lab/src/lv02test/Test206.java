package lv02test;

public class Test206 {

	public static void main(String[] args) {

		// lv02 테스트

		// 1. 마트에서 오이를 3개씩 묶어서 1500원에 판다고 한다.
		// 오이가 14개 필요하다. 돈이 얼마필요한가(오이는 묶음으로만 판다.)
		// 힌트) 3의배수가 아니면 될때까지 증가시킨다.

		int oi = 14;

		int bundle = 3;
		int price = 1500;
		int cash = 0;

		while (oi > 0) {
			oi -= bundle;
			cash += price;
		}
		System.out.println(cash);

		// 2. 민수네 반 학생은 26명입니다.
		// 민수네반 학생들에게 도화지를 2장씩 나누어 주려고합니다.
		// 도화지는 10장씩 묶음으로만 판매하고 10장에 1200원입니다.
		// 총 얼마가 필요한가요?

		int total = 26;
		bundle = 10;
		price = 1200;
		cash = 0;
		while (total > 0) {
			total -= bundle;
			cash += price;
		}
		System.out.println(cash);

		// 3. 가게에서 24600원 짜리 옷을 샀습니다.
		// 1000원짜리 지페로만 옷값을 낸다면 몇장이 필요한가요?
		//

		int clothes = 24600;
		int money = 1000;
		int cnt = 0;
		while (clothes > 0) {
			clothes -= money;
			cnt += 1;
		}
		System.out.println(cnt);
	}

}
