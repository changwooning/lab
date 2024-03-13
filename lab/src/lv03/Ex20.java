package lv03;

public class Ex20 {

	public static void main(String[] args) {
		
		int arr[] = {0,0,0,0,0,0,3,3,3};

		//문제1) 배열을 위와 같이 3줄씩 출력
		
		//풀이 1
		for(int i=0; i<9; i++) {
			System.out.print(arr[i]+ " ");
			if(i % 3 == 2)
				System.out.println();
		}
		boolean isBingo = false;
		
		for(int i=0; i<9; i+=3) {
			if(arr[i] == 3 && arr[i+1] == 3 && arr[i+2] == 3)
				isBingo = true;
		}
		
		
		//풀이 2
		int cnt = 0;
		for(int i=0; i<9; i++) {
			if(arr[i] == 3)
				cnt ++;
			if(cnt == 3) 
				isBingo = true;
			if(i % 3 == 2)
				cnt = 0;
		}
		
		//풀이 3
		//중첩 for문
		
		for(int i=0; i<9; i+=3) {
			cnt =0;
			for(int j=0; j<3; j++) {
				if(arr[i+j] == 3)
					cnt ++;
			}
			if(cnt == 3)
				isBingo = true;
		}
		
		
		
		
			
		//결과 출력
		if(isBingo) {
			System.out.println("빙고");
		}else
			System.out.println("빙고가 아니다.");

	}

}
