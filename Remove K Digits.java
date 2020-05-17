//Remove K Digits
//https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3328/

class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == k) {
            return "0";
        }
        
        StringBuilder str = new StringBuilder(num);
        
        while(k-- > 0) {
            int i = 0;
            while((i+1) < str.length() && str.charAt(i) <= str.charAt(i + 1)) {
                i++;
            }
            //System.out.println(str.charAt(i));
            str.deleteCharAt(i);
        }
        
        int i = 0;
        while(i < str.length() && str.charAt(i) == '0') {
            str.deleteCharAt(i);
        }
        
        if(str.length() == 0) {
            str = new StringBuilder("0");
        }
        
        return str.toString();
    }
}
