//Shortest Cell Path
//https://www.pramp.com/challenge/Y56aZmaj9Ptmd9wV9xvL


import java.io.*;
import java.util.*;

class Solution {

	static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
    int m = grid.length;
    int n = grid[0].length; 
    //System.out.println("row:"+m+" col:"+n);
    
	  int ans = bfs(grid, m, n, sr, sc, tr, tc);
    return ans;
	}
  static int bfs(int[][] grid, int m, int n, int i, int j, int tr, int tc){
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(i,j,0));
    
    while(!q.isEmpty()){
      Pair top = q.poll();
      //System.out.println("top:"+top.i+","+top.j+","+top.dist);
      if(top.i == tr && top.j == tc){
        //System.out.println("found");
        return top.dist;
      }
      grid[top.i][top.j] = -1;
      int dist = top.dist;
      int l = top.i-1;
      int r = top.j;
      //System.out.println("consider:"+"i:"+l+","+r);
      if(l>=0 && l<m && r>=0 && r<n && grid[l][r] > 0){
        //System.out.println("push:"+"i:"+l+","+r);
        q.add(new Pair(l,r,dist+1));
      }
      
      l = top.i;
      r = top.j-1;
      //System.out.println("consider:"+"i:"+l+","+r);
      if(l>=0 && l<m && r>=0 && r<n && grid[l][r] > 0){
        //System.out.println("push:"+"i:"+l+","+r);
        q.add(new Pair(l,r,dist+1));
      }
      
      l = top.i;
      r = top.j+1;
      //System.out.println("consider:"+"i:"+l+","+r);
      if(l>=0 && l<m && r>=0 && r<n && grid[l][r] > 0){
        //System.out.println("push:"+"i:"+l+","+r);
        q.add(new Pair(l,r,dist+1));
      }
      
      l = top.i+1;
      r = top.j;
      //System.out.println("consider:"+"i:"+l+","+r);
      if(l>=0 && l<m && r>=0 && r<n && grid[l][r] > 0){
        //System.out.println("push:"+"i:"+l+","+r);
        q.add(new Pair(l,r,dist+1));
      }
      
    }
    return -1;
  }
  static class Pair{
    int i;
    int j;
    int dist;
    Pair(int i, int j, int dist){
      this.i = i;
      this.j = j;
      this.dist = dist;
    }
  }
	public static void main(String[] args) {
	  int[][] grid = {{1, 1, 1, 1}, 
                    {0, 0, 0, 1}, 
                    {1, 1, 1, 1}
                   };
    int ans = shortestCellPath(grid, 0,0,2,0);
    System.out.println(ans);
	}
}
/*
[1, 1,   (i-1,j), 1], 
[(i,j-1), (i,j), (i,j+1), 1], 
[1, 1, 1, (i+1,j)]

[1, 2, 3, 4], - visited
[0, 0, 0, 5], 
[9, 8, 7, 6]
ans 9-1
*/
