//https://www.interviewbit.com/problems/longest-palindromic-substring/
//Longest Palindromic Substring
public class Solution {
    public String longestPalindrome(String str) {
        int n = str.length();
        int max = Integer.MIN_VALUE;
        int indexL = -1;
        int indexR = -1;
        
        for(int i=0;i<n;i++){
            int len = oddpal(str, i);
            //System.out.println("oddpal:i="+i+" len="+len);
            if(len>max){
                max = len;
                indexL = i;
            }
        }
        for(int i=1;i<n;i++){
            int len = evenpal(str, i-1, i);
            //System.out.println("evenpal:i="+i+" len="+len);
            if(len>max){
                max = len;
                indexL = i-1;
                indexR = i;
            }
        }
        
        if(indexL != -1 && indexR != -1){
            int l = indexL;
            int r = indexR;
            while(l>=0 && r<n){
                if(str.charAt(l) != str.charAt(r)){
                    break;
                }
                l--;
                r++;
            }
            return str.substring(l+1,r);
        }
        else if(indexL != -1){
            int l = indexL-1;
            int r = indexR+1;
            while(l>=0 && r<n){
                if(str.charAt(l) != str.charAt(r)){
                    break;
                }
                l--;
                r++;
            }
            return str.substring(l+1,r);
        }
        else{
            return "";
        }
    }
    public static int oddpal(String str, int mid){
        int n = str.length();
        int l = mid-1;
        int r = mid+1;
        while(l>=0 && r<n){
            if(str.charAt(l) != str.charAt(r)){
                return r-l-1;
            }
            l--;
            r++;
        }
        return r-l-1;
    }
    public static int evenpal(String str, int l, int r){
        int n = str.length();
        
        while(l>=0 && r<n){
            if(str.charAt(l) != str.charAt(r)){
                return r-l-1;
            }
            l--;
            r++;
        }
    return r-l-1;
    }
}
