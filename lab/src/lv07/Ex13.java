package lv07;

class Employee{
	
	// private fields
	private String name;
	private int point;
	// constructor
	public Employee(String name, int point) {
		this.name = name;
		this.point = point;
	}
	
	// method : getter & setter
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return this.point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	// method : other
	@Override
	public String toString() {
		return String.format("%s님의 실적은 %d점입니다.",name,point);
	}
	
}


public class Ex13 {

	public static void main(String[] args) {
		
		String data = "3\n";
		data += "김영희/30\n";
		data += "이만수/40\n";
		data += "이철민/60";
		
		// 임플로이 객체의 생성되어야 할 개수가 3이다. 첫번째줄
		
		
		System.out.println(data);
		
		// 문제1) data 에 있는 내용을 잘라서 group 에 저장 후 출력
		String[] info = data.split("\n");
		int size = Integer.parseInt(info[0]);
		
		Employee[] group;
		group = new Employee[size];	// {null,null,null}
		
		for(int i=0; i<size; i++) {
			String[] temp = info[i+1].split("/");
			String name = temp[0];
			int point = Integer.parseInt(temp[1]);
			group[i] = new Employee(name,point);
			System.out.println(group[i]);
		}
		
		// 문제2) 실적 꼴등 삭제 후 다시 data 에 저장
		
		//
		// 2
		// 이만수/40
		// 이철민/60
		//
		int min = group[0].getPoint();
		int idx = 0;
		
		for(int i=1; i<size; i++) {
			if(min > group[i].getPoint()) {
				min = group[i].getPoint();
				idx = i;
			}
		}
		Employee[] groupTemp = group;
		group = new Employee[size-1];
		int n = 0;
		for(int i=0; i<size; i++) {
			if(i != idx)
				group[n ++] = groupTemp[i];
		}
		size --;
		
		// 문자열 만들기
		data = size + "\n";
		for(int i=0; i<size; i++) {
			Employee employee = group[i];
			
			data += employee.getName() + "/" + employee.getPoint() + "\n";
		}
		data = data.substring(0,data.length()-1);
		
		System.out.println(data);
		

	}

}
