//Trapping Rain Water
//https://leetcode.com/problems/trapping-rain-water/

class Solution {
    public int trap(int[] height) {
        
        if(height.length == 0) {
            return 0;
        }
        
        int[] prev = new int[height.length];
        int[] next = new int[height.length];
        
        prev[0] = height[0];
        for(int i = 1; i < height.length; i++) {
            prev[i] = Math.max(height[i], prev[i - 1]);
        }
        
        next[height.length - 1] = height[height.length - 1];
        for(int i = height.length - 2; i >= 0 ; i--) {
            next[i] = Math.max(height[i], next[i + 1]);
        }
        
        int res = 0;
        for(int i = 0; i < height.length; i++) {
            res += Math.min(prev[i], next[i]) - height[i];
        }
        
        return res;
    }
}
