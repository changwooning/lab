package lv03;

import java.util.Arrays;
import java.util.Scanner;

public class Ex26 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int[] arr = {10,20,30,40,50};
		
		//문제1) 인덱스 2개를 입력받아 값 교체하기
				//예 1) 인덱스1 입력 : 1, 인덱스2 입력 : 3
				//{10,40,30,20,50}
		System.out.println("인덱스 1: ");
		int index1 = scan.nextInt();
		System.out.println("인덱스 2: ");
		int index2 = scan.nextInt();
		//인덱스 값 범위 설정
		if(index1 >=0 && index1 < 5 && index2 >= 0 && index2 < 5) {
			//하나의 변수값 생성 => temp 여기서 temp는 인덱스 의 값
			int temp = 0;
			//값 교체
			temp = arr[index1];
			arr[index1] = arr[index2];
			arr[index2] = temp;
			
		}
		
		System.out.println(Arrays.toString(arr));
		
		
		//문제2) 값 2개를 입력받아 값 교체하기
				//예 2) 값1 입력 : 40 , 값2 입력 : 20
				//{10,20,30,40,50}
		System.out.println("값1 : ");
		int score1 = scan.nextInt();
		System.out.println("값2 : ");
		int score2 = scan.nextInt();

		index1 = -1;		//유효하지 않은 값으로 저장
		index2 = -1;
		
		//인덱스에 해당하는 값을 찾기위해 for문 사용
		for(int i=0; i<5; i++) {
			if(arr[i] == score1)
				index1 = i;
			if(arr[i] == score2)
				index2 = i;
		}
		if(index1 == -1 || index2 == -1) {
			System.out.print("유효하지 않은 값입니다.");
		}else {
			//값 교체
			int temp = 0;
			temp = arr[index1];
			arr[index1] = arr[index2];
			arr[index2] = temp;
		}
		
		System.out.println(Arrays.toString(arr));
			
		
		
		int[] hakbuns = {1001,1002,1003,1004,1005};
		int[] scores = {87,11,45,98,23};
		
		//문제3) 학번 2개를 입력받아 성적 교체하기
				//예 3) 학번1 입력 : 1002, 학번2 입력 : 1003
				//{87,45,11,98,23}
		
		
		System.out.println("학번1) : ");
		int hakbun1 = scan.nextInt();
		System.out.println("학번2) : ");
		int hakbun2 = scan.nextInt();
		
		index1 = -1;
		index2 = -1;
		int temp = 0;
		
		//해당하는 인덱스의 값
		for(int i=0; i<5; i++) {
			if(hakbuns[i] == hakbun1) {
				index1 = i;
			}
			if(hakbuns[i] == hakbun2) {
				index2 = i;
			}
		}
		
		if(index1 == -1 || index2 == -1) {
			System.out.println("유효하지 않은 값입니다.");
		}else {
			//값교체
			temp = hakbuns[index1];
			hakbuns[index1] = hakbuns[index2];
			hakbuns[index2] = temp;
		}
			
		
		
		System.out.println(Arrays.toString(arr));
		
		
	}

}
