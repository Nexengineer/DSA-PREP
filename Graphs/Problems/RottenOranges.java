package Graphs.Problems;
import java.awt.Point;
import java.util.*;
// Rotting Oranges: https://leetcode.com/problems/rotting-oranges/
public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<Point> queue = new LinkedList<>();
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int rows = grid.length;
        int column = grid[0].length;
        
        for(int r = 0; r<rows; r++){
            for(int c=0; c<column; c++){
                if(grid[r][c] == 1){
                    fresh++;
                }
                
                if(grid[r][c] == 2){
                    queue.add(new Point(r,c));
                }
            }
        }
        int time = 0;
        while(!queue.isEmpty() && fresh != 0){
            time++;
            for(int i = 0; i<queue.size(); i++){
                Point currentNode = queue.poll();
                for(int[] path: directions){
                int r = currentNode.x + path[0];
                int c = currentNode.y + path[1];
                if(r < rows 
                   && r>=0
                   && c>=0
                   && c < column
                   && grid[r][c] == 1){
                        grid[r][c] = 2;
                        fresh--;
                        queue.offer(new Point(r, c));
                    }
                }
            }
        }
        
        return fresh == 0 ? time: -1;
    }
}
