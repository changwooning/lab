package lv04practice;

import java.util.Arrays;

public class Practice71 {

	public static void main(String[] args) {
		
		int test1[] = {1,2,3,2,1};
		
		//위 배열에서 중복안된 숫자를 제거하시오
		
		int size = 0;
		//1. test1 배열이 변화할 크기를 알아내야함
		for(int i=0; i<test1.length; i++) {
			int cnt = 0;
			for(int j=0; j<test1.length; j++) {
				//test1[i]가 배열 전체에서 몇개 ?
				if(test1[i] == test1[j])
					cnt ++;
			}
			if(cnt > 1)
				size ++;
		}
		//2. test1 배열이 새주소 할당
		int[] temp = test1;
		test1 = new int[size];
		
		//3. 이사간 주소에 타겟 값들을 옮기기
		int idx = 0;
		for(int i=0; i<temp.length; i++) {
			int cnt = 0;
			for(int j=0; j<temp.length; j++) {
				if(temp[i] == temp[j])
					cnt ++;
			}
			if(cnt > 1)
				test1[idx++] = temp[i];
		}
		System.out.println(Arrays.toString(test1));

	}

}
