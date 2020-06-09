//Find Median from Data Stream
//https://leetcode.com/problems/find-median-from-data-stream/

// c++ multiset solution
class MedianFinder {
public:
    multiset<int> tree;
    std::multiset<int>::iterator mid;
    
    MedianFinder() {
        mid = tree.begin();
    }
    
    void addNum(int num) {
        if(tree.size() == 0) {
            mid = tree.insert(num);
            return;
        }
        if(tree.size() % 2 == 0) {
            tree.insert(num);
            if(num < *mid) {
                mid--;
            }
        }
        else {
            tree.insert(num);
            if(num > *mid || num == *mid) {
                mid++;
            }
        }
    }
    
    double findMedian() {
        if(tree.size() % 2 == 1) {
            return double(*mid);
        }
        else {
            double a = double(*mid);
            double b = double(*prev(mid, 1));
            return (a + b) / 2;
        }
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */

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

// sorting at each step

class MedianFinder {

    List<Integer> list;
        
    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add(num);
    }
    
    public double findMedian() {
        Collections.sort(list);
        
        if(list.size() % 2 == 1) {
            return list.get(list.size()/2);
        }
        else {
            double sum = list.get((list.size() - 1)/2) + list.get((list.size() + 1)/2);
            return sum / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

// insertion at each step assuming previous arr is sorted.

class MedianFinder {

    List<Integer> list;
        
    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        insert(num);
    }
    
    public double findMedian() {
        if(list.size() % 2 == 1) {
            return list.get(list.size()/2);
        }
        else {
            double sum = list.get((list.size() - 1)/2) + list.get((list.size() + 1)/2);
            return sum / 2.0;
        }
    }
    
    public void insert(int num) {
        int i = 0;
        
        while(i < list.size() && list.get(i) < num) {
            i++;
        }
        list.add(i, num);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

// Balanced BST solution

class MedianFinder {
    
    TreeSet<Integer> set;
    
    public MedianFinder() {
        set = new TreeSet<Integer>();
    }
    
    public void addNum(int num) {
        set.add(num);
    }
    
    public double findMedian() {
        Integer ans;
        
        if(set.size() % 2 == 1) {
            ans = getTreeRoot(set);
        }
        else {
            ans = 0;
        }
        return Double.valueOf(ans);
    }
    
    @SuppressWarnings("unchecked")
    public static Integer getTreeRoot(TreeSet<Integer> ts) {
        try {
            java.lang.reflect.Field mField = TreeSet.class.getDeclaredField("m");
            mField.setAccessible(true);
            return getTreeRoot((TreeMap<Integer, Object>) mField.get(ts));
        } 
        catch (NoSuchFieldException | IllegalAccessException e) {
            throw new IllegalStateException("Internals of TreeSet has changed", e);
        }
    }
    
    @SuppressWarnings("unchecked")
    public static <K,V> K getTreeRoot(TreeMap<K,V> tm) {
        try {
            java.lang.reflect.Field rootField = TreeMap.class.getDeclaredField("root");
            rootField.setAccessible(true);
            Map.Entry<K,V> root = (Map.Entry<K,V>) rootField.get(tm);
            return (root == null ? null : root.getKey());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new IllegalStateException("Internals of TreeMap has changed", e);
        }
    }
}
