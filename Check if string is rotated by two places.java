//https://www.geeksforgeeks.org/check-string-can-obtained-rotating-another-string-2-places/
//Check if string is rotated by two places 

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while(t-->0){
            String a = br.readLine();
            String b = br.readLine();
            int found = 0;
            if(a.length() != b.length()){
                found = 0;
            }
            else{
                found = match(a,b);
            }
            System.out.println(found);
        }
    }
    public static int match(String a, String b){
        int found = -1;
        int n = a.length();
        for(int i=0;i<n;i++){
            if(a.charAt((i+2)%n) != b.charAt(i)){
                found = 0;
            }
        }
        if(found == -1){
            return 1;
        }
        found = -1;
        for(int i=0;i<n;i++){
            if(a.charAt((i-2+n)%n) != b.charAt(i)){
                found = 0;
            }
        }
        if(found == -1){
            return 1;
        }
        else{
            return 0;
        }
    }
}
