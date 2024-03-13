package lv06practice;

import java.util.Random;
class Omr3{
	
	int[] answer = {1,2,3,4,5};
	int[] submit = new int[5];
	
	int cnt = 0;
	int score = 0;
	
}

public class Practice02 {
	
	// # OMR 카드 : 클래스 + 변수
			// 1. 배열 anser는 시험문제의 정답지이다.
			// 2. 배열 hgd에 1~5 사이의 랜덤 숫자 5개를 저장한다.
			// 3. answer 와 hgd 값을 비교해 정오표를 출력한다.
			// 4. 한 문제당 20점이다.
			// 예)
			// answer = {1,3,4,2,5}
			// submit = {1,1,4,4,3}
			// 정오표 = {O,X,O,X,X}
			// 성적 = 40점

	public static void main(String[] args) {
		
		Omr3 omr = new Omr3();
		
		Random ran = new Random();
		
		int[] submit = omr.submit;
		int[] answer = omr.answer;
		
		for(int i=0; i<omr.submit.length; i++) {
			omr.submit[i] = ran.nextInt(5)+1;
			
			if(omr.submit[i] == omr.answer[i]) {
				omr.cnt ++;
				omr.score += 20;
			}
			
			System.out.printf("%d) %d : %d [%s]\n", i+1, omr.submit[i],omr.answer[i],omr.submit[i] == omr.answer[i] ? "O" : "X");
		}
		
		System.out.println("score : " + omr.score);
		
		

	}

}
