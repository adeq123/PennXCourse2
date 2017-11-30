package graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class TestGraph {

    public static void main(String[] args) {
	/* //BFS
	UndirectedGraph ugU = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
	DirectedGraph ugD = GraphBuilder.buildDirectedGraph("graph_builder_test.txt");
	BreadthFirstSearch bfsU = new BreadthFirstSearch(ugU);
	BreadthFirstSearch bfsD = new BreadthFirstSearch(ugD);
	System.out.println("BFS D: " + bfsD.bfs(ugD.getNode("2"), "0"));
	System.out.println("BFS UD: " + bfsU.bfs(ugU.getNode("2"), "0"));
	
	//DFS
	DepthFirstSearch dfsU = new DepthFirstSearch(ugU);
	DepthFirstSearch dfsD = new DepthFirstSearch(ugD);
	System.out.println("DFS UD: " + dfsU.calcualteDis(ugU.getNode("2"), "0"));
	System.out.println("DFS D: " + dfsD.calcualteDis(ugD.getNode("2"), "0"));
	
	//Distance
	Set<String> dist = GraphUtils.nodesWithinDistance(ugU, "2", 2);
	for(String s: dist)
	    System.out.println(s);
	
	//isHamiltonian
	LinkedList<String> hamiltonianPath = new LinkedList<String> ();
	hamiltonianPath.add("0");
	hamiltonianPath.add("1");
	hamiltonianPath.add("2");
	hamiltonianPath.add("5");
	hamiltonianPath.add("0");
	System.out.println(GraphUtils.isHamiltonianPath(ugU, hamiltonianPath));
	System.out.println(GraphUtils.isHamiltonianPath(ugD, hamiltonianPath));
	*/
	UndirectedGraph ugU = GraphBuilder.buildUndirectedGraph("testg1.txt");
	Set<String> dist = GraphUtils.nodesWithinDistance(ugU, "0", 10);
	//for(String s: dist)
	  //  System.out.println(s);
    }

}
