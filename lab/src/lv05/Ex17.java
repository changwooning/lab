package lv05;

import java.io.FileWriter;
import java.io.IOException;

public class Ex17 {

	public static void main(String[] args) {
		
		// 파일 처리
		// ㄴ 1) 쓰기 : FileWriter
		
		String fileName = "test.txt";
		FileWriter fw = null;
		
		// 1. try-catch 구문 필요(IOException)
		try {
			
			// 2. new FileWriter("파일명.확장자")
			// fileName으로 FileWriter 객체를 생성 -> 변수 fw에 담음
			fw = new FileWriter(fileName);
			
			// 3. 파일쓰기 write(문자열 호출)
			fw.write("손창우");
			
			// 4. 사용이 끝난 후, 종료시킴. close() 
			fw.close();
			
			System.out.println("파일쓰기 완료");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("파일쓰기 실패");
		}
		

	}

}
