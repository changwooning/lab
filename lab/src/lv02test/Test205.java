package lv02test;

public class Test205 {

	// 문제 5)
	// 증감연산자와 반복문을 사용해서 해결하세요 (산술연산 문제 아님)
	// 예)
	// 박수를 3번 친 결과를 각 횟수당 "짝"으로 출력하시오.

	// 1532

	public static void main(String[] args) {

		int clap = 3;
		while (clap > 0) {
			System.out.print("짝");
			clap--;
		}

		// -1.
		// 은주네 반 학생은 31명입니다.
		// 이중에서 남학생은 12명, 여학생은 14명이 봉사활동을 하였습니다.
		// 은주네 반에서 봉사활동을 하지않은 학생은
		// 몇명인지 출력

		int total = 31;
		int boy = 12;
		int girl = 14;

		for (int i = 0; i < boy; i++) {
			total--;
		}

		for (int i = 0; i < girl; i++) {
			total--;
		}
		System.out.println("봉사활동에 참여하지 않은 학생수 : " + total);
		// 선생님 풀이.

		// -2.
		// 연필 7타를 여학생 2명과 남학생 4명에게 남김없이 똑같이 나누어 주었을때
		// 한사람은 연필을 몇 자루 가지게 되는 지 출력 (연필 1타는 12자루)
		int cnt = 0;
		total = 84;
		int people = 6;
		while (total <= 0) {
			total -= people;
			cnt += 1;
		}
		System.out.print(cnt);
		System.out.println();

		// -3.
		// 어느 공장에서 한사람이 1시간에 컴퓨터를 4대를 조립할수 있다고한다.
		// 3명이 컴퓨터 96대를 조립하면 몇시간이 걸리는가

		total = 96;
		cnt = 0;
		int x = 12;
		while (total <= 0) {
			total -= x;
			cnt += 1;
		}
		System.out.print(cnt);
		System.out.println();

		// -4.
		// 귤 6개의 무게는 840g, 사과 3개의 무게는 750g 입니다.
		// 귤 5개와 사과 4개의 무게는 몇 g인지 출력(단 각각의 무게는 같고 각각의 사과끼리는 무게가 같다.)

		int mandarin = 840 / 6;
		int apple = 750 / 3;
		int sum = 0;

		int n = 1;
		while (n <= 5) {
			sum += mandarin;
			n += 1;
		}
		System.out.println("mandarin : " + sum + "g");

		n = 1;
		sum = 0;
		while (n <= 4) {
			sum += apple;
			n += 1;
		}
		System.out.println("apple : " + sum + "g");

	}

}
