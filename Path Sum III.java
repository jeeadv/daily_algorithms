//Path Sum III
//https://leetcode.com/problems/path-sum-iii/

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
    int ans = 0;
    public int pathSum(TreeNode root, int sum) {
        List<Integer> list = new LinkedList<>();
        ans = 0;
        fun(root, sum, list);
        return ans;
    }
    
    public void fun(TreeNode root, int sum, List<Integer> list){
        if(root == null){
            return;
        }
        
        list.add(root.val);
        
        fun(root.left, sum, list);
        fun(root.right, sum, list);
        
        int arrSum = 0;
        for(int i=list.size()-1;i>=0;i--){
            arrSum += list.get(i);
            if(arrSum == sum){
                ans++;
            }
            //System.out.println(arrSum);
        }
        
        
        list.remove(list.size() - 1);
    }
}
// another O(n^2) approach
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
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        return fun(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    public int fun(TreeNode root, int sum){
        if(root == null){
            return 0;
        }
        
        int ans = 0;
        if(root.val == sum){
            ans += 1;
        }
        return ans + fun(root.left, sum - root.val) + fun(root.right, sum - root.val);
    }
}
