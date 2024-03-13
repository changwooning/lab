package lv03practice;

import java.util.Scanner;

public class Practice25 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// 문제1) 아래 배열 a에서 내가 입력한 값만 빼고 b에 저장
		int a[] = { 10, 20, 30, 40, 50 };
		int b[] = { 0, 0, 0, 0, 0 };
		// 예) 30 ==> b[] = { 10,20,40,50,0}
		
		
		System.out.print("값 : ");
		int input = scan.nextInt();
		
		boolean isRun = false;
		
		int idx = 0;
		
		for(int i=0; i<5; i++) {
			if(a[i] == input) {
				isRun = true; //이해가..
			}else {
				b[idx] = a[i];
				idx ++;
			}
		}
		if(isRun) {
			for(int i=0; i<5; i++) {
				System.out.print(b[i] + " ");
			}
		}else
			System.err.println("입력한 값은 존재하지 않습니다.");
		
		
		
		System.out.println();
				
		// 문제2) 아래 배열에서 내가 입력한 번호의 "번호와 값" 만 빼고 d에 저장
		int c[] = { 1001, 40, 1002, 65, 1003, 70 };
		int d[] = { 0, 0, 0, 0, 0, 0 };
		// 예) 1002 ==> d[] = {1001, 40, 1003, 70, 0, 0};

		
		System.out.print("번호 입력 : ");
		int num = scan.nextInt();
		
		idx = 0;
		
		for(int i=0; i<6; i+=2) {  // i : 0 2 4
			if(c[i] != num && c[i+1] != num) {		//세트로 움직여야함
				d[idx] = c[i]; 
				idx ++;
				d[idx] = c[i+1];
				idx ++;
			}
		}
		for(int i=0; i<6; i++) {
			System.out.print(d[i] + " ");
		}
		
		
		
		
		
	}

}
