package Graphs.Problems;
import java.awt.*;
import java.util.*;
// [Medium]: Max Area of Island : https://leetcode.com/problems/max-area-of-island/
public class MaxIslandNode {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int rCount = grid.length;
        int cCount = grid[0].length;
        
        int maxCount = 0;
        int[][] visited = new int[rCount][cCount];
        
        for(int i=0 ;i<rCount; i++){
            for(int j=0; j<cCount; j++){
                if(grid[i][j] == 1 && visited[i][j] != 1){
                    int newCount = doBFS(grid, i, j, visited);
                    maxCount = Math.max(newCount, maxCount);
                }
            }
        }
        return maxCount;
    }
    
    public int doBFS(int[][] grid, int r, int c, int[][] visited){
        if(visited[r][c] == 1){
            return 0;
        }
        
        int counter = 0;
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r,c));
        while(!q.isEmpty()){
            Point current = q.remove();
            visited[current.x][current.y] = 1;
            for(int i=0; i<directions.length; i++){
                int[] direction = directions[i];
                int rp = current.x+direction[0];
                int cp = current.y+direction[1];
                
                if(rp<visited.length 
                   && rp>=0 && cp>=0 
                   && cp<visited[0].length 
                   && visited[rp][cp] != 1 
                   && grid[rp][cp] == 1)
                {
                    visited[rp][cp] = 1;
                    counter++;
                    q.add(new Point(rp, cp));
                }
            }
        }
        
        return counter+1;
    }
}
