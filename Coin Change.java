//Coin Change
//https://leetcode.com/problems/coin-change/
//recursive with memoization
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

// dp bottom up

class Solution {
    
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        
        //Arrays.sort(coins);
        int[] arr = new int[amount + 1];
        arr[0] = 1;
        
        for(int i = 1; i <= amount; i++) {
            arr[i] = Integer.MAX_VALUE;
        }
        
        for(int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++) {
                if(i - coins[j] > 0) {
                    min = Math.min(min, arr[i - coins[j]]);
                }
                else if(i - coins[j] == 0) {
                    min = 0;
                    break;
                }
            }
            
            if(min != Integer.MAX_VALUE) {
                arr[i] = 1 + min;   
            }
                
        }
        //System.out.println(Arrays.toString(arr));
        
        return arr[amount] == Integer.MAX_VALUE ? -1 : arr[amount];
    }
}

// short

class Solution {
    
    public int coinChange(int[] coins, int amount) {
        int[] arr = new int[amount + 1];
        Arrays.fill(arr, amount + 1);
        arr[0] = 0;
        
        for(int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(i - coins[j] >= 0) {
                    arr[i] = Math.min(arr[i] , arr[i - coins[j]] + 1);
                }
            } 
        }
        
        return arr[amount] == amount + 1 ? -1 : arr[amount];
    }
}
