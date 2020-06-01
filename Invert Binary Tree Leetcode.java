//Invert Binary Tree
//https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3347/

//preorder
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        
        return root;
    }
}

// postorder

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        root.left = right;
        root.right = left;
        
        return root;
    }
}
