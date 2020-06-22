/*
Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.

Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.

 

Example 1:



Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
Output: 2
 

Note:

N will be in the range [1, 100].
K will be in the range [1, N].
The length of times will be in the range [1, 6000].
All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.
*/
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        
        int[][] graph = new int[N + 1][N + 1];
        
        for(int[] arr: graph) {
            Arrays.fill(arr, -1);
        }
        
        for(int[] arr: times) {
            graph[arr[0]][arr[1]] = arr[2];
        }
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;
        
        Queue<Node> q = new PriorityQueue<>((a, b) -> {
            if(a.wt == b.wt) {
                return a.u - b.u;
            }
            return a.wt - b.wt;
        });
        
        q.add(new Node(K, 0));
        
        while(!q.isEmpty()) {
            Node top = q.poll();
            
            for(int v = 1; v <= N; v++) {
                if(graph[top.u][v] >= 0 && (top.wt + graph[top.u][v] < dist[v])) {
                    dist[v] = top.wt + graph[top.u][v];
                    q.add(new Node(v, dist[v]));
                } 
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++) {
            if(dist[i] > max) {
                max = dist[i];
            }
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }
    
    public static class Node {
        int u;
        int wt;
        
        Node(int u, int wt) {
            this.u = u;
            this.wt = wt;
        }
    }
}
