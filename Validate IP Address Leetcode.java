//Validate IP Address
//https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3362/

class Solution {
    static boolean[] map;
    
    static {
        map = new boolean[256];
        for(char i = '0'; i <= '9'; i++) {
            map[i] = true;
        }
        for(char i = 'a'; i <= 'f'; i++) {
            map[i] = true;
        }
        for(char i = 'A'; i <= 'F'; i++) {
            map[i] = true;
        }
    }
    
    public String validIPAddress(String ip) {
        if(ip.length() > 39) {
            return "Neither";
        }
        
        if(isIPv4(ip)) {
            return "IPv4";
        }
        else {
            return isIPv6(ip) ? "IPv6" : "Neither";
        }
    }
    
    public boolean isIPv4(String ip) {
        String[] ipv4 = ip.split("\\.", -1);
        if(ipv4 != null && ipv4.length == 4) {
            for(String str: ipv4) {
                String s = "";
                for(int i = 0; i < str.length(); i++) {
                    if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                        s += str.charAt(i);
                    }
                    else {
                        return false;
                    }
                }
                if(s == null || s.isEmpty()) {
                    return false;
                }
                int num = Integer.parseInt(s);
                if(num > 255 || String.valueOf(num).length() != str.length()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    public boolean isIPv6(String ip) {
        String[] ipv6 = ip.split(":", -1);
        //System.out.println(Arrays.toString(ipv6));
        if(ipv6 != null && ipv6.length == 8) {
            for(String str: ipv6) {
                //System.out.println(str + " " + str.length());
                if(str.length() < 1 || str.length() > 4) {
                    return false;
                }
                for(int i = 0; i < str.length(); i++) {
                    if(!map[str.charAt(i)]) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
