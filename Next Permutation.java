//Next Permutation
//https://leetcode.com/problems/next-permutation/

class Solution {
    public void nextPermutation(int[] nums) {
        int r = nums.length - 2;
        
        while(r >= 0 && nums[r] >= nums[r + 1]) {
            r--;
        }
        
        if(r < 0) {
            Arrays.sort(nums);
        }
        else {
            int index = getNextMax(nums, r);
            swap(nums, r, index);
            Arrays.sort(nums, r + 1, nums.length);
        }
    }
    
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public int getNextMax(int[] nums, int index) {
        int minIndex = index + 1;
        for(int i = index + 1; i < nums.length; i++) {
            if(nums[i] > nums[index] && nums[i] < nums[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}
