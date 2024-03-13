package lv04;

import java.util.Arrays;

public class Ex40 {

	public static void main(String[] args) {

		int test1[] = { 1, 2, 3, 2, 1 };
		int test2[] = { 1, 3, 4, 4, 2 };
		int test3[] = { 1, 1, 1, 2, 1 };

		// 위 배열에서 중복안된숫자를 제거하시오
		// 1) {1,2,2,1}
		// 밑 로직 순서

		int size = 0;
		// 1. test1 배열이 변화할 크기를 알아내야함
		for (int i = 0; i < test1.length; i++) {
			int cnt = 0;
			for (int j = 0; j < test1.length; j++) {
				// test1[i] 가 배열 전체에서 몇개?
				if (test1[i] == test1[j])
					cnt++;
			}

			if (cnt > 1)
				size++;
		}
		// 2. test1 배열이 새 주소 할당
		int[] temp = test1;
		test1 = new int[size];

		int idx = 0;
		// 3. 이사간 주소에 타겟 값들을 옮기기
		for (int i = 0; i < temp.length; i++) {
			int cnt = 0;
			for (int j = 0; j < temp.length; j++) {
				// test1[i] 가 배열 전체에서 몇개?
				if (temp[i] == temp[j])
					cnt++;
			}
			if (cnt > 1)
				test1[idx++] = temp[i];
		}
		System.out.println(Arrays.toString(test1));

		// 2) {4,4}
		size = 0;
		for (int i = 0; i < test2.length; i++) {
			int cnt = 0;
			for (int j = 0; j < test2.length; j++) {
				if (test2[i] == test2[j])
					cnt++;
			}
			if (cnt > 1)
				size++;
		}
		int[] temp1 = test2;
		test2 = new int[size];

		idx = 0;
		for (int i = 0; i < temp1.length; i++) {
			int cnt = 0;
			for (int j = 0; j < temp1.length; j++) {
				if (temp1[i] == temp1[j])
					cnt++;
			}
			if (cnt > 1)
				test2[idx++] = temp1[i];
		}
		System.out.println(Arrays.toString(test2));

		// 3) {1,1,1,1}

		size = 0;
		for (int i = 0; i < test3.length; i++) {
			int cnt = 0;
			for (int j = 0; j < test3.length; j++) {
				if (test3[i] == test3[j])
					cnt++;
			}
			if (cnt > 1)
				size++;
		}
		int[] temp2 = test3;
		test3 = new int[size];

		idx = 0;
		for (int i = 0; i < temp2.length; i++) {
			int cnt = 0;
			for (int j = 0; j < temp2.length; j++) {
				if (temp2[i] == temp2[j])
					cnt++;
			}
			if (cnt > 1)
				test3[idx++] = temp2[i];

		}
		System.out.println(Arrays.toString(test3));

	}

}
