//Pairs with Specific Difference
//pramp.com/challenge/XdMZJgZoAnFXqwjJwnpZ

import java.io.*;
import java.util.*;

class Solution {

  static int[][] findPairsWithGivenDifference(int[] arr, int k) {
    HashSet<Integer> set = new HashSet<>();
    List<List<Integer>> list = new LinkedList<>();
    
    for(int i: arr){
      set.add(i);
    }
    
    for(int i: arr){
      int comp1 = k + i;

      if(set.contains(comp1)){
        List<Integer> subList = new LinkedList<>();
        subList.add(comp1);
        subList.add(i);
        list.add(subList);
      }
      
    }
    
    int[][] res = new int[list.size()][2];
    
    for(int i=0;i<list.size();i++){
      res[i][0] = list.get(i).get(0);
      res[i][1] = list.get(i).get(1);
    }
    return res;
  }

  public static void main(String[] args) {
    int[] arr = {0, -1, -2, 99999999999, 999999999999};
    int[][] ans = findPairsWithGivenDifference(arr, 1);
    
    for(int i=0;i<ans.length;i++){
      System.out.println(Arrays.toString(ans[i]));
    }
  }
  
  /*
  def find_pairs_with_given_difference(arr, k):
  numbers = set(arr)
  results = []

  for y in arr:
    x = y + k
    if x in numbers:
      results.append([x, y])

  return results
  */

}

/* [0, -1, 1] k = 1,  set[0] res=[(0, -1), (0, 1)]
  
input:  arr = [0, -1, -2, 2, 1], k = 1
output: [[1, 0], [0, -1], [-1, -2], [2, 1]]
|a-b| = k
a = k - b
a = k + b

[-1, 2][0, 1]
*/
