//Binary Tree Postorder Traversal
//https://leetcode.com/problems/binary-tree-postorder-traversal/

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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        
        if(root == null){
            return list;
        }
        
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        
        while(!s.isEmpty()){
            TreeNode top = s.pop();
            list.addFirst(top.val);
            
            if(top.left != null){
                s.push(top.left);
            }
            
            if(top.right != null){
                s.push(top.right);
            }
        }
        
        return list;
    }
}
