import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Student> students = loadStudents();
		
		
		for (Student s:students) {
			System.out.println(s);
		}
		System.out.println("=========================");
		
		sortStudentsByName(students);
		System.out.println("Sort by name");
		for (Student s:students) {
			System.out.println(s);
		}
		System.out.println("=========================");
		
		sortStudentById(students);
		System.out.println("Sort by id");
		for (Student s:students) {
			System.out.println(s);
		}
		
		System.out.println("========================");
		
		sortStudentByBirthday(students);
		System.out.println("Sort by birthday");
		for (Student s:students) {
			System.out.println(s);
		}

	}

	private static void sortStudentByBirthday(ArrayList<Student> students) {
		Collections.sort(students, (x,y)->{
			if (x.birthdate.year<y.birthdate.year) { // x is older than y
				return 1;
			} else if (x.birthdate.year>y.birthdate.year) { // x is younger than y;
				return -1;
			} else { // they were born on the same year. than we need to compare the month;
				if (x.birthdate.month<y.birthdate.month) { //x is older than y;
					return 1;
				} else if (x.birthdate.month>y.birthdate.month) { // x is younger than y;
					return -1;
				} else { // x and y were born in the same year same month.
					if (x.birthdate.date<y.birthdate.date) {
						return 1;
					} else if (x.birthdate.date>y.birthdate.date) {
						return -1;
					} else { // they were born on the same day.
						return 0;
					}
				}
			}
		});
		
	}

	private static void sortStudentById(ArrayList<Student> students) {
		// TODO Auto-generated method stub
		Collections.sort(students, (x,y)->{
			return y.id-x.id;
		});
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
		Collections.sort(students, (x,y)->{
			return x.name.compareTo(y.name); // compare 2 strings, directly use string.compareTo() method which 
			// is built in the String class.
		});
		
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
