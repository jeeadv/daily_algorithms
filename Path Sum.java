//Path Sum
//https://leetcode.com/problems/path-sum/

//top down approach with recursion
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
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root == null){
    		return false;
    	}
    	if(root.left == null && root.right == null){
            if(root.val == sum){
                return true;
            }
            else{
                return false;
            }
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

//top down approach with BFS iterative
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
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root == null){
    		return false;
    	}
    	
    	Queue<TreeNode> q = new LinkedList<>();
    	q.add(root);
    	
    	while(!q.isEmpty()){
    		TreeNode top = q.poll();
    		if(top.left == null && top.right == null){
    			if(top.val == sum){
    				return true;
    			}
    		}
    		
    		if(top.left != null){
    			top.left.val += top.val;
    			q.add(top.left);
    		}
    		if(top.right != null){
    			top.right.val += top.val;
    			q.add(top.right);
    		}
    		
    	}
        return false;
    }
}

/*
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
*/

/*
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
*/
