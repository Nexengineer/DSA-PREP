import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinarySearchTree {
    public static void main(String[] args) {
        System.out.println("Hello ! this is the implementation of Binary search tree");
        BSTTreeNode root = BSTTreeNode.insertIntoBST(null, 4);
        BSTTreeNode.insertIntoBST(root, 22);
        BSTTreeNode.insertIntoBST(root, 11);
        BSTTreeNode.insertIntoBST(root, 34);
        BSTTreeNode.insertIntoBST(root, 23);
        BSTTreeNode.insertIntoBST(root, 45);
        BSTTreeNode.insertIntoBST(root, 12);

        System.out.println("---------->");
        BSTTreeNode.preOrderTraversal(root);

        System.out.println("---------->");
        BSTTreeNode.inOrderTraversal(root);

        System.out.println("---------->");
        BSTTreeNode.postOrderTraversal(root);

        System.out.println("---------->");
        BSTTreeNode.levelOrderTraversal(root);

        System.out.println("---------->");
        System.out.println(BSTTreeNode.heightOfTree(root));

        System.out.println("---------->");
        List<BSTTreeNode> leafNodes = new ArrayList<>();
        leafNodes = BSTTreeNode.findLeafNode(root, leafNodes);

        for (BSTTreeNode node : leafNodes) {
            System.out.println(node.data);
        }

        System.out.println("---------->");
        System.out.println(BSTTreeNode.findDiameterOfBST(root));
    }

    private static class BSTTreeNode {
        int data;
        BSTTreeNode leftNode;
        BSTTreeNode rightNode;

        BSTTreeNode(BSTTreeNode left, BSTTreeNode right, int data) {
            this.data = data;
            this.leftNode = left;
            this.rightNode = right;
        }

        // Below method is for adding to the BST
        public static BSTTreeNode insertIntoBST(BSTTreeNode node, int data) {
            if (node == null) {
                return new BSTTreeNode(null, null, data);
            }
            if (data < node.data) {
                node.leftNode = insertIntoBST(node.leftNode, data);
            } else {
                node.rightNode = insertIntoBST(node.rightNode, data);
            }
            return node;
        }

        public static void preOrderTraversal(BSTTreeNode node) {
            if (node != null) {
                System.out.print(node.data + ",");
                preOrderTraversal(node.leftNode);
                preOrderTraversal(node.rightNode);
            }
        }

        public static void inOrderTraversal(BSTTreeNode node) {
            if (node != null) {
                inOrderTraversal(node.leftNode);
                System.out.print(node.data + ",");
                inOrderTraversal(node.rightNode);
            }
        }

        public static void postOrderTraversal(BSTTreeNode node) {
            if (node != null) {
                postOrderTraversal(node.leftNode);
                postOrderTraversal(node.rightNode);
                System.out.print(node.data + ",");
            }
        }

        public static void levelOrderTraversal(BSTTreeNode root) {
            BSTTreeNode currentNode;
            Queue<BSTTreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                currentNode = queue.remove();
                System.out.print(currentNode.data + ",");
                if (currentNode.leftNode != null) {
                    queue.add(currentNode.leftNode);
                }

                if (currentNode.rightNode != null) {
                    queue.add(currentNode.rightNode);
                }
            }
        }

        public static int heightOfTree(BSTTreeNode node) {
            if (node == null) {
                return 0;
            }
            int leftHeight = heightOfTree(node.leftNode);
            int rightHeight = heightOfTree(node.rightNode);
            return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
        }

        public static List<BSTTreeNode> findLeafNode(BSTTreeNode root, List<BSTTreeNode> leafNodes){
            if(root.rightNode == null && root.leftNode == null){
                leafNodes.add(root);
                return leafNodes;
            }

            if(root.leftNode != null){
                findLeafNode(root.leftNode, leafNodes);
            }

            if(root.rightNode != null){
                findLeafNode(root.rightNode, leafNodes);
            }

            return leafNodes;
        }

        public static int findDiameterOfBST(BSTTreeNode root){
            if(root == null){
                return 0;
            }
            int leftHeight = heightOfTree(root.leftNode);
            int rightHeight = heightOfTree(root.rightNode);

            int leftDiameter = findDiameterOfBST(root.leftNode);
            int rightDiameter = findDiameterOfBST(root.rightNode);

            var totalHeight = leftHeight + rightHeight + 1;
            if(leftDiameter > rightDiameter){
                return Math.max(totalHeight, leftDiameter);
            } else {
                return Math.max(totalHeight, rightDiameter);
            }
        }
    }
}

