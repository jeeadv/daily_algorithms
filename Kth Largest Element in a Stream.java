//Kth Largest Element in a Stream
//https://leetcode.com/problems/kth-largest-element-in-a-stream/

class KthLargest {
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int k;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        
        for(int i = 0; i < k && i < nums.length; i++) {
            heap.add(nums[i]);
        }
        
        for(int i = k; i < nums.length; i++) {
            if(heap.peek() != null && nums[i] > heap.peek()) {
                heap.poll();
                heap.add(nums[i]);
            }
        }
    }
    
    public int add(int val) {
        if(heap.size() < k) {
            heap.add(val);
        }
        else {
            if(val > heap.peek()) {
                heap.poll();
                heap.add(val);
            }
        }
        
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
