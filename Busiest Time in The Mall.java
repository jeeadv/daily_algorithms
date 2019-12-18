//Busiest Time in The Mall
//https://www.pramp.com/challenge/2WBx3Axln1t7JQ2jQq96

import java.io.*;
import java.util.*;
/*
[                [1487799425, 14, 1], = 14
                 [1487799425, 4,  0], = 10
                 [1487799425, 2,  0], = 8
                 [1487800378, 10, 1], = 18
                 [1487801478, 18, 0], = 0
                 [1487801478, 18, 1], = 18
                 [1487901013, 1,  0], = 17
                 [1487901211, 7,  1], = 24
                 [1487901211, 7,  0]  = 17
                 ]
                 */
class Solution {
  static int findBusiestPeriod(int[][] data) {
    int n = data.length;
    int max = Integer.MIN_VALUE;
    int time = -1;
    int prev = -1;
    int count = 0;
    for(int i=0;i<n;i++){
      if(data[i][0] != prev){
        if(count > max){
          max = count;
          time = prev;
        }
        //count = 0;
        prev = data[i][0];
      }
      if(data[i][2] == 0){
        count -= data[i][1];
      }
      else{
        count += data[i][1];
      }
    }
    if(count > max){
      max = count;
      time = prev;
    }
    
    return time;
  }

  public static void main(String[] args) {
    int[][] data = { {1487799425, 14, 1}, 
                    {1487799425, 4,  0},
                    {1487799425, 2,  0},
                    {1487800378, 10, 1},
                    {1487801478, 18, 0},
                    {1487801478, 18, 1},
                    {1487901013, 1,  0},
                    {1487901211, 7,  1},
                    {1487901211, 7,  0} };
    int ans = findBusiestPeriod(data);
    System.out.println(ans);
  }
}
