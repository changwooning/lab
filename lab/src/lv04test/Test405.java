package lv04test;

public class Test405 {

	public static void main(String[] args) {

		// # 2차원 반복문
		// 1 2 3 4 5
		// 10 9 8 7 6
		// 11 12 13 14 15
		// 20 19 18 17 16
		// 21 22 23 24 25
		//

		int[][] arr = new int[5][5];

		// 위와 같이 수를 채우고 출력해보세요
		// 홀수
		// 짝수

		int num = 1;
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < arr[i].length; j++)
					arr[i][j] = num++;

			}else {
				for(int j=4; j>=0; j--)
					arr[i][j] = num++;
			}

		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

	}

}
