//Minimum number of swaps required for arranging pairs adjacent to each other
//https://www.geeksforgeeks.org/minimum-number-of-swaps-required-for-arranging-pairs-adjacent-to-each-other/

// brute force exponential

package interview.questions;

public class MinSwapRequired {

	public static void main(String[] args) {
		int n = 7;
		int[] pairs = {0, 3, 6, 1, 5, 4, 2}; //1->3, 2->6, 4->5
		int[] arr = {0, 3, 5, 6, 4, 1, 2};
		int[] index = new int[n];
		
		for(int i = 0; i < n; i++) {
			index[arr[i]] = i;
		}
		
		int res = minSwap(1, arr, pairs, index, n);
		System.out.println(res);
	}
	
	public static int minSwap(int i, int[] arr, int[] pairs, int[] index, int n) {
		if(i >= n - 2) {
			return 0;
		}
		
		if(pairs(arr[i], arr[i + 1], pairs)) {
			return minSwap(i + 2, arr, pairs, index, n);
		}
		else {
			int temp1 = arr[index[pairs[arr[i]]]] = arr[i + 1];
			int temp2 = arr[i + 1] = pairs[arr[i]];
			int way1 = minSwap(i + 2, arr, pairs, index, n);
			arr[index[pairs[arr[i]]]] = temp2;
			arr[i + 1] = temp1;
			
			int temp3 = arr[index[pairs[arr[i + 1]]]] = arr[i];
			int temp4 = arr[i] = pairs[arr[i + 1]];
			int way2 = minSwap(i + 2, arr, pairs, index, n);
			arr[index[pairs[arr[i + 1]]]] = temp4;
			arr[i] = temp3;
			
			if(way1 < way2) {
				System.out.println(temp1 + " " + temp2 + " " + i);
			}
			else {
				System.out.println(temp3 + " " + temp4 + " " + i);
			}
			
			return 1 + Math.min(way1, way2);
		}
	}
	
	public static boolean pairs(int a, int b, int[] pairs) {
		return (pairs[a] == b) && (pairs[b] == a);
	}
}
