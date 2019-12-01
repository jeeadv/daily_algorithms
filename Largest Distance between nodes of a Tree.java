//https://www.interviewbit.com/problems/largest-distance-between-nodes-of-a-tree/
//Largest Distance between nodes of a Tree

public class Solution {
    public int solve(ArrayList<Integer> A) {
        Graph graph = new Graph(A.size());
        for(int i=0;i<A.size();i++){
            if(A.get(i) != -1){
                graph.addEdge(i, A.get(i));
                graph.addEdge(A.get(i), i);
            }
        }
        //graph.print();
        
        Ans ans = graph.bfs(0);
        Ans res = graph.bfs(ans.index);
        return res.max;
    }
}
class Ans{
    int index;
    int max;
    
    public Ans(int index, int max){
        this.index = index;
        this.max = max;
    }
}
class Graph{
    int n;
    ArrayList<Integer>[] arr;
    
    public Graph(int n){
        this.n = n;
        arr = new ArrayList[this.n];
    }
    public void addEdge(int u, int v){
        if(arr[u] == null){
            arr[u] = new ArrayList();
        }
        arr[u].add(v);
    }
    public void print(){
        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }
    }
    
    public Ans bfs(int s){
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        for(int i=0;i<n;i++){
            dist[i] = -1;
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        dist[s] = 0;
        
        while(!q.isEmpty()){
            int top = q.poll();
            visited[top] = true;
            
            for(int v: arr[top]){
                if(!visited[v]){
                    q.add(v);
                    dist[v] = dist[top] + 1;
                }
            }
        }
        
        int max = -1;
        int index = -1;
        for(int i=0;i<n;i++){
            if(dist[i]>max){
                max = dist[i];
                index = i;
            }
        }
        return new Ans(index, max);
    }
}
