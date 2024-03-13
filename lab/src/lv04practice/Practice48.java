package lv04practice;

import java.util.Arrays;
import java.util.Scanner;

public class Practice48 {
	
	//# 벡터 컨트롤러
	//1103

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
			
			System.out.print("선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				//추가
				
				//입력
				System.out.print("추가할 값 : ");
				int input = scan.nextInt();
				
				//구 주소 temp 전달
				int[] temp = score;
				
				//새 주소 초기화
				score = new int[count + 1];
				
				//구 주소 -> 새주소로 복사
				for(int i=0; i<count; i++)
					score[i] = temp[i];
				
				//값 넣기
				score[count] = input;
				count ++;
			}else if(sel == 2) {
				//삭제(인덱스)
				
				//입력
				System.out.print("삭제할 인덱스 : ");
				int delIdx = scan.nextInt();
				
				//예외처리 1.범위
				if(delIdx < 0 || delIdx > count -1)
					continue;
				
				//구 주소
				int[] temp = score;
				//새 주소 초기화
				score = new int[count-1];
				
				//복제
				int idx = 0;
				for(int i=0; i<count; i++) {
					if(i != delIdx) {
						score[idx] = temp[i];
						idx ++;
					}
				}
				count --;
			}else if(sel == 3) {
				//삭제 (값)
				
				//입력
				System.out.print("삭제할 값 : ");
				int delData = scan.nextInt();
				
				//삭제할 값 개수 확인
				int delCnt = 0;
				for(int i=0; i<count; i++) {
					if(score[i] == delData)
						delCnt ++;
				}
				
				//
				int[] temp = score;
				score = new int[count-delCnt];
				
				int idx = 0;
				for(int i=0; i<count; i++) {
					if(temp[i] != delData) {
						score[idx] = temp[i];
						idx ++;
					}
				}
				count -= delCnt;
			}else if(sel == 4) {
				//삽입
				
				//입력
				System.out.print("삽입할 인덱스 : ");
				int index = scan.nextInt();
				System.out.print("삽입할 값 : ");
				int data = scan.nextInt();
				
				//예외처리
				if(index < 0 || index > count -1)
					continue;
				
				int[] temp = score;
				score = new int[count + 1];
				
				for(int i=0; i<count; i++) {
					if(i < index)
						score[i] = temp[i];
					else
						score[i+1] = temp[i];
				}
				score[index] = data;
				count ++;
			}else if(sel == 0)
				break;
			
			
			
			
			
		}
		
	}

}
