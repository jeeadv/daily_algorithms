//Two City Scheduling
//https://leetcode.com/problems/two-city-scheduling/

//sorting

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        Arrays.sort(costs, new Comparator<int[]>() {
            
            public int compare(int[] a, int[] b) {
                int diffa = a[1] - a[0];
                int diffb = b[1] - b[0];
                
                return diffa - diffb;
            }

        });
                    
        int cost = 0;
        for(int i = 0; i < costs.length / 2; i++) {
            cost += costs[i][1];
        }

        for(int i = costs.length / 2; i <costs.length; i++) {
            cost += costs[i][0];
        }

        return cost;
    }
}


//counting sort

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        List<Integer>[] prev = new ArrayList[1001];
        List<Integer>[] next = new ArrayList[1001];
        
        for(int i = 0; i < costs.length; i++) {
            int diff = costs[i][1] - costs[i][0];
            
            if(diff >= 0) {
                if(next[diff] == null) {
                    next[diff] = new ArrayList<>();
                }
                next[diff].add(i);
            }
            else {
                if(prev[-diff] == null) {
                    prev[-diff] = new ArrayList<>();
                }
                prev[-diff].add(i);
            }
        }
        
        int count = 0;
        int sum = 0;
        
        for(int i = 1000; i > 0; i--) {
            List<Integer> list = prev[i] == null ? new ArrayList<>() : prev[i];
            
            for(int index: list) {
                if(count < costs.length / 2) {
                    sum += costs[index][1];
                }
                else {
                    sum += costs[index][0];
                }
                count++;
            }
        }
        
        for(int i = 0; i < 1001; i++) {
            List<Integer> list = next[i] == null ? new ArrayList<>() : next[i];
            
            for(int index: list) {
                if(count < costs.length / 2) {
                    sum += costs[index][1];
                }
                else {
                    sum += costs[index][0];
                }
                count++;
            }
        }
        
        return sum;
    }
}

