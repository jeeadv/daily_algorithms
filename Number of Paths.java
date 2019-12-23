//Number of Paths
//https://www.pramp.com/challenge/N5LYMbYzyOtbpovQoY7X

//dp + recursive

import java.io.*;
import java.util.*;

class Solution {

  static int numOfPathsToDest(int n) {
    int[][] dp = new int[n][n];
    dp[0][0] = 1;
    
    for(int i=1;i<n;i++){
      dp[i][0] = 1;
    }
    
    for(int i=1;i<n;i++){
      for(int j=1;j<n;j++){
        if(i>=j){
          dp[i][j] = dp[i][j-1] + dp[i-1][j];
        }
      }
    }
    return dp[n-1][n-1];
  }
  static int fun(int i, int j, int n){
    if(i>=n || j>=n || i<0 || j<0){
      return 0;
    }
    
    if(i == n-1 && j == n-1){
      return 1;
    }
    
    int right = 0;
    if(i+1>=j){
      right = fun(i+1, j, n);
    }
    
    int up = 0;
    if(i>=j+1){
      up = fun(i, j+1, n);
    }
    
    return right + up;
  }

  public static void main(String[] args) {
    int ans = numOfPathsToDest(4);
    System.out.println(ans);
  }

}
