//https://www.interviewbit.com/problems/stairs/
//Stairs

public class Solution {
    public int climbStairs(int A) {
        if(A<0){
            return 0;
        }
        if(A==0){
            return 1;
        }
        return climbStairs(A-1) + climbStairs(A-2);
    }
}


//using dynamic programming
public class Solution {
    public static int[] sum = new int[37];

    public int climbStairs(int A) {
        for(int i=0;i<37;i++){
            sum[i] = -1;
        }
        return fun(A);
    }
    public int fun(int n){
        if(n<0){
            return 0;
        }
        if(n == 0){
            return sum[n] = 1;
        }
        int left = 0;
        if(n-1>=0 && sum[n-1] == -1){
            left = sum[n-1] = fun(n-1);
        }
        else if(n-1>=0){
            left = sum[n-1];
        }
        int right = 0;
        if(n-2>=0 && sum[n-2] == -1){
            right = sum[n-2] = fun(n-2);
        }
        else if(n-2>=0){
            right = sum[n-2];
        }
        return sum[n] = left + right;
    }
}

