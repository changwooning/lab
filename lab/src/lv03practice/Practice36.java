package lv03practice;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;


public class Practice36 {
	
	//1400
	//1422

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		int[] scores = new int[5];
		int[] hakbuns = new int[5];
		
		
		// 랜덤 점수 (1~100) scores에 5개 저장
		// 학번을 (1001~1005) hakbuns에 5개 저장
		for(int i=0; i<5; i++) {
			scores[i] = ran.nextInt(100) + 1;
			hakbuns[i] = i + 1001;
			System.out.printf("%d번  %d점\n",hakbuns[i],scores[i] );
		}
		
		// 문제1) 인덱스를 입력받아 성적 출력
		// 정답1) 인덱스 입력 : 1 성적 : 11점
		
		System.out.print("인덱스 : ");
		int idx = scan.nextInt();
		
		//예외처리
		if(idx >= 0 && idx <5) {
			System.out.print("성적 : " + scores[idx]);
		}else
			System.err.println("입력한 값은 범위에 해당하지 않습니다.");
		
		
		// 문제2) 성적을 입력받아 인덱스 출력
		// 정답2) 성적 입력 : 11 인덱스 : 1
		
		System.out.print("\n성적 입력 : ");
		int score = scan.nextInt();
		
		boolean isRun = false;
		
		for(int i=0; i<5; i++) {
			if(scores[i] == score) {
				System.out.print("인덱스 : " + i);
				isRun = true;
				}
		}
		
		// 문제3) 학번을 입력받아 성적 출력
		// 정답3) 학번 입력 : 1003 성적 : 45점
		
		isRun= false;
		
		
		System.out.print("\n학번 입력 : ");
		int hakbun = scan.nextInt();
		
		for(int i=0; i<5; i++) {
			if(hakbuns[i] == hakbun) {
				System.out.print("성적 : " + scores[idx]);
				isRun = true;
			}
		}
		
		//문제) 1등 학생의 학번과 성적 출력
		//정답) 1004번(96점)
		int max = 0;
		int maxIndex = -1;
		
		for(int i=0; i<5; i++) {
			if(scores[i] > max) {
				max = scores[i];
				maxIndex = i;
			}
		}
		for(int i=0; i<5; i++) {
			if(scores[i] == max) {
				System.out.print("\n1등 점수 : " + max);
			}
		}
		
		System.out.printf("\n1등학생 %d번 %d점",hakbuns[maxIndex], max);
	
		
		
		
		
		

	}

}
