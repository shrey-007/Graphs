package pepcoding;

import java.util.*;

public class Graph {
    private int V; // Number of vertices
    private ArrayList<Edge>[] adjList; // Adjacency list representation of graph

    public int getV() {
        return V;
    }

    public ArrayList<Edge>[] getAdjList() {
        return adjList;
    }

    // Inner class to represent an edge with a weight
    public class Edge {
        int destination;
        int weight;

        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Constructor
    Graph(int v) {
        V = v;
        adjList = new ArrayList[v];
        for (int i = 0; i < v; ++i)
            adjList[i] = new ArrayList<>();
    }

    // Function to add an edge into the graph
    void addEdge(int source, int destination, int weight) {
        adjList[source].add(new Edge(destination, weight)); // Add destination with weight to source's list
        adjList[destination].add(new Edge(source, weight)); // For undirected graph, add source with weight to destination's list as well
    }

    // Function to print the adjacency list representation of graph
    void printGraph() {
        for (int i = 0; i < V; ++i) {
            System.out.println("Adjacency list of vertex " + i);
            System.out.print(i);
            for (Edge edge : adjList[i])
                System.out.print(" -> (" + edge.destination + ", " + edge.weight + ")");
            System.out.println("\n");
        }
    }

    // Function to take input from user to add vertices and edges
    void takeInput() {
        Scanner scanner = new Scanner(System.in);

        // Taking number of vertices as input
        System.out.print("Enter the number of vertices: ");
        int numOfVertices = scanner.nextInt();

        // Creating graph with given number of vertices
        Graph graph = new Graph(numOfVertices);

        // Taking edges as input
        System.out.print("Enter the number of edges: ");
        int numOfEdges = scanner.nextInt();
        System.out.println("Enter edges (source destination weight): ");
        for (int i = 0; i < numOfEdges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.addEdge(source, destination, weight);
        }

        // Printing the graph
        graph.printGraph();
    }

    public static void main(String args[]) {
        Graph graph = new Graph(4); // Creating a graph with 4 vertices
        graph.takeInput(); // Taking input from user
    }
}

