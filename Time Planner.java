//Time Planner
//https://www.pramp.com/challenge/3QnxW6xoPLTNl5jX5Lg1

import java.io.*;
import java.util.*;

class Solution {

  static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
    List<List<Integer>> list = new LinkedList<>();
    for(int i=0;i<slotsA.length;i++){
      find(slotsA[i], slotsB, list);
    }
    for(List<Integer> i: list){
      if(i.get(1) - i.get(0) >= dur){
        return new int[]{i.get(0), i.get(0) + dur};
      }
    }
    return new int[]{};
  }
  
  static void find(int[] slot, int[][] slotsB, List<List<Integer>> list){
    for(int i=0;i<slotsB.length;i++){
      checkOverlap(slot, slotsB[i], list);
    }
  }
  
  static void checkOverlap(int[] a, int[] b, List<List<Integer>> list){
    int start = Math.max(a[0], b[0]);
    int end = Math.min(a[1], b[1]);
    if(end - start > 0){
      List<Integer> sublist = new LinkedList<>();
      sublist.add(start);
      sublist.add(end);
      list.add(sublist);
    }
  }

  public static void main(String[] args) {
    int[][] a = {{10, 50}, {60, 120}, {140, 210}};
    int[][] b = {{0, 15}, {60, 70}};
    int dur = 8;
    int[] arr = meetingPlanner(a, b, dur);
    System.out.println(Arrays.toString(arr));
  }

}
/*
10,50
60, 70

60, 50

10, 50
12, 60

10,50
12, 40



slotsA = [[10, 50], [60, 120], [140, 210]]
slotsB = [[0, 15], [60, 70]]
common = [[10, 15], [60, 70]]
ans  = [60, 60+8]

dur = 8
*/
