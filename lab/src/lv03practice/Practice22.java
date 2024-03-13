package lv03practice;

import java.util.Scanner;


public class Practice22 {
	
	//1642

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// 문제1) 인덱스(방번호)를 입력하면 값출력
		int a[] = { 10, 20, 30, 40, 50 };
		// 예) 3 ==> 40
		
		System.out.print("방 번호 : ");
		int num = scan.nextInt();
		
		if(num >=0 && num <5) {
			System.out.println(a[num]);
		}else
			System.err.println("입력한 값은 없는 값입니다.");

		//문제2) 아래배열중 가장 큰값 출력
		int b[] = { 12, 54, 23, 87, 1 };
		// 예) 87
		
		int max = 0;
		for(int i=0; i<5; i++) {
			if(b[i] > max) {
				max = b[i];
			}
		}
		System.out.print("Max : " + max);
		
		System.out.println();

		// 문제3) 아래 배열중 홀수의 개수 출력
		int c[] = { 12, 54, 23, 87, 1 };
		// 예) 홀수의 개수 : 3
		int cnt = 0;
		for(int i=0; i<5; i++) {
			if(c[i] % 2 == 1) {
				cnt ++;
			}
		}
		System.out.print(cnt);
				
		System.out.println();
		// 문제4) 아래배열을 거꾸로 저장
		int d[] = { 1, 2, 3, 4, 5 };
		int e[] = { 0, 0, 0, 0, 0 };
		// 예) = {5,4,3,2,1};
		
		int idx = 4;
		for(int i=0; i<5; i++) {
			e[idx] = d[i];
			idx --;
		}
		for(int i=0; i<5; i++) {
			System.out.print(e[i] + " ");
		}
				
				
				
	}

}
