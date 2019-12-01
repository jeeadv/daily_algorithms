//https://www.interviewbit.com/problems/unique-paths-in-a-grid/
//Unique Paths in a Grid

public class Solution {
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        int m = A.size();
        int n = A.get(0).size();
        int[][] arr = new int[m][n];
        for(int j=0;j<n;j++){
            if(A.get(0).get(j) == 0){
                arr[0][j] = 1;
            }
            else{
                break;
            }
        }
        for(int i=0;i<m;i++){
            if(A.get(i).get(0) == 0){
                arr[i][0] = 1;
            }
            else{
                break;
            }
        }
        for(int j=0;j<n;j++){
            
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                int ele = A.get(i).get(j);
                if(ele == 0){
                    arr[i][j] += arr[i-1][j] + arr[i][j-1];
                }
                else{
                    arr[i][j] = 0;
                }
            }
        }
        return arr[m-1][n-1];
    }
}
