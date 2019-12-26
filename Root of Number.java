//Root of Number
//https://www.pramp.com/challenge/jKoA5GAVy9Sr9jGBjzN4

import java.io.*;
import java.util.*;

class Solution {

  static double root(double x, int n) {
    double low = 0;
    double high = x;
    
    while(low < high){
      double mid = (low+high)/2;
      double y = Math.pow(mid, n);
      //System.out.println(low+" "+high+" "+mid+" "+y);
      if(Math.abs(y - x) < 0.001) {
        return mid;
      }
      else if(y < x){
        low = mid;
      }
      else {
        high = mid;
      }
    }
    return 0.0;
  }

  public static void main(String[] args) {
    double x = 9;
    int n = 2;
    double ans = root(x, n);
    System.out.println(ans);
  }

}
/*
 // y^3 = 7
 // y = I + f
 0^3 = 0
 1^3 = 1 // I = 1

 y = 2.0^3 > 7
 
 // (1, 2) => 1.5^3 < 7 => (1.5, 2) else => (1, 1.5)
 
 // margin -> 0.001
 
 WINDOW --> where the answer exists
 0---------low--low--high--------high-----------------> X
*/
