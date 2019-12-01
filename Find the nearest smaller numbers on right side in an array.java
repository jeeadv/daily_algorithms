//Find the nearest smaller numbers on right side in an array
//Find the nearest smaller numbers on left side in an array
//https://www.geeksforgeeks.org/find-the-nearest-smaller-numbers-on-left-side-in-an-array/

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
            int[] arr = new int[n];
            
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            solve(arr, n);
            System.out.println();
        }
    }
    public static void solve(int[] arr, int n){
        Stack<Integer> s = new Stack<>();
        int[] res = new int[n];
        
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && arr[i]<s.peek()){
                s.pop();
            }
            if(s.isEmpty()){
                res[i] = -1;
            }
            else{
                res[i] = s.peek();
            }
            s.push(arr[i]);
        }
        for(int i=0;i<n;i++){
            System.out.print(res[i]+" ");
        }
    }
}
