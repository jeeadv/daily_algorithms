//Power of Two
//https://leetcode.com/problems/power-of-two/

// bit manipulation
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}

// recursive

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) {
            return false;
        }
        else if(n == 1) {
            return true;
        }
        else if(n % 2 == 1) {
            return false;
        }
        return isPowerOfTwo(n / 2);
    }
}
