package RealInterviewQuestions.Tecent;

import Beans.TreeNode;
//给定一个二叉树，求通过删除节点的方式能形成的最大的完全二叉树
public class Tencent1 {
    public TreeNode solve (TreeNode root) {
        // write code here
        judgeAndDelete(root);
        return root;
    }

    private void judgeAndDelete(TreeNode root) {
        if (root == null){
            return;
        }
        if (root.left!=null&&root.right!=null){
            judgeAndDelete(root.left);
            judgeAndDelete(root.right);
        }else {
            root.left=null;
            root.right=null;
        }
    }
}
