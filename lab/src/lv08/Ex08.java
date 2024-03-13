// 1. 학생
//	  ㄴ 등록
//	  ㄴ 제적	//퇴학
//	  ㄴ 조회
// 2. 과목
//	  ㄴ 등록
//	  ㄴ 신청(수강)
//	  ㄴ 철회(수강)
// 3. 정렬
//	  ㄴ 학번(오름차순)
//	  ㄴ 이름(오른차순)
//	  ㄴ 성적(내림차순)
// 4. 파일
//	  ㄴ 저장
//	  ㄴ 로드
package lv08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

class Subject2 {

	private String title;
	private int score;

	// 생성자
	public Subject2(String title, int score) {
		this.title = title;
		this.score = score;
	}

	// 게터 & 세터
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getScore() {
		return this.score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	// 오버라이드
	@Override
	public String toString() {
		return this.title;
	}

}

class Student2 {

	private String name;
	private int code;
	private ArrayList<Subject2> subjects;

	// 생성자
	public Student2(String name, int code) {
		this.name = name;
		this.code = code;
	}

	// 게터 & 세터
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return this.code;
	}
	public void setCode(int code) {
		this.code = code;
	}

	// 오버라이드
	@Override
	public String toString() {
		return String.format("이름 : %s 학번 : %d", name, code);
	}

}

class Manager2 {

	private ArrayList<Student2> group; // 선언
	private ArrayList<Subject2> subjects;
	private Scanner scan;

	private final int STUDENT = 1;
	private final int SUBJECT = 2;
	private final int SCORE = 3;
	private final int SORT = 3;
	private final int FILE = 4;

	private final int ENROLL_STUDENT = 1;
	private final int EXPULSION_STUDENT = 2;
	private final int SEARCH_STUDENT = 3;
	
	private final int ENROLL_SUBJECT = 1;
	private final int APPLY_SUBJECT = 2;
	private final int WITHDRAW_SUBJECT = 3;

	public Manager2() {
		this.group = new ArrayList<>(); // 초기화
		this.subjects = new ArrayList<>();
		this.scan = new Scanner(System.in);
	}
	
	private void applySubject() {
		
		Student2 student = searchStudentByData();
		printSubjectAll();
		
		int subjectIdx = inputNumber("과목 번호") - 1;
	}
	
	private Subject2 searchSubjectByData() {
		
	}
	
	private int createSubjectCode() {
		int code = 0;
		Random ran = new Random();
		while (true) {
			code = ran.nextInt(9000) + 1000;
			int idx = idxOfSubject(code);
			if (idx == -1)
				break;
		}
		return code;
	}
	
	private int idxOfSubject(String title) {
		int idx = -1;
		for(int i=0; i<subjects.size(); i++)
			if(subjects.get(i).getTitle().equals(title))
				idx = i;
		return idx;
	}
	
	private void enrollSubject() {
		String title = inputString("개설할 과목");
		int code = createStudentCode();
		
		Subject2 subject = new Subject2(title,code);
		subjects.add(subject);
		
		if(idxOfSubject(title) != -1) {
			System.err.println("동일 과목명이 이미 존재합니다.");
			return;
		}
		
	}
	
	private void printSubjectAll() {
		for(int i=0; i<subjects.size(); i++) {
			System.out.print(i+1 + " ");
			System.out.println(subjects.get(i));
		}
	}
	
	
	// 등록,신청,철회
	private void subjectRunSubMenu(int sel) {
		if(sel == ENROLL_SUBJECT)
			enrollSubject();
		else if(sel == APPLY_SUBJECT)
			applySubject();
//		else if(sel == WITHDRAW_SUBJECT)
//			withdrawSubject();
	}
	
	private void subjectSubMenu() {
		System.out.println("1)등록");
		System.out.println("2)신청");
		System.out.println("3)철회");
	}
	
	private void searchStudent() { // 조회
		
		Student2 student = searchStudentByData();
		if(student != null)
			System.out.println(student);
		
	}
	
	private Student2 searchStudentByData() {
		
		Student2 target = null;
		int code = createStudentCode();
		String name = inputString("이름");
		
		for(int i=0; i<group.size(); i++) {
			Student2 student = group.get(i);
			
			if(student.getName().equals(name) && student.getCode() == code)
				target = student;
		}
	
		return target;
	}
	
	private void expulsionStudent() {	//제적
		
		Student2 target = searchStudentByData();
		
		if(target != null)
			System.out.println(target);
		
	}

	private void enrollStudent() {	//등록
		int code = createStudentCode();
		String name = inputString("이름");

		Student2 student = new Student2(name, code);
		group.add(student);
	}

	private int idxOfStudent(int code) {
		int idx = -1;
		for (int i = 0; i < group.size(); i++) {
			Student2 student = group.get(i);
			if (student.getCode() == code)
				idx = i;
		}
		return idx;
	}

	private int createStudentCode() {

		int code = 0;
		Random ran = new Random();
		while (true) {
			code = ran.nextInt(9000) + 1000;
			int idx = idxOfStudent(code);
			if (idx == -1)
				break;
		}
		return code;

	}

	private void studentRunSubMenu(int sel) {
		if (sel == ENROLL_STUDENT)
			enrollStudent();
		else if(sel == EXPULSION_STUDENT)
			expulsionStudent();
		else if(sel == SEARCH_STUDENT)
			searchStudent();
	}

	private void studentSubMenu() {
		System.out.println("1)등록");
		System.out.println("2)제적");
		System.out.println("3)조회");
	}

	private void runMenu(int sel) {
		if (sel == STUDENT) {
			studentSubMenu();
			studentRunSubMenu(inputNumber("선택"));
		} else if (sel == SUBJECT) {
			subjectSubMenu();
			subjectRunSubMenu(inputNumber("선택"));
		}
//		else if(sel == SCORE)
//			score();
//		else if(sel == SORT)
//			sort();
//		else if(sel == FILE) {
//			save();
//			load();
//		}
	}

	private String inputString(String message) {
		System.out.print(message + " : ");
		return scan.next();
	}

	private int inputNumber(String message) {
		int number = -1;
		System.out.print(message + " : ");
		try {
			String input = scan.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("숫자를 입력하세요.");
		}
		return number;
	}

	private void printMenu() {
		System.out.println("1.학생");
		System.out.println("2.과목");
		System.out.println("3.성적");
		System.out.println("4.정렬");
		System.out.println("5.파일");
	}

	private void printAll() {
		for (int i = 0; i < group.size(); i++)
			System.out.println(group.get(i) + " ");
	}

	private boolean isRun() {
		return true;
	}

	public void run() {
		while (isRun()) {
			printAll();
			printMenu();
			int sel = inputNumber("MENU");
			runMenu(sel);
		}

	}

}

public class Ex08 {

	public static void main(String[] args) {

		Manager2 system = new Manager2();
		system.run();

	}

}
