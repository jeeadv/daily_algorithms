//Coin Change
//https://leetcode.com/problems/coin-change/

class Solution {
    
    int[] arr;
    
    public int coinChange(int[] coins, int amount) {
        arr = new int[amount + 1];
        return fun(coins, amount);
    }
    
    public int fun(int[] coins, int amount) {
        if(amount < 0) {
            return -1;
        }
        else if(amount == 0) {
            return arr[amount] = 0;
        }
        
        if(arr[amount] != 0) {
            return arr[amount];
        }
        
        int min = Integer.MAX_VALUE;
        for(int coin: coins) {
            int res = fun(coins, amount - coin);
            if(res != -1 && res < min) {
                min = res;
            }
        }
        
        if(min == Integer.MAX_VALUE) {
            return arr[amount] = -1;
        }
        return arr[amount] = 1 + min;
    }
}
