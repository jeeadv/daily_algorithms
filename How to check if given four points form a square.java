//How to check if given four points form a square
//https://www.geeksforgeeks.org/check-given-four-points-form-square/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while(t-->0){
            st = new StringTokenizer(br.readLine());
            int[] x = new int[4];
            int[] y = new int[4];
            
            for(int i=0;i<4;i++){
                x[i] = Integer.parseInt(st.nextToken());
                y[i] = Integer.parseInt(st.nextToken());
            }
            Set<Double> set = new HashSet<>();
            for(int i=0;i<4;i++){
                for(int j=i+1;j<4;j++){
                    set.add(dist(x,y,i,j));
                }
            }
            if(set.size() == 2){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
    }
    public static double dist(int[] x, int[] y, int i, int j){
        return Math.sqrt((x[i]-x[j])*(x[i]-x[j]) + (y[i]-y[j])*(y[i]-y[j]));
    }
}
