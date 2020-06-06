//Queue Reconstruction by Height
//https://leetcode.com/problems/queue-reconstruction-by-height/

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int[][] res = new int[people.length][];
        
        Arrays.sort(people, new Comparator<int[]>() {
            
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        
        
        
        for(int i = 0; i < people.length; i++) {
            int index = getIndex(res, people[i]);
            //System.out.println(index);
            res[index] = new int[] {people[i][0], people[i][1]};
        }
        
        return res;
    }
    
    public int getIndex(int[][] res, int[] a) {
        int count = a[1];
        
        for(int i = 0; i < res.length; i++) {
            if(res[i] == null) {
                if(count == 0) {
                    return i;
                }
                count--;
            }
            else {
                if(res[i][0] >= a[0]) {
                    count--;
                }
            }
        }
        
        return res.length - 1;
    }
}
