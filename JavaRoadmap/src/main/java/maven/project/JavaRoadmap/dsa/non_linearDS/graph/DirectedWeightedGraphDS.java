package maven.project.JavaRoadmap.dsa.non_linearDS.graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * This class represents a directed weighted graph data structure.
 * @param <T> The type of data stored in the vertices.
 * @version 1.0
 * @since 2024-04-27
 */
public class DirectedWeightedGraphDS<T> {
	private Set<WeightedVertex<T>> graphVertices= new HashSet<>();
	private Set<WeightedVertex<T>> visited;
	
	
	/**
	 * Returns the number of vertices in the graph.
	 * @return The number of vertices.
	 */
	public int getVerticesNumber() {
		return visited.size();
	}
	
	
	public void addVertex(WeightedVertex<T> vertix) {
		graphVertices.add(vertix);
	}
	/**
	 * Returns the number of edges in the graph.
	 * @return The number of edges.
	 */
	public int getEdgesNumber() {
		int edgeCount = 0;
		for(WeightedVertex<T> vertex : visited) {
			edgeCount += vertex.neighbours.size();
		}
		return edgeCount;
	}

	/**
	 * Constructor for the DirectedWeightedGraphDS class.
	 */
	public DirectedWeightedGraphDS() {
		visited = new HashSet<>();
	}

	/**
	 * Traverses the graph using Depth-First Search (DFS) starting from a given vertex.
	 * @param vertex The starting vertex for the DFS traversal.
	 */
	public void traverseDFS(WeightedVertex<T> vertex) {
		if (vertex == null)
			return;
		visited.clear(); // Moved to dfsRecursive
		dfsRecursive(vertex);
	}

	/**
	 * Helper method for the DFS traversal.
	 * @param vertex The current vertex in the DFS traversal.
	 */
	public void dfsRecursive(WeightedVertex<T> vertex) {
	    visited.add(vertex);
	    for (Map.Entry<WeightedVertex<T>, Integer> entry : vertex.neighbours.entrySet()) {
	        WeightedVertex<T> neighbour = entry.getKey();
	        int weight = entry.getValue();
	            System.out.println(vertex.getVertex() + " -> " + neighbour.getVertex() + " (Weight: " + weight + ")");
	            dfsRecursive(neighbour);
	    }
	}
	
	/**
	 * Traverses the graph using Breadth-First Search (BFS) starting from a given vertex.
	 * @param vertex The starting vertex for the BFS traversal.
	 */
	public void traverseBFS(WeightedVertex<T> vertex) {
        if (vertex == null)
            return;
        Queue<WeightedVertex<T>> queue = new ArrayDeque<>();
        visited.clear(); // Moved outside of the method if you plan to traverse multiple vertices
        queue.add(vertex);
        visited.add(vertex);
        while (!queue.isEmpty()) {
            WeightedVertex<T> current = queue.poll();
            for (Map.Entry<WeightedVertex<T>, Integer> entry : current.neighbours.entrySet()) {
                WeightedVertex<T> neighbour = entry.getKey();
                int weight = entry.getValue();
                    System.out.println(current.getVertex() + " -> " + neighbour.getVertex() + " (Weight: " + weight + ")");
                    visited.add(neighbour);
                    queue.add(neighbour);
                
            }
        }
    }

	public static void main(String[] args) {
		DirectedWeightedGraphDS<Character> graph = new DirectedWeightedGraphDS<>();
		WeightedVertex<Character> a = new WeightedVertex<>('a');
		WeightedVertex<Character> b = new WeightedVertex<>('b');
		WeightedVertex<Character> c = new WeightedVertex<>('c');
		WeightedVertex<Character> e = new WeightedVertex<>('e');
		WeightedVertex<Character> g = new WeightedVertex<>('g');
		WeightedVertex<Character> o = new WeightedVertex<>('o');
		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(c);
		graph.addVertex(e);
		graph.addVertex(g);
		a.addNeighbour(b, 45);
		a.addNeighbour(c, 32);
		b.addNeighbour(e, 22);
		b.addNeighbour(g, 10);
		e.addNeighbour(g, 15);
		c.addNeighbour(o, 12);
		o.addNeighbour(g, 20);
		System.out.println("DFS traversal");
		graph.traverseDFS(a); // Start DFS from vertex 1
		System.out.println("BFS traversal");
		graph.traverseBFS(a);
		System.out.println("Number of Vertices " + graph.getVerticesNumber());
		System.out.println("Number of Edges " + graph.getEdgesNumber());
		System.out.println(e.getNeighbours());
	}
}