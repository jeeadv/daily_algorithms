//  Surrounded Regions
//https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3363/

class Solution {
    boolean corner = false;
    
    public void solve(char[][] board) {
        int m = board.length;
        if(m < 3) {
            return;
        }
        
        int n = board[0].length;
        if(n < 3) {
            return;
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') {
                    corner = false;
                    dfs(i, j, m, n, board);
                    
                    if(!corner) {
                        dfs2(i, j, m, n, board);
                    }
                    /*for(int k = 0; k < m; k++) {
                        System.out.println(Arrays.toString(board[k]));
                    }
                    System.out.println();*/
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
        /*for(int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(board[i]));
        }*/
    }
    
    public void dfs(int i, int j, int m, int n, char[][] board) {
        if(i < 0 || i == m || j < 0 || j == n) {
            return;
        }
        
        if(board[i][j] != 'O') {
            return;
        }
        
        if(i == m - 1 || i == 0 || j == n -1 || j == 0) {
            corner = true;
        }
        
        board[i][j] = '1';
        
        dfs(i, j - 1, m, n, board);
        dfs(i, j + 1, m, n, board);
        dfs(i + 1, j, m, n, board);
        dfs(i - 1, j, m, n, board);
    }
    
    public void dfs2(int i, int j, int m, int n, char[][] board) {
        if(i < 0 || i == m || j < 0 || j == n) {
            return;
        }
        
        if(board[i][j] != '1') {
            return;
        }
        
        board[i][j] = 'X';
        
        dfs2(i, j - 1, m, n, board);
        dfs2(i, j + 1, m, n, board);
        dfs2(i + 1, j, m, n, board);
        dfs2(i - 1, j, m, n, board);
    }
}

// another solution
class Solution {
    boolean corner = false;
    
    public void solve(char[][] board) {
        int m = board.length;
        if(m < 3) {
            return;
        }
        
        int n = board[0].length;
        if(n < 3) {
            return;
        }
        
        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O') {
                dfs(i, 0, m, n, board);
            }
        }
        for(int i = 0; i < m; i++) {
            if(board[i][n - 1] == 'O') {
                dfs(i, n - 1, m, n, board);
            }
        }
        for(int j = 0; j < n; j++) {
            if(board[0][j] == 'O') {
                dfs(0, j, m, n, board);
            }
        }
        for(int j = 0; j < n; j++) {
            if(board[m - 1][j] == 'O') {
                dfs(m - 1, j, m, n, board);
            }
        }
        
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '1') {
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    public void dfs(int i, int j, int m, int n, char[][] board) {
        if(i < 0 || i == m || j < 0 || j == n) {
            return;
        }
        
        if(board[i][j] != 'O') {
            return;
        }
        
        if(i == m - 1 || i == 0 || j == n -1 || j == 0) {
            corner = true;
        }
        
        board[i][j] = '1';
        
        dfs(i, j - 1, m, n, board);
        dfs(i, j + 1, m, n, board);
        dfs(i + 1, j, m, n, board);
        dfs(i - 1, j, m, n, board);
    }
}
