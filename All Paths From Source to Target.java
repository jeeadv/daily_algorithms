//All Paths From Source to Target
//https://leetcode.com/problems/all-paths-from-source-to-target/

//dfs
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(graph, 0, "", res);
        return res;
    }
    
    public void dfs(int[][] graph, int u, String path, List<List<Integer>> res) {
        path += u + ",";
        if(u == graph.length - 1) {
            res.add(stringToList(path));
            return;
        }
       
        for(int v: graph[u]) {
            dfs(graph, v, path, res);
        }
    }
    
    public List<Integer> stringToList(String path) {
        List<Integer> list = new ArrayList<>();
        for(String s: path.split(",")) {
            if(s != null && !s.isEmpty()) {
                list.add(Integer.parseInt(s));
            }
        }
        return list;
    }
}


// solution with array list copy (dfs)
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(graph, 0, path, res);
        return res;
    }
    
    public void dfs(int[][] graph, int u, List<Integer> path, List<List<Integer>> res) {
        path.add(u);
        if(u == graph.length - 1) {
            res.add(path);
            return;
        }
       
        for(int v: graph[u]) {
            List<Integer> copyList = new ArrayList<>(path);
            dfs(graph, v, copyList, res);
        }
    }
    
}
