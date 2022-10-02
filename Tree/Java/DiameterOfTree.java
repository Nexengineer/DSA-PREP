package Tree;

class Height {
    int h;
}

public class DiameterOfTree {
    public int calculateDiameter(Node node, Height height){ 
        if(node == null){
            return 0;
        }
        
        int lDiameter = calculateDiameter(node.leftChild, height);
        int rDiameter = calculateDiameter(node.rightChild, height);
        
        int maxheight = lDiameter+rDiameter;
        height.h = Math.max(height.h, maxheight);
        
        return Math.max(lDiameter, rDiameter)+1;
    }
    
    public int diameterOfBinaryTree(Node root) {
        Height h = new Height();
        calculateDiameter(root, h);
        return h.h;
    }
}
