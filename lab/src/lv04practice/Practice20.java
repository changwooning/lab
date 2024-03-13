package lv04practice;

import java.util.Arrays;
import java.util.Scanner;

public class Practice20 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		final int SIZE = 3;
		
		int[][] arr = new int[SIZE][SIZE];
		
		int k= 1;
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				arr[i][j] = 10 * k;
				k+=1;
			}
		}
		
		// 문제1) 인덱스를 2개를 입력받아 값 출력
		// 예) 인덱스1 입력 : 1 인덱스2 입력 : 2
		// 값 출력 : 60
		System.out.print("인덱스1 : ");
		int idx1 = scan.nextInt();
		System.out.print("인덱스2 : ");
		int idx2 = scan.nextInt();
		
		if(idx1 < 0 || idx1 > SIZE-1 || idx2 < 0 || idx2 > SIZE-1) {
			System.out.println("입력하신 값은 존재하지 않습니다.");
		}else {
			System.out.print(arr[idx1][idx2] + " ");
		}
		
		System.out.println();
		
		// 문제2) 값을 입력받아 인덱스 2개 출력
		// 예) 값 입력 : 60
		// 인덱스1 출력 : 1 인덱스2 출력 : 2
		
		System.out.print("값 : ");
		int input = scan.nextInt();
		
		idx1 = -1;
		idx2 = -1;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j] == input) {
					idx1 = i;
					idx2 = i;
				}
			}
		}
		
		if(idx1 == -1) {
			System.out.println("해당 값은 존재하지 않습니다.");
		}else {
			System.out.println("인덱스1 : " + idx1);
			System.out.println("인덱스2 : " + idx2);
		}
			
		
		// 문제3) 가장 큰 값의 인덱스 2개 출력
		// 정답3) 2 2
		
		//기준을 하나 잡고 
		int max = arr[0][0];
		idx1 = 0;
		idx2 = 0;
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(arr[i][j] > max) {
					max = arr[i][j];
					idx1 = i;
					idx2 = j;
				}
			}
		}
		System.out.println("Max 인덱스1 : " + idx1);
		System.out.println("Max 인덱스2 : " + idx2);
		
		
		// 문제4) 값 2개를 입력받아 값 교체 (배열안에 있는 갑 두개를 서로 교체)
		System.out.print("값1 : ");
		int data1 = scan.nextInt();
		System.out.print("값2 : ");
		int data2 = scan.nextInt();
		
		idx1 = -1;
		idx2 = -1;
		int idx3 = -1;
		int idx4 = -1;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j] == data1) {
					idx1 = i;
					idx2 = j;
				}
				if(arr[i][j] == data2) {
					idx3 = i;
					idx4 = j;
				}
			}
		}
		if(idx1 == -1 || idx3 == -1) {
			System.out.println("값 교체가 불가능합니다.");
		}else {
			//값교체
			int temp = arr[idx1][idx2];
			arr[idx1][idx2] = arr[idx3][idx4];
			arr[idx3][idx4] = temp;
		}
		//출력
		for(int i=0; i<arr.length; i++) {
			System.out.println(Arrays.toString(arr));
		}
		
		
		
		
		
		
		
		

	}

}
