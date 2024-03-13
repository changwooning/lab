package lv03practice;

public class Practice71 {
	
	/*
	 * # 4의 배수만 저장
	 * - arr 배열에서 4의 배수만 골라 temp 배열에 저장
	 * - 단! temp 의 길이를 4의 배수 개수만큼만 설정한다. 
	 */

	public static void main(String[] args) {
		
		int[] arr = {44, 11, 29, 24, 76};
		int[] temp = null;
		
		int cnt = 0;
		for(int i=0; i<5; i++) {
			if(arr[i] % 4 == 0)
				cnt ++;
		}
		temp = new int[cnt];
		
		int j = 0;
		for(int i=0; i<5; i++) {
			if(arr[i] % 4 == 0) {
				temp[j] = arr[i];
				j++;
			}
		}
		
		for(int i=0; i<cnt; i++) {
			System.out.print(temp[i] + " ");
		}
		
		
		
		
		
	

	}

}
