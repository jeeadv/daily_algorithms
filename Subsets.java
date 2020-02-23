//Subsets
//https://leetcode.com/problems/subsets/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> topList =  new LinkedList<>();
        
        fun(nums, topList, new LinkedList<Integer>(), 0);
        return topList;
    }
    
    public void fun(int[] nums, List<List<Integer>> topList, List<Integer> list, int n){
        if(n == nums.length){
            topList.add(list);
            return;
        }
        List<Integer> newList = new LinkedList<>(list);
        fun(nums, topList, list, n + 1);
        newList.add(nums[n]);
        fun(nums, topList, newList, n + 1);   
    }
}
