package Graphs.Problems;
import java.util.*;

// [Medium]: Network Delay Time. //https://leetcode.com/problems/network-delay-time/
// This solution is not running on leetcode uncomment ans then check
class Pair {
    int edge;
    int weight;
    
    Pair(int edge, int weight){
        this.edge = edge;
        this.weight = weight;
    }
}

public class NetworkDelay {
    HashMap<Integer, List<Pair>> adjency = new HashMap<>();
    public int networkDelayTime(int[][] times, int n, int k) {
        for(int i = 0; i<times.length; i++){
            if(adjency.get(times[i][0]) == null){
                adjency.put(times[i][0], new ArrayList<Pair>());
            }
            adjency.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }
        
        int ans[] = new int[n+1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        findMinimumPath(n, k, ans);
        int maxValue = 0;
        Set<Integer> keys = adjency.keySet();
        
        for(int i=1; i<ans.length; i++){
            if(ans[i] == Integer.MAX_VALUE){
                return -1;
            } else {
                maxValue = Math.max(ans[i], maxValue);
            }
        }
        
        return maxValue;
    }
    
    void findMinimumPath(int n, int k, int[] ans){
        Queue<Integer> q = new LinkedList<>();
        //PriorityQueue<Integer> queue = new PriorityQueue<Integer> ((a, b) -> weight[a] - weight[b]); --> Use pair
        q.add(k);
        ans[k] = 0;
        
        while(!q.isEmpty()){
            int current = q.peek();
            q.remove();
            
            List<Pair> pairs = adjency.get(current);
            if(pairs == null || pairs.size()==0){
                continue;
            }
            for(Pair pair: pairs){
                if(ans[pair.edge] > pair.weight + ans[current]){
                    ans[pair.edge] = pair.weight + ans[current];
                }
                q.add(pair.edge);
            }
        }
        
    }
}
