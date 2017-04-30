import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Graph {
	List<Vertex> vertexes;
	Set<Edge> edges;

	public Graph(int vertexNumber) {
		vertexes = new ArrayList<>(vertexNumber);
		for (int i = 0; i < vertexNumber; i++) {
			vertexes.add(new Vertex(i));
		}
		edges = new HashSet<>();
	}

	public void addEdge(int startNumber, int endNumber, int maxStream) {
		Edge edge = new Edge(vertexes.get(startNumber), vertexes.get(endNumber), maxStream);
		vertexes.get(startNumber).addEdge(edge);
		vertexes.get(endNumber).addEdge(edge);
		edges.add(edge);
	}

	public int findMaxStream(int start, int end) {
		Vertex startVertex = vertexes.get(start);
		Vertex endVertex = vertexes.get(end);
		int i;
		do {
			i = findMaxStream(startVertex, endVertex, 500);
		} while (i != 0);
		edges.forEach(Edge::print);
		return 0;
	}

	private int findMaxStream(Vertex currentVertex, Vertex endVertex, int maxStream) {
		if (currentVertex == endVertex) {
			return maxStream;
		}
		currentVertex.setVisited(true);
		for (Edge edge : currentVertex.getEdges()) {
			Vertex nextVertex;
			boolean isDirect;
			if (edge.getEndVertex() != currentVertex) {
				nextVertex = edge.getEndVertex();
				isDirect = true;
			} else {
				nextVertex = edge.getStartVertex();
				isDirect = false;
			}
			if (!nextVertex.getVisited() && edge.getCurrentStream() < edge.getMaxStream()) {
				int stream = findMaxStream(nextVertex, endVertex, Math.min(maxStream, edge.getMaxStream() - edge.getCurrentStream()));
				if (stream > 0) {
					if (isDirect) {
						edge.setCurrentStream(edge.getCurrentStream() + stream);
					} else {
						edge.setCurrentStream(edge.getCurrentStream() - stream);
					}
					currentVertex.setVisited(false);
					return stream;
				}
			}
		}
		currentVertex.setVisited(false);
		return 0;
	}
}