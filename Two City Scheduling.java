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


//dp

