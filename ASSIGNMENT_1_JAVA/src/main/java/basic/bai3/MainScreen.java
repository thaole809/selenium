package basic.bai3;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MainScreen {

	public static Student inputInfo(Scanner scanner, Student student) {
		try {
			if (student.step == 0) {
				System.out.print("Input full name: ");
				student.setFullName(scanner.nextLine());
				student.step = 1;
			}
			if (student.step == 1) {
				System.out.print("Input address: ");
				student.setAddress(scanner.nextLine());
				student.step = 2;
			}
			if (student.step == 2) {
				System.out.print("Input date of birth (dd/mm/yyyy): ");
				String value = scanner.nextLine();
				
				if (!value.matches("\\d{1,2}/\\d{1,2}/\\d{2,4}")) {
					throw new Exception("DOB must be (dd/mm/yyyy)");
				}
				
				Date date = new Date(value);
				if (date.before(new Date(1, 1, 1900))) {
					throw new Exception("Date must be greater than 01/01/1900");
				}
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
				student.setDOB(sdf.format(date));
				student.step = 3;
			}
			if (student.step == 3) {
				System.out.print("Input gender (nam/nu): ");
				String value = scanner.nextLine();
				if (!"nam".equalsIgnoreCase(value) && !"nu".equalsIgnoreCase(value)) {
					throw new Exception("Gender must be 'nam' or 'nu'");
				}
				student.setGender(value);
				student.step = 4;
			}
			if (student.step == 4) {
				System.out.print("Input final grade: ");
				float value = Float.parseFloat(scanner.nextLine());
				if (value < 0 || value > 10) {
					throw new Exception("Grade must be in [0; 10]");
				}
				student.setFinalGrade(value);
				student.step = 5;
			}
		} catch (Exception ex) {
			System.out.println("-> Incorrect input: " + ex.getMessage());
		}
		return student;
	}

	public static void main(String[] args) {
		System.out.println("-------------------Input------------------");
		Scanner scanner = new Scanner(System.in);
		ArrayList<Student> students = new ArrayList<>();
		boolean isContinue = true;
		do {
			Student student = new Student();
			while (student.step < 5) {
				student = inputInfo(scanner, student);
			}
			students.add(student);

			System.out.println();
			System.out.print("Do you want to continue (Y/N): ");
			isContinue = scanner.nextLine().toUpperCase().contains("Y");
		} while (isContinue);

		System.out.println("-------------------Output------------------");
		float sumFinalGrade = 0;
		for (int i = 0; i < students.size(); i++) {
			System.out.println("Student " + (i + 1) + ": ");
			Student st = students.get(i);
			sumFinalGrade = sumFinalGrade + st.getFinalGrade();
			System.out.println(st.toString());

			if (st.getFinalGrade() < 4.0) {
				System.out.println(" => Học sinh " + st.getFullName().toUpperCase() + " học lực kém.");
			} else if (st.getFinalGrade() >= 4.0 && st.getFinalGrade() < 5.0) {
				System.out.println(" => Học sinh " + st.getFullName().toUpperCase() + " học lực yếu.");
			} else if (st.getFinalGrade() >= 5.0 && st.getFinalGrade() < 5.5) {
				System.out.println(" => Học sinh " + st.getFullName().toUpperCase() + " học lực trung bình yếu.");
			} else if (st.getFinalGrade() >= 5.5 && st.getFinalGrade() < 6.5) {
				System.out.println(" => Học sinh " + st.getFullName().toUpperCase() + " học lực trung bình.");
			} else if (st.getFinalGrade() >= 6.5 && st.getFinalGrade() < 7.0) {
				System.out.println(" => Học sinh " + st.getFullName().toUpperCase() + " học lực trung bình khá.");
			} else if (st.getFinalGrade() >= 7.0 && st.getFinalGrade() < 8.0) {
				System.out.println(" => Học sinh " + st.getFullName().toUpperCase() + " học lực khá.");
			} else if (st.getFinalGrade() >= 8.0 && st.getFinalGrade() < 8.5) {
				System.out.println(" => Học sinh " + st.getFullName().toUpperCase() + " học lực khá giỏi.");
			} else if (st.getFinalGrade() >= 8.5 && st.getFinalGrade() <= 10) {
				System.out.println(" => Học sinh " + st.getFullName().toUpperCase() + " học lực giỏi.");
			}
			System.out.println();
		}

		System.out.println("Điểm tổng kết trung bình của danh sách học sinh: " + (sumFinalGrade / students.size()));
	}
}
