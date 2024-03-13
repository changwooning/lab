package lv03;

import java.util.Scanner;

public class Ex08 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 문제1) 아래 배열 a에서 내가 입력한 값만 빼고 b에 저장
		int a[] = { 10, 20, 30, 40, 50 };
		int b[] = { 0, 0, 0, 0, 0 };
		// 예) 30 ==> b[] = { 10,20,40,50,0}

		System.out.println("값 : ");
		int input = scan.nextInt();

		boolean isRun = false;

		int index = 0;

		for (int i = 0; i < 5; i++) {
			if (a[i] == input) {
				isRun = true;
			} else {
				b[index] = a[i];
				index++;
			}
		}

		if (isRun) {
			for (int i = 0; i < 5; i++) {
				System.out.print(b[i] + " ");
			}
		} else {
			System.err.println("입력한 값이 없습니다.");
		}

		System.out.println();

		// 문제2) 아래 배열에서 내가 입력한 번호의 "번호와 값" 만 빼고 d에 저장
		int c[] = { 1001, 40, 1002, 65, 1003, 70 };
		int d[] = { 0, 0, 0, 0, 0, 0 };
		// 예) 1002 ==> d[] = {1001, 40, 1003, 70, 0, 0};

		System.out.print("번호 또는 값 : ");
		input = scan.nextInt();
		
		index = 0;
		for(int i=0; i<6; i+=2) { 		// i : 0 2 4
			if(input != c[i] && input != c[i+1]) { //조건식 이해하기
				d[index] = c[i];
				index ++;
				d[index] = c[i+1];
				index ++;
			}
		}
		for(int i=0; i<6; i++) {
			System.out.print(d[i] + " ");
		}
		
	}

}
