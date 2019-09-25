package Sword_Offer_026;
import Tools.TreeNode;
public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree==null){
            return null;
        }
        TreeNode treeNode= inOrderTraverse(pRootOfTree);
        TreeNode current=treeNode;
        while (current.left!=null){
            current=current.left;
        }
        return current;
    }

    private TreeNode inOrderTraverse(TreeNode pRootOfTree) {
        if (pRootOfTree==null){
            return null;
        }
        if (pRootOfTree.left==null&&pRootOfTree.right==null){
            return pRootOfTree;
        }
        if (pRootOfTree.left!=null){
            TreeNode left=inOrderTraverse(pRootOfTree.left);
            while (left.right!=null){
                left=left.right;
            }
            pRootOfTree.left=left;
            pRootOfTree.left.right=pRootOfTree;
        }
        if (pRootOfTree.right!=null){
            TreeNode right=inOrderTraverse(pRootOfTree.right);

            while (right.left!=null){
                right=right.left;
            }

            pRootOfTree.right=right;
            pRootOfTree.right.left=pRootOfTree;
        }
        return pRootOfTree;
    }
}