//Count pairs with given sum
//https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum/0
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
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            Integer count1 = map.get(k-arr[i]);
            if(count1 == null){
                count1 = 0;
            }
            ans += count1;
            
            Integer count2 = map.get(arr[i]);
            if(count2 == null){
                count2 = 0;
            }
            map.put(arr[i], count2+1);
        }
        return ans;
    }
}
