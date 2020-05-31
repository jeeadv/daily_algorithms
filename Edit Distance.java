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
