package coreDataStructure;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class LinkedListUtilsTest {

    LinkedListUtils llu;
    LinkedList<Integer> l1;
    LinkedList<Integer> l2;
    LinkedList<String> l3;
    LinkedList<Integer> l4;
    LinkedList<Integer> l5;
    @Before
    public void setUp() throws Exception {
	llu = new LinkedListUtils();
	l1 = new LinkedList<Integer>();
	l2 = new LinkedList<Integer>();
	l3 = new LinkedList<String>();
	l4 = new LinkedList<Integer>();
	l5 = new LinkedList<Integer>();
    }

    @Test
    public void testInsertSorted() {
	for(int i = 0; i < 10; i++){
	    if(i != 5)
		l1.add(i);
	}
	
	LinkedListUtils.insertSorted(l1, 5);
	assertTrue(l1.get(5) == 5);
	LinkedListUtils.insertSorted(l1, 6);
	System.out.println(l1);
	
	LinkedListUtils.insertSorted(l2, 100);
	assertTrue(l2.size() == 1);
	assertTrue(l2.getFirst() == 100 && l2.getLast() == 100);
	
	LinkedListUtils.insertSorted(l1, 100);
	assertTrue(l1.getLast() == 100);
	LinkedListUtils.insertSorted(l1, -1);
	assertTrue(l1.getFirst() == -1);
	
    }

    @Test
    public void testRemoveMaximumValues() {
	l3.add("A");
	l3.add("B");
	l3.add("C");
	l3.add("D");
	l3.add("W");
	l3.add("W");
	l3.add("Z");
	l3.add("Z");
	l3.add("E");
	l3.add("F");
	l3.add("F");
	
	LinkedListUtils.removeMaximumValues(l3, 3);
	
	assertFalse(l3.contains("W"));
	assertFalse(l3.contains("F"));
	assertFalse(l3.contains("Z"));
	
    }

    @Test
    public void testContainsSubsequence() {
	for(int i = 0; i < 10; i++){
	    l1.add(i);
	    if(i > 3 && i < 9)
		l4.add(i);
	}
	assertTrue(LinkedListUtils.containsSubsequence(l1, l4));
	l5.add(6);
	l5.add(4);
	l5.add(5);
	assertFalse(LinkedListUtils.containsSubsequence(l1, l5));
	assertFalse(LinkedListUtils.containsSubsequence(l1, null));
	assertFalse(LinkedListUtils.containsSubsequence(null, l5));
	l1.add(5, 11);
	assertFalse(LinkedListUtils.containsSubsequence(l1, l4));
    }

}
