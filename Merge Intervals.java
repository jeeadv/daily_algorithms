//Merge Intervals
//https://leetcode.com/problems/merge-intervals/

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) {
            return intervals;
        }
        
        Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
        
        List<List<Integer>> list = new LinkedList<>();
        
        for(int i = 1; i < intervals.length; i++) {
            if(intersects(intervals[i - 1], intervals[i])) {
                intervals[i - 1][0] = intervals[i][0] = Math.min(intervals[i-1][0], intervals[i][0]);
                intervals[i - 1][1] = intervals[i][1]= Math.max(intervals[i-1][1], intervals[i][1]);
            }
            else {
                List<Integer> sublist = new LinkedList<>();
                sublist.add(intervals[i - 1][0]);
                sublist.add(intervals[i - 1][1]);
                if(list.size() == 0) {
                    list.add(sublist);
                }
                else if(!match(list.get(list.size() - 1), sublist)){
                    list.add(sublist);
                }
            }
            
        }
        
        List<Integer> sublist = new LinkedList<>();
        sublist.add(intervals[intervals.length - 1][0]);
        sublist.add(intervals[intervals.length - 1][1]);
        
        if(list.size() == 0) {
            list.add(sublist);
        }
        else if(!match(list.get(list.size() - 1), sublist)){
            list.add(sublist);
        }
        
        return listToArray(list);
        
    }
    
    public static int[][] listToArray(List<List<Integer>> list) {
        int[][] res = new int[list.size()][2];
        
        for(int i = 0; i < list.size(); i++) {
            res[i][0] = list.get(i).get(0);
            res[i][1] = list.get(i).get(1);
        }
        return res;
    }
    
    public static boolean match(List<Integer> a, List<Integer> b) {
        return (a.get(0) == b.get(0)) && (a.get(1) == b.get(1));
    }
    
    public static boolean intersects(int[] a, int[] b) {
        int l = Math.max(a[0], b[0]);
        int r = Math.min(a[1], b[1]);
        
        return l <= r;
    }
}
