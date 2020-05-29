//Read Max Books in given hours.

//You can only spend n hours in library.
//You have list of books and amount of time to read it.
//But you can only read in the given order (contiguous)
//find the maximum books you can read

//You can only spend n hours in library.
//You have list of books and amount of time to read it.
//But you can only read in the given order (contiguous)
//find the maximum books you can read
import java.io.*;

class GFG {
	public static void main (String[] args) {
		int hours = 12;
		int[] arr = {5, 2, 1, 3, 9, 5, 1, 3};
		//int[] arr = {5, 2, 1, 3, 9, 5, 1, 3, 2, 1, 4};
		
		int res = maxBooks(arr, hours);
		System.out.println(res);
	}
	
	public static int maxBooks(int[] arr, int hours) {
	    int max = 0;
	    int windowSum = 0;
	    int l = 0;
	    int r = 0;
	    
	    while(r < arr.length) {
	        
	        while(r < arr.length && windowSum <= hours) {
	            windowSum += arr[r];
	            r++;
	            //System.out.println(l + " " + (r-1) + " " + windowSum);
	            if(windowSum <= hours) {
	                max = Math.max(max, r - l);
	            }
	        }
	        
	        while(l < r && l < arr.length && windowSum > hours) {
	            windowSum -= arr[l];
	            l++;
	            //System.out.println(l + " " + (r-1) + " " + windowSum);
	            if(windowSum <= hours) {
	                max = Math.max(max, r - l);
	            }
	        }
	        
	    }
	    return max;
	}
}
