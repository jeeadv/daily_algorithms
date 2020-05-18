//Permutation in String
//https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3333/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] m1 = new int[26];
        
        for(int i = 0; i < s1.length(); i++) {
            m1[s1.charAt(i) - 'a']++;
        }
        
        int l = 0;
        int r = s1.length();
        
        while(r <= s2.length()) {
            int[] m2 = new int[26];
            for(int i = l; i < r; i++) {
                m2[s2.charAt(i) - 'a']++;
            }
            //System.out.println(Arrays.toString(m1) + "\n" + Arrays.toString(m2));
            if(match(m1, m2)) {
                return true;
            }
            l++;
            r++;
        }
        return false;
    }
    
    public static boolean match(int[] m1, int[] m2) {
        for(int i = 0; i < 26; i++) {
            if(m1[i] != m2[i]) {
                return false;
            }
        }
        return true;
    }
}
