//Find a triplet that sum to a given value
//https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/

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
            int res = solve(arr, n, k);
            System.out.println(res);
        }
    }
    public static int solve(int[] arr, int n, int k){
        HashSet<Integer> set;
        for(int i=0;i<n;i++){
            int newk = k-arr[i];
            set = new HashSet<>();
            for(int j=i+1;j<n;j++){
                if(set.contains(newk- arr[j])){
                    return 1;
                }
                set.add(arr[j]);
            }
        }
        return 0;
    }
}
