package lv03practice;

import java.util.Arrays;
import java.util.Scanner;

public class Practice70 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] arr = { 10, 20, 30, 40, 50 };

		// 문제 1) 인덱스 2개를 입력받아 값 교체하기
		// 예 1) 인덱스1 입력 : 1 , 인덱스2 입력 : 3
		// {10, 40, 30, 20, 50}

		System.out.print("인덱스1 입력 : ");
		int idx1 = scan.nextInt();
		System.out.print("인덱스2 입력 : ");
		int idx2 = scan.nextInt();

		// 예외처리
		if (idx1 < 0 || idx1 > 4 || idx2 < 0 || idx2 > 4) {
			System.out.println("인덱스 범위는 0~4입니다.");
		} else {
			// 값교체
			int temp = arr[idx1];
			arr[idx1] = arr[idx2];
			arr[idx2] = temp;
		}
		System.out.println(Arrays.toString(arr));

		// 문제 2) 값 2개를 입력받아 값 교체하기
		// 예 2) 값1 입력 : 40 , 값2 입력 : 20
		// {10, 20, 30, 40, 50}

		System.out.print("값1 : ");
		int input1 = scan.nextInt();
		System.out.print("값2 : ");
		int input2 = scan.nextInt();

		idx1 = -1;
		idx2 = -1;
		for (int i = 0; i < 5; i++) {
			if (arr[i] == input1)
				idx1 = i;
			if (arr[i] == input2)
				idx2 = i;
		}
		if (idx1 == -1 && idx2 == -1) {
			System.out.println("해당 값은 존재하지 않습니다.");
		} else {
			int temp = arr[idx1];
			arr[idx1] = arr[idx2];
			arr[idx2] = temp;
		}
		System.out.println(Arrays.toString(arr));

		int[] hakbuns = { 1001, 1002, 1003, 1004, 1005 };
		int[] scores = { 87, 11, 45, 98, 23 };

		// 문제 3) 학번 2개를 입력받아 성적 교체하기
		// 예 3) 학번1 입력 : 1002 , 학번2 입력 : 1003
		// {87, 45, 11, 98, 23}
		
		System.out.print("학번1 : ");
		int hakbun1 = scan.nextInt();
		System.out.print("학번2 : ");
		int hakbun2 = scan.nextInt();
		
		idx1 = -1;
		idx2 = -1;
		
		for(int i=0; i<5; i++) {
			if(hakbuns[i] == hakbun1)
				idx1 = i;
			if(hakbuns[i] == hakbun2)
				idx2 = i;
		}
		if(idx1 == -1 && idx2 == -1)
			System.out.println("존재하지 않는 학번입니다.");
		else {
			int temp = scores[idx1];
			scores[idx1] = scores[idx2];
			scores[idx2] = temp;
		}
		
		System.out.println(Arrays.toString(scores));
		
		
		
		
		
		
		

	}

}
