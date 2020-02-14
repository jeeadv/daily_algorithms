//Permutations
//https://leetcode.com/problems/permutations/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        fun(nums, list, 0);
        return list;
    }
    
    public static void fun(int[] arr, List<List<Integer>> list, int s){
        if(s == arr.length - 1){
            List<Integer> subList = new LinkedList<>();
            for(int num: arr){
                subList.add(num);
            }
            list.add(subList);
            return;
        }
        
        for(int i = s; i < arr.length; i++){
            swap(arr, s, i);
            fun(arr, list, s + 1);
            swap(arr, s, i);
        }
    }
    
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
