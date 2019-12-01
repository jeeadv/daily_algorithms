//https://www.interviewbit.com/problems/3-sum-zero/
//3 Sum Zero
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> arr) {
        int n = arr.size();
        Collections.sort(arr);
        LinkedHashSet<Ans> set = new LinkedHashSet<>();
        for(int i=0;i<n;i++){
            int l = i+1;
            int r = n-1;
            while(l<r){
                int sum = arr.get(i)+arr.get(l)+arr.get(r);
                if(sum<0){
                    l++;
                }
                else if(sum>0){
                    r--;
                }
                else{
                    Ans ans = new Ans(arr.get(i), arr.get(l), arr.get(r));
                    set.add(ans);
                    l++;
                }
            }
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(Ans ans: set){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(ans.a);
            list.add(ans.b);
            list.add(ans.c);
            res.add(list);
        }
        return res;
    }
}
class Ans{
    public int a;
    public int b;
    public int c;
    Ans(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public int hashCode(){
        return a+b+c;
    }
    public boolean equals(Object obj){
        Ans ins = (Ans) obj;
        return ins.a == this.a && ins.b == this.b && ins.c == this.c;
    }
}
