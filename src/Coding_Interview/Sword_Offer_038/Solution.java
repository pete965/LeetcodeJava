package Coding_Interview.Sword_Offer_038;
/*
输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
import Beans.TreeNode;

public class Solution {
    int max=1;
    public int TreeDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        dfs(root,1);
        return max;
    }

    private void dfs(TreeNode root, int i) {
        if (root.right!=null){
            if(i+1>max){
                max=i+1;
            }
            dfs(root.right,i+1);
        }
        if (root.left!=null){
            if (i+1>max){
                max=i+1;
            }
            dfs(root.left,i+1);
        }
    }
}
