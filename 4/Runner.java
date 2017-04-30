public class Runner {
	public static void main(String args[]) {
		Graph graph = new Graph(6);
		graph.addEdge(0, 1, 3);
		graph.addEdge(1, 2, 3);
		graph.addEdge(2, 3, 2);
		graph.addEdge(4, 3, 3);
		graph.addEdge(5, 4, 2);
		graph.addEdge(0, 5, 3);
		graph.addEdge(1, 5, 2);
		graph.addEdge(2, 4, 4);

		int maxStream = graph.findMaxStream(0, 3);
	}
}