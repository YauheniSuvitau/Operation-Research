public class Edge {
	Vertex startVertex;
	Vertex endVertex;
	int maxStream;
	int currentStream;

	public Edge(Vertex startVertex, Vertex endVertex, int maxStream) {
		this.startVertex = startVertex;
		this.endVertex = endVertex;
		this.maxStream = maxStream;
		this.currentStream = 0;
	}

	public Vertex getStartVertex() {
		return startVertex;
	}

	public Vertex getEndVertex() {
		return endVertex;
	}

	public int getMaxStream() {
		return maxStream;
	}

	public void setCurrentStream(int currentStream) {
		this.currentStream = currentStream;
	}

	public int getCurrentStream() {
		return currentStream;
	}

	public void print() {
		System.out.println(startVertex.getNumber() + "-" + endVertex.getNumber() + " " + currentStream + "/" + maxStream + "\n");
	}
}