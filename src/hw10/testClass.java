package hw10;

import java.util.LinkedList;

public class testClass {

    public static void main(String[] args) {
	StudentsData sd = new StudentsData();
	ClassesData cd = new ClassesData();
 	
	Student I = new Student ("I");
	Student Alice = new Student ("Alice");
	Student Bob = new Student ("Bob");
	Student Chen = new Student ("Chen");
	Student Dhriti = new Student ("Dhriti");
	
	LinkedList<Student> CIS573L = new LinkedList<Student>();
	CIS573L.add(I);
	CIS573L.add(Alice);
	CIS573L.add(Bob);
	CIS573L.add(Chen);
	sd.addClass("CIS573", CIS573L);
	
	LinkedList<Student> CIS550L = new LinkedList<Student>();
	CIS550L.add(I);
	CIS550L.add(Alice);
	CIS550L.add(Chen);
	CIS550L.add(Dhriti);
	sd.addClass("CIS550", CIS550L);
	
	LinkedList<Student> CIS555L = new LinkedList<Student>();
	CIS555L.add(Alice);
	CIS555L.add(Chen);
	sd.addClass("CIS555", CIS555L);
	
	cd.addStudent(I.getName(),new LinkedList<String>() );
	cd.addClassToStudent(I.getName(), "CIS573");
	cd.addClassToStudent(I.getName(), "CIS550");
	cd.addClassToStudent(I.getName(), null);
	
	cd.addStudent(Alice.getName(),new LinkedList<String>() );
	cd.addClassToStudent(Alice.getName(), "CIS573");
	cd.addClassToStudent(Alice.getName(), "CIS550");
	cd.addClassToStudent(Alice.getName(), "CIS555");
	
	cd.addStudent(Bob.getName(),new LinkedList<String>() );
	cd.addClassToStudent(Bob.getName(), "CIS573");
	
	cd.addStudent(Chen.getName(),new LinkedList<String>() );
	cd.addClassToStudent(Chen.getName(), "CIS573");
	cd.addClassToStudent(Chen.getName(), "CIS550");
	cd.addClassToStudent(Chen.getName(), "CIS555");
	
	cd.addStudent(Dhriti.getName(),new LinkedList<String>() );
	cd.addClassToStudent(Dhriti.getName(), "CIS550");
	
	FriendFinder ff = new FriendFinder(cd, sd);
	LinkedList<String> classMates = new LinkedList<String>(ff.findClassmates(I));
	for(String s : classMates)
	    System.out.println(s);

    }

}
