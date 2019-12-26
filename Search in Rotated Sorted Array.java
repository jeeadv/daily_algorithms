//Search in Rotated Sorted Array
//https://leetcode.com/problems/search-in-rotated-sorted-array/

class Solution {
    public int search(int[] arr, int num) {
        int l = 0;
        int r = arr.length - 1;
        
        while(l <= r){
            int mid = (l + r)/2;
            if(arr[mid] == num){
                return mid;
            }
            else if(arr[l] <= arr[mid]){
                if(num >= arr[l] && num <= arr[mid]){
                    r = mid - 1;
                }
                else{
                    l = mid + 1;
                }
            }
            else{
                if(num >= arr[mid] && num <= arr[r]){
                    l = mid + 1;
                }
                else{
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
