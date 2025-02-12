import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Student> students = loadStudents();
		sortStudentsByName(students);
		
		for (Student s:students) {
			System.out.println(s);
		}
		System.out.println("=========================");
		
		
		/*System.out.println("Sort by name");
		for (Student s:students) {
			System.out.println(s);
		}
		System.out.println("=========================");*/
		
		/*sortStudentById(students);
		System.out.println("Sort by id");
		for (Student s:students) {
			System.out.println(s);
		}
		
		System.out.println("========================");
		
		sortStudentByBirthday(students)
		System.out.println("Sort by birthday");
		for (Student s:students) {
			System.out.println(s);
		}*/

	}

	private static ArrayList<Student> loadStudents() {
		// TODO Auto-generated method stub
		ArrayList<Student> students = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		String line = sc.nextLine();
		while (!line.equals("EOF")) {
			Student stud= Student.loadStudent(line);
			students.add(stud);
			line = sc.nextLine();
		}
		return students;
	}

	private static void sortStudentsByName(ArrayList<Student> students) {
		
		
	}

}


class Student {
	String name;
	int id;
	int age;
	char gender; // ‘M’ for male, 'F' for female.
	int grade;
	BirthDate birthdate;
	
	
	public static Student loadStudent(String line) {
		Student stud = new Student();
		String[] fields = line.split(",");
		stud.name = fields[0].trim();
		stud.id = Integer.parseInt(fields[1].trim());
		stud.age = Integer.parseInt(fields[2].trim());
		stud.gender = fields[3].trim().charAt(0);
		stud.grade = Integer.parseInt(fields[4].trim());
		stud.birthdate = new BirthDate();
		stud.birthdate.year = Integer.parseInt(fields[5].trim());
		stud.birthdate.month = Integer.parseInt(fields[6].trim());
		stud.birthdate.date = Integer.parseInt(fields[7].trim());
		
		return stud;
	}


	@Override
	public String toString() {
		return this.name+", "+this.id+", "+this.age+", "+this.gender+", "+this.grade+", "+this.birthdate;
	}
	
	
	
	
}

class BirthDate {
	int year;
	int month;
	int date;
	
	
	@Override
	public String toString() {
		return this.year+", "+this.month+", "+this.date;
	}
	
	
}
