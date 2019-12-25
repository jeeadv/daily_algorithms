//Toeplitz Matrix
//https://www.pramp.com/challenge/0QmxM9x81lTKO47p43Jr

import java.io.*;
import java.util.*;

class Solution {

	static boolean isToeplitz(int[][] arr) {
    int m = arr.length;
    int n = arr[0].length;
		for(int i=0;i<m;i++){
      if(!checkDiagonal(arr, i, 0, arr[i][0], m, n)){
        return false;
      }
    }
    for(int j=1;j<n;j++){
      if(!checkDiagonal(arr, 0, j, arr[0][j], m, n)){
        return false;
      }
    }
    return true;
	}
  
  static boolean checkDiagonal(int[][] arr, int i, int j, int x, int m, int n){
    while(i>=0 && i<m && j>=0 && j<n){
      if(arr[i][j] != x){
        return false;
      }
      i++;
      j++;
    }
    return true;
  }

	public static void main(String[] args) {
	  int[][] arr = {{1,2,3,4},
                   {5,1,9,3},
                   {6,5,1,2}};
    boolean res = isToeplitz(arr);
    System.out.println(res);
	}
}
/*
  
  a[i][j] != a[i-1][j-1]
  1 - m
  1 - n
  
[[1,2,5,4],
 [5,1,2,3],
 [6,5,1,2]]
 
 1 3
 2 1
 
 1 2 3
 4 1 2
 1 4 1
  
  
  [1,4,3,4],
  [5,1,2,3],
  [6,5,1,2]]
*/
