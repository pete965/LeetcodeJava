package Coding_Interview.Sword_Offer_062;

/*
给定一棵二叉搜索树，请找出其中的第k小的结点。
例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    int number = 0;
    TreeNode output=null;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot==null){
            return null;
        }
        traverse(pRoot,k);
        return output;
    }

    private void traverse(TreeNode pRoot,int k) {
        if (pRoot.left!=null){
            traverse(pRoot.left,k);
        }
        number++;
        if (number==k){
            output=pRoot;
        }
        if (pRoot.right!=null){
            traverse(pRoot.right,k);
        }

    }

}
