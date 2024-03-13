package lv04;

import java.util.Scanner;

public class Ex20 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		final int SIZE = 3;

		int[][] arr = new int[SIZE][SIZE];

		int k = 1;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				arr[i][j] = 10 * k;
				k += 1;
			}
		}

		// 문제1) 인덱스를 2개를 입력받아 값 출력
		// 예) 인덱스1 입력 : 1 인덱스2 입력 : 2
		// 값 출력 : 60
		System.out.print("인덱스1 입력 : ");
		int idx1 = scan.nextInt();
		System.out.print("인덱스2 입력 : ");
		int idx2 = scan.nextInt();

		if ((idx1 < 0 || idx1 > SIZE - 1) && idx2 < 0 || idx2 > SIZE - 1) {
			System.out.println("범위에 벗어난 값입니다.");
		} else {
			System.out.print(arr[idx1][idx2] + " ");
		}

		System.out.println();

		// 문제2) 값을 입력받아 인덱스 2개 출력
		// 예) 값 입력 : 60
		// 인덱스1 출력 : 1 인덱스2 출력 : 2
		System.out.print("값 : ");
		int input = scan.nextInt();

		int idx = -1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == input)
					System.out.print(i + "," + j + " ");
			}
		}
		System.out.println();
		// 문제3) 가장 큰 값의 인덱스 2개 출력
		// 정답3) 2 2
		int max = 0;
		int maxIdx1 = 0;
		int maxIdx2 = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] > max) {
					max = arr[i][j];
					maxIdx1 = i;
					maxIdx2 = j;
				}
			}
		}
		System.out.print(maxIdx1 + "," + maxIdx2 + " ");

		// 문제4) 값 2개를 입력받아 값 교체 (배열안에 있는 갑 두개를 서로 교체)
		System.out.print("값1 : ");
		int input1 = scan.nextInt();
		System.out.print("값2 : ");
		int input2 = scan.nextInt();

		int temp = 0;
		int index1 = -1;
		int index2 = -1;
		int index3 = -1;
		int index4 = -1;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == input1) {
					index1 = i;
					index2 = j;
				}else {
					if((index1 < 0 || index1 > SIZE -1) && (index2 < 0 || index2 > SIZE-1))
						System.out.println("범위에 벗어난 값입니다.");
				}
				if (arr[i][j] == input2) {
					index3 = i;
					index4 = j;
				}else {
					if((index1 < 0 || index1 > SIZE -1) && (index2 < 0 || index2 > SIZE-1)){
						
					}
						
				}
			}
		}

		temp = arr[index1][index2];
		arr[index1][index2] = arr[index3][index4];
		arr[index3][index4] = temp;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}
