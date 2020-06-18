//H-Index II
//https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3364/
//https://leetcode.com/problems/h-index/submissions/

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, Math.min(citations[i],  n - i));
        }
        return max;
    }
}

