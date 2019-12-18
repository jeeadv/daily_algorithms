//Regular Expression Matching
//https://leetcode.com/problems/regular-expression-matching/

class Solution {
    public boolean isMatch(String s, String p) {
      	if(s == null || p == null){
	return false;
	}
	int m = s.length();
	int n = p.length();
	return f(s, p, m-1, n-1);
    }
    
    public boolean f(String s, String p, int i, int j){
	   
	if(i == -1){
	   return (j == -1) || checkStar(p, j) ? true : false;
	}
	if(i < 0 || j < 0){
	   return false;
	}
	  
	   if(p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'){
		   return f(s, p, i-1, j-1);
	   }
	   
	   if(p.charAt(j) == '*'){
		   if(j-1 >=0 && (p.charAt(j-1) == s.charAt(i) || p.charAt(j-1) == '.')){
			   return f(s, p, i, j-2) || f(s, p, i, j-1) || f(s, p, i-1, j);
		   }
		   if(j-1 >= 0 && p.charAt(j-1) != s.charAt(i)){
			   return f(s, p, i, j-2);
		   }
	   }
	   return false;
   }
   boolean checkStar(String p, int j){
       if(j<0){
           return false;
       }
       if(j % 2 == 0){
           return false;
       }
       for(int i=1;i<=j;i+=2){
           if(p.charAt(i) != '*'){
               return false;
           }
       }
       return true;   
   }
    
}
