package lv04;

public class Ex14 {

	public static void main(String[] args) {
		
		int[] arr = {87,100,24,11,79};
		System.out.println("arr ; " + arr);	//[I@123a439b -> 주소임
		
		//arr변수 변수의 자료형 : 정수 배열(의 주소)
		// temp 변수의 자료형 : 정수 배열(의 주소)
	
		int[] temp = arr;	// arr주소공유
		
		System.out.println("temp : " +  temp);	//I@123a439b
		
		temp[1] = 0;
		
		for(int i=0; i<5; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		for(int i=0; i<5; i++) {
			System.out.print(temp[i] + " ");
		}
		System.out.println();

	}

}
