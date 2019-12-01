//https://www.interviewbit.com/problems/seats/
//Seats

public class Solution {
    public int seats(String str) {
        if(str.length() == 1){
            return 0;
        }
        
        int[] list = new int[5000000];
        int n = 0;
        int median = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == 'x'){
                list[n++] = i;
            }
        }
        if(n == 0 || n == 1){
            return 0;
        }
        
        if(n%2 == 0){
            median = list[(n/2)-1];
        }
        else{
            median = list[n/2];
        }
        int ans = 0;
        int count = 0;
        int MOD = 10000003;
        for(int i=median-1;i>=0;i--){
            if(str.charAt(i) == 'x'){
                ans += count;
                ans %= MOD;
            }
            else{
                count++;
                count %=MOD;
            }
        }
        count = 0;
        for(int i=median+1;i<str.length();i++){
            if(str.charAt(i) == 'x'){
                ans += count;
                ans %= MOD;
            }
            else{
                count++;
                count %= MOD;
            }
        }
        return ans;
    }
}
