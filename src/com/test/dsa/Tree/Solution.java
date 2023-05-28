package com.test.dsa.Tree;

import java.util.ArrayList;
import java.util.Collection;

public class Solution {

  static ArrayList<Integer> ans = new ArrayList<>();
  public static void main(String[] args) {
    int[] arr = new int[]{10,4,23,3,6,25,7,5};
    TreeNode root = null;
    for (int i = 0; i < arr.length; i++)
       root = insert(root, arr[i]);
    sum(25, root);
    System.out.print(ans);
  }

  private static boolean sum(int sum, TreeNode root){
      ans.add(root.val);
      if(root.left == null && root.right == null){
        boolean s = ans.stream().reduce(0, Integer::sum) == sum;
        if(s)
          return true;
        ans.remove(ans.size()-1);
        return false;
      }
      boolean d = sum(sum, root.left);
      if (d)
        return true;
      return sum(sum, root.right);
  }

  //print binary sum path
  private static TreeNode insert(TreeNode root, int val){
    if(root == null) {
      root = new TreeNode(val);
      return root;
    }
    TreeNode temp = root;
    TreeNode t = new TreeNode(val);
    while(temp != null){
      if(temp.val < val && temp.right == null) {
        temp.right = t;
        break;
      }else if (temp.val > val && temp.left == null){
        temp.left = t;
        break;
      }
      else if(temp.val < val)
         temp = temp.right;
      else if(temp.val > val)
        temp = temp.left;
    }
    return root;
  }

  static class TreeNode{
    int val;
    TreeNode right;
    TreeNode left;
    TreeNode(int val){
      this.val = val;
    }
  }
}
