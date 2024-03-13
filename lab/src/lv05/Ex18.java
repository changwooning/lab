package lv05;

import java.io.FileWriter;
import java.io.IOException;

public class Ex18 {

	public static void main(String[] args) {
		
		// 김철수/20,이만수/30,이영희/40
		
		String[] names = {"김철수","이만수","이영희"};
		int[] ages = {20,30,40};
		
		String fileName = "fileTest01.txt";
		FileWriter fw = null;
		
		String data = "";
		
		for(int i=0; i<names.length; i++) {
			 data += names[i] + "/" + ages[i];
			 
			 if(i < names.length -1)
				 data += ",";
		}
		
		
		// 1. try catch 문 필요
		try {
			
			// 2. fileName 담을 변수 필요
			fw = new FileWriter(fileName);
			
			// 3. writer
			fw.write(data);
			
			// 4. 사용이 끝난 후 종료
			fw.close();
			System.out.println("저장완료");
			
		}catch(IOException e) {
			
			System.out.println("저장실패");
			
		}

	}

}
