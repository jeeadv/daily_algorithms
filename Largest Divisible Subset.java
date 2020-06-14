//Largest Divisible Subset
//https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3359/

class Solution {
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        
        int[] lis = new int[nums.length];
        lis[0] = 1;
        List<Integer>[] array = new ArrayList[nums.length];
        array[0] = new ArrayList<>();
        array[0].add(nums[0]);
        
        for(int i = 1; i < nums.length; i++) {
            int max = 1;
            int maxIndex = -1;
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0) {
                    if(lis[j] + 1 > max) {
                        max = lis[j] + 1;
                        maxIndex = j;
                    }
                }
            }
            lis[i] = max;
            array[i] = new ArrayList<>();
            if(maxIndex != -1)
                array[i] = new ArrayList<>(array[maxIndex]);
            array[i].add(nums[i]);
        }
        int max = 0;
        int maxIndex = 0;
        for(int i = 0; i < lis.length; i++) {
            if(lis[i] > max) {
                max = lis[i];
                maxIndex = i;
            }
        }
        return array[maxIndex];
    }
}
