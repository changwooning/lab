package lv03;

public class Ex37 {

	public static void main(String[] args) {

		// 중첩 for문
		// ㄴ for문 안에 또 다른 for 구문이 들어 있는 것

		for (int i = 0; i < 5; i++) {
			System.out.println("i  : " + i + " <<<");
			for (int j = 0; j < 3; j++) {
				System.out.println("j  : " + j);

			}
		}

		// 0 0 0
		// 0 0 0
		// 0 0 0

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(0 + " ");
			}
			System.out.println();
		}

		// 문제 구구단 전체 출력하기
		// 단 타이틀 출력
		// 2~9단까지 (1~10까지)

		for (int i = 2; i < 10; i++) {
			System.out.printf("---%d단---",i);
			for (int j = 1; j < 11; j++) {
				System.out.println(i + " x " + j + " = " + i * j + " ");
			}
		}

	}

}
