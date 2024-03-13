package lv03practice;

import java.util.Random;
import java.util.Scanner;

public class Practice04 {
	
	//1059
	

	public static void main(String[] args) {
		
		Random ran = new Random();
		Scanner scan = new Scanner(System.in);
		
		int[] hakbuns = null; //값이 없는 상태
		int[] scores = null;
		
		hakbuns = new int[5];
		scores = new int[5];
		
		// 랜덤 점수 (1~100) scores에 5개 저장
		// 학번을 (1001~1005) hakbuns에 5개 저장
		for(int i=0; i<5; i++) {
			scores[i] = ran.nextInt(100) + 1;
			hakbuns[i] = ran.nextInt(5) + 1001;
			System.out.print(scores[i] + " ");
		}
		System.out.println();
		
		// 문제1) 인덱스를 입력받아 성적 출력
		// 정답1) 인덱스 입력 : 1 성적 : 11점
		System.out.print("인덱스 입력 : ");
		int index = scan.nextInt();
		
		// 인덱스를 입력받을땐 항상 예외처리 신경쓰기
		if(index >= 0 && index < 5) {
			System.out.print(scores[index]);
		}else
			System.out.print("유효한 범위의 인덱스가 아닙니다.");
		
		
		// 문제2) 성적을 입력받아 인덱스 출력
		// 정답2) 성적 입력 : 11 인덱스 : 1
		
		System.out.print("\n성적 입력 : ");
		int score = scan.nextInt();

		boolean isFound = false;
		
		for(int i=0; i<5; i++) {
			if(scores[i] == score) {
				System.out.print("인덱스 : " + i);
				isFound = true;
			}
		}
		if(!isFound) {
			System.err.println("입력한 성적은 유효하지 않습니다.");
		}

		
		
		// 문제3) 학번을 입력받아 성적 출력
		// 정답3) 학번 입력 : 1003 성적 : 45점
		
		
		System.out.print("\n학번 입력 : ");
		int hakbun = scan.nextInt();
		
		isFound = false;
		for(int i=0; i<5; i++) {
			if(hakbuns[i] == hakbun) {
				System.out.println(scores[i]);
				isFound = true;
			}
		}
		if(!isFound) {
			System.out.print("존재하지 않는 학번입니다.");
		}
		
		
		//문제) 1등 학생의 학번과 성적 출력
		//정답) 1004번(96점)

	}

}
