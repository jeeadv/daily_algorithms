//Ransom Note
//https://leetcode.com/problems/ransom-note/

// index lookup

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        int index = 0;
        for(int i = 0; i < ransomNote.length(); i++) {
            index = magazine.indexOf(ransomNote.charAt(i), count[ransomNote.charAt(i) - 'a']);
            if(index == -1) {
                return false;
            }
            else {
                count[ransomNote.charAt(i) - 'a'] = index + 1;
            }
        }
        
        return true;
    }
}

// hashing
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        
        for(char c: magazine.toCharArray()) {
            count[c - 'a']++;
        }
        
        for(char c: ransomNote.toCharArray()) {
            if(--count[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
