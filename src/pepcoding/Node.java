package pepcoding;

import java.util.ArrayList;
import java.util.List;

public class Node {
    int value;
    List<Pair> neibh;

    public Node(int value) {
        this.value = value;
        neibh=new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", neibh=" + neibh +
                '}';
    }
}
class Pair{
    Node node;
    int weight;

    public Pair(Node node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "node=" + node +
                ", weight=" + weight +
                '}';
    }
}
