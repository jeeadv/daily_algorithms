//Unique Binary Search Trees
//https://leetcode.com/problems/unique-binary-search-trees/

//dp
class Solution {
    public int numTrees(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                arr[i] += arr[j] * arr[i - j - 1];
            }
        }
        
        return arr[n];
    }
}
//catalan

class Solution {
    public int numTrees(int n) {
        long res = 1;
        for(int i = 0; i < n; ++i) {
            res *= (2*n - i);
            res /= (i + 1);
        }
        res /= (n + 1);
        return (int) res;
    }
}
