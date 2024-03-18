package pepcoding;

import java.util.ArrayList;

// You are given an undirected weigted graph and a source and a destination vertex.
// Tell whether there is a path between source and destination vertex
public class HasPath2 {

    public static boolean hasPath(Node source,Node destination,int [] visited){

        // if source and destination are same then return true(base case)
        if (source==destination){return true;}

        visited[source.value]=1;

        // find whether we can go to destination by source's neighbours
        ArrayList<Pair> neighbours=(ArrayList<Pair>) source.neibh;
        for(Pair pair:neighbours){
            if(visited[pair.node.value]==0){
                boolean faith=hasPath(pair.node,destination,visited);
                if(faith==true){return true;}
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Node node0=new Node(0);
        Node node1=new Node(1);
        Node node2=new Node(2);

        node0.neibh.add(new Pair(node1,10));


        int visited[]=new int[3];

        boolean ans=hasPath(node0,node2,visited);
        System.out.println(ans);
    }

}
