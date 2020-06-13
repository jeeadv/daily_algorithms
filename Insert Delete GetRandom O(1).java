// Insert Delete GetRandom O(1)
//https://leetcode.com/problems/insert-delete-getrandom-o1/

class RandomizedSet {

    /** Initialize your data structure here. */
    List<Integer> list;
    Map<Integer, Integer> map;
    Random random;
    
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        else {
            list.add(val);
            map.put(val, list.size() - 1);
            //System.out.println(list + " " + map + " add");
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)) {
            int index = map.get(val);
            int last = list.get(list.size() - 1);
            list.set(index, last);
            map.put(last, index);
            
            list.remove(list.size() - 1);
            map.remove(val);
            //System.out.println(list + " " + map + " remove");
            return true;
        }
        else {
            return false;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
