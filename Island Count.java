//Island Count
//https://www.pramp.com/challenge/yZm60L6d5juM7K38KYZ6

import java.io.*;
import java.util.*;

class Solution {

  static int getNumberOfIslands(int[][] binaryMatrix) {
    int m = binaryMatrix.length;
    int n = binaryMatrix[0].length;
    int[][] arr = new int[m][n];
    int count = 1;
    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){
        if(binaryMatrix[i][j] != 0 && !visited(arr, i, j)){
          dfs(binaryMatrix, arr, i, j, m, n, count);
          count++;
        }
      }
    }
    return count - 1;
  }
  static boolean visited(int[][] arr, int i, int j){
    if(arr[i][j]>0){
      return true;
    }
    else{
      return false;
    }
  }
  
  static void dfs(int[][] binaryMatrix, int[][] arr,int i,int j,int m,int n,int count){
    if(i<0 || i>=m || j<0 || j>=n){
      return;
    }
    if(binaryMatrix[i][j] == 0 || arr[i][j] != 0){
      return;
    }
    arr[i][j] = count;
    dfs(binaryMatrix, arr, i-1, j, m, n, count);
    dfs(binaryMatrix, arr, i, j+1, m, n, count);
    dfs(binaryMatrix, arr, i+1, j, m, n, count);
    dfs(binaryMatrix, arr, i, j-1, m, n, count);
  }

  public static void main(String[] args) {
    int[][] binaryMatrix = {  {0,    1,    0,    1,    0},
                              {0,    0,    1,    1,    1},
                              {1,    0,    0,    1,    0},
                              {0,    1,    1,    0,    0},
                              {1,    0,    1,    0,    1} 
                           };
    int ans = getNumberOfIslands(binaryMatrix);
    System.out.println(ans);
  }

}
/*
[0,    1,    i-1,j,    1,    0],
[0,    i,j-1, i,j,    i,j+1,    1],
[1,    0,    i+1,j,    1,    0],
[0,    1,    1,    0,    0],
[1,    0,    1,    0,    1] ]

count = 6;
[0,    1,    0,    2,    0],
[0,    0,    2,    2,    2],
[3,    0,    0,    2,    0],
[0,    4,    4,    0,    0],
[5,    0,    4,    0,    6]

0 -> {}
1 -> {}
*/
