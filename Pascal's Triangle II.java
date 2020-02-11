//Pascal's Triangle II
//https://leetcode.com/problems/pascals-triangle-ii/
class Solution {
    public List<Integer> getRow(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        
        if(n == 0){
            return list;
        }
        
        for(int i = 1; i < n; i++){
            long prev = list.get(i - 1);
            long num =  prev * (n - i + 1) / i;
            list.add((int)num);
        }
        
        list.add(1);
        return list;
    }
}
