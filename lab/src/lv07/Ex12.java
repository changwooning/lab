// 1.추가
// 1-1. 학생 (랜덤 4자리 학번 부여) [O]
// 1-2. 과목 (수강 신청) 		  [X]
// 1-2-2. (과목 등록)			  [X]
// 1-3. 성적					  [X]
// 2.삭제						  [X]
// 2-1. 학생
// 2-2. 과목 (수강 취소)
// 3.정렬						  [X]
// 3-1. 학번순
// 3-2. 이름순
// 3-3. 성적순 (평균)
// 4.출력						  [X]
// 4-1. 학생 + 성적
// 5.저장						 [X]
// 6.로드						 [X]
package lv07;

import java.util.Scanner;
import java.util.Random;

class Subject2 {
	private String title;
	private int score;

	public Subject2(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Subject clone() {
		return new Subject(this.title);
	}

	@Override
	public String toString() {
		return this.title;
	}

}

class Student2 {
	private int code;
	private String name;

	private int subjectCnt;
	private Subject2[] subjects; // 수강 신청한 과목들

	public Student2(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return this.code;
	}

	public String getName() {
		return this.name;
	}

	public int getSubjectCnt() {
		return this.subjectCnt;
	}

	public Subject2[] getSubjects() {
		return this.subjects.clone();
	}

	public void setSubject(Subject2[] subjects) {
		this.subjects = subjects;
		this.subjectCnt = subjects == null ? 0 : subjects.length;
	}

	@Override
	public String toString() {
		// 학생학번(이름)
		// ㄴ 과목명1 : 00점
		// ㄴ 과목명2 : 00점
		String info = String.format("%s (%d\n)", code, name);

		for (int i = 0; i < subjectCnt; i++) {
			Subject2 subject = subjects[i];
			info += String.format("%s : %3d점\n", subjects[i].getTitle(), subjects[i].getScore());
		}

		return info;
	}

}

class Lms2 {

	Scanner scan = new Scanner(System.in);

	private final int ADD = 1;
	private final int DELETE = 2;
	private final int SORT = 3;
	private final int PRINT = 4;
	private final int SAVE = 5;
	private final int LOAD = 6;

	private final int ADD_STUDENT = 1;
	private final int ADD_SUBJECT = 2;
	private final int ADD_SCORE = 3;

	private int studentCount;
	private Student2[] students;

	private int subjectCount;
	private Subject2[] subjects; // 수강 신청용 (뷰어)

	private boolean isRun;

	public Lms2() {
		isRun = true;
		setSubjects();
	}

	private void setSubjects() {
		subjectCount = 3;
		subjects = new Subject2[subjectCount];

		subjects[0] = new Subject2("수학");
		subjects[1] = new Subject2("영어");
		subjects[2] = new Subject2("국어");
	}

	
	
	private void addSubject() {
		// 학생이 과목을 선택하면 학생 과목에 추가하는것임(Subject2배열에 저장)
		for (int i = 0; i < subjectCount; i++)
			System.out.printf("%d) %s\n", i + 1, subjects[i]);
		
		int code = createStudentCode();		
		String subject = inputString("subject");
		
		Subject2 subject2 = new Subject2(subject);
		Subject2[] temp = subjects;
		subjects = new Subject2[subjectCount + 1];
		
		for(int i=0; i<subjectCount; i++)
			subjects[i] = temp[i];
		
		subjects[subjectCount++] = subject2;
		System.out.printf("%s 저장완료\n", subject2.getTitle());
		
		
	}

	private int idxOfStudent(int code) {
		int idx = -1;
		for (int i = 0; i < studentCount; i++) {
			Student2 student = students[i];
			if (student.getCode() == code)
				idx = i;
		}
		return idx;
	}

	private void printStudentAll() {
		for (int i = 0; i < studentCount; i++)
			System.out.println(students[i]);
		
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

	private void addStudent() {
		// 고유한 식별자 학번을 부여 받고,
		// 사용자에게 이름을 받고 (동명이인 허용)
		// Student 객체를 생성

		int code = createStudentCode();
		String name = inputString("name");

		Student2 student = new Student2(code, name);
		Student2[] temp = students;
		students = new Student2[studentCount + 1];

		for (int i = 0; i < studentCount; i++)
			students[i] = temp[i];

		students[studentCount++] = student;
		System.out.printf("학생(%d) 등록 완료\n", student.getCode());
	}

	private void runAddSubMenu(int select) {
		if (select == ADD_STUDENT)
			addStudent();
		else if (select == ADD_SUBJECT)
			addSubject();
//		else if (select == ADD_SCORE)
//			addScore();
	}

	private void printAddMenu() {
		System.out.println("1) 학생");
		System.out.println("2) 과목");
		System.out.println("3) 성적");
	}

	private void runMenu(int select) {

		if (select == ADD) {
			printAddMenu();
			runAddSubMenu(inputNumber(""));
		}
//		else if(select == DELETE) {
//			printDeletSubMenu();
//			runDeletSubMenu(inputNumber(""));
//		}
//		else if(select == SORT) {
//			printSortSubMenu();
//			runSortSubMenu(inputNumber(""));
//		}
//		else if(select == PRINT) {
//			printStudentAll();
//		}
//		else if(select == SAVE) {
//			saveData();
//		}
//		else if(select == LOAD) {
//			loadData();
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
		System.out.println("1. 추가");
		System.out.println("2. 삭제");
		System.out.println("3. 정렬");
		System.out.println("4. 출력");
		System.out.println("5. 저장");
		System.out.println("6. 로드");
	}

	private boolean isRun() {
		return isRun;
	}

	public void run() {

		while (isRun()) {
			// 검수용
			printStudentAll();
			printMenu();
			int select = inputNumber("MENU");
			runMenu(select);
		}

	}

}

public class Ex12 {

	public static void main(String[] args) {

		Lms2 system = new Lms2();
		system.run();

	}

}
