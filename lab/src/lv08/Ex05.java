package lv08;
import java.util.Vector;
import java.util.Scanner;
// Vector 를 활용한 컨트롤러 구현
class Tv{
	
	private String name;
	private String brand;
	private int price;
	
	// 생성자
	public Tv(String name, String brand, int price) {
		this.name = name;
		this.brand = brand;
		this.price = price;
	}
	public String getName() {
		return this.name;
	}
	public String getBrand() {
		return this.brand;
	}
	public int getPrice() {
		return this.price;
	}
	
	@Override
	public String toString() {
		return String.format("%s [%s] %d",name,brand,price); 
	}
	
}
class SalesManager{
	
	private Scanner scan;
	// 선언 및 초기화
	private Vector<Tv>list;
	
	
	private final int ADD = 1;
	private final int INSERT = 2;
	private final int DELETE = 3;
	private final int DELETE_BY_VALUE = 4;
	private final int SEARCH = 5;
	private final int UPDATE = 6;
	private final int SIZE = 7;
	
	public SalesManager() {
		this.scan = new Scanner(System.in);
		this.list = new Vector<>();
	}
	
	private void printSize() {
		System.out.println("size : " + list.size());
	}
	
	private void update() {
		int idx = inputNumber("idx");
		Tv tv = createTv();
		
		if(idx < 0 || idx > list.size()-1)
			return;
					
		list.set(idx, tv);
	}
	
	private void search() {
		
		Tv tv = searchTvByData();
		
		if(tv != null)
			System.out.println(tv);
		
	}
	
	private Tv searchTvByData() {
		
		Tv target = null;
		
		String name = inputString("name");
		String brand = inputString("brand");
		int price = inputNumber("price");
		
		for(int i=0; i<list.size(); i++) {
			Tv tv = list.get(i);
			
			if(tv.getName().equals(name) && tv.getBrand().equals(brand) && tv.getPrice() == price)
				target = tv;
		}
		return target;
		
		
	}
	
	private void deleteByValue() {
		Tv target = searchTvByData();
		
		if(target != null)
			list.remove(target);
	}
	
	private void deleteByIdx() {
		int idx = inputNumber("idx");
		if(idx < 0 || idx > list.size()-1)
			return;
		
		list.remove(idx);
	}
	
	private void insert() {
		int idx = inputNumber("idx : ");
		Tv tv = createTv();
		
		if(idx < 0 || idx > list.size() - 1)
			return;
		
		list.add(idx, tv);
	}
	
	private void add() {
		Tv tv = createTv();
		list.add(tv);
	}
	
	private Tv createTv() {
		Tv tv = null;
		String name = inputString("name");
		String brand = inputString("brand");
		int price = inputNumber("price");
		
		tv = new Tv(name,brand,price);
		return tv;
	}
	
	private void runMenu(int sel) {
		if(sel == ADD)
			add();
		else if(sel == INSERT)
			insert();
		else if(sel == DELETE)
			deleteByIdx();
		else if(sel == DELETE_BY_VALUE)
			deleteByValue();
		else if(sel == SEARCH)
			search();
		else if(sel == UPDATE)
			update();
		else if(sel == SIZE)
			printSize();
	}
	
	
	private String inputString(String message) {
		System.out.print(message + " : ");
		return scan.next();
	}
	
	private int inputNumber(String message) {
		int number = 0;
		System.out.print(message + " : ");
		try {
			String input = scan.next();
			number = Integer.parseInt(input);
		}catch(Exception e) {
			System.out.println("숫자를 입력하세요.");
		}
		return number;
	}
	
	private void printDataAll() {
		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i));
	}
	
	public void run() {
		while (true) {
			// 전체 데이터 출력
			printDataAll();
			int sel = inputNumber("MENU");
			runMenu(sel);
			// 추가,삽입,삭제,삭제(값),조회,수정,크기
		}
	}
	
}
public class Ex05 {

	public static void main(String[] args) {
		
		SalesManager system = new SalesManager();
		system.run();

	}

}
