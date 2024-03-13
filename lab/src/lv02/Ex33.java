package lv02;

public class Ex33 {

	public static void main(String[] args) {

		//증감 연산
		int n = 1;
		n = n + 1;
		n += 1;    //복합연산자
		n ++;	   //단항 연산자 
		++ n;
		
		// n ++ 	: 후위 연산
		// ++ n		: 전위 연산
		
		int x= 10;
		int y = 20;
		int z = 0;
		
		//1.
		// x 10 y 20
		z = x ++ + y;  //  30
		
		// x11 y 20
		System.out.println(z);  //30
		
		//2.
		// x 11  y20
		 z = ++ x + y ++;
		 // x 12 y 21
		 System.out.println(z);  //32
		 
		//3.
		 // x 12  y21
		 z = x ++ + ++ y;
		 // x 13 y 22 
		 System.out.println(z); // 12 + 22   34
		 
		
		
		
		
		
	}

}
