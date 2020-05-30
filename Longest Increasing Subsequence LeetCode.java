//Longest Increasing Subsequence
//https://leetcode.com/problems/longest-increasing-subsequence/
//https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
//https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/

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

// dp 

class Solution {
    int globalMax = 0;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        
        for(int i = 0; i < n; i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j])
                    max = Math.max(max, lis[j]);
            }
            lis[i] = max + 1;
        }
        
        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, lis[i]);
        }
        return max;
    }
}
