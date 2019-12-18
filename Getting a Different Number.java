//Getting a Different Number
//https://www.pramp.com/challenge/aK6V5GVZ9MSPqvG1vwQp

import java.io.*;
import java.util.*;
/*
 n = length;
 [0, 1, 2, 3]
 
 [1, 3, 0, 2]
 1 -> 3 -> 2 -> 0 -> 1
 [1, 3, 0, 2]
 [1, 1, 0, 2]
 [1, 1, 0, 3]
 [1, 1, 2, 3]
 [0, 1, 2, 3]
*/
class Solution {

  static int getDifferentNumber(int[] arr) {
    int n = arr.length;
    for(int i=0;i<n;i++){
      if(arr[i] != i){
        int j = arr[i];
        while(j<n && arr[j] != j){
          int temp = arr[j];
          if(arr[j] < n){
            arr[j] = arr[arr[j]];
            arr[arr[j]] = temp;
          }
          j = arr[j];
        }
      }
    }
    for(int i=0;i<n;i++){
      if(arr[i] != i){
        return i;
      }
    }
    return n;
  }
  static int getDifferentNumber1(int[] arr) {
    HashSet<Integer> set = new HashSet<>();
    for(int i: arr){
      set.add(i);
    }
    int i = 0;
    while(true){
      if(!set.contains(i)){
        break;
      }
      i++;
    }
    return i;
  }

  public static void main(String[] args) {
    int[] arr = {0, 1, 2, 3};
    int ans = getDifferentNumber(arr);
    System.out.println(ans);
  }

}
