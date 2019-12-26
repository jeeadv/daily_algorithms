//Shifted Array Search
//https://www.pramp.com/challenge/N5LYMbYzyOtbpovQoYPX

import java.io.*;
import java.util.*;

class Solution {

  static int shiftedArrSearch(int[] shiftArr, int num) {
    if(shiftArr[0] < shiftArr[shiftArr.length - 1]){
      return binarySearch(shiftArr, num, 0, shiftArr.length - 1);
    }
    
    int start = findPivot(shiftArr);
    
    if(num >= shiftArr[start] && num <= shiftArr[shiftArr.length - 1]){
      return binarySearch(shiftArr, num, start, shiftArr.length - 1);
    }
    else{
      return binarySearch(shiftArr, num, 0, start - 1);
    }
  }
  
  static int binarySearch(int[] arr, int num, int l, int r){
    while(l <= r){
      int mid = (l + r)/2;
      if(arr[mid] == num){
        return mid;
      }
      else if(arr[mid] < num){
        l = mid + 1;
      }
      else{
        r = mid - 1;
      }
    }
    return -1;
  }
  
  static int findPivot(int[] arr){
    int l = 0;
    int r = arr.length - 1;
    int mid = -1;
    while(l < r){
      mid = (l + r)/2;
      if(arr[mid] > arr[r]){
        l = mid + 1;
      }
      else{
        r = mid;
      }
    }
    return l;
  }

  public static void main(String[] args) {
    int[] arr = {9, 12, 17, 2, 4, 5};
    System.out.println(shiftedArrSearch(arr, 2));
  }

}
/*
// can you hear?
//can you hear me?

[9, 12, 1, 2, 4, 5] , num = 2
 0   1   2  3  4  5
 (0,5) => 17
 
*/
