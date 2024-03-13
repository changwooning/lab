package lv03practice;

import java.util.Scanner;

public class Practice64 {
	
	//회원가입
	//1000
	//1002

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] ids = new int[5];
		int[] pws = new int[5];
		
		int cnt = 0;
		
		while(true) {
			//출력
			for(int i=0; i<5; i++) {
				System.out.printf("%d %d/%d\n",i+1,ids[i],pws[i]);
			}
			
			System.out.println("1.가입");
			System.out.println("2.탈퇴");
			
			System.out.print("선택 : ");
			int sel = scan.nextInt();
			
			
			
		}
		
		

	}

}
