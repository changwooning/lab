package lv03;

import java.util.Scanner;
import java.util.Arrays;

public class Ex18 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] arr = {10,20,30,40,50};
		
		//문제1) 인덱스 2개를 입력받아 값 교체하기
		//예 1) 인덱스1 입력 : 1, 인덱스2 입력 : 3
		//{10,40,30,20,50}
		System.out.print("인덱스 입력1 : ");
		int index1 = scan.nextInt();
		System.out.print("인덱스 입력2 : ");
		int index2 = scan.nextInt();
		
		
		int temp = 0;
		//arr[index1]
		//arr[index2]
		if(index1 >= 0 && index1 <5 && index2 >= 0 && index2 <5) {
			
			//값 교체
			temp = arr[index1];
			arr[index1] = arr[index2];
			arr[index2] = temp;
		}
		
		System.out.println(Arrays.toString(arr));
		
		
		
		//문제2) 값 2개를 입력받아 값 교체하기
		//예 2) 값1 입력 : 40 , 값2 입력 : 20
		//{10,20,30,40,50}
		
		System.out.print("값1 : ");
		int score1 = scan.nextInt(); //score1 =값
		System.out.print("값2 : ");
		int score2 = scan.nextInt();
		
		index1 = -1;		//인덱스를 찾는 용도 -> 인덱스 범주 밖의 유효하지 않은 값으로 초기화
		index2 = -1;

		
		//인덱스에 해당하는 값을 찾기위해
		for(int i=0; i<5; i++) {
			if(arr[i] == score1)
				index1 = i;
			if(arr[i] == score2)
				index2 = i;
			}
		
		if(index1 == -1 || index2 == -1) {
			System.out.println("유효하지 않은값입니다.");
		}else {
			//값 교체
			temp = arr[index1];
			arr[index1] = arr[index2];
			arr[index2] = temp;
			
		}
		
		System.out.println(Arrays.toString(arr));
		
		//인덱스냐 인덱스자리에 있는 값이냐 
		
		
		int[] hakbuns = {1001,1002,1003,1004,1005};
		int[] scores = {87,11,45,98,23};
		
		//문제3) 학번 2개를 입력받아 성적 교체하기
		//예 3) 학번1 입력 : 1002, 학번2 입력 : 1003
		//{87,45,11,98,23}
		
		index1 = -1;
		index2 = -1;
		temp = 0;
		System.out.print("학번 1) : ");
		int num1 = scan.nextInt();
		System.out.print("학번 2) : ");
		int num2 = scan.nextInt();
		
		for(int i=0; i<5; i++) {
			if(hakbuns[i] == num1)
				index1 = i;
			if(hakbuns[i] == num2)
				index2 = i;
		}
		
		if(index1 == -1 || index2 == -1) {
			System.out.print("유효하지 않은 학번입니다.");
		}else {
			//값 교체
			
		}
		
	}

}
