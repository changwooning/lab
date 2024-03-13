package lv04practice;

import java.util.Arrays;
import java.util.Scanner;

public class Practice14 {
	
	// # 배열 컨트롤러[2단계] : 벡터(Vector)
		// 1. 추가
		// 값을 입력받아 순차적으로 추가
		// 2. 삭제(인덱스)
		// 인덱스를 입력받아 해당 위치의 값 삭제
		// 3. 삭제(값)
		// 값을 입력받아 삭제
		// 없는 값 입력 시 예외처리
		// 4. 삽입
		// 인덱스와 값을 입력받아 삽입

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] score = null;
		int count = 0;
		
		while(true) {
			
			System.out.println(Arrays.toString(score));

			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가");
			System.out.println("[2]삭제(인덱스)");
			System.out.println("[3]삭제(값)");
			System.out.println("[4]삽입");
			System.out.println("[0]종료");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				
				System.out.print("값 입력 : ");
				int input = scan.nextInt();
				
				int[] temp = score;
				
				score = new int[count +1];
				
				for(int i=0; i<count; i++) 
					score[i] = temp[i];
				
				score[count] = input;
				count++;
			}
			else if(sel == 2) {
				
				//입력
				System.out.print("삭제할 인덱스 : ");
				int delIdx = scan.nextInt();
				
				//예외처리 1. 범위
				
				if(delIdx < 0 || delIdx >= count)
					continue;
				
				int[] temp = score;
				
				score = new int[count - 1];
				
				int idx = 0;
				for(int i=0; i<count; i++) {
					if(i != delIdx) {
						score[idx] = temp[i];
						idx ++;
					}
				}
				count --;
				
			}else if(sel == 3) {
				
				
				
				
			}
			
			
			
			
		}
		
		
		

	}

}
