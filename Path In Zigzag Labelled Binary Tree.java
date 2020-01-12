//Path In Zigzag Labelled Binary Tree
//https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/

class Solution {
    public List<Integer> pathInZigZagTree(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        
        while(n > 1){
            list.addFirst(n);
            n = n/2;
            n = inverse(n);
        }
        list.addFirst(1);
        return list;
    }
    
    public int inverse(int n){
        int res = 0;
        int base = 1;
        while(n > 1){
            int d = n % 2;
            if(d == 0){
                res += base;
            }
            base *= 2;
            n /= 2;
        }
        res += base;
        return res;
    }
    
    public List<Integer> pathInZigZagTree1(int n) {
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
