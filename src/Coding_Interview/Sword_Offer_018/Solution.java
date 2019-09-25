package Coding_Interview.Sword_Offer_018;
import Tools.TreeNode;

public class Solution {
    public void Mirror(TreeNode root) {
        if (root!=null){
            if (root.right!=null||root.left!=null){
                TreeNode mid=root.left;
                root.left=root.right;
                root.right=mid;
                if (root.right!=null){
                    Mirror(root.right);
                }
                if (root.left!=null){
                    Mirror(root.left);
                }
            }
        }
    }
}