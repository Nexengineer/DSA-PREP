/* Important things to remember 
    1) Binary heap is well balanced binary tree
            (P)
           /   \
         (L)   (R)
    2) Binary heap is of 2 types where min heap and max heap
        MinHeap -----> (P)<=(L)&(R)
        MaxHeap -----> (P)>=(L)&(R)
    3) In array representation of binary heap we have a simple formula for 
        If parent node is derived from: Array[(i-1)/2]
        left node will be at: Array[(2*i)+1]
        right node will be at: Array[(2*i)+2]
    4) All the operation will be done at left side of the node
*/
class BinaryHeap {
    
}
