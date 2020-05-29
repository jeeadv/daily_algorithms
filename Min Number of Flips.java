//Min Number of Flips
//https://www.geeksforgeeks.org/minimum-number-of-replacements-to-make-the-binary-string-alternating-set-2/
//https://practice.geeksforgeeks.org/problems/min-number-of-flips/0
//https://www.geeksforgeeks.org/number-flips-make-binary-string-alternate/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while(t-->0){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int res = minFlip(s);
            System.out.println(res);
        }
    }
    
    public static int minFlip(String s) {
        char c = '0';
        int flip = 0;
        for(int i = 0; i < s.length(); i++) {
            if(c != s.charAt(i)) {
                flip++;
            }
            c = flip(c);
        }
        return Math.min(flip, s.length() - flip);
    }
    
    public static char flip(char c) {
        return c == '0' ? '1' : '0';
    }
}
