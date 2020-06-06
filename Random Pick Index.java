//Random Pick Index
//https://leetcode.com/problems/random-pick-index/

class Solution {
    int[] arr;
    Random random = new Random();
    
    Map<Integer, List<Integer>> map;
    
    public Solution(int[] nums) {
        map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            List<Integer> list = map.get(nums[i]);
            if(list == null) {
                list = new ArrayList<>();
            }
            list.add(i);
            map.put(nums[i], list);
        }
    }
    
    public int pick(int target) {
        List<Integer> list = map.get(target);
        int index = random.nextInt(list.size());
        
        return list.get(index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
