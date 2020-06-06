//Random Pick with Weight
//https://leetcode.com/problems/random-pick-with-weight/

class Solution {

    int[] arr;
    Random random = new Random();
    
    public Solution(int[] w) {
        arr = new int[w.length];
        arr[0] = w[0];
        
        for(int i = 1; i < w.length; i++) {
            arr[i] = w[i] + arr[i - 1];
        }
    }
    
    public int pickIndex() {
        int num = random.nextInt(arr[arr.length - 1]) + 1;
        int l = 0;
        int r = arr.length - 1;
        
        while(l <= r) {
            int mid = (l + r) / 2;
            
            if(num == arr[mid]) {
                return mid;
            }
            else if(num < arr[mid]) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
