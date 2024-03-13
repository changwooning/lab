package lv06practice;

// # 합 구하기
class MyClass2{
	
	int[] arr = {87,100,11,72,92};
}

public class Practice01 {

	public static void main(String[] args) {
		
		MyClass2 my = new MyClass2();
		
		int[] arr = my.arr;
		
		int sum = 0; 
		int fourthSum = 0;
		int cnt = 0;
		int fourthCnt = 0;
		
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
			
			if(arr[i] % 4 == 0) {
				fourthSum += arr[i];
				fourthCnt ++;
			}
			
			if(arr[i] % 2 == 0)
				cnt ++;
			
		}

	}

}
