package advancedDataStructures;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

public class MovieRatingsParserTest {
    TreeMap<String, PriorityQueue<Integer>> myMap;
    LinkedList<UserMovieRating> ll1;
    @Before
    public void setUp() throws Exception {
	UserMovieRating uma = new UserMovieRating("Movie A", 1);
	UserMovieRating umb = new UserMovieRating("Movie B", 2);
	UserMovieRating umc = new UserMovieRating("Movie C", 3);
	UserMovieRating umd = new UserMovieRating("Movie D", 4);
	UserMovieRating ume = new UserMovieRating("Movie E", 5);
	
	ll1 = new LinkedList<UserMovieRating>();
	ll1.add(uma);
	ll1.add(umb);
	ll1.add(umc);
	ll1.add(umd);
	ll1.add(ume);
	
	ll1.add(umc);
	ll1.add(umc);
	ll1.add(umc);
	
	ll1.add(ume);
	
	myMap = MovieRatingsParser.parseMovieRatings(ll1);
    }

    @Test
    public void testParseMovieRatings() {
	assertTrue(myMap.size() == 5);
	assertTrue(myMap.get("movie b").peek() == 2);
	assertTrue(myMap.get("movie b").size() == 1);
	
	assertTrue(myMap.get("movie c").size() == 4);
	assertTrue(myMap.get("movie e").size() == 2);
	
	assertTrue(myMap.get("movie e").poll() == 5);
	assertTrue(myMap.get("movie e").poll() == 5);
	assertTrue(myMap.get("movie e").isEmpty());
	assertTrue(MovieRatingsParser.parseMovieRatings(null).isEmpty());
	
	UserMovieRating um = new UserMovieRating("", 5);
	ll1.add(um);
	myMap = MovieRatingsParser.parseMovieRatings(ll1);
	assertTrue(!myMap.containsKey(""));
	
	UserMovieRating umu = new UserMovieRating("movie u", -5);
	ll1.add(umu);
	myMap = MovieRatingsParser.parseMovieRatings(ll1);
	assertTrue(!myMap.containsKey("movie u"));
    }

}
