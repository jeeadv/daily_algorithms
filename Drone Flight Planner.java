//Drone Flight Planner
//https://www.pramp.com/challenge/BrLMj8M2dVUoY95A9x3X

import java.io.*;
import java.util.*;

class Solution {

  static int calcDroneMinEnergy(int[][] route) {
    int min = Integer.MAX_VALUE;
    int energy = 0;
    int n = route.length;
    int prevZ = route[0][2];
    for(int i=1;i<n;i++){
      int z = route[i][2];
      
      energy += prevZ - z;
      
      if(energy<min){
        min = energy;
      }
      
      prevZ = z;
    }
    if(min != Integer.MAX_VALUE && min<0){
      return Math.abs(min);
    }
    else{
      return 0;
    }
  }

  public static void main(String[] args) {

  }

}
