//Longest Increasing Subsequence 
//recursive approach
//https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence/0


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG{
    static int globalMax = 1;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while(t-->0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            globalMax = 1;
            if(n == 0){
                globalMax = 0;
            }
            else{
                solve(arr,n-1);
            }
            System.out.println(globalMax);
        }
    }
    public static int solve(int[] arr, int n){
        if(n == 0){
            return 1;
        }
        else{
            int max = 1;
            for(int i=0;i<n;i++){
                
                    int len = 1 + solve(arr,i);
                    if(arr[n]>arr[i] && len>max){
                        max = len;
                    }
                
            }
            if(max>globalMax){
                globalMax = max;
            }
            return max;
        }
    }
}
