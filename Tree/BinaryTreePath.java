package Tree;
import java.util.*;
public class BinaryTreePath {
    public Node calculatePath(Node node, String path, List<String> paths){
        if(node == null){
            return null;
        }
        if(path == ""){
           path = path + String.valueOf(node.data); 
        } else {
            path = path + "->" + String.valueOf(node.data);
        }
        
        if(node.leftChild == null && node.rightChild == null){
            paths.add(path);
        }else{
            calculatePath(node.leftChild, path, paths);
            calculatePath(node.rightChild, path, paths);
        }
        return node;
    }
    
    public List<String> binaryTreePaths(Node root) {
        List<String> result = new ArrayList<>();
        calculatePath(root,"", result);
        return result;
    }
}
