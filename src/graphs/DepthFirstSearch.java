package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * SD2x Homework #6
 * This is an implementation of Depth First Search (DFS) on a graph.
 * You may modify and submit this code if you'd like.
 */

public class DepthFirstSearch {
	protected Set<Node> marked;
	protected Graph graph;
	private int distance ;
	public static HashMap<Node, Integer> dist = new HashMap<Node, Integer>();
	public DepthFirstSearch(Graph graphToSearch) {
		marked = new HashSet<Node>();
		graph = graphToSearch;
		this.distance = 0;
	}
	
	public boolean dfs(Node start, String elementToFind) {
	    
	    
		if (!graph.containsNode(start)) {
			return false;
		}	
	
		if (start.getElement().equals(elementToFind)) {
			return true;
		} else {
			marked.add(start);
			dist.put(start, 0);
			for (Node neighbor : graph.getNodeNeighbors(start)) {
			    dist.put(neighbor, dist.get(start) + 1);
				if (!marked.contains(neighbor) && dfs(neighbor, elementToFind) ){
				    distance ++;
				    return true;
				}
			}
			return false;
		}
		

	}
	
	public int calcualteDis(Node start, String elementToFind){
	    if(dfs(start, elementToFind)){
		return distance;
	    }else{
		return -1;
	    }
	}

}
