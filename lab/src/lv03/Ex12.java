package lv03;

import java.util.Random;


public class Ex12 {

	public static void main(String[] args) {
		
		Random random = new Random();
		
		//문제1) arr배열에 1~100점 사이의 랜덤 정수를 5개 저장
		//예) 1) 87,11,92,14,47
		
		//arr 초기화
		int[] arr = new int[5];
		
		for(int i=0; i<5; i++) {
			//arr 배열에 1~100 랜덤값 저장
			arr[i] = random.nextInt(100) +1;
		}
		
		for(int i=0; i<5; i++) {
			System.out.print(arr[i] + " ");
		}
		
		//문제2) 전교생의 총점과 평균 출력
		//예)	점수가 60점 이상이면 합격
		//예)	합격자 수
		//예)	2) 총점(251) 평균(50.2)
		
		int total = 0;
		double avg = 0;
		int pass = 0;
		
		
		for(int i=0; i<5; i++) {
			total += arr[i];
			avg = total / 5;
			
			boolean isPassed = false;
			if(arr[i] >= 60) {
				pass ++;
				isPassed = true;
			}
		}
		System.out.println("\n총점 : " + total);
		System.out.println("평균 : " + avg);
		
		//문제3) 성적이 60점 이상이면 합격, 합격생 수 출력
		//예) 	3) 2명
		
		System.out.println("합격자 수 : " + pass);
		
		

	}

}
