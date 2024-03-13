package lv03;

public class Ex11 {

	public static void main(String[] args) {

		// 문제1) 10부터 50까지 arr 배열에 저장
		// 정답1) 10 20 30 40 50

		// 변수명 초기화
		int[] arr = new int[5];
		// int[] arr = new int[] {0,1,2,3,4};
		// int[] arr = {0,1,2,3,4};

		int sum = 0;
		for (int i = 0; i < 5; i++) {
			arr[i] = (i + 1) * 10;
			sum += arr[i];
		}

		for (int i = 0; i < 5; i++) {
			System.out.print(arr[i]);
		}

		// 문제2) 전체 합 출력
		// 정답2) 150

		System.out.println(sum);
	}

}
