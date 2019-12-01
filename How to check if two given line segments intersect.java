//How to check if two given line segments intersect
//https://www.geeksforgeeks.org/check-if-two-given-line-segments-intersect/

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
            
            Point p1 = new Point(x1,y1);
            Point p2 = new Point(x2,y2);
            Point p3 = new Point(x3,y3);
            Point p4 = new Point(x4,y4);
            
            int res = doIntersect(new LineSeg(p1,p2), new LineSeg(p3,p4));
            System.out.println(res);
        }
    }
    public static int doIntersect(LineSeg l1, LineSeg l2){
        Point p1 = l1.p1;
        Point p2 = l1.p2;
        Point p3 = l2.p1;
        Point p4 = l2.p2;
        
        //System.out.println(p1+":"+p2+":"+p3+":"+p4);
        
        int o1 = slope_delta(p1, p2, p3);
        int o2 = slope_delta(p1, p2, p4);
        int o3 = slope_delta(p3, p4, p1);
        int o4 = slope_delta(p3, p4, p2);
        
        //System.out.println(o1+":"+o2+":"+o3+":"+o4);
        
        if(o1 != o2 && o3 != o4){
            return 1;
        }
        
        if(o1 == 0 && p3.liesOn(p1,p2)){
            return 1;
        }
        if(o2 == 0 && p4.liesOn(p1,p2)){
            return 1;
        }
        if(o3 == 0 && p1.liesOn(p3,p4)){
            return 1;
        }
        if(o4 == 0 && p2.liesOn(p3,p4)){
            return 1;
        }
        return 0;
    }
    public static int slope_delta(Point p1, Point p2, Point p3){
        int delta = (p3.y-p2.y)*(p2.x-p1.x) - (p2.y-p1.y)*(p3.x-p2.x);
        if(delta == 0){
            return 0;
        }
        else if(delta > 0){
            return 1;
        }
        else{
            return -1;
        }
    }
}
class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public boolean liesOn(Point p1, Point p2){
        Point p3 = this;
        return p3.x>=Math.min(p1.x,p2.x) && p3.x<=Math.max(p1.x,p2.x)
                && p3.y>=Math.min(p1.y,p2.y) && p3.y<=Math.max(p1.y,p2.y);
    }
    public String toString(){
        return "("+x+","+y+")";
    }
}
class LineSeg{
    Point p1;
    Point p2;
    LineSeg(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }
}
