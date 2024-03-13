package lv07;
import java.util.Arrays;
class Test{
	private int code;
	private int size;
	
	// Wrapper Class
	// ㄴ 일반 자료형을 감싸고 있는 클래스
	// ㄴ int -> Integer
	// ㄴ char -> Character
	// ㄴ boolean -> Boolean
	// ㄴ double -> Doudle
	// ㄴ float -> Float
	
	
//	private char[] data;
	private Character[] data;
	
	public Test(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
	public int getSize() {
		return this.size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Character[] getData() {
		return this.data.clone();
	}
	public void setData(Character[] data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return String.format("code(%d) size(%d) data%s",code,size,Arrays.toString(data));
	}
	
}
public class Ex14 {

	public static void main(String[] args) {
		
		String data = "6\n";		// test 객체의 생성되어야 할 개수 
		data += "1/2/a/b\n";
		data += "2/3/a/b/c\n";
		data += "3/5/a/b/c/d/e\n";
		data += "4/4/a/b/c/d\n";
		data += "5/3/a/b/c\n";
		data += "6/1/a\n";
		
		System.out.println(data);
		
		String[] info = data.split("\n");
		int size = Integer.parseInt(info[0]);	// test 객체의 생성되어야 할 개수
		
		Test[] test = new Test[size];
		
		for(int i=0; i<size; i++) {
			String[] temp = info[i+1].split("/");
			
			// code
			int code = Integer.parseInt(temp[0]);
			test[i] = new Test(code);
			
			// size
			int dataSize = Integer.parseInt(temp[1]);
			test[i].setSize(dataSize);
			
			// data
//			char[] testData = new char[dataSize];
			Character[] testData = new Character[dataSize];
			for(int j=0; j<dataSize; j++) {
				
//				testData[j] = new Character(temp[2+j].charAt(0));
				testData[j] = temp[2+j].charAt(0);
			}
			test[i].setData(testData);
		}
		
		// data 의 정보를 클래스 배열에 저장
		for(int i=0; i<size; i++)
			System.out.println(test[i]);

	}

}
