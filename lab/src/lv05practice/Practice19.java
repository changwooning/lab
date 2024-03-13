package lv05practice;

import java.io.FileWriter;

public class Practice19 {

	public static void main(String[] args) {

		String[] names = {"김철수","이만수","이영희"};
		int[] ages = {20,30,40};
		
		String fileName = "fileTest01.txt";
		FileWriter fw = null;
		
		String data = "";
		
		for(int i=0; i<names.length; i++) {
			data += names[i] + "/" + ages[i];
			if(i < names.length-1)
				data += ",";
			
		}
		try {
			fw = new FileWriter(fileName);
			fw.write(data);
			fw.close();
			
			System.out.println("파일쓰기 완료");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("파일쓰기 실패");
		}
		
		
		
	}

}
