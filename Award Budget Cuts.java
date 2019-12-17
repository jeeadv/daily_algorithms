//Award Budget Cuts
//https://www.pramp.com/challenge/r1Kw0vwG6OhK9AEGAyWV

import java.io.*;
import java.util.*;

class Solution {
  
  static double findGrantsCap(double[] grantsArray, double newBudget) {
    Arrays.sort(grantsArray);
    double max = newBudget/grantsArray.length;
    for(int i=0;i<grantsArray.length;i++){
      double budget = newBudget - grantsArray[i];
      double ans = budget/(grantsArray.length-i-1);
      if(ans>max){
        max = ans;
      }
      newBudget = budget;
      //System.out.println(newBudget + " " + ans);
    }
    return max;
  }

  public static void main(String[] args) {
    double[] arr = {2, 100, 50, 120, 1000};
    double ans = findGrantsCap(arr, 190);
    System.out.println(ans);
  }

}
