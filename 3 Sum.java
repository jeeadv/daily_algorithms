//https://www.interviewbit.com/problems/3-sum/
//3 Sum

public class Solution {
    public int threeSumClosest(ArrayList<Integer> arr, int k) {
        int ans = 0;
        int n = arr.size();
        Collections.sort(arr);
        for(int i=0;i<n;i++){
            int l = i+1;
            int r = n-1;
            while(l<r){
                int sum = arr.get(l)+arr.get(r)+arr.get(i);
                if(sum<k){
                    l++;
                }
                else if(sum>k){
                    r--;
                }
                else{
                    return k;
                }
                
                if(isClose(sum,k,ans)){
                    ans = sum;
                }
            }
        }
        return ans;
    }
    public static boolean isClose(int sum, int k, int ans){
        if(Math.abs(sum-k)<Math.abs(ans-k)){
            return true;
        }
        return false;
    }
}
