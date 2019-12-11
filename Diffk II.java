//Diffk II
//https://www.interviewbit.com/problems/diffk-ii/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int diffPossible(final List<Integer> list, int diff) {
        
        int n = list.size();
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            int comp1 = diff + list.get(i);
            int comp2 = list.get(i) - diff;
            if(set.contains(comp1) || set.contains(comp2)){
                return 1;
            }
            else{
                set.add(list.get(i));
            }
        }
        return 0;
    }
}
