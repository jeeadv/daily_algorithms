//Sentence Reverse
//https://www.pramp.com/challenge/VKdqbrq6B1S5XAyGAOn4

import java.io.*;
import java.util.*;

class Solution {

  static char[] reverseWords(char[] arr) {
    int n = arr.length;
    
    // 'p', 'e', 'r', 'f', 'e', 'c', 't', '  '
    List<String> list = new ArrayList<>();
    String str = "";
    for(int i = 0;i<n;i++){
      
      if(arr[i] == ' '){
        list.add(str);
        
        str = "";
      }
      else{
        str += arr[i];
      }
    }
    list.add(str);
    //System.out.println(list);
    int l = 0;
    int r = list.size()-1;
    while(l<r){
      String temp = list.get(l);
      list.set(l, list.get(r));
      list.set(r, temp);
      
      l++;
      r--;
    }
    int k = 0;
    char[] output = new char[n];
    for(String s: list){
      for(int i=0;i<s.length();i++){
        output[k++] = s.charAt(i);
      }
      if(k<n){
        output[k++] = ' ';
      }
    }
    return output;
  }

  public static void main(String[] args) {
    char[] arr = { 'p', 'e', 'r', 'f', 'e', 'c', 't',' ','m', 'a', 'k', 'e', 's', ' ','p','r', 'a', 'c', 't', 'i', 'c', 'e' };
    char[] ans = reverseWords(arr);
    System.out.println(Arrays.toString(ans));
  }

}
