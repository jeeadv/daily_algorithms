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


class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            if(map.get(nums[i]) == null){
                map.put(nums[i], 1);   
            }
            else{
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        
        List<Integer>[] bucket = new List[nums.length + 1];
        
        map.forEach((key, val) -> {
            if(bucket[val] == null){
                bucket[val] = new LinkedList<>();
            }
            
            bucket[val].add(key);
        });
        
        List<Integer> list = new LinkedList<>();
        
        for(int i = bucket.length - 1; i >=0 && list.size() < k; i--){
            if(bucket[i] != null){
                int size = bucket[i].size() < k - list.size() ? bucket[i].size() :  k - list.size();
                list.addAll(bucket[i].subList(0, size));
            }
        }
        
        return list;
    }
    
}
