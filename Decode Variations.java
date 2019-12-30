//Decode Variations
//https://www.pramp.com/challenge/r1Kw0vwG6OhK9AEGAy6L

import java.io.*;
import java.util.*;

class Solution {

  static int decodeVariations(String str) {
    int n = str.length();
    int[] dp = new int[n+1];
    dp[n] = 1;
    for(int i=n-1;i>=0;i--){
      if(str.charAt(i) == '0'){
        dp[i] = 0;
      }
      else if(str.charAt(i) == '1'){
        dp[i] = dp[i+1];
        if(i+2 <= n){
          dp[i] += dp[i+2];
        }
      }
      else if(i+1 < n && str.charAt(i) == '2' && str.charAt(i+1) <= '6'){
        dp[i] = dp[i+1];
        if(i+2 <= n){
          dp[i] += dp[i+2];
        }
      }
      else{
        dp[i] = dp[i+1];
      }
    }
    return dp[0];
	}
  
	static int decodeVariations1(String str) {
    return fun(str, 0);
	}
  
  static int fun(String str, int i){
    if(i == str.length()){
      return 1;
    }
    
    if(i > str.length()){
      return 0;
    }
    
    if(str.charAt(i) == '0'){
      return 0;
    }
    
    if(str.charAt(i) == '1'){
      return fun(str, i + 1) + fun(str, i + 2);
    }
    
    if(i+1 < str.length() && str.charAt(i) == '2' && str.charAt(i+1) <= '6'){
      return fun(str, i + 1) + fun(str, i + 2);
    }
    
    return fun(str, i + 1); 
  }

	public static void main(String[] args) {
	  System.out.println(decodeVariations("26"));
	}
}
