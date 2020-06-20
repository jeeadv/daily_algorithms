//Permutation Sequence
//https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3366/
class Solution {
    int count = 0;
    public String getPermutation(int n, int k) {
        count = 0;
        String str = "";
        for(int i = 1; i <= n; i++) {
            str += i;
        }
        
        return fun(str, 0, n, k);
    }
    
    public String fun(String str, int i, int n, int k) {
        if(i == n - 1) {
            count++;
            //System.out.println(count + " " + str);
            if(count == k) {
                return str;
            }
            return null;
        }
        for(int j = i; j < n; j++) {
            char[] arr = swap(str, i, j).toCharArray();
            Arrays.sort(arr, i + 1, n);
            String s = fun(new String(arr), i + 1, n, k);
            if(s != null) {
                return s;
            }
        }
        return null;
    }
    
    public String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
        return sb.toString();
    }
}
