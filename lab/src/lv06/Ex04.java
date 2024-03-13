package lv06;

import java.util.Arrays;
import java.util.Random;

class Omr {

	int[] answer = { 1, 3, 4, 2, 5 };
	int[] submit = new int[5];

	int cnt = 0;
	int score = 0;
}

public class Ex04 {

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

		Random ran = new Random();
		Omr omr = new Omr();

		
		// 참조 변수 (값으로 주소를 가짐)
		int[] answer = omr.answer;
		int[] submit = omr.submit;
		
		// 일반 변수
		int cnt = omr.cnt;		// 0
		int score = omr.score;	// 0

		String[] result = new String[5];

		for (int i = 0; i < answer.length; i++) {
			int rNum = ran.nextInt(5) + 1;
			submit[i] = rNum;
			if (answer[i] == submit[i]) {
				result[i] = "O";
				cnt++;
			} else
				result[i] = "X";
		}
		score = cnt * 20;
		omr.cnt = cnt;
		omr.score = score;
		System.out.println("answer = " + Arrays.toString(answer));
		System.out.println("submit = " + Arrays.toString(submit));
		System.out.println("정오표 = " + Arrays.toString(result));
		System.out.println("성적 = " + score);
		
	}

}
