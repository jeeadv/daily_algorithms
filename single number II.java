//single number II
//https://leetcode.com/problems/single-number-ii/

// bit

class Solution {
    public int singleNumber(int[] nums) {
        int[] arr = new int[32];
        
        for(int num: nums) {
            for(int i = 0; i < 32; ++i) {
                if((num & 1) == 1) {
                    ++arr[i];
                }
                num >>= 1;
            }
        }
        int res = 0;
        int prod = 1;
        for(int i = 0; i < 32; ++i) {
            if(arr[i] % 3 == 1) {
                res += prod;
            }
            prod *= 2;
        }
        return res;
    }
}

//hashmap
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for(int i: nums) {
            if(map.get(i) == 1) {
                return i;
            }
        }
        return -1;
    }
}
