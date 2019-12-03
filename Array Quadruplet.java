/*
Given an unsorted array of integers arr and a number s, 
write a function findArrayQuadruplet that finds four numbers (quadruplet) in arr that sum up to s. 
Your function should return an array of these numbers in an ascending order. 
If such a quadruplet doesn’t exist, return an empty array.

Note that there may be more than one quadruplet in arr whose sum is s. 
You’re asked to return the first one you encounter (considering the results are sorted).

Explain and code the most efficient solution possible, and analyze its time and space complexities.
*/

import java.io.*;
import java.util.*;

class Solution {
  
  static int[] findArrayQuadruplet(int[] arr, int s) {

    int n = arr.length;
    int[] res = new int[4];
    Arrays.sort(arr);
    
    for(int i=0;i<n;i++){
      for(int j=i+1;j<n;j++){
        int l = j+1;
        int r = n-1;
        while(l<r){
          int sum = arr[i]+arr[j]+arr[l]+arr[r];
          if(sum<s){
            l++;
          }
          else if(sum>s){
            r--;
          }
          else{
            res[0] = arr[i];
            res[1] = arr[j];
            res[2] = arr[l];
            res[3] = arr[r];
            return res;
          }
        }
      }
    }
    return new int[] {};
  }

  public static void main(String[] args) {
    int[] arr = {2, 7, 4, 0, 9, 5, 1, 3};
    int n = 8;
    int s = 20;
    
    int[] ans = findArrayQuadruplet(arr, s);
    System.out.println(Arrays.toString(ans));
  }

}
