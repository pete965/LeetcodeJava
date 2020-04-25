package Leetcode.No_1008_Construct_Binary_Search_Tree_from_Preorder;

import Beans.TreeNode;
import Beans.Util;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Util.treeToBreString(solution.bstFromPreorder(new int[]{8,5,1,7,10,12})));
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int length = preorder.length;
        if (length==0){
            return null;
        }
        return construct(0,length,preorder);
    }

    private TreeNode construct(int i, int split, int[] preorder) {
        int cut = i+1;
        if (i==split){
            return null;
        }else {
            TreeNode treeNode = new TreeNode(preorder[i]);
            for (int j=i+1;j<split;j++){
                if (preorder[j]<treeNode.val){
                    cut++;
                }else {
                    break;
                }
            }
            treeNode.left = construct(i+1,cut,preorder);
            treeNode.right = construct(cut,split,preorder);
            return treeNode;
        }
    }
}
