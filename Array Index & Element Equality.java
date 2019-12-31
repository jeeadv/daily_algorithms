//Array Index & Element Equality
//https://www.pramp.com/challenge/jKoA5GAVy9Sr9jGBjz04
import java.io.*;
import java.util.*;

class Solution {
  static int indexEqualsValueSearch(int[] arr) {
    int l = 0;
    int r = arr.length - 1;
    
    while(l <= r){
      int mid = (l + r)/2;
      if(arr[mid] == mid){
        return mid;
      }
      else if(arr[mid] < mid){
        l = mid + 1;
      }
      else{
        r = mid - 1;
      }
    }
    
    return -1;
  }
  
  static int indexEqualsValueSearch1(int[] arr) {
    for(int i=0;i<arr.length;i++){
      if(arr[i] == i){
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = {-8,0,2,5};
    int ans = indexEqualsValueSearch(arr);
    System.out.println(ans);
  }

}
/*
[-8,0,2,5] l = 0, r = 3, mid = 1
  0 i 2 3 arr[i] < i => right
  
     i
 [-8,5,6,7]  arr[i]  > i => left 
*/
