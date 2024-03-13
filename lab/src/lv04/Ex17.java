package lv04;

import java.util.Arrays;
import java.util.Scanner;

public class Ex17 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// int[] a= {1,1,3,3,3,100,2,2,3,1,3};

		// 위 배열에서 똑같은 숫자의 개수가 가장 적은 숫자와 가장 많은 숫자의 개수를 출력
		// 예) 개수가 가장 적은 숫자 ==> 100
		// 예) 개수가 가장 많은 숫자 ==> 3

		// 가장 많은 개수 출력 : 3 => 5개
		// 가장 적은 개수 출력 : 100 => 1개

		// 배열의 크기 => 배열변수명.length : 배열의 크기
		// null 인 상태에서는 length를 참조할 수 없다.(주의)

		int[] a = { 1, 1, 3, 3, 3, 100, 2, 2, 3, 1, 3 };

		int maxCnt = 0;
		int maxNum = 0;

		int minCnt = a.length;
		int minNum = 0;
		
		int idx = 0;

		for (int i = 0; i < a.length; i++) {
			//검사 대상 : a[i]
			int cnt = 0;
			//검사 범위 : 배열 전체
			for(int j=0; j<a.length; j++) {
				if(a[i] == a[j])
					cnt ++;
			}
			if(cnt > maxCnt) {
				maxCnt = cnt;
				maxNum = a[i];
			}
			if(cnt <= minCnt) {
				minCnt = cnt;
				minNum = a[i];
			}
		}
		System.out.printf("가장 많은 갯수 출력 : %d ===> %d개\n",maxNum,maxCnt);
		System.out.printf("가장 적은 갯수 출력 : %d ===> %d개\n",minNum,minCnt);
		
		
		//벡터컨트롤러 이용하기
		//int[] a = {5,1,2,2,3,3,4,4,5,1};
		
		
		//1.가장 적은 숫자의 개수
		//2.가장 적은 숫자의 개수
		//3.가장 많은 숫자의 개수와 같으면 => 별도로 해당 숫자를 여러개(몇개인지모름) 기억 (변수 -> 배열)
		//4.가장 적은 숫자의 개수와 같으면 => 별도로 해당 숫자를 여러개(몇개인지모름) 기억 (변수 -> 배열)
		//5. 결과배열 A,B를 출력
		
		maxCnt = 0;
		minCnt = a.length+1;
		
		int[] maxNums = null;
		int maxIdx = 0;
		
		int[] minNums = null;
		int minIdx = 0;
		
		
		//가장 많은 갯수 출력 : 1 ===> 2
		//가장 많은 갯수 출력 : 2 ===> 2
		//가장 많은 갯수 출력 : 3 ===> 2
		//가장 많은 갯수 출력 : 4 ===> 2
		//가장 많은 갯수 출력 : 5 ===> 2
		
		//가장 적은 갯수 출력 : 1 ===> 2
		//가장 적은 갯수 출력 : 2 ===> 2
		//가장 적은 갯수 출력 : 3 ===> 2
		//가장 적은 갯수 출력 : 4 ===> 2
		//가장 적은 갯수 출력 : 5 ===> 2
		
		
		
		
		

	}

}
