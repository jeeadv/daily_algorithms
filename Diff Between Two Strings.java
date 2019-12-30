//Diff Between Two Strings
//https://www.pramp.com/challenge/5j2xWAx1qPtlZGLnG2O0

import java.io.*;
import java.util.*;

class Solution {
  static List<String> list;
  static int min = Integer.MAX_VALUE;
  
  static String[] diffBetweenTwoStrings(String source, String target) {
    int m = source.length();
    int n = target.length();
    
    List<String> list = new LinkedList<>();
    
    int[][] dp = new int[m][n];
    dp[m-1][n-1] = 0;
    
    for(int i=0;i<m-1;i++){
      dp[i][n-1] = m - i;
    }
    
    for(int j=0;j<n-1;j++){
      dp[m-1][j] = n - j;
    }
    
    for(int i=m-2;i>=0;i--){
      for(int j=n-2;j>=0;j--){
        if(source.charAt(i) == target.charAt(j)){
          dp[i][j] = dp[i+1][j+1];
        }
        else{
          if(dp[i+1][j] < dp[i][j+1]){
            dp[i][j] = 1 + dp[i+1][j];
          }
          else{
            dp[i][j] = 1 + dp[i][j+1];
          }
        }
      }
    }
    
    /*for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }*/
    
    int i = 0;
    int j = 0;
    while(i < m - 1 && j < n - 1){
      //System.out.println(i + " " + j);
      if(dp[i][j] == dp[i+1][j+1]){
        list.add("" + source.charAt(i));
        i++;
        j++;
      }
      else{
        if(dp[i+1][j] < dp[i][j+1]){
          list.add("-" + source.charAt(i));
          i++;
        }
        else{
          list.add("+" + target.charAt(j));
          j++;
        }
      }
    }
    
    while(i<m){
      list.add("-" + source.charAt(i));
      i++;
    }
    
    while(j<n){
      list.add("+" + target.charAt(j));
      j++;
    }
    
    System.out.println(dp[0][0]);
    return list.toArray(new String[list.size()]);
  }
  
	static String[] diffBetweenTwoStringsRecursiveTopDown(String source, String target) {
	  list = new LinkedList<>();
    min = Integer.MAX_VALUE;
    
    fun(0, 0, source, target, 0, "");
    String str = list.get(0);
    List<String> res = new LinkedList<>();
    for(int i=0;i<str.length();i++){
      if(str.charAt(i) == '-' || str.charAt(i) == '+'){
        String temp = "";
        temp += str.charAt(i);
        temp += str.charAt(i + 1);
        res.add(temp);
        i++;
      }
      else{
        String temp = "";
        temp += str.charAt(i);
        res.add(temp);
      }
    }
    return res.toArray(new String[res.size()]);
	}
  
  static void fun(int i, int j, String src, String trg, int oper, String prefix){
    if(i == src.length() && j == trg.length()){
      if(oper < min){
        min = oper;
        list = new LinkedList<>();
        list.add(prefix);
      }
      return;
    }
    
    if(i == src.length()){
      fun(i, j + 1, src, trg, oper + 1, prefix + "+" + trg.charAt(j));
      return;
    }
    
    if(j == trg.length()){
      fun(i + 1, j, src, trg, oper + 1, prefix + "-" + src.charAt(i));
      return;
    }
    
    if(src.charAt(i) == trg.charAt(j)){
      fun(i + 1, j + 1, src, trg, oper, prefix + src.charAt(i));
    }
    else{
      fun(i + 1, j, src, trg, oper + 1, prefix + "-" + src.charAt(i));
      fun(i, j + 1, src, trg, oper + 1, prefix + "+" + trg.charAt(j));
    }
  }

	public static void main(String[] args) {
	  String source = "ABCDEFG";
    String target = "ABDFFGH";
    String[] res = diffBetweenTwoStrings(source, target);
    System.out.println(Arrays.toString(res));
	}
}
/*
src = CA [C = 0, A = 1]
trg = AC [A = 0, C = 1]

=> -C
src = A  [A = 1]
trg = AC [A = 0, C = 1]

dp[m+1][n+1]

if src[i] == trg[j]  then dp[i][j] = dp[i+1][j+1] AB, AC
else Min(dp[i+1][j], dp[i][j+1]) + 1 // CA, BA

calculateDP

int i = 0, j = 0;

while (i < m && j < n) {
  if (src[i] == trg[j])
    ans.push(src[i]);
  else
    if (dp[i+1][j] < dp[i][j+1])
      ans.push("-" + src[i]);
    else
      ans.push("+" + trg[j])
      
}

src = ABCDEFG -> m =>  int srcMap[26]; hashMap<Char, List<Index>>
trg = ABDFFGH -> n     int trgMap[26];

 BCDEFG
 
 A


match = ABDFG -> max(m,n)
srcM = CE => 
trgM = FH


res = AB-CD-EF+FG+H

ABCDEFG, ABDFFGH => BCDEFG, BDFFGH => CDEFG, DFFGH => DEFG, DFFGH
                                            |
                                      DCDEFG, DFFGH
*/
