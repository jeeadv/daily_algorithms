//https://www.interviewbit.com/problems/equal/
//Equal
//find four indices i,j,k,l such that A+B = C+D

public class Solution {
    public ArrayList<Integer> equal(ArrayList<Integer> list) {
        int n = list.size();
        HashMap<Integer, ArrayList<ArrayList<Integer>>> hashMap = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int sum = list.get(i) + list.get(j);
                if(hashMap.containsKey(sum)){
                    ArrayList<ArrayList<Integer>> temp = hashMap.get(sum);
                    
                    ArrayList<Integer> tempList = new ArrayList<>();
                    tempList.add(i);
                    tempList.add(j);
                    temp.add(tempList);
                    hashMap.put(sum, temp);
                }
                else{
                    hashMap.put(sum, new ArrayList<ArrayList<Integer>>());
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int sum = list.get(i) + list.get(j);
                if(hashMap.containsKey(sum)){
                    ArrayList<ArrayList<Integer>> temp = hashMap.get(sum);
                    for(ArrayList<Integer> itr: temp){
                        if(itr.get(0) != i && itr.get(1) != i
                            && itr.get(0) != j && itr.get(1) != j){
                                ArrayList<Integer> ans = new ArrayList<>();
                                ans.add(i);
                                ans.add(j);
                                ans.add(itr.get(0));
                                ans.add(itr.get(1));
                                //Collections.sort(ans);
                                return ans;
                            }
                    }
                }
            }
        }
        return new ArrayList<Integer>();
    }
}
