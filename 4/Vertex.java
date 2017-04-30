import java.util.ArrayList;
import java.util.List;

public class Vertex {
	private int number;
	private List<Edge> edges;
	private boolean visited;

	public Vertex(int number) {
		this.number = number;
		edges = new ArrayList<>();
		visited = false;
	}

	public void addEdge(Edge edge) {
		edges.add(edge);
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public boolean getVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public int getNumber() {
		return number;
	}

	public void print() {
		edges.forEach(Edge::print);
	}
}