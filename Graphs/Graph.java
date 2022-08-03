package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {
    private Map<Integer, ArrayList<Integer>> adjencyList;

    Graph () {
        adjencyList = new HashMap<>();
    }

    public void addNode(int value) {
        adjencyList.putIfAbsent(value, new ArrayList<>());
    }

    public void removeNode(int value, boolean isBiDirectional) {
        if (adjencyList.get(value) != null){
            if (isBiDirectional){
                adjencyList.values().stream().forEach(e -> e.remove(value));
            }
            adjencyList.get(value).clear();
            adjencyList.remove(value);
        }
    }

    public void addEdges(int source, int destination, boolean isBiDirectional) {
        if (adjencyList.get(source) == null || adjencyList.get(destination) == null){
            System.out.println("Source or Destination is not present in the graph");
            return;
        }

        adjencyList.get(source).add(destination);
        if(isBiDirectional){
            adjencyList.get(destination).add(source);
        }
    }

    public void removeEdge(int source, int destination, boolean isBiDirectional){
        if(adjencyList.get(source) == null || adjencyList.get(destination) == null){
            System.out.println("Source or destination is not present in the graph");
            return;
        }
        if(isBiDirectional){
            adjencyList.get(destination).remove(source);
        }
        adjencyList.get(source).remove(destination);
    }

    public void printGraph(){
        Set<Integer> allKeys = adjencyList.keySet();
        allKeys.stream().forEach(obj -> System.out.println("Node: " + obj + " AdjencyList: " + adjencyList.get(obj)));
    }

    public void doDFSRecursive(int at, List<Integer> visited) {
        if (visited.contains(at)){
            return;
        }
        visited.add(at);
        System.out.println(at);
        adjencyList.get(at).stream().forEach(e -> doDFSRecursive(e, visited));
    }

    public void doDFSIterative(int at){
        List<Integer> visited = new ArrayList<Integer>();
        Stack<Integer> history = new Stack<>();
        history.push(at);
        while(!history.isEmpty()){
            int node = history.pop();
            visited.add(node);
            // System.out.println(node);
            System.out.println(visited);
            adjencyList.get(node).forEach(e -> {
                if(!visited.contains(e))
                    history.push(e);
            });
            // System.out.println(history);
        }
    }

    public void doBFS(int start){
        List<Integer> visited = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<Integer>();
        visited.add(start);
        queue.add(start);
        while(!queue.isEmpty()){
            int node = queue.poll();
            System.out.println(node);
            adjencyList.get(node).stream().forEach(e -> {
                if(!visited.contains(e)){
                    visited.add(e);
                    queue.add(e);
                }
            });
        }
    }
}
