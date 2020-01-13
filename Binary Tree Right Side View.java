//Binary Tree Right Side View
//https://leetcode.com/problems/binary-tree-right-side-view/

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root == null){
            return list;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int n = q.size();
            
            for(int i = 0; i < n; i++){
                TreeNode top = q.poll();
                
                if(top.left != null){
                    q.add(top.left);
                }
                if(top.right != null){
                    q.add(top.right);
                }
                
                if(i == n-1){
                    list.add(top.val);
                }
            }
        }
        return list;
    }
}
