//H-Tree Construction
//https://www.pramp.com/challenge/EmYgnOgVd4IElnjAnQqn


import java.util.*;

class Main {
  static public void main( String args[] ) {
    double x = 0.0;
    double y = 0.0;
    double length = 2.0;
    int depth = 2;
    drawHTree(x, y, length, depth);
  }
  static public void drawHTree(double x, double y, double length, int depth){
    if(depth == 0){
      return;
    }
    double x1 = x - length/2;
    double y1 = y;
    
    double x2 = x + length/2;
    double y2 = y;
    
    drawLine(x1, y1, x2, y2);
    
    double x3 = x + length/2;
    double y3 = y - length/2;
    
    double x4 = x + length/2;
    double y4 = y + length/2;
    
    drawLine(x3, y3, x4, y4);
    
    double x5 = x - length/2;
    double y5 = y - length/2;
    
    double x6 = x - length/2;
    double y6 = y + length/2;
    
    drawLine(x5, y5, x6, y6);
    
    drawHTree(x3, y3, length/Math.sqrt(2), depth - 1);
    drawHTree(x4, y4, length/Math.sqrt(2), depth - 1);
    drawHTree(x5, y5, length/Math.sqrt(2), depth - 1);
    drawHTree(x6, y6, length/Math.sqrt(2), depth - 1);
  }
  
  static void drawLine(double a, double b, double c, double d){
    System.out.println(a+","+b+" "+c+","+d);
  }
  
}
/*
(x,y) => horizontal = > (x - length/2, y) (x + length/2, y)
(x - length/2, y) => vertical line => (x - length/2, y - length/2) (x - length/2, y + length/2)
(x + length/2, y) => vertical line => (x + length/2, y - length/2) (x + length/2, y + length/2)
*/

