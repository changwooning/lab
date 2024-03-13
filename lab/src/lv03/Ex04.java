package lv03;

import java.util.Random;
import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {

		Random random = new Random();
		Scanner scan = new Scanner(System.in);

		int[] hakbuns = null; // 아무것도 담고 있지 않은 상태
		int[] scores = null; // 아무것도 담고 있지 않은 상태

		scores = new int[5];
		hakbuns = new int[5];

		// 랜덤 점수 (1~100) scores에 5개 저장
		// 학번을 (1001~1005) hakbuns에 5개 저장
		for (int i = 0; i < 5; i++) {
			hakbuns[i] = i + 1001;
			scores[i] = random.nextInt(100) + 1;
			System.out.printf("%d) %d점\n", hakbuns[i], scores[i]);
		}

		// 문제1) 인덱스를 입력받아 성적 출력
		// 정답1) 인덱스 입력 : 1 성적 : 11점
		System.out.print("인덱스 입력 : ");
		int index = scan.nextInt();

		if (index >= 0 && index < 5) {
			System.out.println(scores[index] + "점");
		} else {
			System.err.println("배열의 길이는 5입니다.");
		}

		// 문제2) 성적을 입력받아 인덱스 출력
		// 정답2) 성적 입력 : 11 인덱스 : 1
		System.out.print("score : ");
		int score = scan.nextInt();

		boolean isFound = false;

		for (int i = 0; i < 5; i++) {
			if (scores[i] == score) {
				System.out.println("인덱스 : " + i);
				isFound = true;
			}
		}
		if (!isFound) {// isFound == false;
			System.out.println("입력한 성적은 존재하지 않습니다.");
		}

		// 문제3) 학번을 입력받아 성적 출력
		// 정답3) 학번 입력 : 1003 성적 : 45점

		isFound = false;

		System.out.print("학번 : ");
		int hakbun = scan.nextInt();

		for (int i = 0; i < 5; i++) {
			if (hakbuns[i] == hakbun) {
				// 인덱스를 찾았다.
				System.out.println(scores[i] + "점");
				isFound = true;
			}
		}
		if (!isFound) {// isFound == false;
			System.err.println("존재하지 않는 학번입니다.");
		}
		
		//문제) 1등 학생의 학번과 성적 출력
		//정답) 1004번(96점)
		int max = 0;
		int maxIndex = -1; //인덱스를 기억하는 용도를 가진 변수는, 유효한 인덱스 범위 밖의 값으로 음수 초기화
		
		for(int i=0; i<5; i++) {
			if(scores[i] > max) {
				max = scores[i];
				maxIndex = i;
			}
		}
		
		for(int i=0; i<5; i++) {
			if(scores[i] == max) {
				System.out.printf("1등 점수 %d\n", max);
			}
		}
		System.out.printf("1등 : %d번 (%d점)\n", hakbuns[maxIndex],max);
	}

}
