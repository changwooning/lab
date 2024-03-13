package lv06;

// # 나만의 계산기

class MyCalculator {
	
	int[] nums = {10,20};
	
	// + (return o parameter o)
	int sum(int a,int b) {
		return a+b;
	}
	// - (return o parameter x)
	int minus() {
		return nums[0]-nums[1];
	}
	// * (return x parameter x)
	void multiple() {
		System.out.println(nums[0]*nums[1]);
		// return;
	}
	// / (return x parameter o)
	void divide(int a,int b) {
		System.out.println((double) a/b);
	}
	
	
	
}
public class Ex09 {

	public static void main(String[] args) {
		
		MyCalculator calculator = new MyCalculator();
		
		// 메소드 호출
		int result = calculator.sum(1, 2);
		System.out.println(result);
	
		result = calculator.minus();
		System.out.println(result);
		
		calculator.multiple();
		
		calculator.divide(10,3);
		
		
	}

}
