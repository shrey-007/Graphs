package pepcoding;

import java.util.ArrayList;

// You are given an undirected weigted graph and a source and a destination vertex.
// Tell whether there is a path between source and destination vertex
public class HasPath {

    public static boolean hasPath(Graph graph,int source,int destination,int [] visited){

        // if source and destination are same then return true(base case)
        if (source==destination){return true;}

        visited[source]=1;

        // find whether we can go to destination by source's neighbours
        ArrayList<Graph.Edge> neighbours=graph.getAdjList()[source];
        for(Graph.Edge edge:neighbours){
            if(visited[edge.destination]==0){
                boolean faith=hasPath(graph,edge.destination,destination,visited);
                if(faith==true){return true;}
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Graph graph=new Graph(7);
        graph.takeInput();

        int visited[]=new int[3];

        boolean ans=hasPath(graph,0,1,visited);
        System.out.println(ans);
    }

}
