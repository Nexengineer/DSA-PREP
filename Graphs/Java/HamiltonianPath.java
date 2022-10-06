package Graphs.Problems;

//[HARD] https://practice.geeksforgeeks.org/problems/hamiltonian-path2522/1
import java.awt.*;
import java.util.*;

public class HamiltonianPath {
    class Solution {
        ArrayList<ArrayList<Integer>> V;

        boolean dfs(int v, int[] label, int count, int N) {
            label[v] = 1;
            if (count == N)
                return true;

            for (int j = 0; j < V.get(v).size(); j++) {
                if (label[V.get(v).get(j)] == 0) {
                    if (dfs(V.get(v).get(j), label, count + 1, N))
                        return true;
                    label[V.get(v).get(j)] = 0;
                }
            }

            return false;
        }

        boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
            // code here
            V = new ArrayList<>();
            for (int i = 0; i <= N; i++)
                V.add(new ArrayList<>());

            for (ArrayList<Integer> i : Edges) {
                V.get(i.get(0)).add(i.get(1));
                V.get(i.get(1)).add(i.get(0));
            }

            int[] label = new int[15];

            for (int i = 1; i <= N; i++) {
                if (dfs(i, label, 1, N))
                    return true;
                label[i] = 0;
            }
            return false;
        }
    }

}
