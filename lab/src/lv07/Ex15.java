package lv07;

// Wrapper class 포함하여 정의하기

class Member{
	
	int number,performance;
	String name;
	
	public Member(int number,int performance,String name) {
		this.number = number;
		this.performance = performance;
		this.name = name;
	}
	
	public int getNumber() {
		return this.number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getPerformance() {
		return this.performance;
	}
	public void setPerformance(int performance) {
		this.performance = performance;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
public class Ex15 {

	public static void main(String[] args) {

		
		String data1 = "1001/3,1002/1,1001/3,1003/5,1004/1,1002/2";
		String data2 = "1001/손창우,1002/김경현,1003/김민기,1004/김선영";
		
		// data1 은 사원번호와 판매실적이다.
		// data2 는 사원번호와 이름이다.
		
		// 판매실적이 4이상인 사원은 우수 사원으로 분류된다.
		
		// 위 데이터를 파싱 해서 Member 클래스 배열을 완성 후
		// 실적 내림차순으로 정렬하여 출력해보세요. (우수 사원은 BEST 붙여주기)
		
		Member[] memberList = null;
		
		String[] temp = data1.split(",");	// {"1001/3","1002/1","1001/3","1003/5","1004/1","1002/2"}
		String[] info = data2.split(",");	// {"1001/손창우","1002/김경현","1003/김민기","1004/김선영"}
		
		String data = "";
		
		for(int i=0; i<temp.length; i++) {
			String[] temp2 = temp[i].split("/");
			String[] info2 = info[i].split("/");
			
		}
		
		
		
		
		
	}

}
