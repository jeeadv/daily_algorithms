//K-Messed Array Sort
import java.io.*;
import java.util.*;

class Solution {

  static int[] sortKMessedArray(int[] arr, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    for(int i=0;i<=k;i++){
      heap.add(arr[i]);
    }
    
    int j = 0;
    for(int i=k+1;i<arr.length;i++){
      arr[j++] = heap.remove();
      heap.add(arr[i]);
    }
    
    while(!heap.isEmpty()){
      arr[j++] = heap.remove();
    }
    return arr;
  }
  
  static int[] sortKMessedArray1(int[] arr, int k) {
    return insertionSort(arr, k);
  }
  
  static int[] insertionSort(int[] arr, int k){
    int n = arr.length;
    for(int i=1;i<n;i++){
      if(arr[i] < arr[i-1]){
        shiftArray(arr, i);
      }
    }
    return arr;
  }
  
  static void shiftArray(int[] arr, int r){
    while(r>=1){
      if(arr[r] < arr[r-1]){
        swap(arr, r, r - 1);
      }
      else{
        return;
      }
      r--;
    }
  }
  
  static void swap(int[] arr, int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    int[] arr = {1, 4, 5, 2, 3, 7, 8, 6, 10, 9};
    int k = 2;
    int[] res = sortKMessedArray(arr, k);
    System.out.println(Arrays.toString(res));
  }

}
/*
k = 2
[4 3 2 1]
[2 3 4 1]
[2 3 4 1]

[1, 4, 5, 2, 3, 7, 8, 6, 10, 9]
[1, 2, 3, 4, 5, 6, 8, 7, 10, 9]
[1, 2, 3, 4, 5, 6, 7, 8, 10, 9]

[1, 2, 4, 5, 3, 7, 8, 6, 10, 9]
[1, 2, 3, 4, 5, 7, 8, 6, 10, 9]
[1, 2, 3, 4, 5, 6, 7, 8, 10, 9]
*/
