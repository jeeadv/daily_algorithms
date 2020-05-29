//Continuous Tree
//https://www.geeksforgeeks.org/continuous-tree/



public static boolean isContinuousTree(Node root) {
    if(root == null) {
        return true;
    }
    
    boolean isContinuous = true;
    
    if(root.left != null) {
        isContinuous &= Math.abs(root.data - root.left.data) == 1;
    }
    
    if(root.right != null) {
        isContinuous &= Math.abs(root.data - root.right.data) == 1;
    }
    
    return isContinuous && isContinuousTree(root.left) && isContinuousTree(root.right);
}
