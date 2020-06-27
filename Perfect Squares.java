//Perfect Squares
//https://leetcode.com/problems/perfect-squares/

//dp n*sqrt(n)
class Solution {
    public int numSquares(int n) {
        int[] arr = new int[n + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = 0;
        int sqrt = (int) Math.sqrt(n);
        for(int i = 1; i <= sqrt; ++i) {
            arr[i * i] = 1;
            for(int num = i * i + 1; num <= n; ++num) {
                arr[num] = Math.min(arr[num], arr[num - i * i] + arr[i * i]);
            }
            //System.out.println(Arrays.toString(arr));
        }
        return arr[n];
    }
}
