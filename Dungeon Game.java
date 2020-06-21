//Dungeon Game
//https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3367/

class Solution {
    int pathMax = Integer.MIN_VALUE;
    public int calculateMinimumHP(int[][] dungeon) {
        pathMax = Integer.MIN_VALUE;
        int m = dungeon.length;
        int n = dungeon[0].length;
        fun(0, 0, m, n, dungeon, 0, Integer.MAX_VALUE);
        
        if(pathMax > 0) {
            return 1;
        }
        else {
            return -pathMax + 1;
        }
    }
    
    public void fun(int i, int j, int m, int n, int[][] dungeon, int pathSum, int pathMin) {
        if(i == m - 1 && j == n || i == m && j == n - 1) {
            //System.out.println(pathSum + " " + pathMin);
            if(pathMin > pathMax) {
                pathMax = pathMin;
            }
            return;
        }
        
        if(i == m || j == n) {
            return;
        }
        
        fun(i + 1, j, m, n, dungeon, pathSum + dungeon[i][j], Math.min(pathMin, pathSum + dungeon[i][j]));
        fun(i, j + 1, m, n, dungeon, pathSum + dungeon[i][j], Math.min(pathMin, pathSum + dungeon[i][j]));
    }
    
}
