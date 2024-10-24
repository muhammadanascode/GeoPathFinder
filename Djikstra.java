import java.util.Arrays;

class Djikstra {

    // Method to find the vertex with the minimum distance value
    private static int getMinimumVertex(boolean[] visited, double[] distance, int numberOfVertices) {
        double minDistance = Double.MAX_VALUE;
        int minVertex = -1;

        for (int i = 0; i < numberOfVertices; i++) {
            if (!visited[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minVertex = i;
            }
        }

        return minVertex;
    }

    // Method to implement Dijkstra's algorithm
    public static void dijkstra(double[][] adjacencyMatrix, int sourceVertex) {
        int numberOfVertices = adjacencyMatrix.length;
        boolean[] visited = new boolean[numberOfVertices];
        double[] distance = new double[numberOfVertices];
        int[] parents = new int[numberOfVertices];

        // Initialize distances and parents
        Arrays.fill(distance, Double.MAX_VALUE);
        Arrays.fill(parents, -1);
        distance[sourceVertex] = 0;

        // Find the shortest path for all vertices
        for (int i = 0; i < numberOfVertices - 1; i++) {
            int nearestVertex = getMinimumVertex(visited, distance, numberOfVertices);
            visited[nearestVertex] = true;

            // Update the distance value of the adjacent vertices of the picked vertex
            for (int vertex = 0; vertex < numberOfVertices; vertex++) {
                if (!visited[vertex] && adjacencyMatrix[nearestVertex][vertex] != Double.MAX_VALUE &&
                        distance[nearestVertex] + adjacencyMatrix[nearestVertex][vertex] < distance[vertex]) {
                    distance[vertex] = distance[nearestVertex] + adjacencyMatrix[nearestVertex][vertex];
                    parents[vertex] = nearestVertex;
                }
            }
        }
        printSolution(sourceVertex, distance, parents);

    }

    // Method to print the solution
    private static void printSolution(int sourceVertex, double[] distances, int[] parents) {
        int numberOfVertices = distances.length;
        System.out.println("Vertex\t\tDistance\tPath");

        for (int vertex = 0; vertex < numberOfVertices; vertex++) {
            if (vertex != sourceVertex) {
                System.out.print(sourceVertex + " -> ");
                System.out.print(vertex + "\t\t");
                System.out.print(distances[vertex] + "\t\t");
                System.out.println();
            }
        }
    }
}
