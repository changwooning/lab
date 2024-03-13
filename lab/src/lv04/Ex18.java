package lv04;
import java.util.Arrays;
public class Ex18 {

	public static void main(String[] args) {
		
		// 다차원 배열
		// ㄴ 배연 안에 또다른 배열이 값으로 있는 것
		
		// 1차원 배열 : {1,2,3,5}
		
		// 2차원 배열 : { {1,2,} {3,4} {5,6} {7,8} }
		//				0		1	  2     3
		//				0 1     1 2   1 2   0  1

		//	선언과 초기화
		// 자료형키워드[][] 변수명 = new 자료형키워드[배열의크기][내부배열의크기]
		int[][] arr = new int[4][2];
		
		System.out.println(arr);		//[I@123a439b
		System.out.println(Arrays.toString(arr));
		// [[I@7de26db8, [I@1175e2db, [I@36aa7bc2, [I@76ccd017]
		
		// 사용방법 (각 방에 접근)
		// 변수명[바깥인덱스][내부인덱스]
		arr[0][0] = 10;
		arr[0][1] = 20;
		arr[1][1] = 30;
		
		// arr 배열의 전체값 출력 (for문 사용)
		for(int i=0; i<arr.length; i++) {			//arr.length : 4
			for(int j=0; j<arr[i].length; j++) {	//arr[i]length : 2
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		
		
		
		
		
		
	}

}
