package lv03practice;

import java.util.Random;
import java.util.Scanner;


public class Practice05 {
	
	//1219
	//1231

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		int[] hakbuns = null; 		
		int[] scores = null;
		
		//학번 점수 배열초기화 부터
		hakbuns = new int[5];
		scores = new int[5];
		
		// 랜덤 점수 (1~100) scores에 5개 저장
		// 학번을 (1001~1005) hakbuns에 5개 저장
		for(int i=0; i<5; i++) {
			hakbuns[i] = i + 1001;
			scores[i] = ran.nextInt(100) + 1;
			System.out.print(scores[i] + " ");
		}
		
		
		// 문제1) 인덱스를 입력받아 성적 출력
		// 정답1) 인덱스 입력 : 1 성적 : 11점
		System.out.print("\n인덱스 입력 : ");
		int index = scan.nextInt();
		
		//index 값 범위 예외처리
		if(index >= 0 && index < 5) {
			System.out.println(scores[index] + " ");
		}else
			System.err.println("배열의 길이는 5입니다.");

		// 문제2) 성적을 입력받아 인덱스 출력
		// 정답2) 성적 입력 : 11 인덱스 : 1
		
		System.out.print("\n성적 : ");
		int score = scan.nextInt();
		
		boolean isFound = false;
		
		for(int i=0; i<5; i++) {
			if(scores[i] == score) {
				System.out.println("\n인덱스 : " + i);
				isFound = true;
			}
		}
		//예외처리
		if(!isFound)
			System.out.println("입력한 점수는 존재하지 않습니다.");
		
		
		// 문제3) 학번을 입력받아 성적 출력
		// 정답3) 학번 입력 : 1003 성적 : 45점
		
		isFound = false;
		System.out.print("\n학번 입력 : ");
		int hakbun = scan.nextInt();
		
		for(int i=0; i<5; i++) {
			if(hakbuns[i] == hakbun) {
				System.out.println(scores[i] + "점");
				isFound = true;
			}
		}
		if(!isFound)
			System.err.println("해당하는 학번은 없습니다.");
		
		
	}

}
