//https://www.interviewbit.com/problems/square-root-of-integer/
//Square Root of Integer
public class Solution {
    public int sqrt(int a) {
        return (int)search((long)0,(long)a,(long)a);
    }
    public long search(long l, long r, long a){
        long mid = (l+r+1)/2;
        long square = mid*mid;
        if(l<r){
            if(a == square){
                return mid;
            }
            else if(a<square){
                return search(l,mid-1,a);
            }
            else{
                return search(mid+1,r,a);
            }
        }
        else{
            if(square == a){
                return l;
            }
            else if(square>a){
                return l-1;
            }
            else{
                return l;
            }
        }
    }
}
