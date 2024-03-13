package lv06;

class MyClas{
	int[] arr = {87,100,11,72,92};
}

public class Ex03 {

	public static void main(String[] args) {
		
		// 클래스로 객체를 생성(인스턴스)
		// ㄴ 생성된 
		MyClas my = new MyClas();
		
		// ㄴ 참조변수를 통해 배열의 인스턴스를 -> arr 변수에 담음
		int[] arr = my.arr;

		int sum = 0;
		int fourthSum =0;
		int cnt = 0;
		int fourthCnt = 0;
		
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
			
			if(arr[i] % 4 == 0) {
				fourthSum += arr[i];
				fourthCnt ++;
			}
			
			if( arr[i] % 2 == 0)
				cnt ++;
		}
		
		
		
	}

}
