package lv06;

//클래스가 가질 수 있는 두 가지 요소
	// 1) 속성	(멤버 변수, 필드 값)
	// 2) 기능	(메소드)
	// ㄴ Method : Class 안에 정의된 함수 Function
	// ㄴ 4가지 유형의 메소드
	//   a) return X , parameter X
	//   b)	return X , parameter O
	//   c) return O , parameter O
	//   d) return O , parameter X
	
	// * 메소드 정의
	// ㄴ 리턴타입 메소드명(파라미터타입1 파라미터2 ,파라미터타입1 파라미터2,파라미터타입1 파라미터2,...) {}
	

class Sample{
	void func1() {
		System.out.println("Hello My Function");
//		return
	}
	
	void func2(int number) {
		System.out.println("number : " + number);
//		return;
	}
	
	int func3(int number) {
		// 리턴할 값을 돌려주고 소멸함
		return number;
	}
	
	int func4() {
		return 100;
	}
	
	
}

public class Ex08 {

	public static void main(String[] args) {
		
		Sample sample = new Sample();
		sample.func1();
	}

}
