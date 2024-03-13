package lv03;

import java.util.Arrays;
import java.util.Scanner;

public class Ex40 {

	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
		int arr[] = {10,20,30,40,50};
		int b[] = new int[5];
		
		//숫자를 5개 입력받고 arr 배열안에 입력한값이 있을때마다
		//b배열안에 해당 값의 인덱스를 차례대로 저장할려고 한다.
		//조건) 만약에 입력한 숫자가 arr에 없으면 인덱스 대신 -1 저장
		
		//예) 10, 20, 10, 1, 50
		//b = {0,1,0,-1,4}
		
		//예) 30,40,1,10,2
		//b = {2,3,-1,0,-1}
		
//		for(int i=0; i<5; i++) {		// i : 0 1 2 3 4 5
//			System.out.print("숫자 : ");
//			int num = scan.nextInt();
//			for(int j=0; j<5; j++) {	// j : 0 1 2 3 4
//				if(arr[i] == num) {
//					arr[j]= i;
//					System.out.print(b[i] + " ");
//				}else {
//					arr[j] = -1;
//				}
//			}
//		}
		
		for(int i=0; i<5; i++) {		// i : b배열의 인덱스 0~4
			System.out.printf("숫자 %d : ",i+1);
			int num = scan.nextInt();
			
			//num 값이 arr 배열 안에서 어느 인덱스이냐?
			int idx = -1;
			for(int j=0; j<5; j++) {		//j: arr배열의 인덱스 0~4
				if(num == arr[j])
					idx = j;
			}
			b[i] = idx;
				
		}
		System.out.println(Arrays.toString(b));
		
		

	}

}
