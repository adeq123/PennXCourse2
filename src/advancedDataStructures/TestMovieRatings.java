package advancedDataStructures;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class TestMovieRatings {

    public static void main(String[] args) {
	UserMovieRating uma = new UserMovieRating("Movie A", 1);
	UserMovieRating umb = new UserMovieRating("Movie B", 2);
	UserMovieRating umc = new UserMovieRating("Movie C", 3);
	UserMovieRating umd = new UserMovieRating("Movie D", 4);
	UserMovieRating ume = new UserMovieRating("Movie E", 5);
	
	LinkedList<UserMovieRating> ll1 = new LinkedList<UserMovieRating>();
	ll1.add(uma);
	ll1.add(umb);
	ll1.add(new UserMovieRating("Movie W", 6));
	ll1.add(umc);
	ll1.add(umd);
	ll1.add(new UserMovieRating("Movie T", 8));
	ll1.add(ume);
	
	ll1.add(umc);
	ll1.add(umc);
	ll1.add(umc);
	
	ll1.add(ume);
	
	TreeMap<String, PriorityQueue<Integer>> myMap = MovieRatingsParser.parseMovieRatings(ll1);
	System.out.println(myMap.size());
	System.out.println(myMap.get("movie c"));
	
	ll1.add(new UserMovieRating("Movie Z", 9));
	ll1.add(new UserMovieRating("Movie G", 10));
	ll1.add(new UserMovieRating("Movie H", 7));
	ll1.add(new UserMovieRating("Movie X", 8));
	ll1.add(new UserMovieRating("Movie H", 9));
	myMap = MovieRatingsParser.parseMovieRatings(ll1);
	
	List<String> moviesAlphabetical = MovieRatingsProcessor.getAlphabeticalMovies(myMap);
	for(String mov : moviesAlphabetical)
	    System.out.println(mov +" " + myMap.get(mov));
	
	TreeMap<String, Integer> romvedRatingsMap = MovieRatingsProcessor.removeAllRatingsBelow(myMap, 4);
	Set <Entry <String, Integer>> romvedRatingsSet = romvedRatingsMap.entrySet();
	
	System.out.println("Removed ratings for each movie: \n");
	for(Entry <String, Integer> entr  : romvedRatingsSet)
	    System.out.println(entr.getKey() +" " + entr.getValue());
	
	Set <Entry <String, PriorityQueue<Integer>>> removedMoviesBelow = myMap.entrySet();
	
	System.out.println("New list of movies with delted ratings \n");
	for(Entry <String, PriorityQueue<Integer>> entr  : removedMoviesBelow)
	    System.out.println(entr.getKey() +" " + entr.getValue());
    }

}
