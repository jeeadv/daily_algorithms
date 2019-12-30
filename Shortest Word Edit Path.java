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
	  HashSet<String> set = new HashSet<>();
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
        set.add(top);
        for(int j = 0;j<n;j++){
          if(isNeighbour( top, words[j], set)){
            queue.add(words[j]);
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
