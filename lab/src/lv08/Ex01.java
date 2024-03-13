package lv08;
import java.util.Vector;

//class & member (field , method)

//lv 08. Collection & Map
//ㄴ 자료구조를 구현해주는 컬렉션 프레임워크
//ㄴ 자료구조 Data Structure : 데이터를 저장하는 방식

//Collection 
//ㄴ 1) List (선형 자료구조 , 순서가있음)
//		ㄴ Vector 
//		ㄴ ArrayList
//ㄴ 2) Set (비선형, 순서를 보장 X, 중복을 허용 X)

class MyData{
	
	private int data;
	public MyData(int data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return this.data + "";
	}
}

public class Ex01 {

	public static void main(String[] args) {
		
		// Vector 선언과 초기화
		
				// 선언
				// Vector<클래스명> 변수명
				Vector<MyData> list;

				// 초기화
				// =
//				list = new Vector<MyData>();
				list = new Vector<>();		// 생성자 호출 시 , 제네릭 타입 생략 가능 <> 안에 있는거 말하는거임
				
				System.out.println(list);
				
				// 1) 추가
				list.add(new MyData(10));
				System.out.println(list);
				
				// 2) 값 가져오기
				MyData data = list.get(0);
				System.out.println(data);
				
				list.add(new MyData(10));
				list.add(new MyData(30));
				list.add(new MyData(40));
				list.add(new MyData(50));
				
				// 3) 삭제
				list.remove(list.size()-1);
				System.out.println(list);
				
				// ㄴ 값(인스턴스) 삭제
				list.remove(data);
				System.out.println(list);
				
				// ㄴ 인덱스로 삭제
				list.remove(list.get(1));
				System.out.println(list);
				
				// 4) 수정
				list.set(0, new MyData(50));
				System.out.println(list);
				
				// 5) 삽입
				list.add(1, data);
				System.out.println(list);
				
				list.insertElementAt(data, 0);
				System.out.println(list);

	}

}
