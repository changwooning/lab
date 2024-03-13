package lv03;
import java.util.Random;


public class Ex03 {

	public static void main(String[] args) {
		
		Random random = new Random();
		int[] arr = new int[5];
		
		// 문제1) arr배열에 1~100점 사이의 랜덤 정수를 5개 저장
		// 예)	1) 87,, 11, 92, 14, 47

		for(int i=0; i<5; i++) {
			// 배열의 각 방에 랜덤값을 넣어 초기화
			arr[i] = random.nextInt(100) +1;
	
			System.out.print(arr[i]+ " ");
		}
		
		
		int total = 0;
		double avg = 0;
		int pass = 0;
		
		// 문제2) 전교생의 총점과 평균 출력
		// 예	2) 총점(251) 평균(50.2)
		
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
		// 문제3) 성적이 60점 이상이면 합격, 합격생 수 출력
		// 예	3) 2명

		System.out.print("합격생 수 : " + pass);
	}

}
