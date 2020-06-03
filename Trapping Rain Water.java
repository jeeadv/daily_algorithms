//Trapping Rain Water
//https://leetcode.com/problems/trapping-rain-water/

// dp O(n) O(n)
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

// two pointer O(n) O(1)
class Solution {
    public int trap(int[] height) {
        
        if(height.length < 3) {
            return 0;
        }
        
        int leftMax = 0;
        int rightMax = 0;
        
        int l = 0;
        int r = height.length - 1;
        int res = 0;
        while(l <= r) {
            
            leftMax = Math.max(leftMax, height[l]);
            rightMax = Math.max(rightMax, height[r]);
            
            if(height[l] <= height[r]) {
                res += Math.min(leftMax , rightMax) - height[l];
                l++;
            }
            else {
                res += Math.min(leftMax , rightMax) - height[r];
                r--;
            }
        }
        
        return res;
    }
}
