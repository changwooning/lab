package lv03practice;

import java.util.Random;

import java.util.Scanner;

public class Practice17 {
	
	//1350
	//1429

	public static void main(String[] args) {
		
		Random ran = new Random();
		Scanner scan = new Scanner(System.in);
		
		int[] hakbuns = new int[5];
		int[] scores = new int[5];
		

		
		// 랜덤 점수 (1~100) scores에 5개 저장
		// 학번을 (1001~1005) hakbuns에 5개 저장
		
		for(int i=0; i<5; i++) {
			hakbuns[i] = i + 1001;
			scores[i] = ran.nextInt(100) + 1;
			System.out.printf("%d번  %d점\n",hakbuns[i],scores[i]);
		}
		
		// 문제1) 인덱스를 입력받아 성적 출력
		// 정답1) 인덱스 입력 : 1 성적 : 11점
		
		System.out.print("인덱스 입력 : ");
		int idx = scan.nextInt();
		
		if(idx >= 0 && idx <5) {
			System.out.println(scores[idx]);
		}else
			System.err.println("유효하지 않은 범위입니다.");
		
		
		// 문제2) 성적을 입력받아 인덱스 출력
		// 정답2) 성적 입력 : 11 인덱스 : 1
		System.out.print("성적 입력 : ");
		int score = scan.nextInt();
		
		boolean isFound = false;
		
		for(int i=0; i<5; i++) {
			if(scores[i] == score) {
				System.out.println("인덱스 : " + i);
				isFound = true;
			}
		}
		if(!isFound)
			System.out.println("입력한 점수를 존재하지 않습니다.");
		// 문제3) 학번을 입력받아 성적 출력
		// 정답3) 학번 입력 : 1003 성적 : 45점
		
		System.out.print("학번입력: ");
		int hakbun = scan.nextInt();
		
		isFound = false;
		
		
		for(int i=0; i<5; i++) {
			if(hakbuns[i] == hakbun) {
				System.out.println(scores[i]);
				isFound = true;
			}
		}
		if(!isFound)
			System.out.print("입력한 학번은 존재하지 않습니다.");		
		
		//문제5) 1등 학생의 학번과 성적 출력
		//정답5) 1004번(96점)
		
		int max = 0;
		//인덱스를 기억하는 용도를 가진 변수는
		//유효한 인덱스 범위 밖의 값으로 음수 초기화
		int maxIdx = -1; 
		
		for(int i=0; i<5; i++) {
			if(scores[i] > max) {
				max = scores[i];
				maxIdx = i;
			}
		}
		for(int i=0; i<5; i++) {
			if(scores[i] == max) {
				System.out.printf("1등 점수 :%d점\n",max);
			}
		}
		System.out.printf("%d번 (%d)점",hakbuns[maxIdx],max);
		
		
	}

}
