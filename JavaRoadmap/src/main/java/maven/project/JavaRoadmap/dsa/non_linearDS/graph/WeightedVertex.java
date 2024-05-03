package maven.project.JavaRoadmap.dsa.non_linearDS.graph;

import java.util.HashMap;

/**
 * This class represents a weighted vertex in the graph.
 */
public class WeightedVertex<T> {
	private T vertex;
	HashMap<WeightedVertex<T>, Integer> neighbours;

	/**
	 * Constructor for the WeightedVertex class.
	 * @param vertex The value of the vertex.
	 */
	public WeightedVertex(T vertex) {
		this.vertex = vertex;
		neighbours = new HashMap<WeightedVertex<T>, Integer>();
	}

	/**
	 * Getter for the vertex value.
	 * @return The value of the vertex.
	 */
	public T getVertex() {
		return vertex;
	}

	/**
	 * Setter for the vertex value.
	 * @param vertex The new value of the vertex.
	 */
	public void setVertex(T vertex) {
		this.vertex = vertex;
	}

	/**
	 * Adds a neighbour to the current vertex.
	 * @param vertex The neighbour vertex.
	 * @param weight The weight of the edge to the neighbour.
	 */
	public void addNeighbour(WeightedVertex<T> vertex, int weight) {
		if (!neighbours.containsKey(vertex)) {
			neighbours.put(vertex, weight);
		}
	}

	/**
	 * Removes a neighbour from the current vertex.
	 * @param vertex The neighbour vertex.
	 * @return True if the neighbour was removed, false otherwise.
	 */
	public boolean removeNeighbour(WeightedVertex<T> vertex) {
		if (!neighbours.containsKey(vertex)) {
			return false;
		}
		neighbours.remove(vertex);
		return true;
	}

	/**
	 * Getter for the neighbours of the current vertex.
	 * @return A HashMap of the neighbours and their weights.
	 */
	public HashMap<WeightedVertex<T>, Integer> getNeighbours() {
		return neighbours;
	}

	@Override
	public String toString() {
		return String.valueOf(vertex);
	}
}