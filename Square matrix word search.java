//square matrix word search.
//given a square matrix of alphabet find words. left to right horizontal, up to down vertical, diagonal left to up
//diagonal left to down

package geeks;

/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/

import java.util.*;
public class CandidateCode {
    public static void main(String args[] ) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	String[][] arr = new String[n][n];
    	for(int i=0;i<n;i++){
    		arr[i] = sc.next().split("#");
    	}
    	String str = sc.next();
    	if("".equals(str)){
    		System.out.print(0);
    	}
    	else if(str.length() == 1){
    		int count = 0;
    		for(int i=0;i<n;i++){
    			for(int j=0;j<n;j++){
    				if(arr[i][j].equals(str)){
    					count++;
    				}
    			}
    		}
    		System.out.print(count);
    	}
    	else{
    		int ans = solve(arr, n, str);
        	System.out.print(ans);
    	}
    	sc.close();
   }
   
   public static int solve(String[][] arr, int n, String pattern){
	   String text;
	   int ans = 0;
	   
	   for(int i=0;i<n;i++){
		   text = get_left_to_right_horizontally(arr,i,0,n);
		   ans += kmp(text, pattern);
	   }
	   
	   for(int j=0;j<n;j++){
		   text = get_up_to_down_vertically(arr,0,j,n);
		   ans += kmp(text, pattern);
	   }
	  
	   for(int i=0;i<n;i++){
		   text = get_left_to_down_diagonally(arr,i,0,n);
		   ans += kmp(text, pattern);
	   }
	   
	   for(int j=1;j<n;j++){
		   text = get_left_to_down_diagonally(arr,0,j,n);
		   ans += kmp(text, pattern);
	   }
	   
	   for(int i=0;i<n;i++){
		   text = get_left_to_up_diagonally(arr,i,0,n);
		   ans += kmp(text, pattern);
	   }
	   
	   for(int j=1;j<n;j++){
		   text = get_left_to_up_diagonally(arr,0,j,n);
		   ans += kmp(text, pattern);
	   }
	   
	   return ans;
   }
   
   public static String get_left_to_right_horizontally(String[][] arr, int i, int j, int n){
	   String str = "";
	   while(j<n){
		   str += arr[i][j];
		   j++;
	   }
	   return str;
   }
   
   public static String get_up_to_down_vertically(String[][] arr, int i, int j, int n){
	   String str = "";
	   while(i<n){
		   str += arr[i][j];
		   i++;
	   }
	   return str;
   }
   
   public static String get_left_to_down_diagonally(String[][] arr, int i, int j, int n){
	   String str = "";
	   while(i<n && j<n){
		   str += arr[i][j];
		   i++;
		   j++;
	   }
	   return str;
   }
   
   public static String get_left_to_up_diagonally(String[][] arr, int i, int j, int n){
	   String str = "";
	   while(i>=0 && j<n){
		   str += arr[i][j];
		   i--;
		   j++;
	   }
	   return str;
   }
   
   public static int kmp(String txt, String pat) { 
	   int ans = 0;
       int M = pat.length(); 
       int N = txt.length(); 
 
       
       int lps[] = new int[M]; 
       int j = 0; 
 
       
       computeLPSArray(pat, M, lps); 
 
       int i = 0; 
       while (i < N) { 
           if (pat.charAt(j) == txt.charAt(i)) { 
               j++; 
               i++; 
           } 
           if (j == M) { 
               ans++; 
               j = lps[j - 1]; 
           } 
           else if (i < N && pat.charAt(j) != txt.charAt(i)) { 
               
               if (j != 0) 
                   j = lps[j - 1]; 
               else
                   i = i + 1; 
           } 
       } 
       return ans;
   } 
   
   public static void computeLPSArray(String pat, int M, int lps[]) 
   { 
       
       int len = 0; 
       int i = 1; 
       lps[0] = 0; 
 
       while (i < M) { 
           if (pat.charAt(i) == pat.charAt(len)) { 
               len++; 
               lps[i] = len; 
               i++; 
           } 
           else 
           { 
               if (len != 0) { 
                   len = lps[len - 1]; 
               } 
               else
               { 
                   lps[i] = len; 
                   i++; 
               } 
           } 
       } 
   }
}
