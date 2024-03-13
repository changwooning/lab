package lv04;

public class Ex19 {

	public static void main(String[] args) {

		int[][] arr = new int[3][3];
		//{{0,0,0}{0,0,0}{0,0,0}}

		int k = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = 10 * k++;
			}
		}
		
		//문제1) 전체 합 출력
		//정답1) 450
		int sum = 0;
		int cnt = 0;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(arr[i][j] + " ");
				sum += arr[i][j] ;
			}
			System.out.println();	//줄바꿈
		}
		System.out.print("sum : "  + sum);
		
		
		
		//문제2) 4의 배수만 출력
		//문제2) 20 40 60 80
		
		//문제3) 4의 배수의 합 출력
		//정답3) 200
		
		//문제4) 4의 배수의 개수 출력
		//정답4) 4
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j] % 4 == 0) {
					System.out.print(arr[i][j] + " ");
					sum += arr[i][j];
					cnt ++;
				}
			}
		}
		System.out.println("\n4의 배수의 합 : "+ sum);
		System.out.println("\n4의 배수의 개수 : "+ cnt);
		
		
		
		
		

	}

}
