package softwareDesign;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/*
 * SD2x Homework #8
 * This class represents the Data Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

public class DataTier {

    private String fileName; // the name of the file to read

    public DataTier(String inputSource) {
	fileName = inputSource;

    }
    /**
     * read the data file containing information about the books, 
     * create Book objects for each, and then return the Book objects.
     * @return
     */
    public List<Book> getAllBooks(){
	List<Book> listOfBooks = new LinkedList<Book>();
	File booksFile = new File (fileName);
	FileReader booksFileReader;
	String line;
	BufferedReader bf;
	String [] lineArray;
	Book newBook;
	try {
	    booksFileReader = new FileReader (booksFile);
	    bf = new BufferedReader(booksFileReader);
	    while((line = bf.readLine()) != null){
		lineArray = line.split("\t");
		newBook = new Book(lineArray[0], lineArray[1], Integer.parseInt(lineArray[2]));
		listOfBooks.add(newBook);
	    }
	} catch (FileNotFoundException e) {
	    System.out.println("File ot find. Enter valid file path");
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return listOfBooks;

    }

}
