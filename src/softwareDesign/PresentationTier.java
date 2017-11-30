package softwareDesign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.TreeSet;

/*
 * SD2x Homework #8
 * This class represents the Presentation Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below. 
 * Also implement the start method as described in the assignment description.
 */

public class PresentationTier {

    private LogicTier logicTier; // link to the Logic Tier
    private BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public PresentationTier(LogicTier logicTier) {
	this.logicTier = logicTier;
    }
    public void showBookTitlesByAuthor (){
	System.out.println("Please enter the author name:");
	TreeSet<String> bookTree = null;;
	try {
	    bookTree = (TreeSet<String>) logicTier.findBookTitlesByAuthor(bf.readLine());
	    bf.close();
	} catch (IOException e) {
	    System.out.println("Something went wrong! Input - Output Exception");
	}
	if(bookTree != null){
	    LinkedList <String> bookList = new LinkedList <String> (bookTree);
	    System.out.println("\nList of books: ");
	    ListIterator<String> iterL = bookList.listIterator();
	    while(iterL.hasNext()){
		System.out.println(iterL.next());
	    }
	}
    }

    public void showNumberOfBooksInYear (){
	try {
	    System.out.println(logicTier.findNumberOfBooksInYear(Integer.parseInt(bf.readLine())));
	} catch (NumberFormatException e) {
	    System.out.println("Incorrect input! only numbers accepted");
	} catch (IOException e) {
	    System.out.println("Something went wrong! Input - Output Exception");
	    e.printStackTrace();
	}
    }
    public void start() {
	System.out.println("How can I help you ?\n- Press 1 to search for book list of one author\n- Press 2 to search for all books in the year given");
	try {
	    if(Integer.parseInt(bf.readLine()) == 1){
		showBookTitlesByAuthor ();
	    }else{
		showNumberOfBooksInYear ();
	    }
	} catch (NumberFormatException e) {
	    System.out.println("Incorrect input! only numbers accepted");
	} catch (IOException e) {
	    System.out.println("Something went wrong! Input - Output Exception");
	    e.printStackTrace();
	}

    }


}
