package prelab;

import java.util.ArrayList;

public class EntireDataset {
	ArrayList<Student> studentList = new ArrayList<Student>();
	
	public EntireDataset(ArrayList<String[]> in) {
		for (String[] student : in) {
			Student s = new Student(student);
			studentList.add(s);
		}
	}
	
	@Override
	public String toString() { 
		StringBuilder s = new StringBuilder();
		for (Student student : studentList) {
			s.append(student.toString() + "\n");
		}
		return s.toString();
	} 
}
