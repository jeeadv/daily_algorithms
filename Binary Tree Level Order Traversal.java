//Binary Tree Level Order Traversal
//https://leetcode.com/problems/binary-tree-level-order-traversal/
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        fun(root, 0, list);
        return list;
    }
    
    public void fun(TreeNode root, int level, List<List<Integer>> list){
        if(root == null){
            return;
        }
        System.out.println(list);
        if(list.size() == level){
            list.add(new LinkedList<>());
        }
        list.get(level).add(root.val);
        
        fun(root.left, level + 1, list);
        fun(root.right, level + 1, list);
    }
}


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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        
        if(root == null){
            return list;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> subList = new LinkedList<>();
            int n = q.size();
            for(int i=0;i<n;i++){
                TreeNode top = q.poll();
                subList.add(top.val);
                if(top.left != null)
                    q.add(top.left);
                if(top.right != null)
                    q.add(top.right);
                
            }
            list.add(subList);
        }
        
        return list;
    }
}
