package hw10;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class StudentsData implements StudentsDataSource{

  
    HashMap <String, LinkedList<Student>> studentsInClasses;
    public StudentsData (){
	this.studentsInClasses = new HashMap <String, LinkedList<Student>>();
    }
	/*
	 * Returns a List of students who are taking the specified class.
	 */
    public List<Student> getStudents(String className) {
	if(className != null && !className.equals("") && studentsInClasses.containsKey(className))
	    return studentsInClasses.get(className);
	return new LinkedList<Student>();
    }
    
    public void addClass(String className, LinkedList<Student> studentsList){
	if(className != null && studentsList != null && !className.equals("")){
	studentsInClasses.put(className, studentsList);
	}
    }
    
    public void addStudentToClass(String className, Student student){
	if(className != null && student != null && !className.equals("")){
	    studentsInClasses.get(student).add(student);
	}
    }

}
