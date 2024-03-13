package lv04;

import java.util.Arrays;

public class Ex26 {
	// 가장 많은 갯수 출력 : 1 ===> 2
	// 가장 많은 갯수 출력 : 2 ===> 2
	// 가장 많은 갯수 출력 : 3 ===> 2
	// 가장 많은 갯수 출력 : 4 ===> 2
	// 가장 많은 갯수 출력 : 5 ===> 2

	public static void main(String[] args) {

		// 벡터컨트롤러 이용하기
		int[] a = { 5, 1, 2, 2, 3, 3, 4, 4, 5, 1 };

		// 1.가장 많은 숫자의 개수
		// 2.가장 적은 숫자의 개수

		int maxCnt = 0;
		int minCnt = a.length + 1;

		for (int i = 0; i < a.length; i++) {
			// a[i] -> 몇개
			int cnt = 0;
			for (int j = 0; j < a.length; j++) {
				if (a[i] == a[j])
					cnt++;
			}

			if (cnt > maxCnt)
				maxCnt = cnt;
			if (cnt < minCnt)
				minCnt = cnt;
		}

		int[] maxNums = null;
		int maxCount = 0; //

		int[] minNums = null;
		int minCount = 0;

		// 3.가장 많은 숫자의 개수와 같으면 => 별도로 해당 숫자를 여러개(몇개인지모름) 기억 (변수 -> 배열)
		// 4.가장 적은 숫자의 개수와 같으면 => 별도로 해당 숫자를 여러개(몇개인지모름) 기억 (변수 -> 배열)

		for (int i = 0; i < a.length; i++) {
			int cnt = 0;
			for (int j = 0; j < a.length; j++) {
				if (a[i] == a[j])
					cnt++;
			}

			if (cnt == maxCnt) {
				// maxNums 배열에 a[i] 숫자가 이미 존재하는지 ?
				boolean isDupl = false;
				for (int j = 0; j < maxCount; j++) {
					if (a[i] == maxNums[j])
						isDupl = true;
				}
				if (!isDupl) {
					// a[i]을 maxNums 배열에 넣기
					
					int[] temp = maxNums;
					
					maxNums = new int[maxCount + 1];

					for (int j = 0; j < maxCount; j++)
						maxNums[j] = temp[j];
					
					maxNums[maxCount++] = a[i]; // 

				}
			}

			if (cnt == minCnt) {
				boolean isDupl = false;
				for (int j = 0; j < minCount; j++) {
					if (a[i] == minNums[j])
						isDupl = true;
				}

				if (!isDupl) {
					int[] temp = minNums;

					minNums = new int[minCount + 1];

					for (int j = 0; j < minCount; j++)
						minNums[j] = temp[j];

					minNums[minCount++] = a[i];
				}
			}
		}
		// 5. 결과배열 A,B를 출력
		System.out.println("maxNums : " + Arrays.toString(maxNums));
		System.out.println("minNums : " + Arrays.toString(minNums));

		for (int i = 0; i < maxCount; i++)
			System.out.printf("가장많은 갯수 출력 : %d ==> %d개", maxNums[i],maxCnt);

		for (int i = 0; i < minCount; i++)
			System.out.printf("가장 적은 갯수 출력 : %d ==> %d개", minNums[i],minCnt);

	}

}
