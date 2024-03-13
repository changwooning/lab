package lv03;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Ex31 {
	
	//#  1 to 4
	// 1. arr배열에 1~4 사이의 숫자를 중뵥없이 랜덤으로 저장한다.
	// 2. 사용자는 1부터 순서대로 해당 위치 값을 입력한다.
	// 3. 정답을 맞추면 해당 값은 9로 변경되어 모든 값이 9가 되면 게임은 종료된다.
	// 예)
	// 4 2 3 1
	// 입력 : 3
	// 4 2 3 9
	// 입력 : 1
	// 4 9 3 9
	//
	//입력한 숫자 값에 자리가 9로 변신
	

	public static void main(String[] args) {
		
		Random ran = new Random();
		Scanner scan = new Scanner(System.in);
		
		int SIZE = 4;
		
		int[] arr = new int[SIZE];      //{0,0,0,0}
		int[] check = new int[SIZE];	//{0,0,0,0}
		
		//1. arr 배열에 1~4사이 숫자 중복없이 랜덤한 위치에 저장
		for(int i=0; i<4; i++) {			// 0 1 2 3
			int rNum = ran.nextInt(4)+1;  // 1 2 3 4
			if(check[rNum-1] == 0) {
				arr[i] = rNum;
				check[rNum-1] = 1;
			}else {
				i --;
			}
		}
		System.out.print(Arrays.toString(arr));
		//2. 인덱스 입력받기 
		System.out.print("인덱스 : ");
		int index = scan.nextInt();
		
		//3. 인덱스 위치의 값이 순서에 맞는 값인지 확인
		for(int i=0; i<4; i++) {
			
		}
		
		//4. 인덱스 위치의 값이 맞으면 9 아니면 다시
		//5. 값이 다 9로 바뀌면 게임종료
		
		//arr배열에 인덱스의 값이 = rNum이고 rNum 값이 index 같으면 9
	}

}
