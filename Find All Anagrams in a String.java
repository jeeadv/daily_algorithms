//Find All Anagrams in a String
//https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3332/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] m1 = new int[26];
        for(int i = 0; i < p.length(); i++) {
            m1[p.charAt(i) - 'a']++;
        }
        
        int l = 0;
        int r = p.length();
        List<Integer> list = new LinkedList<>();
        
        while(r <= s.length()) {
            int[] m2 = new int[26];
            
            for(int i = l; i < r; i++) {
                m2[s.charAt(i) - 'a']++;
            }
            
            if(match(m1, m2)) {
                list.add(l);
            }
            
            l++;
            r++;
        }
        return list;
    }
    
    public static boolean match(int[] a, int[] b) {
        for(int i = 0; i < 26; i++) {
            if(a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
