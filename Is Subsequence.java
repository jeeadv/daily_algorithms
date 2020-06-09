//Is Subsequence
//https://leetcode.com/problems/is-subsequence/

//index lookup

class Solution {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for(char c: s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if(index == -1) {
                return false;
            }
        }
        return true;
    }
}
//2 pointer
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }
            else {
                j++;
            }
        }
        
        return i == s.length();
    }
}

// dp top down
class Solution {
    public boolean isSubsequence(String s, String t) {
        boolean[][] arr = new boolean[s.length() + 1][t.length() + 1];
        
        for(int j = 0; j <= t.length(); j++) {
            arr[s.length()][j] = true;
        }
        
        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = t.length() - 1; j >= 0; j--) {
                if(s.charAt(i) == t.charAt(j)) {
                    arr[i][j] = arr[i + 1][j + 1];
                }
                else {
                    arr[i][j] = arr[i][j + 1];
                }
            }
        }
        return arr[0][0];
    }
}

// bottom up memoization

class Solution {
    public boolean isSubsequence(String s, String t) {
        int[][] arr = new int[s.length()][t.length()];
        for(int i = 0; i < arr.length; i++)
            Arrays.fill(arr[i], 2);
        return fun(s, t, 0, 0, arr);
    }
    
    public boolean fun(String s, String t, int i, int j, int[][] arr) {
        if(i == s.length() && j == t.length()) {
            return true;
        }
        else if(i == s.length() && j != t.length()) {
            return true;
        }
        else if(i != s.length() && j == t.length()) {
            return false;
        }
        
        if(arr[i][j] != 2) {
            return arr[i][j] == 1;
        }
        boolean flag = false;
        if(s.charAt(i) == t.charAt(j)) {
            flag = fun(s, t, i + 1, j + 1, arr);
        }
        else {
            flag = fun(s, t, i, j + 1, arr);
        }
        arr[i][j] = flag ? 1 : 0;
        return flag;
    }
}

// brute force recursive bottom up

class Solution {
    public boolean isSubsequence(String s, String t) {
        return fun(s, t, 0, 0);
    }
    
    public boolean fun(String s, String t, int i, int j) {
        if(i == s.length() && j == t.length()) {
            return true;
        }
        else if(i == s.length() && j != t.length()) {
            return true;
        }
        else if(i != s.length() && j == t.length()) {
            return false;
        }
        
        if(s.charAt(i) == t.charAt(j)) {
            return fun(s, t, i + 1, j + 1);
        }
        else {
            return fun(s, t, i, j + 1);
        }
    }
}
