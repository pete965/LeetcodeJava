package Sword_Offer_038;

import Tools.TreeNode;

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
