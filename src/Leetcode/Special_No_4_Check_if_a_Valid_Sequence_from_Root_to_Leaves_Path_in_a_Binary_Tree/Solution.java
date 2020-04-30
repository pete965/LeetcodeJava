package Leetcode.Special_No_4_Check_if_a_Valid_Sequence_from_Root_to_Leaves_Path_in_a_Binary_Tree;

import Beans.TreeNode;

import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        if (root==null){
            return false;
        }
        if (arr.length==0){
            return false;
        }
        ArrayList<TreeNode> pathCandidates = new ArrayList<>();
        for (int i=0;i<arr.length;i++){
            if (i==0){
                if (root.val!=arr[i]){
                    return false;
                }else {
                    pathCandidates.add(root);
                }
            }else {
                if (pathCandidates.size()==0){
                    return false;
                }
                ArrayList<TreeNode> newCandidates = new ArrayList<>();
                for (TreeNode node:pathCandidates){
                    if (node.left!=null&&node.left.val==arr[i]){
                        newCandidates.add(node.left);
                    }
                    if (node.right!=null&&node.right.val==arr[i]){
                        newCandidates.add(node.right);
                    }
                }
                pathCandidates=newCandidates;
            }
        }
        if (pathCandidates.size()==0){
            return false;
        }
        for (TreeNode node:pathCandidates){
            if (node.left!=null||node.right!=null){
                return false;
            }
        }
        return true;
    }
}
