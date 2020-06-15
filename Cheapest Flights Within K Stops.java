//Cheapest Flights Within K Stops
//https://leetcode.com/problems/cheapest-flights-within-k-stops/

// adj matrix
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] graph = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            graph[i] = new int[n];
        }
        
        for(int[] arr: flights) {
            graph[arr[0]][arr[1]] = arr[2]; 
        }
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        q.add(new int[] {0, src, -1});
        
        while(!q.isEmpty()) {
            int[] top = q.remove();
            //System.out.println(Arrays.toString(top) + " " + Arrays.toString(dist));
            int wt = top[0];
            int u = top[1];
            int k = top[2];
            
            if(u == dst) {
                return wt;
            }
           
            if(k < K) {
                for(int v = 0; v < n; v++) {
                    if(graph[u][v] > 0) {
                        dist[v] = Math.min(dist[v], wt + graph[u][v]);
                        q.add(new int[] {wt + graph[u][v], v, k + 1});
                    }
                }   
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}


// adj list
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<List<Integer>>[] graph = new ArrayList[n];
        
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] arr: flights) {
            List<Integer> list = new ArrayList<>();
            list.add(arr[1]);
            list.add(arr[2]);
            graph[arr[0]].add(list); 
        }
        
        Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        q.add(new int[] {0, src, -1});
        
        while(!q.isEmpty()) {
            int[] top = q.remove();
            int wt = top[0];
            int u = top[1];
            int k = top[2];
            
            if(u == dst) {
                return wt;
            }
           
            if(k < K) {
                for(List<Integer> p: graph[u]) {
                    q.add(new int[] {wt + p.get(1), p.get(0), k + 1});
                }   
            }
        }
        return -1;
    }
}
