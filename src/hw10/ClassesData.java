package hw10;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ClassesData implements ClassesDataSource {

    private HashMap<String , LinkedList<String>> studentsClasses;
    
    public ClassesData(){
	this.studentsClasses = new HashMap<String , LinkedList<String>>();
    }
	/*
	 * Returns a List of the names of the classes 
	 * that are being taken by the specified student.
	 */
    public List<String> getClasses(String studentName) {
	
	return studentsClasses.get(studentName);
    }
    
    public void addStudent(String studentName, LinkedList<String> classList){
	if(studentName != null && classList != null && !studentName.equals(""))
	    studentsClasses.put(studentName, classList);
    }
    
    public void addClassToStudent(String studentName, String className){
	if(studentName != null && className != null && !studentName.equals("") && !className.equals(""))
	    studentsClasses.get(studentName).add(className);
    }

}
