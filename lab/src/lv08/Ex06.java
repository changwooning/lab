package lv08;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

class Tv2 {

	private String name;
	private String brand;
	private int price;
	
	private Integer list[];
	private int size;
	

	// 생성자
	public Tv2(String name, String brand, int price) {
		this.name = name;
		this.brand = brand;
		this.price = price;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return this.brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return this.price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public boolean add(Integer element) {
		Integer[] temp = list;
		list = new Integer[size + 1];
		
		for(int i=0; i<size; i++)
			list[i] = temp[i];
		
		list[size++] = element;
		
		return true;
	}
	
	public void add(Integer element, int idx) {
		Integer[] temp = list;
		list = new Integer[size + 1];
		
		for(int i=0; i<size; i++) {
			if(i<idx)
				list[i] = temp[i];
			else
				list[i+1] = temp[i];
		}
		list[idx] = element;
		size ++;
	}
	
	@Override
	public String toString() {
		return String.format("이름 : %s 브랜드 : %s 가격 : %d\n",name,brand,price);
	}

}

class SalesManager2 {

	Scanner scan = new Scanner(System.in);

	// 선언 및 초기화
	private Vector<Tv2> list = new Vector<>();
	
	private final int ADD = 1;
	private final int INSERTION = 2;
	private final int DELETE = 3;
	private final int DELETE_DATA = 4;
	private final int INQUIRY = 5;
	private final int MODIFY = 6;
	private final int SIZE = 7;
	
	
	private void size() {
		
		System.out.print(list.size());
	}
	
	private void modify() {
		
		// 수정할 인덱스 찾기 
		int idx = inputNumber("수정할 인덱스 : ");
		String name = inputString("name");
		String brand = inputString("brand");
		int price = inputNumber("price");
		
		Tv2 tv = new Tv2(name,brand,price);
		
		list.set(idx,tv);
		
	}
	
	private void inquiry() {
		
		list.size();
		
		
	}
	
	private void deleteData() {
		
		// 삭제할 값 입력받기
		
		String name = inputString("name");
		String brand = inputString("brand");
		int price = inputNumber("price");
		
		// 삭제할 값이 있는지 확인
		
		Tv2 tv = new Tv2(name,brand,price);
		list.remove(tv);
		
	}
	
	private void delete() {
		
		// 삭제할 인덱스 입력받기
		int idx = inputNumber("삭제할 인덱스");
		
		// 삭제할 인덱스가 있는지 확인
		
		list.remove(idx);
		
	}
	
	private void insertion() {
		
		// 삽입할 인덱스 입력받기
		int idx = inputNumber("삽입할 인덱스");
		
		// 이름 브랜드 가격 입력받기 ?
		String name = inputString("name");
		String brand = inputString("brand");
		int price = inputNumber("price");
		
		Tv2 tv = new Tv2(name,brand,price);
		list.add(idx, tv);
		
	}

	private void add() {
		// 이름
		// 브랜드
		// 가격
		// ㄴ 입력 받아야함
		String name = inputString("name");
		String brand = inputString("brand");
		int price = inputNumber("price");
		
		Tv2 tv = new Tv2(name,brand,price);
		list.add(tv);
	}
	

	private void runMenu(int sel) {
		if (sel == ADD)
			add();
		else if(sel == INSERTION) 
			insertion();
		else if(sel == DELETE) 
			delete();
		else if(sel == DELETE_DATA) 
			deleteData();
		else if(sel == INQUIRY)
			inquiry();
		else if(sel == MODIFY)
			modify();
		else if(sel == SIZE)
			size();
	}

	private String inputString(String message) {
		System.out.print(message + " ");
		return scan.next();
	}

	private int inputNumber(String message) {
		int number = -1;
		try {
			System.out.print(message + " : ");
			String input = scan.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("숫자를 입력하세요.");
		}
		return number;
	}

	private void printMenu() {
		System.out.println("1.추가");
		System.out.println("2.삽입");
		System.out.println("3.삭제");
		System.out.println("4.삭제(값)");
		System.out.println("5.조회");
		System.out.println("6.수정");
		System.out.println("7.크기");
	}

	private void printAll() {
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + " ");
		System.out.println();
	}

	public void run() {
		while (true) {
			// 전체 데이터 출력
			printAll();
			// 추가,삽입,삭제,삭제(값),조회,수정,크기
			printMenu();
			int sel = inputNumber("MENU");
			runMenu(sel);
		}
	}
}

public class Ex06 {

	public static void main(String[] args) {

		SalesManager2 system = new SalesManager2();
		system.run();

	}

}
