package lv02;

import java.util.Random;


public class Ex20 {

	public static void main(String[] args) {
		
		Random random = new Random();
		
		int total = 0;
		int pass = 0;
		
		int top = 0;
		int max = 0;
		
		int n = 0;
		while(n <= 10) {
			
			//1~100 랜덤 숫자
			int score = (int)(Math.random() * 100) + 1;
			total += score;
			
			//합격자
			if(score >= 60) {
				pass ++;
			}
			
			if(score > max) {
				top = n;
				max = score;
			}
			System.out.printf("%d번 학생) %d점 [%s]\n", n + 1, score , score >= 60);
			n ++;
		}
		
		System.out.println("---------------------");
		System.out.printf("전교생 총점 %d점, 평균 %d점\n", total,total / n);
		System.out.printf("합격자 수 : %d\n", pass);
		System.out.printf("1등 학생 번호 %d 점수 %d\n", top, max);
	}

}
