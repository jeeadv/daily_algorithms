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


// dp bottom up

class Solution {
    Integer[][] dp;
    
    public int change(int amount, int[] coins) {
        int[] arr = new int[amount + 1];
        arr[0] = 1;
        
        for(int coin: coins) {
            for(int i = coin; i <= amount; i++) {
                arr[i] += arr[i - coin];
            }
        }
        return arr[amount];
    }
    
}

// all possibility print

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CoinChange {

    static List<String>[] list;
    
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		int amount = 5;
		int[] coins = {1, 2, 5};
		
		list = new ArrayList[amount + 1];
		
		System.out.println(new CoinChange().change(amount, coins));
		
		for(List<String> item: list) {
			System.out.println(item);
		}
	}
	
	public int change(int amount, int[] coins) {
        int[] arr = new int[amount + 1];
        arr[0] = 1;
        
        for(int coin: coins) {
            for(int i = coin; i <= amount; i++) {
                arr[i] += arr[i - coin];
                
                /* adding start*/
                if(list[i] == null) {
                	list[i] = new ArrayList<>();
                }
                if(list[i - coin] == null) {
                	list[i].add(String.valueOf(i));
                }
                else {
                	for(String s: list[i - coin]) {
                		list[i].add(s + " " + coin);
                	}
                }
                /* adding end*/
            }
        }
        return arr[amount];
    }

}
