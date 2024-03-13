package lv03practice;

import java.util.Scanner;


public class Practice38 {
	
	//1448
	

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// 문제1) 인덱스(방번호)를 입력하면 값출력
		int a[] = { 10, 20, 30, 40, 50 };
		// 예) 3 ==> 40
		
		System.out.println("방 번호 : 10 20 30 40 50");
		int idx = scan.nextInt();
		
		if(idx < 0 || idx >=5) {
			System.err.println("범위에 없는 값입니다.");
		}else {
			System.out.println(a[idx]);
		}

				
		// 문제2) 아래배열중 가장 큰값 출력
		int b[] = { 12, 54, 23, 87, 1 };
		// 예) 87
		int max = 0;
		for(int i=0; i<5; i++) {
			if(b[i] > max) {
				max = b[i];
			}
		}
		System.out.println(max);
		
			
		// 문제3) 아래 배열중 홀수의 개수 출력
		int c[] = { 12, 54, 23, 87, 1 };
		// 예) 홀수의 개수 : 3
		int cnt = 0;
		for(int i=0; i<5; i++) {
			if(c[i] % 2 == 1)
				cnt ++;
		}
		System.out.println(cnt);
		
			
		// 문제4) 아래배열을 거꾸로 저장
		int index = 4;
		int d[] = { 1, 2, 3, 4, 5 };
		int e[] = { 0, 0, 0, 0, 0 };
		// 예) = {5,4,3,2,1};
		for(int i=0; i<5; i++) {
			e[index] = d[i];
			index --;
		}
		for(int i=0; i<5; i++) {
			System.out.print(e[i]);
		}
		
		
		
	}

}
