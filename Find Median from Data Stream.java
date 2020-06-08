//Find Median from Data Stream
//https://leetcode.com/problems/find-median-from-data-stream/

// 2 priority queue (heap) solution

class MedianFinder {
    
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;
    
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
    }
    
    public void addNum(int num) {
        if(maxHeap.size() == 0) {
            maxHeap.add(num);
            return;
        }
        
        if(num < maxHeap.peek()) {
            maxHeap.add(num);
        }
        else {
            minHeap.add(num);
        }
        
        if(maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        }
        else if(minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        else if(maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        else {
            return minHeap.peek();
        } 
    }
}
