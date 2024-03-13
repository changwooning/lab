package lv03practice;

import java.util.Scanner;
import java.util.Arrays;


public class Practice37 {
	
	//1424

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int a[] = { 10, 49, 51, 36, 17 };
		// 문제1) 다음리스트를 값을 입력하면 번호 출력
		// 예) 51 ==> 2
		// 예) 10 ==> 0
		
		int idx = -1;
		
		System.out.println("10 49 51 36 17");
		int score = scan.nextInt();
	
		for(int i=0; i<5; i++) {
			if(a[i] == score) {
				idx = i;
			}
		}
		if(idx != -1)
			System.out.print("번호 : " + idx);
		else
			System.err.println("입력한 점수는 없는 점수입니다.");
		
		System.out.println();
		
		
		// 문제2) 다음 리스트를 이용해서 a의 값중 홀수만 b에 저장(위치는 동일한 위치에 저장)
		// 예) b = [0, 49, 51, 0, 17]
		int b[] = { 0, 0, 0, 0, 0 };
		
		for(int i=0; i<5; i++) {
			if(a[i] % 2 == 1) {
				b[i] = a[i];
			}
		}
		for(int i=0; i<5; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();
		// 문제3) 다음 리스트를 이용해서 a의 값중 홀수만 c에 저장(위치는 앞에서 부터 저장)
		// 2번 문제와 조금 다름
		// 예) c = [49, 51, 17, 0, 0]
		int c[] = { 0, 0, 0, 0, 0 };
		
		idx = 0;
		
		for(int i=0; i<5; i++) {
			if(a[i] % 2 == 1) {
				c[idx] = a[i];
				idx ++;
			}
		}
		for(int i=0; i<5; i++) {
			System.out.print(c[i] + " ");
		}
		
		
		int arr[] = { 1001, 20, 1002, 45, 1003, 54 };
		// 학번과 점수가 한쌍이다. ==> 1001:20, 1002:45 , 1003: 54
		// 문제4) 학번을 입력하면 점수 출력
		// 예) 1001 ==> 20, 1003 ==> 54
		
		boolean isFound = false;
		
		//학번은 짝수자리에 있다.
		System.out.print("\n학번 입력 : ");
		int hakbun = scan.nextInt();
		
		for(int i=0; i<6; i+=2) {		// 0 2 4
 			if(arr[i] == hakbun) {
				System.out.println(arr[i+1]);
				isFound = true;
			}
		}
		if(!isFound)
			System.err.println("존재하지 않는 학번입니다.");
		
		// 문제5) 점수를 입력하면 학번 출력
		// 예) 20 ==> 1001, 45 ==> 1002
		
		//점수는 홀수자리에 있다.
		isFound = false;
		
		System.out.print("\n점수 입력 : ");
		int score2 = scan.nextInt();
		
		for(int i=1; i<6; i+=2) {
			if(arr[i] == score2) {
				System.out.println(arr[i-1]);
				isFound = true;
			}
		}
		if(!isFound)
			System.err.println("존재하지 않은 점수입니다.");
		
		

	}

}
