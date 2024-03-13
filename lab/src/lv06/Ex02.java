package lv06;

class MyClass {
	
	int[] arr = {87,100,11,72,92};
	
	
}

public class Ex02 {

	public static void main(String[] args) {
		
		// 클래스로 객체를 생성 (Instance)
		MyClass my = new MyClass();
		MyClass chang = new MyClass();

		// 문제 1) 전체 합 출력
		// 정답 1) 362
		int sum = 0;
		for(int i=0; i<my.arr.length; i++) {
			sum += my.arr[i];
		}
		System.out.println(sum);
		
		sum = 0;
		for(int i=0; i<chang.arr.length; i++)
			sum += chang.arr[i];
		System.out.println(sum);

		// 문제 2) 4의 배수의 합 출력
		// 정답 2) 264
		
		sum = 0;
		int cnt = 0;
		for(int i=0; i<my.arr.length; i++) {
			if(my.arr[i] % 4 == 0) {
				sum += my.arr[i];
				cnt ++;
			}
		}
		System.out.println(sum);
		// 문제 3) 4의 배수의 개수 출력
		// 정답 3) 3
		System.out.println(cnt);
		
		// 문제 4) 짝수의 개수 출력
		// 정답 4) 3
		cnt = 0;
		for(int i=0; i<my.arr.length; i++) {
			if(my.arr[i] % 2 == 0)
				cnt ++;
		}
		System.out.println(cnt);

	}

}
