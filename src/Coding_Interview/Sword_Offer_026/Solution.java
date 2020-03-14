package Coding_Interview.Sword_Offer_026;
import Tools.TreeNode;

/*
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
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
