

public class Edge implements Comparable<Edge>{
	private int vertex1;
	private int vertex2;
	private int weight;

	public Edge(int vertex1, int vertex2, int weight) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = weight;
	}

	public int getVertex1() {
		return vertex1;
	}

	public void setVertex1(int vertex1) {
		this.vertex1 = vertex1;
	}

	public int getVertex2() {
		return vertex2;
	}

	public void setVertex2(int vertex1) {
		this.vertex2 = vertex2;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int compareTo(Edge edge) {
		return Integer.compare(getWeight(), edge.getWeight());
	}

	public String toString() {
		return "I'm edge from " + vertex1 + " to " + vertex2 + " with weight " + weight;
	}

	public void print() {
		System.out.println(this);
	}
}