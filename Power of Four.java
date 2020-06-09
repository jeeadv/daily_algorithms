//Power of Four
//https://leetcode.com/problems/power-of-four/

// log of num base 2 is always even if num = 4^n.
class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (Math.log(num) / Math.log(2)) % 2 == 0;
    }
}

// 0x55555555 is mask to check bits are at odd position.
class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }
}

// 4^n -1 is always divisible by 3.
class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
    }
}
