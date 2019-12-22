//Cousins in Binary Tree
//https://leetcode.com/problems/cousins-in-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int xLevel = -1;
    int yLevel = -1;
    TreeNode xParent = null;
    TreeNode yParent = null;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        xLevel = -1;
        yLevel = -1;
        xParent = null;
        yParent = null;
        
        fun(root, x, y, null, 0);
        
        if(xLevel != -1 && yLevel != -1){
            if(xLevel == yLevel && xParent != yParent){
                return true;
            }
        }
        return false;
    }
    
    public void fun(TreeNode root, int x, int y, TreeNode parent, int level){
        if(root == null){
            return;
        }
        
        if(root.val == x){
            xLevel = level;
            xParent = parent;
        }
        
        if(root.val == y){
            yLevel = level;
            yParent = parent;
        }
        
        fun(root.left, x, y, root, level+1);
        fun(root.right, x, y, root, level+1);
    }
}
