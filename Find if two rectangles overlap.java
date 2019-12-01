//https://www.geeksforgeeks.org/find-two-rectangles-overlap/
//Find if two rectangles overlap
//follwing solution is only for rectangles parallel to co ordinate axes.
//tilted rectangles solution is coming.

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
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            int x3 = Integer.parseInt(st.nextToken());
            int y3 = Integer.parseInt(st.nextToken());
            int x4 = Integer.parseInt(st.nextToken());
            int y4 = Integer.parseInt(st.nextToken());
            
            int res = solve(new Point(x1,y1), new Point(x2,y2),
                            new Point(x3,y3), new Point(x4,y4));
            System.out.println(res);
        }
    }
    public static int solve(Point p1, Point p2, Point p3, Point p4){
        if(p2.x<p3.x || p4.x<p1.x){
            return 0;
        }  
        if(p3.y<p2.y || p1.y<p4.y){
            return 0;
        }
        return 1;
    }
    
}
class Rectangle{
    Point p1;
    Point p2;
    Rectangle(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }
}
class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "("+x+","+y+")";
    }
}
