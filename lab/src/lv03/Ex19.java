package lv03;

import java.util.Arrays;

public class Ex19 {
	
	//# 4의 배수만 저장
	// - arr배열에서 4의 배수만 골라 temp 배열에 저장
	// - 단! temp의 길이를 4의 배수 개수만큼만 설정한다.

	public static void main(String[] args) {
		
		int[] arr = {44,11,29,24,76};
		int[] temp = null; //값이 들어있지 않은 상태
		
		int cnt = 0;
		
		//for문을 돌린 목적 : 4의 배수의 개수를 구하는 반복문
		for(int i=0; i<5; i++) {
			if(arr[i] % 4 == 0) {
				cnt ++;
			}
		}
		// temp를 cnt개수만큼의 배열로 초기화
		temp = new int[cnt];
		// 목적 : 4의 배수를 -> temp 배열에 차곡차곡 차례로 담기
		// temp 배열용 "인덱스 변수" 선언 및 초기화
		int index = 0;
		for(int i=0; i<5; i++) {
			//4의 배수만 골라서 temp에 저장
			if(arr[i] % 4 == 0) {
				temp[index] = arr[i];
				index++;
			}
		}
		System.out.println(Arrays.toString(temp));
	}

}
