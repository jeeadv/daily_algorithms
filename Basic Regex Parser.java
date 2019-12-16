//Basic Regex Parser
//https://www.pramp.com/challenge/KvZ3aL35Ezc5K9Eq9Llp


class Solution {
  
  static boolean isMatch(String text, String pattern) {
	  return fun(text, pattern, 0, 0);
  }
  static boolean fun(String text, String pattern, int i, int j){
	  //System.out.println(text.substring(i)+" "+pattern.substring(j));
	  if(i == text.length() && j == pattern.length()){
		  return true;
	  }
	  else if(i == text.length() && j == pattern.length() - 2 && pattern.charAt(pattern.length() - 1) == '*'){
		  return true;
	  }
	  else if(i == text.length() && j < pattern.length()){
		  return false;
	  }
	  else if(i < text.length() && j == pattern.length()){
		  return false;
	  }
	  else if(i < text.length() && pattern.charAt(j) == '.'){
		  return fun(text, pattern, i+1, j+1);
	  }
	  else{
		  if(j+1<pattern.length() && pattern.charAt(j+1) == '*'){
			  if(text.charAt(i) == pattern.charAt(j)){
				  return fun(text, pattern, i, j+2) || fun(text, pattern.substring(0,j) + pattern.charAt(j) + pattern.substring(j), i, j);
			  }
			  else{
				  return fun(text, pattern, i, j+2);
			  }
			  
		  }
		  else{
			  return fun(text, pattern, i+1, j+1);
		  }
	  }
		
  }

  public static void main(String[] args) {
	  String text;
    String pattern;
    boolean ans;
    text = "aa";
    pattern = "a";
    ans = isMatch(text, pattern);
    System.out.println(text + " " + pattern + " " + ans);
    
    text = "aa";
	  pattern = "aa";
    ans = isMatch(text, pattern);
    System.out.println(text + " " + pattern + " " + ans);
    
    text = "abc";
	  pattern = "a.c";
    ans = isMatch(text, pattern);
    System.out.println(text + " " + pattern + " " + ans);
    
    text = "abbb";
	  pattern = "ab*";
    ans = isMatch(text, pattern);
    System.out.println(text + " " + pattern + " " + ans);
    
    text = "acd";
	  pattern = "ab*c.";
    ans = isMatch(text, pattern);
    System.out.println(text + " " + pattern + " " + ans);

    text = "abaa";
	  pattern = "a.*a*";
    ans = isMatch(text, pattern);
    System.out.println(text + " " + pattern + " " + ans);
    
    text = "abbdbb";
	  pattern = "ab*d";
    ans = isMatch(text, pattern);
    System.out.println(text + " " + pattern + " " + ans);
  }

}
/*
(b, b*b) => (b, b)
|
(b, bb*b)

text = "acd", pattern = "abc."
          i                  j
          
text = "bb", pattern = "bb*b"   => true
         i                j


("abb" , "abb*b") => ("bb" , "bb*b") => ("b" , "b*b") => ("b" , "bb*")
                                                
                                         
                                          

("abc", "a.c") => ("bc", ".c") => ("c", "c") => ("", "") => true
("abbb", "ab*") => ("bbb", "b*") => ("bbb", "bb*") => ("bb", "b*") => ("b", "b*") => ("b", "bb*") => ("", "b*") = true
*/
