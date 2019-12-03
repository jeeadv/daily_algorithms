/*
Largest Smaller BST Key

Given a root of a Binary Search Tree (BST) and a number num, implement an efficient function findLargestSmallerKey
that finds the largest key in the tree that is smaller than num.
If such a number doesn’t exist, return -1. Assume that all keys in the tree are nonnegative.
*/

import java.io.*;
import java.util.*;

/***********************************************************
 * CODE INSTRUCTIONS:                                      *
 * 1) The method findLargestSmallerKey you're              *
 *    asked to implement is located at line 36.            *
 * 2) Use the helper code below to implement it.           *
 * 3) In a nutshell, the helper code allows you to         *
 *    to build a Binary Search Tree.                       *
 * 4) Jump to line 82 to see an example for how the        *
 *    helper code is used to test findLargestSmallerKey.   *
 ***********************************************************/


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
    int answer;
    int findLargestSmallerKey(int num) {
      answer = -1;
      inorder(root, num); 
      return answer;
    }
    void inorder(Node root, int num){
      if(root == null){
        return;
      }
      inorder(root.left, num);
      if(root.key > num){
        return;
      }
      else{
        answer = root.key;
      }
      inorder(root.right, num);
    }
    
    //  inserts a new node with the given number in the
    //  correct place in the tree
    void insert(int key) {
      
      // 1) If the tree is empty, create the root
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
  }

  /*********************************************
   * Driver program to test above function     *
   *********************************************/ 
   
   public static void main(String[] args) {
     
     // Create a Binary Search Tree
     BinarySearchTree bst = new BinarySearchTree();
     bst.insert(20);
     bst.insert(9);
     bst.insert(25);
     bst.insert(5);
     bst.insert(12);
     bst.insert(11);
     bst.insert(14);
     
     int result = bst.findLargestSmallerKey(17);
     System.out.println("Largest smaller number is " + result);
    
  }
}
