//Sudoku Solver
//https://www.pramp.com/challenge/O5PGrqGEyKtq9wpgw6XP



import java.io.*;
import java.util.*;

class Solution {

	static boolean sudokuSolve(char[][] board) {
	    int n = board.length;
	    /*for(int i=0;i<n;i++){
	    	System.out.println(Arrays.toString(board[i]));
		}*/
	    int count = 0;
	    int l = -1;
	    int r = -1;
	    for(int i=0;i<n;i++){
	      for(int j=0;j<n;j++){
	        if(board[i][j] == '.'){
	          count++;
	          l = i;
	          r = j;
	        }
	      }
	    }
	    //System.out.println("count:"+count);
	    if(count == 0){
	      return true;
	    }
	    
	    
	      for(char k='1';k<='9';k++){
	        if(isSafe(board, k,l,r)){
	          board[l][r] = k;
	          if(sudokuSolve(board)){
	            return true;
	          }
	          //else{
	          board[l][r] = '.';
	          //}
	        }
	      }
	        
	      
	    
	    return false;
  }
	
  static boolean sudokuSolve1(char[][] board) {
	
    int n = board.length;
    /*for(int i=0;i<n;i++){
    	System.out.println(Arrays.toString(board[i]));
	}*/
    int count = 0;
    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
        if(board[i][j] == '.'){
          count++;
        }
      }
    }
    //System.out.println("count:"+count);
    if(count == 0){
      return true;
    }
    
    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
        if(board[i][j] == '.'){
          for(char k='9';k>='1';k--){
            if(isSafe(board, k,i,j)){
              board[i][j] = k;
              if(sudokuSolve(board)){
                return true;
              }
              else{
                board[i][j] = '.';
              }
            }
          }
        }
      }
    }
    return false;
  }
  static boolean isSafe(char[][] board, char k, int r, int c){
    int n = board.length;
    for(int j=0;j<n;j++){
      if(board[r][j] == k){
        return false;
      } 
    }
    for(int i=0;i<n;i++){
      if(board[i][c] == k){
        return false;
      } 
    }
    int startI = r - r%3;
    int startJ = c - c%3;
    int endI = startI + 2;
    int endJ = startJ + 2;
    for(int i=startI;i<=endI;i++){
      for(int j=startJ;j<=endJ;j++){  
        if(board[i][j] == k){
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    char[][] board = {{'.','.','.','7','.','.','3','.','1'},
                      {'3','.','.','9','.','.','.','.','.'},
                      {'.','4','.','3','1','.','2','.','.'},
                      {'.','6','.','4','.','.','5','.','.'},
                      {'.','.','.','.','.','.','.','.','.'},
                      {'.','.','1','.','.','8','.','4','.'},
                      {'.','.','6','.','2','1','.','5','.'},
                      {'.','.','.','.','.','9','.','.','8'},
                      {'8','.','5','.','.','4','.','.','.'}};
    /*int n = board.length;
    int dot = 0;
    int num = 0;
    for(int i=0;i<n;i++){
    	for(int j=0;j<n;j++){
    		if(board[i][j] == '.')
    			dot++;
    		else if(board[i][j]>='1' && board[i][j]<='9'){
    			num++;
    		}
    	}
    }
    System.out.println(dot+","+num+","+(dot+num));*/
    /*for(char k='1';k<='9';k++){
    	System.out.println(k);
    }*/
   boolean solvable = sudokuSolve(board);
   System.out.println(solvable);
  }

  
  
  /* static boolean sudokuSolve(char[][] board) {
        // your code goes here
        int index = 1;
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                box[index++] = new BoxInfo(i, j, i+2, j + 2);
            }
        }
        return sudokuSolve(board, 0, 0);
    }
    
    static class BoxInfo {
        int startI, startJ, endI, endJ;
        BoxInfo(int startI, int startJ, int endI, int endJ) {
            this.startI = startI;
            this.endI = endI;
            this.startJ = startJ;
            this.endJ = endJ;
        }
    }
    
    static boolean checkBox(char[][] board, char val, int i, int j) {

        int startI = i - i % 3;
        int startJ = j - j%3;
        int endI = startI + 2;
        int endJ = startJ + 2;

        for (int k = startI; k <= endI; k++) {
            for (int p = startJ; p <= endJ; p++) {
                if (board[k][p] == val)
                    return false;
            }
        }
        return true;
    }
    
    static boolean checkBox(char[][] board, char val, int i, int j) {

        int boxId = (i + j) - 4;
        if (boxId <= 0 && boxId >= -4) {
            boxId = 1;
        }
        if (boxId >= 9 && boxId <= 12) {
            boxId = 9;
        }

        System.out.println(boxId);
        Integer startI = box[boxId].startI;
        Integer startJ = box[boxId].startJ;

        Integer endI =  box[boxId].endI;
        Integer endJ =  box[boxId].endJ;

        for (int k = startI; k <= endI; k++) {
            for (int p = startJ; p <= endJ; p++) {
                if (board[k][p] == val)
                    return false;
            }
        }
        return true;
    }
    
    char[][] board = {{'.','.','.','7','.','.','3','.','1'},{'3','.','.','9','.','.','.','.','.'},{'.','4','.','3','1','.','2','.','.'},{'.','6','.','4','.','.','5','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','1','.','.','8','.','4','.'},{'.','.','6','.','2','1','.','5','.'},{'.','.','.','.','.','9','.','.','8'},{'8','.','5','.','.','4','.','.','.'}};
    */
}
