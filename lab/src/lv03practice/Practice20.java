package lv03practice;

import java.util.Arrays;
import java.util.Scanner;


public class Practice20 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
		int a[] = { 10, 49, 51, 36, 17 };
		// 문제1) 다음리스트를 값을 입력하면 번호 출력
		// 예) 51 ==> 2
		// 예) 10 ==> 0
		System.out.println("10 49 51 36 17");
		int score = scan.nextInt();
		
		int idx = -1; //음수 초기화
		
		for(int i=0; i<5; i++) {
			if(a[i] == score) {
				idx = i;
			}
		}
		if(idx != -1) {
			System.out.println(idx);
		}else	// idx = -1 일때
			System.err.println("존재하지 않는 점수입니다.");
		
		
		// 문제2) 다음 리스트를 이용해서 a의 값중 홀수만 b에 저장(위치는 동일한 위치에 저장)
		// 예) b = [0, 49, 51, 0, 17]
		int b[] = { 0, 0, 0, 0, 0 };
		
		for(int i=0; i<5; i++) {
			if(a[i] % 2 == 1) {
				b[i] = a[i];
			}
		}
		
		// 문제3) 다음 리스트를 이용해서 a의 값중 홀수만 c에 저장(위치는 앞에서 부터 저장)
		// 2번 문제와 조금 다름
		// 예) c = [49, 51, 17, 0, 0]
		int c[] = { 0, 0, 0, 0, 0 };
		
		idx = 0;
		
		for(int i=0; i<5; i++) {
			if(a[i] % 2 == 1) {
				c[idx] = a[i];
				idx ++;		//인덱스를 증가시키는 이유
			}
		}
		
		System.out.println(Arrays.toString(c));
		
		int arr[] = { 1001, 20, 1002, 45, 1003, 54 };
		// 학번과 점수가 한쌍이다. ==> 1001:20, 1002:45 , 1003: 54

		// 문제4) 학번을 입력하면 점수 출력
		// 예) 1001 ==> 20, 1003 ==> 54
		
		//짝수자리에 학번있음
		boolean isFound = false;
		
		System.out.print("학번 : ");
		int hakbun = scan.nextInt();
		
		for(int i=0; i<6; i+=2) {		//i : 0 2 4
			if(arr[i] == hakbun) {
				isFound = true;
				System.out.print(arr[i+1]);
			}
		}
		
				
		// 문제5) 점수를 입력하면 학번 출력
		// 예) 20 ==> 1001, 45 ==> 1002
		
		//홀수자리에 점수있음
		isFound = false;
		
		
		System.out.print("점수 : ");
		score = scan.nextInt();
		
		for(int i=1; i<6; i+=2) {   // i : 1 3 5
			if(arr[i] == score) {
				System.out.print(arr[i-1]);
			}
			
		}
		
		
	}

}
