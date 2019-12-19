//Pancake Sort
//https://www.pramp.com/challenge/3QnxW6xoPLTNl5jX5LM1

import java.io.*;
import java.util.*;
/*
[1, 5, 4, 3, 2]
[5, 1, 4, 3, 2]
[4, 1, 5, 3, 2]
*/
class Solution {

  static int[] pancakeSort(int[] arr) {
    int n = arr.length - 1;
    int max = Integer.MIN_VALUE;
    int maxIndex = 0;
    
    while(n>0){
      for(int i=0;i<=n;i++){
        if(arr[i] > max){
          max = arr[i];
          maxIndex = i;
        } 
      }
      
      flip(arr, maxIndex);
      flip(arr, n);
      n--;
      
      max = Integer.MIN_VALUE;
      maxIndex = 0;
    }
    
    return arr;
  }
  static void flip(int[] arr, int k){
    int l = 0;
    int r = k;
    while(l<r){
      int temp = arr[l];
      arr[l] = arr[r];
      arr[r] = temp;
      l++;
      r--;
    }
  }

  public static void main(String[] args) {
    int[] arr = {1, 5, 4, 3, 2};
    
    arr = pancakeSort(arr);
    System.out.println(Arrays.toString(arr));
  }

}




/*
    array       max  flip
[2, 3, 1, 5, 4]	5	  flip(arr, 3)
[5, 1, 3, 2, 4]	5	  flip(arr, 4)
[4, 2, 3, 1, 5]	4	  flip(arr, 0)
[4, 2, 3, 1, 5]	4	  flip(arr, 3)
[1, 3, 2, 4, 5]	3	  flip(arr, 1)
[3, 1, 2, 4, 5]	3	  flip(arr, 2)
[2, 1, 3, 4, 5]	2	  flip(arr, 0)
[1, 2, 3, 4, 5]	2	  flip(arr, 1)
*/
