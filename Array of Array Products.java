//Array of Array Products
//https://www.pramp.com/challenge/7Lg1WA1nZqfoWgPbgM0M

import java.io.*;
import java.util.*;

class Solution {
  
  static int[] arrayOfArrayProducts(int[] arr) {
    int n = arr.length;
    if(n <= 1){
      return new int[]{};
    }
    
    int[] prefix = new int[n];
    int[] suffix = new int[n];
    int[] res = new int[n];
    
    prefix[0] = 1;
    for(int i = 1;i < n;i++){
      prefix[i] = prefix[i-1]*arr[i-1];
    }
    
    suffix[n-1] = 1;
    for(int i = n-2;i >= 0;i--){
      suffix[i] = suffix[i+1]*arr[i+1];
    }
    
    for(int i=0;i<n;i++){
      res[i] = prefix[i]*suffix[i];
    }
    return res;
  }

  public static void main(String[] args) {
    int[] arr = {2, 7, 3, 4};
    int[] ans = arrayOfArrayProducts(arr);
    System.out.println(Arrays.toString(ans));
  }

}
/*
[8, 10, 2]
[1, 8, 80] - prefix prod
[20, 2, 1] - suffix prod
[20, 16, 80]
*/
