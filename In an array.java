//https://www.interviewbit.com/problems/in-an-array/
//In an array

public class Solution {
    public int solve(ArrayList<Integer> A, int B, int C, int D) {
        int n = 1005;
        int[] arr = new int[n+1];
        
        for(int i: A){
            arr[i] += 1;
        }
        long ans = 0;
        long MOD = 1000000007;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                int m1 = (i+j)%B;
                int m2 = (i*j)%B;
                if(i == j){
                    if(m1 == C && m2 == D){
                        ans += (arr[i]*(arr[j]-1));
                    }
                }
                else{
                    if(m1 == C && m2 == D){
                        ans += (arr[i]*arr[j]);
                    }
                }
            }
        }
        ans /= 2;
        ans %= MOD;
        return (int)ans;
    }
}
