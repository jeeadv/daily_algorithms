//Pascal's Triangle
//https://leetcode.com/problems/pascals-triangle/

class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(n >= 1){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            result.add(list);
        }
        
        if(n >= 2){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(1);
            result.add(list);
        }
        
        for(int i = 2; i < n; i++){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for(int j = 0; j < result.get(i - 1).size() - 1; j++){
                list.add(result.get(i - 1).get(j) + result.get(i - 1).get(j + 1));
            }
            list.add(1);
            result.add(list);
        }
        return result;
    }
}
