//Key Pair 
//https://practice.geeksforgeeks.org/problems/key-pair/0

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
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            String res = solve(arr, n, k);
            System.out.println(res);
        }
    }
    public static String solve(int[] arr, int n, int k){
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0;i<n;i++){
            if(set.contains(k-arr[i])){
                return "Yes";
            }
            set.add(arr[i]);
        }
        return "No";
    }
}
