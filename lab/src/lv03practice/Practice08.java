package lv03practice;

import java.util.Scanner;
import java.util.Arrays;


public class Practice08 {
	
	//0923
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int a[] = { 10, 49, 51, 36, 17 };
		System.out.println(Arrays.toString(a));
		
		// 문제1) 다음리스트를 값을 입력하면 번호 출력
		// 예) 51 ==> 2
		// 예) 10 ==> 0
		
		//값을 입력하면 인덱스 출력
		boolean isFound = false;
		
		System.out.print("값 : ");
		int score = scan.nextInt();
		
		for(int i=0; i<5; i++) {
			if(a[i] == score) {
				isFound = true;
				System.out.println("인덱스 : " + i);
			}
		}
		//예외처리
		if(!isFound)
			System.err.println("입력한 값은 존재하지 않습니다.");
		
		
		// 문제2) 다음 리스트를 이용해서 a의 값중 홀수만 b에 저장(위치는 동일한 위치에 저장)
		// 예) b = [0, 49, 51, 0, 17]
		int b[] = { 0, 0, 0, 0, 0 };
		
		//인덱스를 이용해서 값찾기 그리고 홀수만 저장 //저장하는법을 잘 모름 //출력은 따로 하기!
		// 출력은 ?
		
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
		
		// 앞에서부터 저장하는 법 잘 모름
		// ㄴ 저장할때 별도의 인덱스 지정
		int c[] = { 0, 0, 0, 0, 0 };
		
		int index = 0; // 인덱스는 0이면 첫번째부터 출발
		
		for(int i=0; i<5; i++) {
			if(a[i] % 2 == 1) {
				c[index] = a[i];
				index ++; //하나씩 증가시켜줌
			}
		}
		for(int i=0; i<5; i++) {
			System.out.print(c[i] + " ");
		}
		
		
		int arr[] = { 1001, 20, 1002, 45, 1003, 54 };
		
		// 문제4) 학번을 입력하면 점수 출력
		// 예) 1001 ==> 20, 1003 ==> 54
		
		System.out.print("학번 입력 : ");
		int hakbun = scan.nextInt();
		
		isFound = false;
		
		for(int i=0; i<5; i++) {
			
		}
		
		
		
		
				
		// 문제5) 점수를 입력하면 학번 출력
		// 예) 20 ==> 1001, 45 ==> 1002
		

	}

}
