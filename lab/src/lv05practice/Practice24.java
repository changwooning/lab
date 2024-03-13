package lv05practice;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Practice24 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] vector = null;
		int count = 0;
		
		String fileName = "vector.txt";
		File file = new File(fileName);
		
		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br = null;
		String data = "";
		
		while(true) {
			
			System.out.println("count : " + count);
			System.out.println(Arrays.toString(vector));
			
			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가하기");
			System.out.println("[2]삭제하기");
			System.out.println("[3]저장하기");
			System.out.println("[4]로드하기");
			System.out.println("[0]종료하기");
			
			System.out.print("선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				
				System.out.print("추가할 값 : ");
				int input = scan.nextInt();
				
				int[] temp = vector;
				vector = new int[count+1];
				
				for(int i=0; i<count; i++)
					vector[i] = temp[i];
				
				vector[count] = input;
				count++;
				
			}
			else if(sel == 2) {
				
				System.out.println("2-1) 삭제(인덱스)");
				System.out.println("2-2) 삭제(인덱스)");
				int subSel = scan.nextInt();
				
				if(subSel == 1) {
					System.out.print("삭제할 인덱스 : ");
					int delIdx = scan.nextInt();
					
					if(delIdx < 0 || delIdx > count -1)
						continue;
					
					int[] temp = vector;
					vector = new int[count-1];
					
					int idx = 0;
					for(int i=0; i<count; i++) {
						if(i != delIdx) {
							vector[idx] = temp[i];
							idx ++;
						}
					}
					count --;
				}else if(subSel == 2) {
					
					System.out.print("삭제할 값 : ");
					int delData = scan.nextInt();
					
					int delCnt = 0;
					for(int i=0; i<count; i++) {
						if(vector[i] == delData)
							delCnt++;
					}
					
					int[] temp = vector;
					vector = new int[count-delCnt];
					
					int idx = 0;
					for(int i=0; i<count; i++) {
						if(temp[i] != delData) {
							vector[idx] = temp[i];
							idx ++;
						}
					}
					count -= delCnt;
				}
			}
			else if(sel == 3) {
				
				data = "";
				
				for(int i=0; i<count; i++)
					data += vector[i] + "\n";
				data = data.substring(0,data.length()-1);
				
				try {
					
					fw = new FileWriter(file);
					fw.write(data);
					fw.close();
					System.out.println("파일저장완료");
					
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("파일저장실패");
				}
			}
			else if(sel == 4) {
				
				data = "";
				
				try {
					fr = new FileReader(file);
					br = new BufferedReader(fr);
					
					while(br.ready()) {
						data += br.readLine() + "/";
						count ++;
					}
					br.close();
					fr.close();
					System.out.println("파일로드완료");
					
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("파일로드실패");
				}
				
				vector = new int[count];
				String[] temp = data.split("/");
				for(int i=0; i<count; i++)
					vector[i] = Integer.parseInt(temp[i]);
				
				
			}
			else if(sel == 5) {}
			
			
			
			
		}
		
		
		
		
		
		
	}

}
