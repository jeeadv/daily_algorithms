//Maximum Width of Binary Tree
//https://leetcode.com/problems/maximum-width-of-binary-tree/

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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        preorder(root, 1);
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int globalMax = Integer.MIN_VALUE;
        
        while(!q.isEmpty()){
            int n = q.size();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                TreeNode top = q.poll();
                if(top.left != null){
                    q.add(top.left);
                }
                if(top.right != null){
                    q.add(top.right);
                }
                
                if(top.val < min){
                    min = top.val;
                }
                if(top.val > max){
                    max = top.val;
                }
            }
            if(max - min + 1> globalMax){
                globalMax = max - min + 1;
            }
        }
        return globalMax;
    }
    
    public void preorder(TreeNode root, int x){
        if(root == null){
            return;
        }
        
        root.val = x;
        
        preorder(root.left, 2*x);
        preorder(root.right, 2*x + 1);
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
    int max = 0;
    public int widthOfBinaryTree2(TreeNode root) {
        max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        preorder(root, 0, 1, map);
        return max;
    }
    
    public void preorder(TreeNode root, int level, int x, HashMap<Integer, Integer> map){
        if(root == null){
            return;
        }
        
        if(map.get(level) == null){
            map.put(level, x);
        }
        
        max = Math.max(max, x - map.get(level) + 1);
        
        preorder(root.left, level + 1, 2*x, map);
        preorder(root.right, level + 1, 2*x + 1, map);
    }
    
    public int widthOfBinaryTree1(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root, 1));
        
        int globalMax = Integer.MIN_VALUE;
        
        while(!q.isEmpty()){
            int n = q.size();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
                
            for(int i=0;i<n;i++){
                Node top = q.poll();
                int x = top.x;
                int val = x;
                
                if(val > max){
                    max = val;
                }
                if(val < min){
                    min = val;
                }
                
                if(top.node.left != null){
                    q.add(new Node(top.node.left, 2*x));
                }
                if(top.node.right != null){
                    q.add(new Node(top.node.right, 2*x + 1));
                }
            }
            if(max - min + 1 > globalMax){
                globalMax = max - min + 1;
            }
        }
        return globalMax;
    }
}
class Node{
    TreeNode node;
    int x;
    Node(TreeNode node, int x){
        this.node = node;
        this.x = x;
    }
}
