//Container With Most Water
//https://www.interviewbit.com/problems/container-with-most-water/

public class Solution {
    public int maxArea(ArrayList<Integer> A) {
        int n = A.size();
        int max = 0;
        int l = 0;
        int r = 0;
        while(l<r){
            int min = Math.min(A.get(l),A.get(r));
            int area = min*(r-l);
            if(area>max){
                max = area;
            }
            if(A.get(l)<A.get(r)){
                l++;
            }
            else{
                r--;
            }
        }
        return max;
    }
}
