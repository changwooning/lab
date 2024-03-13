package lv03practice;

import java.util.Random;
import java.util.Scanner;

public class Practice18 {
	
	//1433
	//1448
	

	public static void main(String[] args) {
		
		Random ran = new Random();
		Scanner scan = new Scanner(System.in);
		
		int[] scores = new int[5];
		int[] hakbuns = new int[5];

		// 랜덤 점수 (1~100) scores에 5개 저장
		// 학번을 (1001~1005) hakbuns에 5개 저장
		
		for(int i=0; i<5; i++) {
			scores[i] = ran.nextInt(100) + 1;
			hakbuns[i] = i + 1001;
			System.out.printf("%d번 [%d]점\n",hakbuns[i], scores[i]);
		}
		
		// 문제1) 인덱스를 입력받아 성적 출력
				// 정답1) 인덱스 입력 : 1 성적 : 11점
		
		System.out.print("인덱스 입력 : ");
		int idx = scan.nextInt();
		
		if(idx >=0 && idx <5) {
			System.out.printf("성적 : %d점\n",scores[idx]);
		}else
			System.err.println("배열의 길이는 5입니다.");
		
		// 문제2) 성적을 입력받아 인덱스 출력
		// 정답2) 성적 입력 : 11 인덱스 : 1
		
		boolean isFound = false;
		System.out.print("성적입력: ");
		int score = scan.nextInt();
		
		for(int i=0; i<5; i++) {
			if(scores[i] == score) {
				System.out.print("인덱스 : " + i);  //printf랑은 무슨차이지?
				isFound = true;
			}
		}
		if(!isFound){
			System.err.println("입력한 성적은 존재하지 않습니다.");
		}
		
		// 문제3) 학번을 입력받아 성적 출력
				// 정답3) 학번 입력 : 1003 성적 : 45점
		
		isFound = false;
		System.out.print("\n학번 입력 : ");
		int hakbun = scan.nextInt();
		for(int i=0; i<5; i++) {
			if(hakbuns[i] == hakbun) {
				System.out.printf("%d점\n",scores[i]);
				isFound = true;
			}
		}
		if(!isFound)
			System.err.println("입력한 학번은 존재하지 않습니다.");
		
		//문제) 1등 학생의 학번과 성적 출력
		//정답) 1004번(96점)
		int max = 0;
		int maxIdx = -1;
		for(int i =0; i<5; i++) {
			if(scores[i] > max) {
				max = scores[i];
				maxIdx = i;
			}
		}
		for(int i=0; i<5; i++) {
			if(scores[i] == max) {
				System.out.printf("1등 점수 : %d점\n",max);
			}
		}
		System.out.printf("1등 학생 %d번 (%d)점",hakbuns[maxIdx],max);
		
		
		
	}

}
