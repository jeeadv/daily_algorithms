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

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        //System.out.println(Arrays.toString(citations));
        int n = citations.length;
        int max = 0;
        int l = 0;
        int r = n - 1;
        
        while(l <= r) {
            int mid = (l + r) / 2;
            int val = Math.min(citations[mid], n - mid);
            //System.out.println(citations[mid] + " " + (n - mid));
            //System.out.println(l + " " + r + " " + mid + " " + val);
            max = Math.max(max, Math.min(citations[mid], n - mid));
            if(citations[mid] <= (n - mid)) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return max;
    }
}
