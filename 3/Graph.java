import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
	private ArrayList<LinkedList<Direct>> vertexes;
	private final int AMOUNT_OF_VERTEXES;

	public Graph(int amountOfVertexes) {
		this.AMOUNT_OF_VERTEXES = amountOfVertexes;
		vertexes = new ArrayList<LinkedList<Direct>>(amountOfVertexes);
		for (int i = 0; i < amountOfVertexes; i++) {
			vertexes.add(new LinkedList<Direct>());
		}
	}

	public void addEdge(int vertex1, int vertex2, int weight) {
		if (vertex1 < AMOUNT_OF_VERTEXES && vertex2 < AMOUNT_OF_VERTEXES) {
			vertexes.get(vertex1).add(new Direct(vertex2, weight));
			vertexes.get(vertex2).add(new Direct(vertex1, weight));
		}
	}

	public LinkedList<Direct> getDirectes(int vertex) {
		if (vertex < AMOUNT_OF_VERTEXES) {
			return vertexes.get(vertex);
		}
		else {
			return new LinkedList<Direct>();
		}
	}
}