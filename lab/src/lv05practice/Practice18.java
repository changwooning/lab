package lv05practice;

import java.io.FileWriter;
public class Practice18 {

	public static void main(String[] args) {
		
		// 파일 처리 
		// ㄴ 1) 쓰기 : FileWriter
		
		String fileName = "test.txt";
		FileWriter fw = null;
		
		// try- catch 구문 필요
		try {
			fw = new FileWriter(fileName);
			fw.write("손창우");
			fw.close();
			System.out.println("파일쓰기 완료");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("파일쓰기 실패");
		}
		
		

	}

}
