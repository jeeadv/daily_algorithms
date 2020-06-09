//Sliding Window Median
//https://leetcode.com/problems/sliding-window-median/

// 2 treeset solution
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        TreeSet<Integer> left = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return nums[a] == nums[b] ? a - b : Integer.compare(nums[a], nums[b]);
            }
        });
        
        TreeSet<Integer> right = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return nums[a] == nums[b] ? a - b : Integer.compare(nums[a], nums[b]);
            }
        });
        
        for(int i = 0; i < k; i++) {
            left.add(i);
        }
        balance(left, right);
        //System.out.println(left + " " + right);
        
        double[] res = new double[nums.length - k + 1];
        res[0] = getMedian(left, right, nums);
        
        for(int i = k; i < nums.length; i++) {
            if(!left.remove(i - k)) {
                right.remove(i - k);
            }
            right.add(i);
            left.add(right.pollFirst());
            balance(left, right);
            //System.out.println(left + " " + right);
            res[i - k + 1] = getMedian(left, right, nums);
        }
        return res;
    }
    
    public double getMedian(TreeSet<Integer> left, TreeSet<Integer> right, int[] nums) {
        if(left.size() == right.size()) {
            //System.out.println(nums[left.last()] + " " + nums[right.first()]);
            return ((double)nums[left.last()] + (double)nums[right.first()]) / (double)2;
        }
        if(left.size() - right.size() >= 1) {
            //System.out.println(nums[left.last()]);
            return (double)nums[left.last()];
        }
        else {
            //System.out.println(nums[right.first()]);
            return (double)nums[right.first()];
        }
    }
    
    public void balance(TreeSet<Integer> left, TreeSet<Integer> right) {
        while(left.size() > right.size()) {
            right.add(left.pollLast());
        }
    }
}
