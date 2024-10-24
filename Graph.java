public class Graph {

    private Coordinate[] vertices;
    private double[][] adjacencyMatrix;
    private int numberOfVertices;

    public Graph(int totalVertices) {
        this.vertices = new Coordinate[totalVertices];
        this.adjacencyMatrix = new double[totalVertices][totalVertices];
        this.numberOfVertices = 0;

        // Initialize the adjacency matrix
        for (int i = 0; i < totalVertices; i++) {
            for (int j = 0; j < totalVertices; j++) {
                adjacencyMatrix[i][j] = Double.MAX_VALUE; // Use MAX_VALUE to represent no edge
            }
        }

    }

    // Method to add a vertex
    public void addVertex(double latitude, double longitude) {
        vertices[numberOfVertices] = new Coordinate(latitude, longitude);
        numberOfVertices++;
    }

    // Method to add an edge
    public void addEdge(int source, int destination, double weight) {
        adjacencyMatrix[source][destination] = weight;
        adjacencyMatrix[destination][source] = weight;
    }

    // Method to display the graph using the adjacency matrix
    public void displayGraph() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                if (adjacencyMatrix[i][j] == Double.MAX_VALUE) {
                    System.out.print("0   "); // No edge
                } else {
                    System.out.print(adjacencyMatrix[i][j] + "    ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5); // Create a graph with a maximum of 5 vertices

        // Adding vertices with their coordinates
        graph.addVertex(40.7128, -74.0060); // chemistry depart
        graph.addVertex(34.0522, -118.2437); // Ubit
        graph.addVertex(41.8781, -87.6298); // silver jubliee gate
        graph.addVertex(29.7604, -95.3698); // pharmacy
        graph.addVertex(39.7392, -104.9903); // mathematics

        // Adding edges (source, destination, weight)
        graph.addEdge(0, 1, 6);
        graph.addEdge(0, 2, 5);
        graph.addEdge(1, 2, 7);
        graph.addEdge(2, 3, 10);
        graph.addEdge(3, 4, 11);

        // Display the graph
        graph.displayGraph();
    }

}