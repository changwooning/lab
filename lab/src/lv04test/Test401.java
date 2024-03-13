package lv04test;

import java.util.Arrays;

public class Test401 {

	// test 1
	// 석차 출력
	// 성적 순으로 이름 출력

	// 1001
	// 

	public static void main(String[] args) {

		String[] name = { "홍길동", "김영", "자바킹", "민병철", "메가맨" };
		int[] score = { 87, 42, 100, 11, 98 };

		for (int i = 0; i < 4; i++) {
			int idx = i;
			for (int j = i + 1; j < 5; j++) {
				if (score[idx] < score[j]) {
					idx = j;
				}
			}
			int temp = score[i];
			score[i] = score[idx];
			score[idx] = temp;
			
			String tmp = name[i];
			name[i] = name[idx];
			name[idx] = tmp;
		}
		for(int i=0; i<5; i++) {
			System.out.print(name[i] + " ");
		}
	}

}
