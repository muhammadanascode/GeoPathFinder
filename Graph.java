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
        Graph graph = new Graph(8); // Create a graph with a maximum of 5 vertices

        // Adding vertices with their coordinates
        graph.addVertex(24.930897, 67.118166); // Silver jubliee gate
        graph.addVertex(24.935883, 67.120274); // road intersection at criminology department
        graph.addVertex(24.937434, 67.119073); // road intersection at dean faculty
        graph.addVertex(24.939253, 67.118011); // road intersection at microbiology
        graph.addVertex(24.940883, 67.117050); // road intersection at staff club
        graph.addVertex(24.934653, 67.105672); // Maskan Gate
        graph.addVertex(24.943258, 67.122034); // road intersection at point terminal
        graph.addVertex(24.940422, 67.123675); // road intersection at geography department

        // Adding edges (source, destination, weight)
        graph.addEdge(0, 1, 5);
        graph.addEdge(1, 2, 4);
        graph.addEdge(2, 3, 3);
        graph.addEdge(3, 4, 3);
        graph.addEdge(4, 5, 8);
        graph.addEdge(4, 6, 7);
        graph.addEdge(6, 7, 4);
        graph.addEdge(7, 3, 4);

        // Display the graph
        graph.displayGraph();
    }

}