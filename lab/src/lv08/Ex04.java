package lv08;

import java.util.ArrayList;
import java.util.Arrays;

// 나만의 ArrayList 구현

class MyArrayList {

	private int size;
	private Integer list[];

	public boolean add(Integer element) {
		Integer[] temp = list;
		list = new Integer[size + 1];

		for (int i = 0; i < size; i++)
			list[i] = temp[i];

		list[size++] = element;
		return true;
	}

	public void add(int idx, Integer element) {
		Integer[] temp = list;
		list = new Integer[size + 1];

		for (int i = 0; i < size; i++) {
			if (i < idx)
				list[i] = temp[i];
			else
				list[i + 1] = temp[i];
		}
		list[idx] = element;
		size++;
	}

	public Integer remove(int idx) {
		Integer element = null;
		element = list[idx];

		Integer[] temp = list;
		list = new Integer[size - 1];

		int n = 0;
		for (int i = 0; i < size; i++) {
			if (i != idx)
				list[n++] = temp[i];
		}
		size--;

		return element;
	}

	public boolean remove(Integer element) {

		int idx = -1;
		for (int i = 0; i < size; i++) {
			if (list[i].equals(element)) {
				idx = i;
				break;
			}
		}

		if(idx == -1)
			return false;
		
		remove(idx);
		
		return true;
	}
	 public boolean set(int idx, Integer element){
		 list[idx] = element;
		 return true;
	 }
	 public Integer get(int idx){
		 Integer element  = null;
		 element = list[idx];
		 return element;
	 }
	 public int size(){
		 return this.size;
	 }

	@Override
	public String toString() {
		return Arrays.toString(this.list);
	}

}

public class Ex04 {

	public static void main(String[] args) {

		ArrayList<Integer> arr = new ArrayList<>();
		
		MyArrayList list = new MyArrayList();
		list.add(1);	// 2111991224
		list.add(2);	// 292938459
		list.add(1);	// 2111991224
		list.add(1);	// 2111991224
		
		System.out.println(list);	// 1,2,1,1
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(System.identityHashCode(list.get(i)));
		}
		list.remove(0);
		System.out.println(list);	// 2,1,1
		
		list.remove(1);
		System.out.println(list);	// 2,1
		
		list.add(1,100);
		System.out.println(list);	// 2, 100, 1

	}

}
