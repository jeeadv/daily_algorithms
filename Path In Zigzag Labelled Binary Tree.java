//Path In Zigzag Labelled Binary Tree
//https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/

class Solution {
    public List<Integer> pathInZigZagTree(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        
        String binary = dToB(n);
        System.out.println(binary);
        
        boolean even = true;
        for(int i = binary.length() - 1;i >= 0;i--){
            int num = bToD(binary, i, even);
            list.addFirst(num);
            even = !even;
        }
        return list;
    }
    
    public String dToB(int n){
        String str = "";
        while(n > 0){
            str = n % 2 + str;
            n /= 2;
        }
        return str;
    }
    
    public int bToD(String binary, int n, boolean even){
        int res = 0;
        int base = 1;
        if(even){
            base = 1;
            for(int i = n; i >= 0; i--){
                if(binary.charAt(i) == '1')
                    res += base;
                base *= 2;
            }
        }
        else{
            base = 1;
            for(int i = n; i >= 1; i--){
                if(comp(binary.charAt(i)) == '1')
                    res += base;
                base *= 2;
            }
            res += base;
        }
        return res;
    }
    
    public int comp(char i){
        return i == '1' ? '0' : '1';
    }
}
