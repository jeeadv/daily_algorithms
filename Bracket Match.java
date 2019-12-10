//Bracket Match
//https://www.pramp.com/challenge/xJZA01AxdlfpM2vZ2Wwa
import java.io.*;
import java.util.*;

class Solution {
  
  static int bracketMatch(String text) {
    int ans = 0;
    int stackSize = 0;
    
    for(int i=0;i<text.length();i++){
      if(text.charAt(i) == '('){
        stackSize++;
      }
      else{
        if(stackSize == 0){
          ans += 1;
        }
        else{
          stackSize--;
        }
      }
    }
    ans += stackSize;
    return ans;
  }

  public static void main(String[] args) {

  }

}
