//Matrix Spiral Copy
//https://www.pramp.com/challenge/ml9AwEA42YHK735G3lq5

import java.io.*;
import java.util.*;

class Solution {
  
  static int[] spiralCopy(int[][] inputMatrix) {
    int r = 0;
    int c = 0;
    int m = inputMatrix.length;
    int n = inputMatrix[0].length;
    m -= 1;
    n -= 1;
    List<Integer> list = new LinkedList<>();
    
    while(r <= m && c <= n){
      if(r <= m && c <= n)
        printRow(r, c, m, n, inputMatrix, list);
      r++;
      if(r <= m && c <= n)
        printCol(r, c, m, n, inputMatrix, list);
      n--;
      if(r <= m && c <= n)
        printRowRev(r, c, m, n, inputMatrix, list);
      m--;
      if(r <= m && c <= n)
        printColRev(r, c, m, n, inputMatrix, list);
      c++;
    }
    
    int[] res = new int[list.size()];
    for(int i=0;i<list.size();i++){
      res[i] = list.get(i);
    }
    return res;
  }
  
  static void printCol(int r, int c, int m, int n, int[][] arr, List<Integer> list){
    for(int i=r;i<=m;i++){
      list.add(arr[i][n]);
    }
  }
  
  static void printColRev(int r, int c, int m, int n, int[][] arr, List<Integer> list){
    for(int i=m;i>=r;i--){
      list.add(arr[i][c]);
    }
  }
  
  static void printRow(int r, int c, int m, int n, int[][] arr, List<Integer> list){
    for(int j=c;j<=n;j++){
      list.add(arr[r][j]);
    }
  }
  
  static void printRowRev(int r, int c, int m, int n, int[][] arr, List<Integer> list){
    for(int j=n;j>=c;j--){
      list.add(arr[m][j]);
    }
  }

  public static void main(String[] args) {
    int[][] arr = { {1,    2,   3,  4,    5},
                    {6,    7,   8,  9,   10},
                    {11,  12,  13,  14,  15},
                    {16,  17,  18,  19,  20} };
    int[] res = spiralCopy(arr);
    for(int i: res){
      System.out.print(i + " ");
    }
  }

}
/*
[1,    2,   3,  4,    5],
[6,    7,   8,  9,   10],
[11,  12,  13,  14,  15],
[16,  17,  18,  19,  20] ]
*/
