package lv03practice;

import java.util.Scanner;

public class Practice65 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 인덱스 0 1 2 3 4
		int[] arr = { 87, 11, 45, 98, 23 };

		// 문제1) 인덱스를 입력받아 성적 출력
		// 정답1) 인덱스 입력 : 1 성적 : 11점

		System.out.print("인덱스 입력 : ");
		int idx = scan.nextInt();

		if (idx < 0 || idx > 4) {
			System.out.println("인덱스 범위는 0~4입니다.");
		} else {
			System.out.print(arr[idx] + " ");
		}

		// 문제2) 성적을 입력받아 인덱스 출력
		// 정답2) 성적 입력 : 11 인덱스 : 1
		System.out.print("\n성적 입력 : ");
		int score = scan.nextInt();
		
		
		idx = -1;
		for (int i = 0; i < 5; i++) {
			if (arr[i] == score) {
				idx = i;
			}
		}
		
		if(idx == -1) {
			System.out.println("해당 점수는 존재하지 않습니다.");
		}else {
			System.out.print("인덱스 : " + idx);
		}
		int[] hakbuns = { 1001, 1002, 1003, 1004, 1005 };
		int[] scores = { 87, 11, 45, 98, 23 };

		// 문제3) 학번을 입력받아 성적 출력
		// 정답3) 학번 입력 : 1003 성적 : 45점

		System.out.print("\n학번 입력 : ");
		int hakbun = scan.nextInt();

		for (int i = 0; i < 5; i++) {
			if (hakbuns[i] == hakbun) {
				System.out.print(scores[i]);
			}
		}

		// 문제) 학번을 입력받아 성적 출력
		// 단, 없는학번 입력 시 예외처리
		// 예)
		// 학번 입력 : 1002 성적 : 11점
		// 학번 입력 : 1000 해당학번은 존재하지 않습니다.

		System.out.print("\n학번 입력 : ");
		hakbun = scan.nextInt();

		idx = -1;

		for(int i=0; i<5; i++) {
			if(hakbuns[i] == hakbun)
				idx = i;
		}
		
		if(idx == -1) {
			System.out.println("해당학번은 존재하지 않습니다.");
		}else
			System.out.print(scores[idx]);
		
		// 문제) 1등 학생의 학번과 성적 출력
		// 정답) 1004번(98점)
		
		int max = 0;
		for(int i=0; i<5; i++) {
			if(scores[i] > max)
				max = scores[i];
		}
		System.out.printf("\n1등학생: %d번 (%d점)", hakbuns[idx],max);
		
		
		
		
		

	}

}
