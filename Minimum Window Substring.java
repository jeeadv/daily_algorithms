//Minimum Window Substring
//https://leetcode.com/problems/minimum-window-substring/

//optimized O(n)
class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for(int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }
        
        int min = Integer.MAX_VALUE;
        int minL = -1;
        int minR = -1;
        int l = 0;
        int r = 0;
        int count = 0;
        
        while(r < s.length()) {
            
            while(r < s.length() && count < t.length()) {
                if(map[s.charAt(r)]-- > 0) {
                    count++;
                }
                r++;
            }
            
            while(l < r && count == t.length()) {
                if(map[s.charAt(l)]++ == 0) {
                    count--;
                }
                if(r - l < min) {
                    min = r -l;
                    minL = l;
                    minR = r;
                }
                l++;
            }
        }
        if(minL == -1 || minR == -1) {
            return "";
        }
        return s.substring(minL, minR);
    }
    
}

// O(n*256)

class Solution {
    public String minWindow(String s, String t) {
        int[] tt = new int[256];
        for(int i = 0; i < t.length(); i++) {
            tt[t.charAt(i)]++;
        }
        
        int[] ss = new int[256];
        int min = Integer.MAX_VALUE;
        int minL = 0;
        int minR = 0;
        int l = 0;
        int r = 0;
        
        while(r < s.length()) {
            
            while(r < s.length() && !match(tt, ss)) {
                //System.out.println("r:" + r);
                ss[s.charAt(r)]++;
                r++;
            }
            
            while(l < r && match(tt, ss)) {
                //System.out.println("l:" + l);
                ss[s.charAt(l)]--;
                
                if(r - l < min) {
                    min = r -l;
                    minL = l;
                    minR = r;
                }
                //System.out.println(minL + " " + minR + " " + min);
                
                l++;
                
            }
        }
        //System.out.println(minL + " " + minR + " " + min);
        return s.substring(minL, minR);
    }
    
    public boolean match(int[] tt, int[] ss) {
        for(int i = 0; i < 256; i++) {
            if(tt[i] > ss[i]) {
                return false;
            }
        }
        return true;
    }
}
