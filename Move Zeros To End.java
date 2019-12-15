//Move Zeros To End
//https://www.pramp.com/challenge/9PNnW3nbyZHlovqAvxXW
import java.io.*;
import java.util.*;

class Solution {

	static int[] moveZerosToEnd(int[] arr) {
	  int n = arr.length;
    int l = -1;
    for(int i=0;i<n;i++){
      if(arr[i] == 0){
        if(l == -1){
          l = i;
        }
        continue;
      }
      else{
        if(l != -1){
          arr[l] = arr[i];
          arr[i] = 0;
          l++;
        }
      }
    }
    return arr;
	}

	public static void main(String[] args) {
	  int[] arr = {1, 10, 2, 8, 3, 6, 4, 0, 0, 0, 0, 5, 7, 0};
    int[] ans = moveZerosToEnd(arr);
    System.out.println(Arrays.toString(ans));
	}
}
/*
[1, 10, 2, 8, 3, 6, 4, 0, 0, 0, 0, 5, 7, 0]
                    l        r
*/
