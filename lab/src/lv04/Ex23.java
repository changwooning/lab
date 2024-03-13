package lv04;

import java.util.Scanner;

public class Ex23 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int[][] apt = { 
				{ 101, 102, 103 }, // 0 1 2
				{ 201, 202, 203 }, // 3 4 5
				{ 301, 302, 303 } // 6 7 8
		};
		int[][] pay = { 
				{ 1000, 2100, 1300 }, 
				{ 4100, 2000, 1000 }, 
				{ 3000, 1600, 800 } 
		};
		
		
		
		//1번
		for(int i=0; i<pay.length; i++) {
			int sum = 0;
			for(int j=0; j<pay[i].length; j++) {
				sum += pay[i][j];
			}
			System.out.printf("%d층 관리비 : 총 %d원\n", i+1,sum);
		}
		
		
		//2번
		System.out.print("호수 입력 :");
		int ho = scan.nextInt();
		
		int idx1 = -1;
		int idx2 = -1;
		
		for(int i=0; i<apt.length; i++) {
			for(int j=0; j<apt[i].length; j++) {
				if(apt[i][j] == ho) {
					idx1 = i;
					idx2 = j;
				}
			}
		}
		if(idx1 != -1) {
			System.out.println(pay[idx1][idx2]);
		}else
			System.out.println("존재하지 않는 호수입니다.");
		
		
		//3번
		// 밑에 중요
		int max = pay[0][1];
		idx1 = 0;
		idx2 = 1;
		int min = pay[2][2];	
		int idx3 = 2;
		int idx4 = 2;
		
		for(int i=0; i<pay.length; i++) {
			for(int j=0; j<pay[i].length; j++) {
				if(pay[i][j] > max) {
					max = pay[i][j];
					idx1 = i;
					idx2 = j;
				}
				if(pay[i][j] < min) {
					idx3 = i;
					idx4 = j;
				}
			}
		}
		System.out.printf("가장 많이 나온 집(%d), 가장 적게 나온 집(%d)",apt[idx1][idx2],apt[idx3][idx4]);
		
		//4번
		
		System.out.print("호수1 : ");
		ho = scan.nextInt();
		System.out.print("호수2 : ");
		int ho2 = scan.nextInt();
		
		idx1 = -1;
		idx2 = -1;
		idx3 = -1;
		idx4 = -1;
		
		for(int i=0; i<apt.length; i++) {
			for(int j=0; j<apt[i].length; j++) {
				if(apt[i][j] == ho) {
					idx1 = i;
					idx2 = j;
					
				}if(apt[i][j]== ho2) {
					idx3 = i;
					idx4 = j;
				}
			}
		}
		if(idx1 != -1 && idx3 != -1) {
			int temp = pay[idx1][idx2];
			pay[idx1][idx2] = pay[idx3][idx4];
			pay[idx3][idx4] = temp;
		}else {
			
		}
		
		
		
		
		
		
	}

}
