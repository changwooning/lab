package lv07;

import java.util.Scanner;
import java.util.Random;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

class Subject {
	private String title;
	private int score;

	public Subject(String title) {
		this.title = title;
	}

	public Subject(String title, int score) {
		this.title = title;
		this.score = score;
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

class Student {
	private int code;
	private String name;

	private int subjectCount;
	private Subject[] subjects; // 수강 신청한 과목들

	public Student(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return this.code;
	}

	public String getName() {
		return this.name;
	}

	public int getSubjectCount() {
		return this.subjectCount;
	}

	public Subject[] getSubjects() {
		return this.subjects != null ? this.subjects.clone() : null;
	}

	public Subject getSubjectByIdx(int idx) {
		Subject subject = null;
		try {
			subject = subjects[idx];
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subject;
	}

	public double getScoreAverage() {
		double average = 0;

		double total = 0;
		for (int i = 0; i < subjectCount; i++)
			total += subjects[i].getScore();

		if (total != 0)
			average = total / subjectCount;

		return average;
	}

	public void setSubject(Subject[] subjects) {
		this.subjects = subjects;
		this.subjectCount = subjects == null ? 0 : subjects.length;
	}

	public int idxOfSubject(String title) {
		int idx = -1;
		for (int i = 0; i < subjectCount; i++) {
			if (subjects[i].getTitle().equals(title))
				idx = i;
		}
		return idx;
	}

	@Override
	public String toString() {
		// 학생학번(이름)
		// ㄴ 과목명1 : 00점
		// ㄴ 과목명2 : 00점
		String info = String.format("%s (%d)\n", name, code);
		for (int i = 0; i < subjectCount; i++) {
			Subject subject = subjects[i];
			info += String.format("%s : %3d점\n", subject.getTitle(), subject.getScore());
		}
		return info;
	}

}

class Lms {

	// 1.추가
	// 1-1. 학생 (랜덤 4자리 학번 부여) [O]
	// 1-2. 과목 (수강 신청) [X]
	// 1-2-2. (과목 등록)
	// 1-3. 성적
	// 2.삭제
	// 2-1. 학생
	// 2-2. 과목 (수강 취소)
	// 3.정렬
	// 3-1. 학번순
	// 3-2. 이름순
	// 3-3. 성적순 (평균)
	// 4.출력
	// 4-1. 학생 + 성적
	// 5.저장
	// 6.로드

	Scanner scan = new Scanner(System.in);

	private FileWriter fileWriter;
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	private File file;
	private String fileName;

	private final int ADD = 1;
	private final int DELETE = 2;
	private final int SORT = 3;
	private final int PRINT = 4;
	private final int SAVE = 5;
	private final int LOAD = 6;

	private final int ADD_STUDENT = 1;
	private final int ADD_SUBJECT = 2;
	private final int ADD_SCORE = 3;

	private final int ADD_SUBJECT_ENROLL = 1;
	private final int ADD_SUBJECT_OPEN = 2;

	private final int DELETE_STUDENT = 1;
	private final int DELETE_SUBJECT = 2;

	private final int SORT_BY_CODE = 1;
	private final int SORT_BY_NAME = 2;
	private final int SORT_BY_SCORE = 3;

	private int studentCount;
	private Student[] students;

	private int subjectCount;
	private Subject[] subjects; // 수강 신청용 (뷰어)

	private boolean isRun;

	public Lms() {

		fileName = "Lms.txt";
		file = new File(fileName);

		isRun = true;
		setSubjects();
	}

	private void setSubjects() {
		subjectCount = 3;
		subjects = new Subject[subjectCount];

		subjects[0] = new Subject("수학");
		subjects[1] = new Subject("영어");
		subjects[2] = new Subject("국어");
	}

	private void setSubjects(String[] list) {

		int size = list == null ? 0 : list.length;

		if (size > 0) {
			subjects = new Subject[size];

			for (int i = 0; i < subjects.length; i++)
				subjects[i] = new Subject(list[i]);

			subjectCount = subjects.length;
		}

	}

	private void loadData() {
		// 수학/영어/국어/자바/데이터베이스...
		// 학번1/이름1/과목1/성적1/과목2/성적2
		// 학번2/이름2/과목1/성적1
		// 학번3/이름3/과목1/성적1/과목2

		if (file.exists()) {

			try {

				fileReader = new FileReader(file);
				bufferedReader = new BufferedReader(fileReader);

				String[] subjectList = bufferedReader.readLine().split("/");
				setSubjects(subjectList);

				loadDataStudents(fileReader, bufferedReader);

				fileReader.close();
				bufferedReader.close();

				System.out.println("파일로드 완료");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("파일로드 실패");
			}
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}
	}

	private void loadDataStudents(FileReader fileReader, BufferedReader bufferedReader) {

		try {
			while (bufferedReader.ready()) {
				String[] data = bufferedReader.readLine().split("/");

				int code = Integer.parseInt(data[0]);
				String name = data[1];

				Student student = new Student(code, name);

				// 수강신청 내역이 존재함
				if (data.length > 2) {
					int size = (data.length - 2) / 2;

					Subject[] subject = new Subject[size];

					int idx = 2;
					for (int i = 0; i < size; i++) {
						String title = data[idx++];
						int score = Integer.parseInt(data[idx++]);

						subjects[i] = new Subject(title, score);
					}
					student.setSubject(subject);
				}
				addStudent(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String createDataString() {

		String data = "";
		for (int i = 0; i < subjectCount; i++) {
			data += subjects[i].getTitle();

			if (i < subjectCount - 1)
				data += "/";
		}
		data += "\n";

		for (int i = 0; i < studentCount; i++) {
			Student student = students[i];

			data += student.getCode() + "/" + student.getName();

			if (student.getSubjectCount() > 0)
				data += "/";

			for (int j = 0; j < student.getSubjectCount(); j++) {
				Subject subject = student.getSubjectByIdx(i);

				data += subject.getTitle() + "/" + subject.getScore();

				if (j < student.getSubjectCount() - 1)
					data += "/";
			}

			if (i < studentCount - 1)
				data += "\n";
		}

		return data;

	}

	private void saveData() {
		// 수학/영어/국어/자바/데이터베이스...
		// 학번1/이름1/과목1/성적1/과목2/성적2
		// 학번2/이름2/과목1/성적1/과목2/성적2
		// 학번3/이름3/과목1/성적1/과목2

		String data = createDataString();

		try {
			fileWriter = new FileWriter(file);
			fileWriter.write(data);
			fileWriter.close();
			System.out.println("파일저장 완료");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("파일저장 실패");
		}

	}

	private void sortByScore() {
		for (int i = 0; i < studentCount; i++) {
			Student student = students[i];
			int idx = i;

			for (int j = i; j < studentCount; j++) {
				Student target = students[j];

				if (student.getScoreAverage() < target.getScoreAverage()) {
					student = target;
					idx = j;
				}
			}

			if (idx != i) {
				students[idx] = students[i];
				students[i] = student;
			}
		}
	}

	private void sortByName() {
		for (int i = 0; i < studentCount; i++) {
			Student student = students[i];
			int idx = i;

			for (int j = i; j < studentCount; j++) {
				Student target = students[j];

				if (student.getName().compareTo(target.getName()) > 0) {
					student = target;
					idx = j;
				}
			}

			if (idx != i) {
				students[idx] = students[i];
				students[i] = student;
			}
		}
	}

	private void sortByCode() {
		for (int i = 0; i < studentCount; i++) {
			Student student = students[i];
			int idx = i;

			for (int j = i; j < studentCount; j++) {
				Student target = students[j];

				if (student.getCode() > target.getCode()) {
					student = target;
					idx = j;
				}
			}

			if (idx != i) {
				students[idx] = students[i];
				students[i] = student;
			}
		}
	}

	private void runSortSubMenu(int select) {
		if (select == SORT_BY_CODE)
			sortByCode();
		else if (select == SORT_BY_NAME)
			sortByName();
		else if (select == SORT_BY_SCORE)
			sortByScore();
	}

	private void printSortSubMenu() {
		System.out.println("1) 학번순 (오름차순)");
		System.out.println("2) 이름순 (오름차순)");
		System.out.println("3) 성적순 (내림차순)");
	}

	private void deleteSubject() {
		Student student = searchStudent();
		if (student != null) {
			System.out.println(student);
			String title = inputString("과목명");

			int subjectIdx = student.idxOfSubject(title);
			if (subjectIdx == -1)
				System.err.println("수강신청한 과목이 아닙니다.");
			Subject[] temp = student.getSubjects();
			int size = student.getSubjectCount();
			Subject[] list = new Subject[size - 1];
			int idx = 0;
			for (int i = 0; i < size; i++) {
				if (i != subjectIdx)
					list[idx++] = temp[i];
			}
			student.setSubject(list);

			System.out.println("수강철회 완료");
		}
	}

	private void deleteStudent() {
		Student student = searchStudent();
		if (student != null) {
			Student[] temp = students;
			students = new Student[studentCount - 1];
			int idx = 0;
			for (int i = 0; i < studentCount; i++) {
				if (temp[i] != student)
					students[idx++] = temp[i];
			}
			studentCount--;
			System.out.println("학생 삭제 완료");
		}
	}

	private void runDeleteSubMenu(int select) {
		if (select == DELETE_STUDENT)
			deleteStudent();
		else if (select == DELETE_SUBJECT)
			deleteSubject();
	}

	private void printDeletSubMenu() {
		System.out.println("1) 학생");
		System.out.println("2) 과목");
	}

	private Student searchStudent() {
		Student student = null;
		int studentCode = inputNumber("학번");
		int idx = idxOfStudent(studentCode);

		if (idx != -1)
			student = students[idx];
		return student;
	}

	private void addScore() {

		Student student = searchStudent();
		// 학번을 입력받고

		if (student != null) {
			System.out.println(student);
			String title = inputString("과목명");

			int subjectIdx = student.idxOfSubject(title); // 각 학생이 들곧있는 서브젝스를 알수 있다.
			if (subjectIdx == -1) {
				System.out.println("수강신청한 과목이 아닙니다.");
				return;
			}
			Subject subject = student.getSubjectByIdx(subjectIdx);
			int score = inputNumber("성적");
			if (score < 0 || score > 100) {
				System.err.println("유효하지 않은 성적 범위입니다.");
				return;
			}
			subject.setScore(score);
			System.out.println("성적 입력 완료");
		}

	}

	private int idxOfSubject(String title) {
		int idx = -1;
		for (int i = 0; i < subjectCount; i++)
			if (subjects[i].getTitle().equals(title))
				idx = i;
		return idx;
	}

	private void openSubject() {
		String title = inputString("개설할 과목");
		if (idxOfSubject(title) != -1) {
			System.err.println("동일 과목명이 이미 존재합니다.");
			return;
		}
		Subject[] temp = subjects;
		subjects = new Subject[subjectCount + 1];

		for (int i = 0; i < subjectCount; i++)
			subjects[i] = temp[i];

		subjects[subjectCount++] = new Subject(title);
		System.out.println("과목 개설 완료");

	}

	private void printSubjectAll() {
		for (int i = 0; i < subjectCount; i++) {
			System.out.print(i + 1 + ") ");
			System.out.println(subjects[i]);
		}
	}

	private void enrollSubject() {

		Student student = searchStudent();

		printSubjectAll();
		int subjectIdx = inputNumber("과목 번호") - 1;
		if (subjectIdx < 0 || subjectIdx >= subjectCount) {
			System.err.println("유효하지 않은 번호입니다.");
			return;
		}
		Subject subject = subjects[subjectIdx];

		if (student.idxOfSubject(subject.getTitle()) != -1) {
			System.out.println("이미 신청한 과목입니다.");
			return;
		}

		enrollSubjectForStudent(student, subject.clone());
	}

	private void enrollSubjectForStudent(Student student, Subject subject) {
		Subject[] temp = student.getSubjects();
		int size = student.getSubjectCount();
		Subject[] list = new Subject[size + 1];
		for (int i = 0; i < size; i++)
			list[i] = temp[i];
		student.setSubject(list);
		System.out.println("수강신청 완료");
	}

	private int printAddSubjectOption() {
		int option = 0;
		System.out.println("1)수강신청");
		System.out.println("2)과목개설");
		option = inputNumber("option");
		return option;
	}

	private void addSubject() {
		// 1) 수강신청
		// 2) 과목개설
		int option = printAddSubjectOption();
		if (option == ADD_SUBJECT_ENROLL)
			enrollSubject();
		else if (option == ADD_SUBJECT_OPEN)
			openSubject();
	}

	private int idxOfStudent(int code) {
		int idx = -1;
		for (int i = 0; i < studentCount; i++) {
			Student student = students[i];
			if (student.getCode() == code)
				idx = i;
		}

		if (idx == -1) {
			System.out.println("존재하지 않는 학생입니다.");
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

	private void addStudent(Student student) {
		Student[] temp = students;
		students = new Student[studentCount + 1];

		for (int i = 0; i < studentCount; i++)
			students[i] = temp[i];

		students[studentCount++] = student;
	}

	private void addStudent() {
		// 고유한 식별자 학번을 부여 받고,
		// 사용자에게 이름을 받고 (동명이인 허용)
		// Student 객체를 생성
		int code = createStudentCode();
		String name = inputString("name");

		Student student = new Student(code, name);
		Student[] temp = students;
		students = new Student[studentCount + 1];

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
		else if (select == ADD_SCORE)
			addScore();
	}

	private void printAddMenu() {
		System.out.println("1) 학생");
		System.out.println("2) 과목");
		System.out.println("3) 성적");
	}

	private void runMenu(int select) {

		// 검수용

		if (select == ADD) {
			printAddMenu();
			runAddSubMenu(inputNumber(""));
		} else if (select == DELETE) {
			printDeletSubMenu();
			runDeleteSubMenu(inputNumber(""));
		} else if (select == SORT) {
			printSortSubMenu();
			runSortSubMenu(inputNumber(""));
		} else if (select == PRINT) {
			printStudentAll();
		} else if (select == SAVE) {
			saveData();
		} else if (select == LOAD) {
			loadData();
		}
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

public class Ex11 {

	public static void main(String[] args) {

		Lms system = new Lms();
		system.run();

	}

}
