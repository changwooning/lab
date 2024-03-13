package lv04;
import java.util.Arrays;
import java.util.Scanner;

public class Ex21 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		final int  SIZE = 3;
		
		int[][] arr = new int[SIZE][SIZE];
		
		int k = 1;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				arr[i][j] = 10 * k;
				k += 1;
			}
		}
		
		//1번
		System.out.print("인덱스1 : ");
		int idx1 = scan.nextInt();
		System.out.print("인덱스2 : ");
		int idx2 = scan.nextInt();
		
		if(idx1 < 0 || idx1 > SIZE-1 || idx2 < 0 || idx2 > SIZE-1) {
			System.out.println("유효하지 않은 인덱스 범위 입니다.");
		}else
			System.out.println(arr[idx1][idx2]);
		
		
		
		
		//2번
		System.out.print("값 입력 : ");
		int data = scan.nextInt();
		
		idx1 = -1;
		idx2 = -1;
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(arr[i][j] == data) {
					idx1 = i;
					idx2 = j;
				}
			}
		}
		
		if(idx1 == -1) {
			System.out.println("해당 값은 존재하지 않습니다.");
		}else {
			System.out.println("인덱스1 : " + idx1);
			System.out.println("인덱스2 : " + idx2);
		}
		
		
		//3번
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
		System.out.println("max 인덱스1 : " + idx1);
		System.out.println("max 인덱스2 : " + idx2);
		
		
		
		//4번
		System.out.println("값1 : ");
		data = scan.nextInt();
		System.out.println("값2 : ");
		int data2 = scan.nextInt();
		
		idx1 = -1;
		idx2 = -1;
		int idx3 = -1;
		int idx4 = -1;
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(data == arr[i][j]) {
					idx1 = i;
					idx2 = j;
				}
				if(data2 == arr[i][j]) {
					idx3 = i;
					idx4 = j;
				}
			}
		}
		if(idx1 == -1 || idx3 == -1) {	// 값이 없으므로! 찾기 불가능 값교체 불가능ㅇ 
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
