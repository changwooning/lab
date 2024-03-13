package lv03;

public class Ex01 {
	
	//중요하다!!!!!!!
	

	public static void main(String[] args) {
															
		// 변수 : 값을 한 개 저장하는 곳!
		
		// 배열 Array : 값을 여러개 저장하는 곳!
		
		// 배열을 선언과 초기화
		// 자료형키워드[] 변수명 = new 자료형키워드[개수];
		
		int[] arr = new int[3];
	//	int[] arr = new int[] {1,2,3};
	//	int[] arr = {1,2,3};
		// 사용 방법
		// *인덱스 index (방의 번호, 0부터 시작!)
		// 배열변수명[인덱스]
		
		// 배열의 전체값 초기화
		// 1~3까지로 초기화
		for(int i=0; i<3; i++) {   // i : 0 1 2
			 arr[i] = i + 1;		// i : 1 2 3
			 
		}
		
		// 두번째 방에 있는 값을 출력
		//System.out.println(arr[1]);
		
		// 반복문을 활용하여 배열의 전체 값을 출력
		
		// 무한루프 true or false 느낌
		int index = 0;
		while(index < 3) {
			System.out.print(arr[index]);
			index ++;
		}
		
		
		//반복구간이 확실할때
		for(int i=0; i<3; i++) {
			System.out.print(arr[i]);
		}
		
	}

}
