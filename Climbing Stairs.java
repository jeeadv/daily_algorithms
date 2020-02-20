//Climbing Stairs
//https://leetcode.com/problems/climbing-stairs/

class Solution {
    public int climbStairs(int n) {
        if(n <= 1){
            return 1;
        }
        int a = 1;
        int b = 1;
        int c = 0;
        for(int i = 2; i <= n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}

// nth fibbonacci formula
class Solution {
    public int climbStairs(int n) {
        double phi = (1 + Math.sqrt(5)) / 2;
        return (int)Math.round(Math.pow(phi, n + 1) / Math.sqrt(5));
    }
}
