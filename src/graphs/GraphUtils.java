package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/*
 * SD2x Homework #6
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class GraphUtils {
    /**
     * minDistance: Given a Graph, this method returns the shortest distance (in terms of number of edges)
     * from the node labeled src to the node labeled dest. The method should return -1 for any invalid inputs,
     * including: null values for the Graph, src, or dest; there is no node labeled src or dest in the graph;
     * there is no path from src to dest. Keep in mind that this method does not just return the distance of
     * any path from src to dest, it must be the shortest path.
     * 
     * @param graph
     * @param src
     * @param dest
     * @return
     */
    public static int minDistance(Graph graph, String src, String dest) {

	if(graph != null && src != null && dest != null && graph.containsElement(src) && graph.containsElement(dest)){
	    BreadthFirstSearch bfs = new BreadthFirstSearch(graph);
	    DepthFirstSearch dfs = new DepthFirstSearch(graph);

	    return Math.min(bfs.bfs(graph.getNode(src), dest), dfs.calcualteDis(graph.getNode(src), dest));
	}

	return -1; // this line is here only so this code will compile if you don't modify it
    }

    /**
     * Given a Graph, this method returns a Set of the values of all nodes within the specified distance 
     * (in terms of number of edges) of the node labeled src, i.e. for which the minimum number of edges 
     * from src to that node is less than or equal to the specified distance. The value of the node itself 
     * should not be in the Set, even if there is an edge from the node to itself. The method should return 
     * null for any invalid inputs, including: null values for the Graph or src; there is no node labeled 
     * src in the graph; distance less than 1. However, if distance is greater than or equal to 1 and there 
     * are no nodes within that distance (meaning: src is the only node in the graph), the method should 
     * return an empty Set.
     * @param graph
     * @param src
     * @param distance
     * @return
     */
    public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {
	if(graph != null && src != null && distance >= 1 && graph.containsElement(src) ){
	    Set<String> toReturn = new HashSet<String>();
	    Queue<Node> toExplore = new LinkedList<Node>();
	    toExplore.add(graph.getNode(src));
	    Node current;
	    Set<Node> currentNeighbours = new HashSet<Node> ();
	    HashMap<Node, Integer> distMap = new HashMap<Node, Integer>();
	    current = toExplore.poll();
	    distMap.put(current, 0);
	    if(graph.getAllNodes().size() > 1)
	    do{
		currentNeighbours = graph.getNodeNeighbors(current);
		for(Node n: currentNeighbours){
		    toExplore.add(n);
		    distMap.put(n, distMap.get(current) + 1);
		    toReturn.add(n.element);
		}
		current = toExplore.poll(); 
	    }while(distMap.get(current) < distance && !toExplore.isEmpty());

	    return toReturn;
	}

	return null; // this line is here only so this code will compile if you don't modify it
    }

    /**
     * Given a Graph, this method indicates whether the List of node values represents a Hamiltonian Path.
     *  A Hamiltonian Path is a valid path through the graph in which every node in the graph is visited 
     *  exactly once, except for the start and end nodes, which are the same, so that it is a cycle. 
     *  If the values in the input List represent a Hamiltonian Path, the method should return true, 
     *  but the method should return false otherwise, e.g. if the path is not a cycle, if some nodes 
     *  are not visited, if some nodes are visited more than once, if some values do not have corresponding 
     *  nodes in the graph, if the input is not a valid path (i.e., there is a sequence of nodes in the List 
     *  that are not connected by an edge), etc. The method should also return false if the input Graph or List is null.
     *  
     *  The idea in this method is to check:
     *  - if graph contains all of the elements
     *  - if first and the last element is the same
     *  - each of the nodes is visited only once 
     *  - next node is a neighbor of the previous
     *  - checks if the first and last element is present on list more the twice
     *  - checks if all nodes has been visited
     * @param g
     * @param values
     * @return
     */
    public static boolean isHamiltonianPath(Graph g, List<String> values) {
	if(g != null && values != null && !values.isEmpty()){
	    String s = "";
	    Set<Node> elementNeighbor;
	    HashSet<Node> visitedNodes = new HashSet<Node> ();
	    if(!values.get(0).equals(values.get(values.size() - 1))) // check if the first and last one are the same
		return false;
	    if(!values.subList(1, values.size()).contains(values.get(0)))//checks if the first (and last) element are present on the list
		//more then twice
		return false;
	    for(int i = 0; i < values.size(); i++){
		s = values.get(i);
		if(!g.containsElement(s)) // check if all of the elements are present in the graph
		    return false;
		if(!s.equals(values.get(0))){
		    if(visitedNodes.contains(g.getNode(s))) // check if the element has been already visited
			return false;
		    visitedNodes.add(g.getNode(s));
		    elementNeighbor = g.getNodeNeighbors(g.getNode(values.get(i - 1))); // neighbor of the prev
		    if(!elementNeighbor.contains(g.getNode(s))) // check all elements without last one
			return false;
		}else if(i == (values.size() - 1)){ // check the last one
		    elementNeighbor = g.getNodeNeighbors(g.getNode(values.get(i -1)));
		    visitedNodes.add(g.getNode(s));
		    if(!elementNeighbor.contains(g.getNode(s))) // check last element
			return false;
		}
	    }
	    for(Node n : g.getAllNodes()){ // check if all nodes has been visited
		if(!visitedNodes.contains(n))
		    return false;
	    }
	    return true;
	}

	return false; // this line is here only so this code will compile if you don't modify it
    }

}
