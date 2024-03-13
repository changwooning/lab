package lv03;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int a[] = { 10, 49, 51, 36, 17 };
		// 문제1) 다음리스트를 값을 입력하면 번호 출력
		// 예) 51 ==> 2
		// 예) 10 ==> 0
		System.out.println("10, 49, 51, 36, 17");
		int score = scan.nextInt();
		
		int index = -1;  //
		
		for (int i = 0; i < 5; i++) {
			if (a[i] == score) {
				index = i;
			}
		}
		if(index != -1) {
			System.out.println("번호 : " + index);
		}else { //index == -1 일때!
			System.err.println("해당 값은 존재하지 않습니다.");
		}

		// 문제2) 다음 리스트를 이용해서 a의 값중 홀수만 b에 저장(위치는 동일한 위치에 저장)
		// 예) b = [0, 49, 51, 0, 17]
		int b[] = { 0, 0, 0, 0, 0 };

		for (int i = 0; i < 5; i++) {
			if (a[i] % 2 == 1) {
				b[i] = a[i];
			}
		}

		// 문제3) 다음 리스트를 이용해서 a의 값중 홀수만 c에 저장(위치는 앞에서 부터 저장)
		// 2번 문제와 조금 다름
		// 예) c = [49, 51, 17, 0, 0]
		int c[] = { 0, 0, 0, 0, 0 };
		
		index = 0; // 용도 : c배열의 인덱스 사용
		
		for(int i=0; i<5; i++) {
			if(a[i] % 2 == 1) {
				c[index] = a[i];
				index ++;
			}
		}
		// ------------------------------
		int arr[] = { 1001, 20, 1002, 45, 1003, 54 };
		// 학번과 점수가 한쌍이다. ==> 1001:20, 1002:45 , 1003: 54

		// 문제4) 학번을 입력하면 점수 출력
		// 예) 1001 ==> 20, 1003 ==> 54
		
		System.out.print("학번 : ");
		int num = scan.nextInt();
		
		//짝수 인덱스에 학번 있음
		boolean isFound =false;
		
		for(int i=0; i<6; i+=2) {		// i : 0 2 4
			if(arr[i] == num) {
				System.out.println(arr[i+1]);
				isFound = true;
			}
		}
		if(!isFound) {
			System.err.println("존재하지 않는 학번입니다.");
		}

		// 문제5) 점수를 입력하면 학번 출력
		// 예) 20 ==> 1001, 45 ==> 1002
		
		System.out.print("점수 : ");
		int score2 = scan.nextInt();
		
		//홀수 인덱스에 있음
		//i : 1 3 5
		for(int i=1; i<6; i+=2) {
			if(arr[i] == score2) {
				System.out.println(arr[i-1]);
				isFound = true;
			}
		}
		
		
	}

}
