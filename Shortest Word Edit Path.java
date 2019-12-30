//Shortest Word Edit Path
//https://www.pramp.com/challenge/MW75pP53wAtzNPVLPG0d

import java.io.*;
import java.util.*;

class Solution {

	static int shortestWordEditPath(String source, String target, String[] words) {
    return bfs(words, source, target);
	}
  
  static int bfs(String[] words, String src, String trg){
    int n = words.length;
	  HashSet<String> visited = new HashSet<>();
    HashSet<String> wordSet = new HashSet<>();
    for(String word: words){
      wordSet.add(word);
    }
    System.out.println("word set:"+wordSet);
    int level = 0;
    
    Queue<String> queue = new LinkedList<>();
    queue.add(src);
    
    while(!queue.isEmpty()){
      int m = queue.size();
      for(int i=0;i<m;i++){
        String top = queue.poll();
        if(trg.equals(top)){
          return level;
        }
        visited.add(top);
        //System.out.println();
        //System.out.print(top + "->");
        //method 1
        /*for(int j = 0;j<n;j++){
          if(isNeighbour(top, words[j], set)){
            queue.add(words[j]);
          }
        }*/
        //method 2
        StringBuffer neighbour = new StringBuffer(top);
        for(int j=0;j<neighbour.length();j++){
          for(char k='a';k<='z';k++){
            neighbour.setCharAt(j, k);
            if(wordSet.contains(neighbour.toString()) && !visited.contains(neighbour.toString())){
              //System.out.print(neighbour + " ");
              queue.add(neighbour.toString());
            }
        
            neighbour.setCharAt(j, top.charAt(j));
          }
        }
      }
      level++;
    }
    
    return -1;
  }
  
  static boolean isNeighbour(String current, String neighbor, HashSet<String> set){
    if(set.contains(neighbor)){
      return false;
    }
    
    if(current.length() != neighbor.length()){
      return false;
    }
    
    int diff = 0;
    for(int i=0;i<current.length();i++){
      if(current.charAt(i) != neighbor.charAt(i)){
        diff++;
      }
    }
    
    return diff == 1 ? true : false;
  }

	public static void main(String[] args) {
	  String source = "bit";
    String target = "dog";
    String[] words = {"but", "put", "big", "pot", "pog", "dog", "lot"};
    int ans = shortestWordEditPath(source, target, words);
    System.out.println(ans);
	}
}
/*
(bit, dog) => (bot, dog)
  i    j

n = number of words
m = avg size of words
time - O(n*(n*m)) = O(n^2 * m)

src = bit
words = ["but", "put", "big", "pot", "pog", "dog", "lot"]

bit -> but, big
        |
       put
        |
       pot
        |
*/
