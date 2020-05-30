//Longest Increasing Subsequence
//https://leetcode.com/problems/longest-increasing-subsequence/

//brute force
class Solution {
    int globalMax = 0;
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        globalMax = 0;
        lis(nums.length - 1, nums);
        return globalMax;
    }
    
    public int lis(int n, int[] nums) {
        int max = 0;
        for(int i = 0; i < n; i++) {
            int length = lis(i, nums);
            if(nums[i] < nums[n]) {
                max = Math.max(max, length);
            }
        }
        if(globalMax < max + 1) {
            globalMax = max + 1;
        }
        return max + 1;
    }
}
