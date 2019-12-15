//Deletion Distance
//https://www.pramp.com/challenge/61ojWAjLJbhob2nP2q1O
import java.io.*;
import java.util.*;

class Solution {

  static int deletionDistance(String str1, String str2) {
    int[][] dp = new int[str1.length()][str2.length()];
    for(int i=0;i<str1.length();i++){
      for(int j=0;j<str2.length();j++){
        dp[i][j] = -1;
      }
    }
    int ans = solve(str1, str2, 0, 0, dp);
    ans = str1.length() + str2.length() - 2*ans;
    return ans;
  }
  
  static int solve(String str1, String str2, int i, int j, int[][] dp){
    if(i>= str1.length() || j>=str2.length()){
      return 0;
    }
    if(dp[i][j] != -1){
      return dp[i][j];
    }
    else{
      if(str1.charAt(i) == str2.charAt(j)){
        return dp[i][j] = solve(str1, str2, i+1,j+1, dp) + 1;
      }
      else{
        int one = solve(str1, str2, i,j+1, dp);
        int two = solve(str1, str2, i+1,j, dp);
        return dp[i][j] = Math.max(one, two);
      }
    }
    
  }

  public static void main(String[] args) {
    int ans = deletionDistance("heat", "hit");
    System.out.println(ans);
  }
 
}
/*
str1 = "dog", str2 = "frog"
ans = 3


"teah" "hit"

"heat" "hit"
1+f(eat,it); // match
max(f(heat,it), (eat, hit))

teah it  eah hit
*/
