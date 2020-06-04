//Find the Town Judge
//https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3325/

class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] knownTo = new int[N + 1];
        int[] knows = new int[N + 1];
        
        for(int i = 0; i < trust.length; i++) {
            knownTo[trust[i][1]]++;
            knows[trust[i][0]]++;
        }
        
        for(int i = 1; i <= N; i++) {
            if(knownTo[i] == N - 1 && knows[i] == 0) {
                return i;
            }
        }
        
        return -1;
    }
}

//another

class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] knownTo = new int[N + 1];
        
        for(int i = 0; i < trust.length; i++) {
            knownTo[trust[i][1]]++;
            knownTo[trust[i][0]]--;
        }
        
        for(int i = 1; i <= N; i++) {
            if(knownTo[i] == N - 1) {
                return i;
            }
        }
        
        return -1;
    }
}
