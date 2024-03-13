package lv05practice;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class Practice23 {

	public static void main(String[] args) {
		
		String[] ids = null;
		String[] pws = null;
		int[] moneys = null;
		
		String fileName = "fileTest02.txt";
		
		File file = new File(fileName);
		FileReader fr = null;
		BufferedReader br = null;
		
		String data = "";
		
		if(file.exists()) {
			
			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				
				while(br.ready()) 
					data += br.readLine() + "\n";
				
				br.close();
				fr.close();
				
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			String[] temp = data.split("\n");
			
			int cnt = temp.length;
			
			ids = new String[cnt];
			pws = new String[cnt];
			moneys = new int[cnt];
			
			for(int i=0; i<cnt; i++) {
				String[] info = temp[i].split("/");
				
				ids[i] += info[0];
				pws[i] += info[1];
				moneys[i] += Integer.parseInt(info[2]);		
			}
			
		}else
			System.out.println("파일이 존재하지 않습니다.");

	}

}
