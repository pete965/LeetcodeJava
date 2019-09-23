package Sword_Offer_062;

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
