//BST Successor Search
//https://www.pramp.com/challenge/MW75pP53wAtzNPVLPG2b
import java.io.*;
import java.util.*;

/********************************************************
 * CODE INSTRUCTIONS:                                   *
 * 1) The method findInOrderSuccessor you're asked      *
 *    to implement is located at line 36.               *
 * 2) Use the helper code below to implement it.        *
 * 3) In a nutshell, the helper code allows you to      *
 *    to build a Binary Search Tree.                    *
 * 4) Jump to line 103 to see an example for how the    *
 *    helper code is used to test findInOrderSuccessor. *
 ********************************************************/

class Solution {

  static class Node {
      
    int key;
    Node left;
    Node right;
    Node parent;
    
    Node(int key) {
      this.key = key;
      left = null;
      right = null;
      parent = null;
    }
  }
  
  static class BinarySearchTree {
    
    Node root;

    Node findInOrderSuccessor(Node inputNode) {
      Node node = root;
      while(node != null){
        if(node.key == inputNode.key){
          break;
        }
        else if(node.key < inputNode.key){
          node = node.right;
        }
        else{
          node = node.left;
        }
      }
      Node successor = null;
      if(node.right != null){
        successor = node.right;
      }
      else{
          successor = node.parent;
          while(successor != null){
            if(successor.key > inputNode.key){
              return successor;
            }
            successor = successor.parent;
          }
      }
      
      while(successor != null && successor.left != null){
        successor = successor.left;
      }
      return successor;
    }
    
    //  Given a binary search tree and a number, inserts a new node
    //  with the given number in the correct place in the tree
    void insert(int key) {
      
      // 1. If the tree is empty, create the root
      if(this.root == null) {
        this.root = new Node(key);
        return;
      }

      // 2) Otherwise, create a node with the key
      //    and traverse down the tree to find where to
      //    to insert the new node
      Node currentNode = this.root;
      Node newNode = new Node(key); 

      while(currentNode != null) {
        if(key < currentNode.key) {
          if(currentNode.left == null) {
            currentNode.left = newNode;
            newNode.parent = currentNode;
            break;
          } else {
            currentNode = currentNode.left;
          }
        } else {
          if(currentNode.right == null) {
            currentNode.right = newNode;
            newNode.parent = currentNode;
            break;
          } else {
            currentNode = currentNode.right;
          }
        }
      }
    }
    
    // Return a reference to a node in the BST by its key.
    // Use this method when you need a node to test your 
    // findInOrderSuccessor method on
    Node getNodeByKey(int key) {
      Node currentNode = this.root;
      
      while(currentNode != null) {
        if(key == currentNode.key) {
          return currentNode;
        }
        
        if(key < currentNode.key) {
          currentNode = currentNode.left;
        } else {
          currentNode = currentNode.right;
        }
      }
      
      return null; 
    }
  }
  
  /***********************************************
   * Driver program to test findInOrderSuccessor *
   ***********************************************/

  public static void main(String[] args) {
     
    Node test = null, succ = null;
     
    // Create a Binary Search Tree
    BinarySearchTree tree = new BinarySearchTree();
    tree.insert(20);
    tree.insert(9);
    tree.insert(25);
    tree.insert(5);
    tree.insert(12);
    tree.insert(11);
    tree.insert(14);
     
    // Get a reference to the node whose key is 9
    test = tree.getNodeByKey(20);

    // Find the in order successor of test
    succ = tree.findInOrderSuccessor(test);
     
    // Print the key of the successor node
    if (succ != null) {
      System.out.println("Inorder successor of " + test.key +
                          " is " + succ.key);
    } else {
      System.out.println("Inorder successor does not exist");
    }
  }
}
