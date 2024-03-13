package lv05practice;
import java.io.FileWriter;
public class Practice20 {

	public static void main(String[] args) {
		
		String[] names = {"mom","megait","github"};
		String[] pws = {"1111","2222","3333"};
		int[] moneys = {20000,30000,40000};
		
		String fileName = "fileTest02.txt";
		FileWriter fw = null;
		
		String data = "";
		
		// mom/1111/20000
		// megait/2222/30000
		// github/3333/40000
		
		for(int i=0; i<names.length; i++) {
			data += names[i] + "/" + pws[i] + "/" + moneys[i];
			if(i < names.length-1)
				data += "\n";
		}
		
		try {
			fw = new FileWriter(fileName);
			fw.write(data);
			fw.close();
			System.out.println("파일저장 완료");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("파일저장 완료");
		}

	}

}
