//Number of 1 Bits
//https://leetcode.com/problems/number-of-1-bits/

// right shift
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        
        for(int i = 0; i < 32; i++) {
            if((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }
}

// deleting set bits from right to left
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            n &= n-1;
            count++;
        }
        return count;
    }
}
