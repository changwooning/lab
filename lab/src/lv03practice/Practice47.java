package lv03practice;

import java.util.Arrays;
import java.util.Scanner;

public class Practice47 {

	// 1641

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] arr = { 10, 20, 30, 40, 50 };

		// 문제1) 인덱스 2개를 입력받아 값 교체하기
		// 예 1) 인덱스1 입력 : 1, 인덱스2 입력 : 3
		// {10,40,30,20,50}

		System.out.print("인덱스1 : ");
		int idx1 = scan.nextInt();
		System.out.print("인덱스2 : ");
		int idx2 = scan.nextInt();

		int temp = 0;

		if (idx1 >= 0 && idx1 < 5 && idx2 >= 0 && idx2 < 5) {
			// 값교체
			temp = arr[idx1];
			arr[idx1] = arr[idx2];
			arr[idx2] = temp;
		}
		System.out.println(Arrays.toString(arr));

		// 문제2) 값 2개를 입력받아 값 교체하기
		// 예 2) 값1 입력 : 40 , 값2 입력 : 20
		// {10,20,30,40,50}

		int index1 = -1;
		int index2 = -1;

		System.out.print("값 1 : ");
		int score1 = scan.nextInt();
		System.out.print("값 2 : ");
		int score2 = scan.nextInt();

		for (int i = 0; i < 5; i++) {
			if (arr[i] == score1) {
				index1 = i;
			}
			if (arr[i] == score2) {
				index2 = i;
			}
		}

		temp = 0;
		if (index1 != -1 && index2 != -1) {
			// 값교체
			temp = arr[index1];
			arr[index1] = arr[index2];
			arr[index2] = temp;
		} else
			System.err.println("입력한 값은 해당하지 않습니다.");

		System.out.println(Arrays.toString(arr));

		int[] hakbuns = { 1001, 1002, 1003, 1004, 1005 };
		int[] scores = { 87, 11, 45, 98, 23 };

		// 문제3) 학번 2개를 입력받아 성적 교체하기
		// 예 3) 학번1 입력 : 1002, 학번2 입력 : 1003
		// {87,45,11,98,23}

		index1 = -1;
		index2 = -1;

		System.out.print("학번 입력1 : ");
		int hakbun1 = scan.nextInt();
		System.out.print("학번 입력2 : ");
		int hakbun2 = scan.nextInt();

		temp = 0;

		for (int i = 0; i < 5; i++) {
			if (hakbuns[i] == hakbun1) {
				index1 = i;
			}
			if (hakbuns[i] == hakbun2) {
				index2 = i;
			}
		}
		if (index1 == -1 || index2 == -1) {
			System.err.println("입력하신 학번은 존재하지 않습니다.");
		} else {
			// 값 교체
			temp = scores[index1];
			scores[index1] = scores[index2];
			scores[index2] = temp;
		}
		
		System.out.println(Arrays.toString(scores));

	}

}
