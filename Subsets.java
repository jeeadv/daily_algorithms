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
//iterative

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> topList =  new LinkedList<>();
        
        for(int i = 0; i < Math.pow(2, nums.length); i++){
            fun(i, topList, nums);
        }
        return topList;
    }
    
    public void fun(int n, List<List<Integer>> topList, int[] nums){
        String s = IntegertoBinaryString(n, nums.length);
        //System.out.println(s);
        List<Integer> list = new LinkedList<>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                list.add(nums[i]);
            }
        }
        
        topList.add(list);
    }
    
    public String IntegertoBinaryString(int num, int n){
        String str = "";
        for(int i = 1; i <= n; i++){
            if((num & 1) == 1){
                str = '1' + str;
            }
            else{
                str = '0' + str;
            }
            num >>= 1;
        }
        return str;
    }
}
