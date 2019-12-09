//Word Count Engine
//https://www.pramp.com/challenge/W5EJq2Jld3t2ny9jyZXG
//O(nlogn) time and O(n) space
import java.io.*;
import java.util.*;



class Solution {

  static String[][] wordCountEngine(String document) {
    LinkedHashMap<String, Integer> hashMap = new LinkedHashMap<>();
    
    String[] arr = document.split(" ");
    for(int i=0;i<arr.length;i++){
      String key = arr[i];
      key = format(key);
      if("".equals(key)){
        continue;
      }
      if(hashMap.containsKey(key)){
        int count = hashMap.get(key);
        hashMap.put(key, count+1);
      }
      else{
        hashMap.put(key, 1);
      }
    }
    
    List<Node> list = new ArrayList<>();
    
    hashMap.forEach((k,v)->{
    	list.add(new Node(k,v));
    });
    
    list.sort((a,b)->{
    	return b.count - a.count;
    });
    
    String[][] res = new String[list.size()][2];
    int i = 0;
    for(Node node: list){
      res[i] = new String[2];
      res[i][0] = node.key;
      res[i][1] = node.count.toString();
      i++;
    }
    return res;
  }
  
  
  
  public static String format(String str){
    str = str.toLowerCase();
    String formatted = "";
    for(int i=0;i<str.length();i++){
      if(str.charAt(i)>='a' && str.charAt(i)<='z'){
        formatted += str.charAt(i);
      }
    }
    return formatted;
  }
  
  static class Node{
    String key;
    Integer count;
    Node(String key, int count){
      this.key = key;
      this.count = count;
    }
  }

  public static void main(String[] args) {
	 //String str = "Practice makes perfect. you'll only get Perfect by practice. just practice!";
	 //String[][] arr = wordCountEngine(str);
	 
	 //for(String[] a: arr){
		 //System.out.println(Arrays.toString(a));
	 //}
  }

}

//by bucket sort- time (n) space (n*maxFrequency) where n is number of words.



import java.util.*;

class Solution {

  static String[][] wordCountEngine(String document) {
    LinkedHashMap<String, Integer> hashMap = new LinkedHashMap<>();
    
    int bucketSize = 1;
    String[] arr = document.split(" ");
    for(int i=0;i<arr.length;i++){
      String key = arr[i];
      key = format(key);
      if("".equals(key)){
        continue;
      }
      if(hashMap.containsKey(key)){
        int count = hashMap.get(key);
        hashMap.put(key, count+1);
        if(count+1>bucketSize){
        	bucketSize = count+1;
        }
      }
      else{
        hashMap.put(key, 1);
      }
    }
    
    //System.out.println(hashMap);
    
    List[] bucket = new List[bucketSize+1];
    
    hashMap.forEach((k,v)->{
    	if(bucket[v] == null){
    		bucket[v] = new ArrayList<>();
    	}
    	bucket[v].add(k);
    });
    
    /*for(List list: bucket){
    	System.out.println(list);
    }*/
    
    String[][] res = new String[hashMap.size()][2];
    int i = 0;
    
    for(int j = bucketSize;j>=0;j--){
      List<String> list = bucket[j];
      if(list != null && list.size()>0){
    	  for(String s:list){
        	  res[i] = new String[2];
        	  res[i][0] = s;
        	  res[i][1] = ((Integer)j).toString();
        	  i++;
          }
      }
    }
    return res;
  }
  
  
  
  public static String format(String str){
    str = str.toLowerCase();
    String formatted = "";
    for(int i=0;i<str.length();i++){
      if(str.charAt(i)>='a' && str.charAt(i)<='z'){
        formatted += str.charAt(i);
      }
    }
    return formatted;
  }

  public static void main(String[] args) {
	 String str = "Practice makes perfect. you'll only get Perfect by practice. just practice!";
	 String[][] arr = wordCountEngine(str);
	 
	 for(String[] a: arr){
		 System.out.println(Arrays.toString(a));
	 }
  }

}

