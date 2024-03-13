package lv06;

	// 자바 : 프로그래밍 언어 중 -> "객체" 지향 언어( <-> 절차 지향 언어)

	// 객체 Object => 객체를 만들 수 있는 설계가 필요함
	// ㄴ 현실 세계에서 존재하는 추상적, 구체적 존재를 
	// ㄴ 프로그래밍 세계에서 처리할 수 있는 데이터의 단위로 만든 것

	// * 공기, 사람, 책상 모니터, 커피, 텀블러, 스마트폰
	// * 강의, 과목,

	// 클래스
	// ㄴ 객체를 정의하는 설계도 (사용자 정의 자료형) (내가 만든 자료형)
	// ㄴ 클래스와 !- 객체
	
	// 클래스 정의
	// ㄴ 클래스명 : 대문자로 시작하는 카멜 표기법으로 작성
	// class 클래스명 {}

	// 인스턴스 Instance (= 생성된 객체)
	// ㄴ 클래스를 통해 객체가 구현된 코드의 상태

class Person{	// 클래스와 객체 다르다
	
	// 클래스가 가질 수 있는 두 가지 요소
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
	
	
	
	// * 키, 의상, 혈액형, 몸무게, 성별, 나이, 이름, 생일 ...
	String name;
	int age;
	int gender;
	int birth;
	int height;
	int weight;
	char blood;
	
	
}

public class Ex01 {

	public static void main(String[] args) {
		
		// 클래스를 활용하여 -> 객체를 생성
		// new 클래스명();
		
		// 참조 변수 (주소를 가지고있는 것)
		Person gildong = new Person();		// 다시 참조하기 위해 변수에 담아둬야함
		System.out.println(gildong);		// lv06.Person@7de26db8
		
		Person chang = new Person();
		System.out.println(chang);			// lv06.Person@1175e2db
	
		// 생성된 객체로부터 -> 멤버를 얻어올 수 있는데
		// 참조변수 뒤에 닷(.) 을 붙여서 가져옴
		
		gildong.name = "홍길동";
		gildong.birth = 970719;
		gildong.blood = 'A';
		gildong.gender = 1;
		gildong.age = 28;
		gildong.height = 178;
		gildong.weight = 80;
		
		System.out.println(gildong.age);
		System.out.println(gildong.birth);
		System.out.println(gildong.blood);
		System.out.println(gildong.gender);
		System.out.println(gildong.height);
		System.out.println(gildong.name);
		System.out.println(gildong.weight);
		
		
		
		
		
		
		
	}

}
