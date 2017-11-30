package advancedDataStructures;
/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.text.html.HTMLDocument.Iterator;


public class MovieRatingsProcessor {
    /**
     * return a List of movie titles in alphabetical order
     * @param movieRatings
     * @return
     */
    public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
	LinkedList<String>  listToReturn = new LinkedList <String>();
	if(movieRatings != null){
	    TreeSet<String> movieAlphabeticalTree = new TreeSet<String>(movieRatings.keySet());
	    listToReturn = new LinkedList <String>(movieAlphabeticalTree);
	}
	return listToReturn; 
    }

    /**
     * given an input int rating, return a List of movie titles in alphabetical order, where all 
     * movies in the List do not have any ratings less than or equal to rating (hint: the 
     * PriorityQueue is a min-heap, meaning that the smallest rating is at the front of the queue!)
     * @param movieRatings
     * @param rating
     * @return
     */
    public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
	LinkedList<String> alphabeticalMoviesAboveRatingList = new LinkedList <String>();
	if(movieRatings != null && rating >= 0){
	    TreeSet<String> movieAlphabeticalAboveRatingTree = new TreeSet<String>();
	    Set <Entry <String, PriorityQueue<Integer>>> movieRatingSet = movieRatings.entrySet();
	    for(Entry <String, PriorityQueue<Integer>> entr : movieRatingSet)
		if(entr.getValue().peek() > rating && entr != null)
		    movieAlphabeticalAboveRatingTree.add(entr.getKey());  
	    alphabeticalMoviesAboveRatingList = new LinkedList <String>(movieAlphabeticalAboveRatingTree);
	}
	return alphabeticalMoviesAboveRatingList; // this line is here only so this code will compile if you don't modify it
    }
    /**
     * given an input int rating, modify the TreeMap object that was passed as an 
     * argument so that you remove all ratings in the PriorityQueue that are below 
     * (but not equal to) rating for every movie in the Map. If all ratings are removed 
     * from a movie’s PriorityQueue, then remove the mapping from the TreeMap. Additionally, 
     * this method should return a new TreeMap that maps a movie title to the number of 
     * ratings that were removed from its corresponding PriorityQueue; the TreeMap that is 
     * returned should only contain movies that had ratings removed from its PriorityQueue.
     * @param movieRatings
     * @param rating
     * @return
     */
    public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
	TreeMap <String, Integer> numberOfMovieRatingsRemoved = new TreeMap <String, Integer> ();
	if(movieRatings != null && !movieRatings.isEmpty() && rating >= 0){
	    
	    //TreeMap<String, PriorityQueue<Integer>> newMovieRatings = new TreeMap<String, PriorityQueue<Integer>>();
	    Set <Entry <String, PriorityQueue<Integer>>> movieRatingsEntrySet = movieRatings.entrySet();
	    PriorityQueue <Integer> newRatings;
	    java.util.Iterator<Entry<String, PriorityQueue<Integer>>> iter = movieRatingsEntrySet.iterator();
	    Entry<String, PriorityQueue<Integer>> entr;
	    
	    while(iter.hasNext()){
		entr = iter.next();
		newRatings = new PriorityQueue <Integer>();
		int totalNumberOfMovieRatings = 0;
		int movieRatingsAdded = 0;
		for(int i : entr.getValue()){
		    totalNumberOfMovieRatings ++;
		    if(i >= rating){
			newRatings.add(i);
			movieRatingsAdded ++;
		    }
		}
		if(totalNumberOfMovieRatings - movieRatingsAdded > 0)
		    numberOfMovieRatingsRemoved.put(entr.getKey(), totalNumberOfMovieRatings - movieRatingsAdded);
		if(newRatings.isEmpty()){
		    //iter.remove();
		    movieRatings.remove(entr.getKey());
		}else{
		    movieRatings.replace(entr.getKey(), entr.getValue(), newRatings);
		}
	    }
	   
	}
	return numberOfMovieRatingsRemoved; // this line is here only so this code will compile if you don't modify it
    }
}
