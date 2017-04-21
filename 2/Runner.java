import java.util.Random;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Runner {

	public static final int MAX_WEIGHT = 6;
	public static final int AMOUNT_OF_VERTEX = 5;

	public static void main(String args[]) {
		List<Edge> graph = createGraph2();
		System.out.println("Graph before sort:");
		graph.forEach(Edge::print);
		//System.out.println("Graph after sort:");
		Collections.sort(graph);
		//graph.forEach(Edge::print);

		int[] marks = new int[AMOUNT_OF_VERTEX];
		int nextMark = 1;
		List<Edge> result = new ArrayList();
		for (Edge edge : graph) {
			if (marks[edge.getVertex1()] == marks[edge.getVertex2()]) {
				if (marks[edge.getVertex1()] == 0) {
					marks[edge.getVertex1()] = nextMark;
					marks[edge.getVertex2()] = nextMark;
					nextMark ++;
					result.add(edge);
				}
				else {
					System.out.println("We cann't add edge from " + edge.getVertex1() + " to " + edge.getVertex2());
				}
			}
			else {
				if (marks[edge.getVertex1()] == 0) {
					marks[edge.getVertex1()] = marks[edge.getVertex2()];
				}
				else if (marks[edge.getVertex2()] == 0) {
					marks[edge.getVertex2()] = marks[edge.getVertex1()];
				}
				else {
					int oldMark = marks[edge.getVertex2()];
					int newMark = marks[edge.getVertex1()];
					for (int i = 0; i < AMOUNT_OF_VERTEX; i++) {
						if (marks[i] == oldMark) {
							marks[i] = newMark;
						}
					}
				}
				result.add(edge);
			}
			if (result.size() + 1 == AMOUNT_OF_VERTEX) {
				break;
			}
		}
		System.out.println("Result:");
		result.forEach(Edge::print);
		System.out.println("Hello world");
	}

	public static List<Edge> createGraph(int n) { // generate random graph
		List<Edge> result = new ArrayList();
		Random random = new Random();
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				result.add(new Edge(i, j, random.nextInt(MAX_WEIGHT) + 1));
			}
		}
		return result;
	}

	public static List<Edge> createGraph2() { // 5 vertex
		List<Edge> result = new ArrayList();
		result.add(new Edge(0, 1, 3));
		result.add(new Edge(0, 4, 1));
		result.add(new Edge(1, 2, 5));
		result.add(new Edge(1, 4, 4));
		result.add(new Edge(2, 3, 2));
		result.add(new Edge(2, 4, 6));
		result.add(new Edge(3, 4, 7));
		return result;
	}
}