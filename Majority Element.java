//Majority Element
//https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3321/

//hashmap solution

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int maxe = 0;
        
        for(int i: nums) {
            Integer j = map.get(i);
            
            if(j == null) {
                map.put(i, 1);
                if(1 > max) {
                    max = 1;
                    maxe = i;
                }
            }
            else {
                map.put(i, j + 1);
                if(j + 1 > max) {
                    max = j + 1;
                    maxe = i;
                }
            }
        }
        return maxe;
    }
}

// moore's voting algorithm

class Solution {
    public int majorityElement(int[] nums) {
        
        int candidate = nums[0];
        int count = 1;
        
        for(int i = 1; i < nums.length; i++) {
            
            if(nums[i] == candidate) {
                count++;
            }
            else {
                if(count > 0) {
                    count--;
                }
                else {
                    count = 1;
                    candidate = nums[i];
                }
            }
        }
        
        return candidate;
    }
}
