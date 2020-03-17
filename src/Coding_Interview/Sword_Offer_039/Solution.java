package Coding_Interview.Sword_Offer_039;
/*
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
import Tools.TreeNode;

public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root==null){
            return true;
        }
        return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right)&&Math.abs(TreeDepth(root.left)-TreeDepth(root.right))<=1;
    }
    int max=1;
    public int TreeDepth(TreeNode root) {
        max=1;
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
