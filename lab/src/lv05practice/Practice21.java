package lv05practice;

import java.io.BufferedReader;
import java.io.FileReader;

public class Practice21 {

	public static void main(String[] args) {
		
		// 파일 처리
		// ㄴ 2) 읽기 FileReader, BufferedReader
		
		FileReader fr = null;
		BufferedReader br = null;
		
		String fileName = "fileTest02.txt";
		
		
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			
			// 읽지 않은 새로운 문자열 한 줄만 읽음
			String data = br.readLine();
			System.out.println("data : " + data);
			
			br.close();
			fr.close();
			System.out.println("파일읽기 완료");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("파일읽기 실패");
		}
		

	}

}
