package maven.project.JavaRoadmap.dsa.non_linearDS.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;

/**
 * Represents an undirected graph data structure.
 * @param <T> The type of data stored in the vertices.
 * @version 1.0
 * @since 2024-04-26
 */
public class UndirectedGraphDS<T> {
    
    /**
     * Represents a vertex in the graph.
     * @param <T> The type of data stored in the vertex.
     */
    public class Vertex<T> {
        public T vertex;
        List<Vertex<T>> neighbours;

        /**
         * Constructs a vertex with the given value.
         * @param vertex The value of the vertex.
         */
        public Vertex(T vertex) {
            this.vertex = vertex;
            this.neighbours = new ArrayList<>();
        }

        /**
         * Retrieves the value of the vertex.
         * @return The value of the vertex.
         */
        public T getVertex() {
            return vertex;
        }

        /**
         * Sets the value of the vertex.
         * @param vertex The new value of the vertex.
         */
        public void setVertex(T vertex) {
            this.vertex = vertex;
        }

        /**
         * Retrieves the list of neighbours of the vertex.
         * @return The list of neighbours.
         */
        public List<Vertex<T>> getNeighbours() {
            return neighbours;
        }

        /**
         * Adds a neighbour to the vertex.
         * @param vertex The neighbour to add.
         */
        public void addNeighbour(Vertex<T> vertex) {
            if (!neighbours.contains(vertex)) {
                neighbours.add(vertex);
            }
        }

        /**
         * Removes a neighbour from the vertex.
         * @param vertex The neighbour to remove.
         */
        public void removeNeighbour(Vertex<T> vertex) {
            if (!neighbours.contains(vertex)) {
                throw new NoSuchElementException("The vertex is not a neighbour of the current vertex");
            }
            neighbours.remove(vertex);
        }

        /**
         * Returns a string representation of the vertex.
         * @return A string representation of the vertex.
         */
        @Override
        public String toString() {
            return String.valueOf(vertex);
        }
    }

    private Set<Vertex<T>> visited;

    /**
     * Constructs an undirected graph.
     */
    public UndirectedGraphDS() {
        visited = new HashSet<>();
    }

    /**
     * Checks if the graph is empty.
     * @return True if empty, false otherwise.
     */
    public boolean isEmpty() {
    	return visited.isEmpty();
    }
    
    /**
     * Counts the number of verticles.
     * @return The number of verticles.
     */
    public int getVerticesNumber() {
    	return visited.size();
    }
    
    /**
     * Counts the number of edges.
     * @return The number of edges.
     */
    public int getNumberOfEdges() {
        int edgeCount = 0;
        for (Vertex<T> vertex : visited) {
            edgeCount += vertex.neighbours.size();
        }
        // Since each edge is counted twice (once for each vertex it connects),
        // divide by 2 to get the actual number of edges
        return edgeCount / 2;
    }
    
    /**
     * Traverses the graph using Depth First Search (DFS) starting from the given vertex.
     * @param vertex The starting vertex for traversal.
     */
    public void traverseDFS(Vertex<T> vertex) {
        if (vertex == null) return;
        visited.clear();
        dfsRecursive(vertex);
    }

    private void dfsRecursive(Vertex<T> vertex) {
        visited.add(vertex);
        System.out.print(vertex.vertex + " ");
        for (Vertex<T> neighbour : vertex.neighbours) {
            if (!visited.contains(neighbour)) {
                dfsRecursive(neighbour);
            }
        }
    }

    /**
     * Traverses the graph using Breadth First Search (BFS) starting from the given vertex.
     * @param vertex The starting vertex for traversal.
     */
    public void traverseBFS(Vertex<T> vertex) {
        if (vertex == null) return;
        visited.clear();
        Queue<Vertex<T>> queue = new ArrayDeque<>();
        queue.add(vertex);
        visited.add(vertex);

        while (!queue.isEmpty()) {
            Vertex<T> current = queue.poll();
            System.out.print(current.vertex + " ");

            for (Vertex<T> neighbour : current.neighbours) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
    }

    /**
     * Main method for testing.
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
    	UndirectedGraphDS<Character> graph1 = new UndirectedGraphDS<>();
        UndirectedGraphDS<Character>.Vertex<Character> a = graph1.new Vertex<>('a');
        UndirectedGraphDS<Character>.Vertex<Character> b = graph1.new Vertex<>('b');
        UndirectedGraphDS<Character>.Vertex<Character> c = graph1.new Vertex<>('c');
        UndirectedGraphDS<Character>.Vertex<Character> d = graph1.new Vertex<>('d');
        UndirectedGraphDS<Character>.Vertex<Character> g = graph1.new Vertex<>('g');
        UndirectedGraphDS<Character>.Vertex<Character> k = graph1.new Vertex<>('k');
        UndirectedGraphDS<Character>.Vertex<Character> e = graph1.new Vertex<>('e');
        a.addNeighbour(b);
        a.addNeighbour(c);
        a.addNeighbour(g);
        b.addNeighbour(a);
        b.addNeighbour(d);
        c.addNeighbour(a);
        d.addNeighbour(b);
        d.addNeighbour(k);
        d.addNeighbour(e);
        g.addNeighbour(a);
        k.addNeighbour(d);
        e.addNeighbour(d);
        
        System.out.println("DFS Traversal:");
        graph1.traverseDFS(a);
        System.out.println("\nBFS Traversal:");
        graph1.traverseBFS(a);
        System.out.println();
        System.out.println(a.getVertex());
        System.out.println("numver of verticles "+graph1.getVerticesNumber());   
    }
}


