import java.util.ArrayList;
import java.util.LinkedList;

public class Runner {
	public static final int AMOUNT_OF_VERTEX = 6;
	public static final int START_EDGE = 0;
	public static final int END_EDGE = 5;

	public static void main(String args[]) {
		Graph graph = new Graph(AMOUNT_OF_VERTEX);
		addEdgesToGraph(graph);

		int marks[] = new int[AMOUNT_OF_VERTEX];
		boolean visits[] = new boolean[AMOUNT_OF_VERTEX];

		for (int i = 0; i < AMOUNT_OF_VERTEX; i++) {
			if (i != START_EDGE) {
				marks[i] = Integer.MAX_VALUE;
			}
		}
		int currentMin = findMin(marks, visits);
		while (currentMin != -1) {
			LinkedList<Direct> directes = graph.getDirectes(currentMin);
			for (Direct direct : directes) {
				if (!visits[direct.getVertex()] && marks[currentMin] + direct.getWeight() < marks[direct.getVertex()]) {
					marks[direct.getVertex()] = marks[currentMin] + direct.getWeight();
				}
			}
			visits[currentMin] = true;
			currentMin = findMin(marks, visits);
		}

		for (int i = 0; i < AMOUNT_OF_VERTEX; i++) {
			System.out.println("Weight of vertex " + i + " is " + marks[i]);
		}

		int currentVertex = END_EDGE;
		
		while (currentVertex != START_EDGE) {
			LinkedList<Direct> directes = graph.getDirectes(currentVertex);
			for (Direct direct : directes) {
				if (marks[direct.getVertex()] + direct.getWeight() == marks[currentVertex]) {
					System.out.println(currentVertex);
					currentVertex = direct.getVertex();
					break;
				}
			}
		}
	}

	public static void addEdgesToGraph(Graph graph) {
		graph.addEdge(0, 1, 7);
		graph.addEdge(0, 2, 9);
		graph.addEdge(0, 5, 14);
		graph.addEdge(1, 2, 10);
		graph.addEdge(1, 3, 15);
		graph.addEdge(2, 3, 11);
		graph.addEdge(2, 5, 2);
		graph.addEdge(3, 4, 6);
		graph.addEdge(4, 5, 9);
	}

	public static int findMin(int marks[], boolean visits[]) {
		int minIndex = -1;
		int minValue = Integer.MAX_VALUE;
		for (int i = 0; i < AMOUNT_OF_VERTEX; i++) {
			if (!visits[i] && marks[i] < minValue) {
				minIndex = i;
				minValue = marks[i];
			}
		}
		return minIndex;
	}
}