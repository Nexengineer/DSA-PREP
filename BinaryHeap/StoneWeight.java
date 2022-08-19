package BinaryHeap;
import java.util.*;

//[Easy]: Last Stone Weight => https://leetcode.com/problems/last-stone-weight/
public class StoneWeight {
    public int lastStoneWeight(int[] stones) {
        if(stones.length ==1){
            return stones[0];
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone: stones){
            heap.offer(stone);
        }
        
        while(heap.size() > 1){
            int stone1 = heap.poll();
            int stone2 = heap.poll();
            
            if(stone1 == stone2){
                continue;
            }else if(stone1<stone2){
                heap.offer(stone2-stone1);
            }else{
                heap.offer(stone1-stone2);
            }
        }
            
        return heap.size() != 0 ? heap.poll(): 0;
    }
}
