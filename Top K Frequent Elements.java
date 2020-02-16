//Top K Frequent Elements

//https://leetcode.com/problems/top-k-frequent-elements/

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            if(map.get(nums[i]) == null){
                map.put(nums[i], 1);
            }
            else{
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        
        List<Node> list = new ArrayList<>();
        map.forEach( (ke, va) -> {
           list.add(new Node(ke, va)); 
        });
        
        Collections.sort(list, (a, b) -> {
            return b.freq - a.freq;
        });
        
        List<Integer> result = new LinkedList<>();
        for(int i = 0; i < k; i++){
            result.add(list.get(i).val);
        }
        return result;
    }
    
    public static class Node{
        int val;
        int freq;
        
        Node(int val, int freq){
            this.val = val;
            this.freq = freq;
        }
    }
}
