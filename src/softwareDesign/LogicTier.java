package softwareDesign;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * SD2x Homework #8
 * This class represents the Logic Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

public class LogicTier {

    private DataTier dataTier; // link to the Data Tier
    private LinkedList<Book> allBooks;

    public LogicTier(DataTier dataTier) {
	this.dataTier = dataTier;
	this.allBooks = (LinkedList<Book>) dataTier.getAllBooks();
    }
    /**
     * for a given name, search through all of the books and return 
     * the titles of those books whose author name includes the input name.
     * @param authorGiven
     * @return
     */
    public Set<String> findBookTitlesByAuthor(String authorGiven){	
	TreeSet<String> bookSet = new TreeSet<String>();
	if(authorGiven != null && !authorGiven.equals("")){
	    ListIterator<Book> iter = allBooks.listIterator();
	    Book oneBook;

	    while(iter.hasNext()){
		oneBook = iter.next();
		Pattern p = Pattern.compile("\"" + "([a-z]*)"  + "(\\D*)" + authorGiven.toLowerCase() +"(\\D*)" +"([a-z]*)" + "\""); //+ "[a-z]*"
		Matcher m = p.matcher(oneBook.getAuthor().toLowerCase());
		if(m.matches()){
		    bookSet.add(oneBook.getTitle());
		}
	    }
	}
	return bookSet;

    }
    /**
     * for a given year, search through all of the books and return the 
     * number of books published in that year
     * @param date
     * @return
     */
    public int findNumberOfBooksInYear(int date){
	int countBooksInAYear = 0;
	if(date > 0){
	    ListIterator<Book> iter = allBooks.listIterator();
	    Book oneBook;

	    while(iter.hasNext()){
		oneBook = iter.next();
		if(oneBook.getPublicationYear() == date)
		    countBooksInAYear ++;
	    }
	}
	return countBooksInAYear;
    }

}
