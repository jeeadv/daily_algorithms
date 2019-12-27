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
        return preorderIterative(root, null, null);
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
