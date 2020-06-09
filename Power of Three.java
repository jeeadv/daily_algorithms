//Power of Three
//https://leetcode.com/problems/power-of-three/

class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 0) {
            return false;
        }
        
        while(n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}

class Solution {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}

class Solution {

    int[] arr = {1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969, 14348907, 43046721, 129140163, 387420489, 1162261467};
        
    public boolean isPowerOfThree(int n) {
        return Arrays.binarySearch(arr, n) >= 0;
    }
}

class Solution {
    static List<Integer> list = new ArrayList<>(32);
        
    static {
        int val = 1;
        list.add(val);
        for(int i = 1; i < 32; i++) {
            val *= 3;
            list.add(val);
        }
    }
        
    public boolean isPowerOfThree(int n) {
        return list.contains(n);
    }
}

class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 0) {
            return false;
        }
        else if(n == 1) {
            return true;
        }
        else if(n % 3 != 0) {
            return false;
        }
        return isPowerOfThree(n / 3);
    }
}
