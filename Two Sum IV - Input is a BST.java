//Two Sum IV - Input is a BST
//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

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
    public boolean findTarget1(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return preorder(root, k, set);
    }
    
    public boolean preorder(TreeNode root, int k, HashSet<Integer> set){
        if(root == null){
            return false;
        }
        
        int comp = k - root.val;
        
        if(set.contains(comp)){
            return true;
        }
        set.add(root.val);
        return preorder(root.left, k, set) || preorder(root.right, k, set);
    }
    
    public boolean findTarget(TreeNode root, int k) {
        TreeNode root1 = root;
        TreeNode root2 = root;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        pushLeft(root1, s1);
        pushRight(root2, s2);
        
        while(!s1.isEmpty() && !s2.isEmpty()){
            if(s1.peek() == s2.peek()){
                return false;
            }       
            
            int sum = s1.peek().val + s2.peek().val;
            
            if(sum == k){
                return true;
            }
            else if(sum < k){
                pushLeft(s1.pop().right, s1);
            }
            else{
                pushRight(s2.pop().left, s2);
            }
        }
        
        return false;
    }
    
    public void pushLeft(TreeNode root, Stack<TreeNode> s){
        while(root != null){
            s.push(root);
            root = root.left;
        }
    }
    
    public void pushRight(TreeNode root, Stack<TreeNode> s){
        while(root != null){
            s.push(root);
            root = root.right;
        }
    }
}
