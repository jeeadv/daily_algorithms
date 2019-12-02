//Equal to product 
//https://practice.geeksforgeeks.org/problems/equal-to-product/0

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class GFG{
    public static void main(String[] args) throws IOException{
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());*/
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            //st = new StringTokenizer(br.readLine());
            //int n = Integer.parseInt(st.nextToken());
            int n = sc.nextInt();
            BigInteger k = new BigInteger(sc.next());
            
            //st = new StringTokenizer(br.readLine());
            long[] arr = new long[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextLong();//Long.parseLong(st.nextToken());
            }
            String res = solve(arr,n,k);
            System.out.println(res);
        }
    }
    public static String solve(long[] arr, int n, BigInteger k){
        
        HashSet<Long> set = new HashSet<>();
        for(int i=0;i<n;i++){
            if(arr[i] != 0){
                BigInteger b = new BigInteger(String.valueOf(arr[i]));
                if(Long.parseLong(String.valueOf(k.mod(b)))==0
                    && set.contains(Long.parseLong(String.valueOf(k.divide(b))))){
                    return "Yes";
                }
                set.add(arr[i]);
            }
            else{
                if(k.toString().equals("0")){
                    return "Yes";
                }
            }
        }
        return "No";
    }
}
