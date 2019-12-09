//Word Count Engine
//https://www.pramp.com/challenge/15oxrQx6LjtQj9JK9XqA
import java.io.*;
import java.util.*;

class Solution {
 
  static class Node {
      
    int cost;
    Node[] children;
    Node parent;

    Node(int cost) {
      this.cost = cost;
      children = null;
      parent = null;
    }
  }

  static class SalesPath {
        
    int getCheapestCost(Node rootNode) {
      int min = Integer.MAX_VALUE;
      Queue<Node> q = new LinkedList<>();
      q.add(rootNode);
      while(!q.isEmpty()){
        Node top = q.poll();
        if(isLeaf(top)){
          if(top.cost<min){
            min = top.cost;
          }
        }
        else{
          for(Node child: top.children){
            if(child != null){
              child.cost += top.cost;
              q.add(child);
            }
          }
        }
        
      }
      return min;
    }
  }
  public static boolean isLeaf(Node node){
    if(node == null){
      return false;
    }
    if(node.children == null){
      return true;
    }
    return false;
  }
    
  /*********************************************
   * Driver program to test above method     *
   *********************************************/

  public static void main(String[] args) {
    Node root = new Node(0);
    root.children = new Node[3];
    root.children[0] = new Node(5);
    root.children[1] = new Node(3);
    root.children[2] = new Node(6);
    
    root.children[0].children = new Node[1];
    root.children[0].children[0] = new Node(4);
    
    root.children[1].children = new Node[2];
    root.children[1].children[0] = new Node(2);
    root.children[1].children[1] = new Node(0);
    
    root.children[1].children[0].children = new Node[1];
    root.children[1].children[0].children[0] = new Node(1);
    root.children[1].children[0].children[0].children = new Node[1];
    root.children[1].children[0].children[0].children[0] = new Node(1);
    
    root.children[1].children[1].children = new Node[1];
    root.children[1].children[1].children[0] = new Node(10);
    
    root.children[2].children = new Node[2];
    root.children[2].children[0] = new Node(1);
    root.children[2].children[1] = new Node(5);
    
    
    int ans = new SalesPath().getCheapestCost(root);
    System.out.println(ans);
    
  }
}
