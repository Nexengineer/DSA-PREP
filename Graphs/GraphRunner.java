package Graphs;

import java.util.ArrayList;

public class GraphRunner {
    // public static void main(String [] args){
    //     runGraphSimpleGraph();
    // }

    public static void runGraphSimpleGraph(){
        System.out.println("Inside Run Simple Graph");
        System.out.println("------------------------------");
        Graph graph = new Graph();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addNode(6);
        graph.printGraph();

        System.out.println("------------------------------");
        graph.addEdges(1, 2, true);
        graph.addEdges(1, 3, true);
        graph.addEdges(3, 6, true);
        graph.addEdges(3, 5, true);
        graph.addEdges(5, 4, true);
        graph.addEdges(6, 4, true);
        graph.printGraph();

        System.out.println("------------------------------");
        graph.doDFSRecursive(1, new ArrayList<>());
        System.out.println("------------------------------");
        graph.doDFSIterative(1);
        System.out.println("------------------------------");
        graph.doBFS(1);
    }
}
