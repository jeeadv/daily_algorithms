//Edit Distance
//https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3346/

class Solution {
    public int minDistance(String word1, String word2) {
        return minDistance(0, 0, word1, word2);
    }
    
    public int minDistance(int i, int j, String a, String b) {
        if(i == a.length() && j == b.length()) {
            return 0;
        }
        else if(i == a.length() && j < b.length()) {
            return 1 + minDistance(i, j + 1, a, b);
        }
        else if(i < a.length() && j == b.length()) {
            return 1 + minDistance(i + 1, j, a, b);
        }
        
        if(a.charAt(i) == b.charAt(j)) {
            return minDistance(i + 1, j + 1, a, b);
        }
        else {
            int way1 = minDistance(i, j + 1, a, b); //insert
            int way2 = minDistance(i + 1, j + 1, a, b); //replace
            int way3 = minDistance(i + 1, j, a, b); // delete
            
            return 1 + Math.min(way1, Math.min(way2, way3));
        }
    }
}

// Memomization with recursion

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        return minDistance(0, 0, word1, word2, dp);
    }
    
    public int minDistance(int i, int j, String a, String b, int[][] dp) {
        if(i == a.length() && j == b.length()) {
            return 0;
        }
        else if(i == a.length() && j < b.length()) {
            return 1 + minDistance(i, j + 1, a, b, dp);
        }
        else if(i < a.length() && j == b.length()) {
            return 1 + minDistance(i + 1, j, a, b, dp);
        }
        
        if(dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }
        
        if(a.charAt(i) == b.charAt(j)) {
            return minDistance(i + 1, j + 1, a, b, dp);
        }
        else {
            int way1 = minDistance(i, j + 1, a, b, dp); //insert
            int way2 = minDistance(i + 1, j + 1, a, b, dp); //replace
            int way3 = minDistance(i + 1, j, a, b, dp); // delete
            
            return dp[i][j] = 1 + Math.min(way1, Math.min(way2, way3));
        }
    }
}
