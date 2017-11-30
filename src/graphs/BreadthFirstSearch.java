package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * SD2x Homework #6
 * This is an implementation of Breadth First Search (BFS) on a graph.
 * You may modify and submit this code if you'd like.
 */

public class BreadthFirstSearch {
	protected Set<Node> marked;
	protected Graph graph;

	public BreadthFirstSearch(Graph graphToSearch) {
		marked = new HashSet<Node>();
		graph = graphToSearch;
	}
	
	/**
	 * This method was discussed in the lesson
	 */
	public int bfs(Node start, String elementToFind) {
	    	HashMap<Node, Integer> dist = new HashMap<Node, Integer>();
		if (!graph.containsNode(start)) {
				return -1;
		}
		if (start.getElement().equals(elementToFind)) {
			return 0;
		}
		Queue<Node> toExplore = new LinkedList<Node>();
		marked.add(start);
		toExplore.add(start);
		dist.put(start, 0);
		while (!toExplore.isEmpty()) {
			Node current = toExplore.remove();
			for (Node neighbor : graph.getNodeNeighbors(current)) {
			    	dist.put(neighbor, dist.get(current) + 1);
				if (!marked.contains(neighbor)) {
					if (neighbor.getElement().equals(elementToFind)) {
						return dist.get(neighbor);
					}
					marked.add(neighbor);
					toExplore.add(neighbor);
				}
			}
		}
		return -1;
	}
	

}
