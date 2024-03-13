package lv03;

public class Ex10 {

	public static void main(String[] args) {

		
		//변수 : 값을 한개 저장하는 곳
		//배열 Array : 값을 여러개 저장하는 곳
		
		//배열을 선언과 초기화
		// 자료형키워드[] 변수명 = new 자료형키워드[개수];
		
		//int[] arr = new int[3];
		//int[] arr = new int[] {1,2,3};
		int[] arr = {1,2,3};
		
		//사용방법
		//인덱스 index (방의 번호, 0부터 시작)
		//배열변수명[인덱스]
		
		//배열의 전체값 초기화
		//1~3까지로 초기화
		for(int i=0; i<3; i++) {
			arr[i] = i + 1;
			System.out.print(arr[i]);
		}
		// 1.while문 => 무한루프 true or false; 사용할때
		// 2.for문 => 반복구간이 확실할때 주로 사용
		
		
	}

}
