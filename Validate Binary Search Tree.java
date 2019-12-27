//Validate Binary Search Tree
//https://leetcode.com/problems/validate-binary-search-tree/

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
    public boolean isValidBST(TreeNode root) {
        return inorderIterative(root);
    }
    public boolean inorderIterative(TreeNode root){
        if(root == null){
            return true;
        }
        Integer prev = null;
        Stack<TreeNode> stack = new Stack<>();
    
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode top = stack.pop();
            if(prev != null && top.val <= prev){
                return false;
            }
            prev = top.val;
            root = top.right;
        }
        return true;
    }
    public boolean inorderRecursive(TreeNode root, Integer[] prev){
        if(root == null){
            return true;
        }
        
        if(!inorderRecursive(root.left, prev)){
            return false;
        }
        
        if(prev[0] != null && root.val <= prev[0]){
            return false;
        }
        prev[0] = root.val;
        
        return inorderRecursive(root.right, prev);
    }
    public boolean preorderIterative(TreeNode root, Integer min, Integer max){
        if(root == null){
            return true;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(root, null, null));
        while(!stack.isEmpty()){
            Node top = stack.pop();
            if(top.min != null && top.node.val <= top.min){
                return false;
            }
            if(top.max != null && top.node.val >= top.max){
                return false;
            }
            if(top.node.left != null){
                stack.push(new Node(top.node.left, top.min, top.node.val));
            }
            if(top.node.right != null){
                stack.push(new Node(top.node.right, top.node.val, top.max));
            }
        }
        return true;
    }
    public boolean preorderRecursive(TreeNode root, Integer min, Integer max){
        if(root == null){
            return true;
        }
        
        if(min != null && root.val <= min){
            return false;
        }
        
        if(max != null && root.val >= max){
            return false;
        }
        
        return preorderRecursive(root.left, min, root.val) && preorderRecursive(root.right, root.val, max);
        
    }
}
class Node{
    TreeNode node;
    Integer min;
    Integer max;
    Node(TreeNode node, Integer min, Integer max){
        this.node = node;
        this.min = min;
        this.max = max;
    }
}
