//Find The Duplicates
//https://www.pramp.com/challenge/15oxrQx6LjtQj9JK9XlA
import java.io.*;
import java.util.*;

class Solution {

  static int[] findDuplicates(int[] arr1, int[] arr2) {
    int m = arr1.length;
    int n = arr2.length;
    int i = 0;
    int j = 0;
    List<Integer> list = new ArrayList<>();
    while(i<m && j<n){
      if(arr1[i] < arr2[j]){
        i++;
      }
      else if(arr1[i] > arr2[j]){
        j++;
      }
      else{
        list.add(arr1[i]);
        i++;
        j++;
      }
    }
    int[] ans = new int[list.size()];
    int k = 0;
    for(int e: list){
      ans[k++] = e;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] arr1 = {1, 2, 3, 5, 6, 7};
    int[] arr2 = {3, 6, 7, 8, 20};
    int[] ans = findDuplicates(arr1, arr2);
    System.out.println(Arrays.toString(ans));
  }

}
