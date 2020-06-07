//Coin Change 2
//https://leetcode.com/problems/coin-change-2/

// bottom up with memoization (like knapsack problem, in this case infinite supply)

class Solution {
    Integer[][] dp;
    
    public int change(int amount, int[] coins) {
        dp = new Integer[amount + 1][coins.length];
        return fun(amount, coins, 0);
    }
    
    public int fun(int amount, int[] coins, int i) {
        if(amount == 0) {
            return 1;
        }
        
        if(amount < 0 || i == coins.length) {
            return 0;
        }
        
        if(dp[amount][i] != null) {
            return dp[amount][i];
        }
        
        return dp[amount][i] = fun(amount - coins[i], coins, i) + fun(amount, coins, i + 1);
    }
}
